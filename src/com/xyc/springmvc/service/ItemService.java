package com.xyc.springmvc.service;

import java.util.List;

import com.xyc.springmvc.pojo.Items;

/**
 * 商品管理的service层的接口
 * @author YuChen_Xu
 *
 */
public interface ItemService {

	List<Items> selectItemList();

}
