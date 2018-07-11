package com.libsgh.tools.controller;

import java.util.List;

import com.jfinal.core.Controller;
import com.libsgh.tools.bean.So;

public class IndexController extends Controller{
	
	/**
	 * 首页跳转
	 */
	public void index() {
		render("system.html");
	}
	
	/**
	 * 首页跳转
	 */
	public void getSoData() {
		List<So> list = So.dao.find("select * from so");
		renderJson(list);
	}
	
}
