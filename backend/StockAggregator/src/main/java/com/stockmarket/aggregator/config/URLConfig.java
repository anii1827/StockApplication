package com.stockmarket.aggregator.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;


@Component
public class URLConfig {
	
	 @Autowired
	 private EurekaClient eurekaClient;
	
		public String getUrl(String applicaionName,String baseUrl){
				Application application = eurekaClient.getApplication(applicaionName);
				InstanceInfo instanceInfo = application.getInstances().get(0);
				String ipAddr = instanceInfo.getIPAddr();
				int port = instanceInfo.getPort();
				return buildUrl(ipAddr,port,baseUrl); 
		}

		public String buildUrl(String ipAddr, int port, String baseurl) {
			return new StringBuilder("http://")
					.append(ipAddr).append(":")
					.append(port).append("/")
					.append(baseurl).toString();
		}
}
