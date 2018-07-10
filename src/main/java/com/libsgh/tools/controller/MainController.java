package com.libsgh.tools.controller;

import com.jfinal.core.Controller;

public class MainController extends Controller{
	
	public void index() {
		renderText("Hello JFinal World.");
	}
	
}
