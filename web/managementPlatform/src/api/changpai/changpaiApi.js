import request from '@/utils/request';
// list
export const changpaiList = (params) => {
    return request({
        url: '/label/page',
        method: 'post',
        data: params,
    })
};
export const changpaiDetail = (id) => {
    return request({
        url: '/label/'+id,
        method: 'get',
    })
};
// add
export const changpaiSave = (params) => {
    return request({
        url: '/label',
        method: 'post',
        data: params,
    })
};
// updt
export const changpaiEdit = (params) => {
    return request({
        url: '/label',
        method: 'put',
        data: params,
    })
};
// delete
export const changpaiDelete = (id) => {
    return request({
        url: '/label/'+id,
        method: 'delete',
    })
};
// pldel
export const changpaiDeleteList = (changpais) => {
    return request({
        url: '/label/deleteList',
        data:{list:changpais},
        method: 'post',
    })
};
// all
export const changpaiAllList = () => {
    return request({
        url: '/label',
        method: 'get',
    })
};
export const changpaiUpdatePassword = (params) =>{
    return request({
        url: `/label/updatePassword`,
        method: 'put',
        data: {...params,password:params.password}, })};
