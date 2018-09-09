package net.adonika.chicken.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class ThymeleafConfig {
	
	@Autowired
	private ITemplateResolver iTemplateResolver;
	
	@Bean
    public SpringTemplateEngine templateEngine(){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(iTemplateResolver);
        templateEngine.addDialect(new LayoutDialect());
        return templateEngine;
    }

}
