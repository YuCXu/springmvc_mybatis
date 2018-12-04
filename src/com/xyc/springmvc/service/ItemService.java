package com.xyc.springmvc.service;

import java.util.List;

import com.xyc.springmvc.pojo.Items;

/**
 * 商品管理的service层的接口
 * @author YuChen_Xu
 *
 */
public interface ItemService {
	/**
	 * 查询商品列表
	 * @return
	 */
	List<Items> selectItemList();

	Items queryItemById(Integer id);
	
	//根据id修改商品
	void updateItemById(Items items);

}
