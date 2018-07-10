package com.libsgh.tools.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jfinal.core.Controller;

public class ApiController extends Controller{
	
	public static String listHtml;
	
	//private String url ="http://www.vpngate.net/";
	
	public static  List<String> urls = new ArrayList<String>();
	
	public static  String url ="http://185.242.4.92:26689/cn/sites.aspx";
	
	public void vgsites() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("listHtml", listHtml);
		map.put("urls", urls);
		renderJson(map);
	}

}
