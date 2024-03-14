import request from '@/utils/request';
// list
export const yinpingaojianList = (params) => {
    return request({
        url: '/audio/page',
        method: 'post',
        data: params,
    })
};
export const yinpingaojianDetail = (id) => {
    return request({
        url: '/audio/'+id,
        method: 'get',
    })
};
// add
export const yinpingaojianSave = (params) => {
    return request({
        url: '/audio',
        method: 'post',
        data: params,
    })
};
// updt
export const yinpingaojianEdit = (params) => {
    return request({
        url: '/audio',
        method: 'put',
        data: params,
    })
};
// delete
export const yinpingaojianDelete = (id) => {
    return request({
        url: '/audio/'+id,
        method: 'delete',
    })
};
// pldel
export const yinpingaojianDeleteList = (yinpingaojians) => {
    return request({
        url: '/audio/deleteList',
        data:{list:yinpingaojians},
        method: 'post',
    })
};
// all
export const yinpingaojianAllList = () => {
    return request({
        url: '/audio',
        method: 'get',
    })
};

