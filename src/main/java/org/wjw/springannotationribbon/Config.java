package org.wjw.springannotationribbon;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config {
	@Bean
	public RibbonConfig ribbonConfig() {
		RibbonConfig ribbonConfig = new RibbonConfig();
		ribbonConfig.setClientName("service-one");

		Properties properties = new Properties();
		properties.setProperty("service-one.ribbon.MaxAutoRetries", "1");
		properties.setProperty("service-one.ribbon.MaxAutoRetriesNextServer", "1");
		properties.setProperty("service-one.ribbon.OkToRetryOnAllOperations", "true");
		properties.setProperty("service-one.ribbon.ServerListRefreshInterval", "2000");
		properties.setProperty("service-one.ribbon.ConnectTimeout", "3000");
		properties.setProperty("service-one.ribbon.ReadTimeout", "3000");
		properties.setProperty("service-one.ribbon.listOfServers", "192.168.2.113:8861,192.168.2.114:8861");
		properties.setProperty("service-one.ribbon.EnablePrimeConnections", "false");
		ribbonConfig.setProperties(properties);

		return ribbonConfig;
	}
}
