import request from '@/utils/request';

export const login =(params) => {
	if(params.role == '管理员'){return request({url: '/admin/login',method: 'post',data: {username:params.username,password:params.password},});}
	else if(params.role == '厂牌'){return request({url: '/label/login',method: 'post',data: {username:params.username,password:params.password},});}
	else if(params.role == '音乐人'){return request({url: '/artist/login',method: 'post',data: {username:params.username,password:params.password},});}

	
	
}
export const register =(params) => {return request({url: '/artist/register',method: 'post',data: {username:params.username,password:params.password},})}