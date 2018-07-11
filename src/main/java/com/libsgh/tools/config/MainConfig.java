package com.libsgh.tools.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.plugin.cron4j.Cron4jPlugin;
import com.jfinal.template.Engine;
import com.libsgh.tools.bean.So;
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
		PropKit.use("config.properties");
		Cron4jPlugin cp = new Cron4jPlugin();
		//每分钟执行一次
		cp.addTask("* * * * *", new GetVpnGate());
		C3p0Plugin dp = new C3p0Plugin(String.format(PropKit.get("jdbcUrl"), PathKit.getRootClassPath()),PropKit.get("user"), PropKit.get("password").trim());
		dp.setDriverClass("org.sqlite.JDBC");
		me.add(dp);
	    ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
	    arp.addMapping("so", So.class);
	    me.add(arp);
		me.add(cp);
	}

	@Override
	public void configRoute(Routes me) {
		me.add("/api", ApiController.class);
		me.add("/", IndexController.class);
	}
}
