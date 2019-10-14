package com.example.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo.bean.Goods;
import com.example.demo.service.GoodsService;

@Controller
public class GoodsController {
	@Resource
	private GoodsService goodsService;
	public String listgoods(Model model) {
		List<Goods> listgoods = goodsService.listgoods();
		model.addAttribute("listgoods",listgoods);
		return "list";
	}
}
