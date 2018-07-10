package com.libsgh.tools.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.template.Engine;
import com.libsgh.tools.controller.MainController;

public class MainConfig  extends JFinalConfig{

	@Override
	public void configConstant(Constants me) {
		me.setDevMode(true);
	}

	@Override
	public void configEngine(Engine me) {
		
	}

	@Override
	public void configHandler(Handlers me) {
		
	}

	@Override
	public void configInterceptor(Interceptors me) {
		
	}

	@Override
	public void configPlugin(Plugins me) {
		
	}

	@Override
	public void configRoute(Routes me) {
		me.add("/hello", MainController.class);
	}

}
