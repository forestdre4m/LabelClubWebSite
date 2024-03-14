import request from '@/utils/request';

export function useMenuApi() {
	return {
		getMenuGuanliyuan: (params) => {
			// 本地数据，路径：`/public/xxx.json`
			return request({
				url: './guanliyuan.json',
				method: 'get',
				params,
			});

		},
		getMenuChangpai: (params) => {
			return request({
				url: './changpai.json',
				method: 'get',
				params,
			});
		},getMenuYinleren: (params) => {
			return request({
				url: './yinleren.json',
				method: 'get',
				params,
			});
		},
		
	};
}
