import request from '@/utils/request';
// list
export const yinlerenList = (params) => {
    return request({
        url: '/artist/page',
        method: 'post',
        data: params,
    })
};
export const yinlerenDetail = (id) => {
    return request({
        url: '/artist/'+id,
        method: 'get',
    })
};
// add
export const yinlerenSave = (params) => {
    return request({
        url: '/artist',
        method: 'post',
        data: params,
    })
};
// updt
export const yinlerenEdit = (params) => {
    return request({
        url: '/artist',
        method: 'put',
        data: params,
    })
};
// delete
export const yinlerenDelete = (id) => {
    return request({
        url: '/artist/'+id,
        method: 'delete',
    })
};
// pldel
export const yinlerenDeleteList = (yinlerens) => {
    return request({
        url: '/artist/deleteList',
        data:{list:yinlerens},
        method: 'post',
    })
};
// all
export const yinlerenAllList = () => {
    return request({
        url: '/artist',
        method: 'get',
    })
};
export const yinlerenUpdatePassword = (params) =>{ return request({ url: `/artist/updatePassword`, method: 'put',data: {...params,password:params.password}, })};
