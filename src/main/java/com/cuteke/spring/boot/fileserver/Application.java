package com.cuteke.spring.boot.fileserver;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.apache.coyote.http11.AbstractHttp11Protocol;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	/**
	 * 文件上传配置-现在在application.properties里面配置
	 * @return
	 */
//	@Bean
//	public MultipartConfigElement multipartConfigElement() {
//		MultipartConfigFactory factory = new MultipartConfigFactory();
//		//文件最大  
//		factory.setMaxFileSize("10240KB"); //KB,MB  
//		/// 设置总上传数据总大小  
//		factory.setMaxRequestSize("10240KB");
//		return factory.createMultipartConfig();
//	}
	@Bean
	public TomcatServletWebServerFactory containerFactory() {
		return new TomcatServletWebServerFactory() {
			protected void customizeConnector(Connector connector) {
				int maxSize = -1; //tomcat不打断
				super.customizeConnector(connector);  
				connector.setMaxPostSize(maxSize);
				connector.setMaxSavePostSize(maxSize);
				if (connector.getProtocolHandler() instanceof AbstractHttp11Protocol) {
					((AbstractHttp11Protocol <?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
					logger.info("Set MaxSwallowSize "+ maxSize);
				}
			}
		};

	}
}
