package com.libsgh.tools.controller;

import java.util.Properties;

import com.geccocrawler.socks5.ProxyServer;
import com.jfinal.core.Controller;

public class IndexController extends Controller{
	
	/**
	 * 首页跳转
	 */
	public void index() {
		render("index.html");
	}
	
	/**
	 * 首页跳转
	 */
	public void start() {
		int port = 11080;
		boolean auth = false;
		Properties properties = new Properties();
		try {
			properties.load(ProxyServer.class.getResourceAsStream("/config.properties"));
			port = Integer.parseInt(properties.getProperty("port"));
			auth = Boolean.parseBoolean(properties.getProperty("auth"));
		} catch(Exception e) {
			System.out.println("load config.properties error, default port 11080, auth false!");
		}
		try {
			ProxyServer.create(port).logging(true).auth(auth).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
