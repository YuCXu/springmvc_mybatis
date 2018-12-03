package com.xyc.springmvc.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xyc.springmvc.pojo.Items;
import com.xyc.springmvc.service.ItemService;

@Controller
public class ItemController {
	
	@Resource
	private ItemService itemService;
	
	@RequestMapping("/itemList.action")
	public ModelAndView queryItemList() {
		
		List<Items> list = itemService.selectItemList();
		//创建ModelAndView，用来存放数据和视图
		ModelAndView modelAndView = new ModelAndView();
		//设置数据到模型中
		modelAndView.addObject("itemList", list);
		modelAndView.setViewName("itemList");
		return modelAndView;
	}
}
