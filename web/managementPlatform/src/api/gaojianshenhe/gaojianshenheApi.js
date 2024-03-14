import request from '@/utils/request';
// list
export const gaojianshenheList = (params) => {
    return request({
        url: '/audiocheck/page',
        method: 'post',
        data: params,
    })
};
export const gaojianshenheDetail = (id) => {
    return request({
        url: '/audiocheck/'+id,
        method: 'get',
    })
};
// add
export const gaojianshenheSave = (params) => {
    return request({
        url: '/audiocheck',
        method: 'post',
        data: params,
    })
};
// updt
export const gaojianshenheEdit = (params) => {
    return request({
        url: '/audiocheck',
        method: 'put',
        data: params,
    })
};
// delete
export const gaojianshenheDelete = (id) => {
    return request({
        url: '/audiocheck/'+id,
        method: 'delete',
    })
};
// pldel
export const gaojianshenheDeleteList = (gaojianshenhes) => {
    return request({
        url: '/audiocheck/deleteList',
        data:{list:gaojianshenhes},
        method: 'post',
    })
};
// all
export const gaojianshenheAllList = () => {
    return request({
        url: '/audiocheck',
        method: 'get',
    })
};

