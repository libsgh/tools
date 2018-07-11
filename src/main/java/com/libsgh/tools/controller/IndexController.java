package com.libsgh.tools.controller;

import java.util.List;

import com.jfinal.core.Controller;

public class IndexController extends Controller{
	
	/**
	 * 首页跳转
	 */
	public void index() {
		render("system.html");
	}
	
}
