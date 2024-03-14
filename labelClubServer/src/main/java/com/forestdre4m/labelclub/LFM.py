import math
import sys
import numpy as np
import pymysql

conn1 = pymysql.connect(host='localhost',
                           user='root',
                           password='123456',
                           database='labelclub',
                           port=3306)

cur1 = conn1.cursor()
cur2 = conn1.cursor()

sql1 = 'select * from lfm'
sql2 = 'SELECT COUNT(DISTINCT id) FROM lfm'

try:

    cur1.execute(sql1)
    cur2.execute(sql2)

    # 查询所有
    lfm_rs = cur1.fetchall()
    # 查询ID计数
    idNum = cur2.fetchone()[0]
    # 查询一条
    # students = cur.fetchone()

    # 存入数组
    R1 = []
    R2 = []
    for row in lfm_rs:
        record = row[2]
        R1.append(record)

    # for lfm_r in lfm_rs:
    #
    #     userId = lfm_r[0]
    #     itemId = lfm_r[1]
    #     rate = lfm_r[2]
    #     print('userId:',userId,'itemId:',itemId,'rate:',rate)

except Exception as e:
    print(e)
    print('>>>>>>查询所有数据失败')
finally:

    n = int(len(R1)/idNum)
    m = idNum

    for i in range(n):
        temp = []
        for j in range(m):
            temp.append(R1[i*5+j])
        R2.append(temp)
    R3 = np.array(R2)

    conn1.close()

# R 评分矩阵
# K 特征维度
# alpha 学习率
# lanbda 正则化项系数
# epoch 下降的批次

def lfm(R3,K,alpha,lanbda,epoch):
    M = R3.shape[0]
    N = R3.shape[1]

    P = np.random.rand(M,K)
    Q = np.random.rand(K,N)

    loss_arr = []

    for step in range(epoch):
        #核心下降代码
        for u in range(M):
            for i in range(N):
                if R3[u][i] > 0: #有评分数据的时候才下降
                    eui = np.dot(P[u,:],Q[:,i]) - R3[u][i]
                    for k in range(K):
                        P[u][k] = P[u][k] - alpha * 2 * (eui * Q[k][i] + lanbda * P[u][k])
                        Q[k][i] = Q[k][i] - alpha * 2 * (eui * P[u][k] + lanbda * Q[k][i])
            #计算 loss function
            loss = 0
            for u in range(M):
                for i in range(N):
                    if R3[u][i] > 0:
                        loss += (np.dot(P[u,:],Q[:,i]) - R3[u,i])**2
            if step % 3 == 0:
                #print("step=",step,",loss=",loss)
                loss_arr.append(loss)
    return P,Q,loss_arr

K = 5
alpha = 0.03
lanbda = 0.2
epoch = 5000

P,Q,loss_arr = lfm(R3,K,alpha,lanbda,epoch)

print(">>>>>>source data: \n",R3)
print(">>>>>>Processed data: \n",np.dot(P,Q))

#处理后的数据写回数据库
conn2 = pymysql.connect(host='localhost',
                           user='root',
                           password='123456',
                           database='labelclub',
                           port=3306)

cursor = conn2.cursor()
sql = 'UPDATE lfm SET rate = (%s) WHERE id = (%s) '
#批量更新
try:

    R4 = [num for sublist in np.dot(P,Q) for num in sublist]

    int_list = list(map(lambda x: int(math.ceil(x)),R4))
    print(">>>>>>The result of rounding: \n",int_list)

#获取数组长度
    print(">>>>>>data length: \n",len(int_list))
    for i in range(0,len(int_list)):
        cursor.execute(sql,(int_list[i],i+1))
    conn2.commit()

except Exception as e:
    print(e)
    conn2.rollback()
finally:
    conn2.close()

# 显示模型训练图像
# x = np.arange(25000)
# y = loss_arr
#
# import matplotlib.pyplot as plt
# plt.plot(x,y)
# plt.show()

