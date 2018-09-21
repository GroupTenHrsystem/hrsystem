package com.hrsystem;
//package com.example.demo;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.ViewResolver;
//import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.thymeleaf.spring5.SpringTemplateEngine;
//import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
//import org.thymeleaf.spring5.view.ThymeleafViewResolver;
//import org.thymeleaf.templateresolver.ITemplateResolver;
///**
// * JSP和Thymeleaf模板的设置
// * @author Sailer
// *
// */
//@Configuration
//@EnableWebMvc
////@ComponentScan
//public class WebMvcConfig extends WebMvcConfigurerAdapter{
//	   @Bean
//       public ViewResolver viewResolver() {
//           InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//           resolver.setPrefix("/WEB-INF/");
//           resolver.setSuffix(".jsp");
//           resolver.setViewNames("jsp/*");
//           resolver.setOrder(2);
//           return resolver;
//       }
//
//       @Bean
//       public ITemplateResolver templateResolver() {
//           SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//           templateResolver.setTemplateMode("HTML5");
//           templateResolver.setPrefix("classpath:/templates/");
//           templateResolver.setSuffix(".html");
//           templateResolver.setCharacterEncoding("utf-8");
//           templateResolver.setCacheable(false);
//           return templateResolver;
//       }
//
//       @Bean
//       public SpringTemplateEngine templateEngine() {
//           SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//           templateEngine.setTemplateResolver(templateResolver());
//           return templateEngine;
//       }
//
//       @Bean
//       public ThymeleafViewResolver viewResolverThymeLeaf() {
//           ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//           viewResolver.setTemplateEngine(templateEngine());
//           viewResolver.setCharacterEncoding("utf-8");
//           viewResolver.setViewNames(new String[]{"thymeleaf/*"});
//           viewResolver.setOrder(1);
//           return viewResolver;
//       }
//
//       @Override
//       public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//           configurer.enable();
//       }
//
////       @Override
////       public void addResourceHandlers(ResourceHandlerRegistry registry) {
////           super.addResourceHandlers(registry);
////       }
//       
//       @Override
//       public void addResourceHandlers(ResourceHandlerRegistry registry) {
//           //将所有/static/** 访问都映射到classpath:/static/ 目录下
//           registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//           registry.addResourceHandler("/public/**").addResourceLocations("classpath:/public/");
//           registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/resources/");
//       }
//}