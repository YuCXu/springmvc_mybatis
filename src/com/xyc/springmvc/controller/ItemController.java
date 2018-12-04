package com.xyc.springmvc.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xyc.springmvc.pojo.Items;
import com.xyc.springmvc.pojo.QueryVo;
import com.xyc.springmvc.service.ItemService;

@Controller
public class ItemController {
	
	@Resource
	private ItemService itemService;
	/**
	 * 显示商品列表
	 * @return
	 */
	@RequestMapping("/itemList.action")
	public ModelAndView queryItemList() {
		//获取商品数据
		List<Items> list = itemService.selectItemList();
		//创建ModelAndView，用来存放数据和视图
		ModelAndView modelAndView = new ModelAndView();
		//设置数据到模型中
		modelAndView.addObject("itemList", list);
		//设置逻辑视图
		modelAndView.setViewName("itemList");
		return modelAndView;
	}
	
	/**
	 * 根据Id查找商品
	 * @return
	 */
	@RequestMapping("/itemEdit.action")
	//public ModelAndView queryItemById(HttpServletRequest httpServletRequest) {
	//public ModelAndView queryItemById(Integer id) {
	public ModelAndView queryItemById(@RequestParam(value="id",required=false,defaultValue="1") Integer idaaa) {
		//从request中获取请求参数
		//String strId = httpServletRequest.getParameter("id");
		//Integer id = Integer.valueOf(strId);
		//根据id查找商品数据
		Items item = itemService.queryItemById(idaaa);
		//创建ModelAndView，用来存放数据和视图
		ModelAndView modelAndView = new ModelAndView();
		//把商品数据放在模型中
		modelAndView.addObject("item",item);
		//设置逻辑视图
		modelAndView.setViewName("editItem");
		return modelAndView;
	}
	
	@RequestMapping("/updateitem.action")
	public ModelAndView updateItem(Items items) {
		//修改
		itemService.updateItemById(items);
		
		//创建ModelAndView，用来存放数据和视图
		ModelAndView modelAndView = new ModelAndView();
		//存放视图
		modelAndView.setViewName("success");
		return modelAndView;
	}
	//绑定包装数据类型
	@RequestMapping("/queryitem.action")
	public String queryItem(QueryVo queryVo) {
		System.out.println(queryVo.getItems().getId());
		System.out.println(queryVo.getItems().getName());
		return "success";
	}
}
