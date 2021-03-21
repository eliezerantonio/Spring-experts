package com.stackcode.gestao.config;



import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import com.stackcode.gestao.controller.ProdutosController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;



@Configuration
@ComponentScan(basePackageClasses = { ProdutosController.class })
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {
	//Classe resonsavel pela comunicao com o finheiros web 

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;

	}
	
	
	@Bean 
	public ViewResolver viewResolver() {
		ThymeleafViewResolver resolver= new ThymeleafViewResolver();
		resolver.setTemplateEngine(templateEngine());
		resolver.setCharacterEncoding("UTF-8");
		return resolver;
	}
	
	 //Processa os arquivos html, uo seja desenha a pagina
	// @Bean -  faz com que o templateEgine fica disponivel dentro do contexto do Spring
	
	@Bean 
	public TemplateEngine templateEngine() {
		SpringTemplateEngine engine =new SpringTemplateEngine();
		engine.setEnableSpringELCompiler(true);
		engine.setTemplateResolver(templateResolver());
		return engine;
		
	}
	
	private ApplicationContext applicationContext;

	// motodo para resolver template
	private ITemplateResolver templateResolver() {
		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
		resolver.setApplicationContext(applicationContext);
		resolver.setPrefix("classpath:/templates/"); //local dos templates/ na pasta templates
		resolver.setSuffix(".html");
		resolver.setTemplateMode(TemplateMode.HTML); //mode do template HTML
		return resolver;
	}
//habilia recursos estaticos
  @Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	}
 
        
	
}
