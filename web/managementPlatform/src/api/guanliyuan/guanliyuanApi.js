import request from '@/utils/request';
// list
export const guanliyuanList = (params) => {
    return request({
        url: '/admin/page',
        method: 'post',
        data: params,
    })
};
export const guanliyuanDetail = (id) => {
    return request({
        url: '/admin/'+id,
        method: 'get',
    })
};
// add
export const guanliyuanSave = (params) => {
    return request({
        url: '/admin',
        method: 'post',
        data: params,
    })
};
// updt
export const guanliyuanEdit = (params) => {
    return request({
        url: '/admin',
        method: 'put',
        data: params,
    })
};
// delete
export const guanliyuanDelete = (id) => {
    return request({
        url: '/admin/'+id,
        method: 'delete',
    })
};
// pldel
export const guanliyuanDeleteList = (guanliyuans) => {
    return request({
        url: '/admin/deleteList',
        data:{list:guanliyuans},
        method: 'post',
    })
};
// all
export const guanliyuanAllList = () => {
    return request({
        url: '/admin',
        method: 'get',
    })
};
export const guanliyuanUpdatePassword = (params) =>{ return request({ url: `/admin/updatePassword`, method: 'put',data: {...params,password:params.password}, })};