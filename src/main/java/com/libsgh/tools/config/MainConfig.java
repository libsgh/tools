package com.libsgh.tools.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.cron4j.Cron4jPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;
import com.libsgh.tools.controller.ApiController;
import com.libsgh.tools.controller.IndexController;
import com.libsgh.tools.task.GetVpnGate;

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
		//loadPropertyFile("config.properties");
		//DruidPlugin dp = new DruidPlugin(getProperty("jdbcUrl"), getProperty("root"), getProperty("password"));
		//me.add(dp);
		Cron4jPlugin cp = new Cron4jPlugin();
		//每分钟执行一次
		cp.addTask("* * * * *", new GetVpnGate());
		me.add(cp);
	}

	@Override
	public void configRoute(Routes me) {
		me.add("/api", ApiController.class);
		me.add("/", IndexController.class);
	}
}
