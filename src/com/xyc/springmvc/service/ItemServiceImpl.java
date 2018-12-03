package com.xyc.springmvc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xyc.springmvc.dao.ItemsMapper;
import com.xyc.springmvc.pojo.Items;

/**
 * 商品管理的service层的实现类
 * @author YuChen_Xu
 *
 */
@Service
public class ItemServiceImpl implements ItemService{
	 
	@Resource(name="itemsMapper")
	private ItemsMapper itemsMapper;

	@Override
	public List<Items> selectItemList() {
		List<Items> list = itemsMapper.selectByExample(null);
		return list;
	}
	
	
}
