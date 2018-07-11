package com.libsgh.tools.task;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.libsgh.tools.controller.ApiController;

public class GetVpnGate implements Runnable{

	@Override
	public void run() {
		Document doc;
		try {
			doc = Jsoup.connect(ApiController.url).get();
			ApiController.date = doc.getElementById("Label2").text();
			Element el = doc.select("#vpngate_inner_contents_td ul").get(1);
			ApiController.listHtml =  el.toString();
			Elements els = el.select(".listBigArrow a");
			for (Element element : els) {
				String u = element.attr("href");
				if(testUrl(u)) {
					ApiController.url = u + "sites.aspx";
					break;
				}
			}
			ApiController.urls.clear();
			for (Element element : els) {
				String u = element.attr("href");
				ApiController.urls.add(u);
			}
		} catch (IOException e) {
			ApiController.url ="http://www.vpngate.net/cn/sites.aspx";
		}
	}
	private static Boolean testUrl(String url) {
		try {
			Jsoup.connect(url).get();
		} catch (IOException e) {
			return false;
		}
		return true;
	}
}
