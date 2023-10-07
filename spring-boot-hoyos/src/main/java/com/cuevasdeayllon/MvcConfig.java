package com.cuevasdeayllon;

import java.util.Locale;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
@Configuration

public class MvcConfig implements WebMvcConfigurer{


	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/error_403").setViewName("error_403");	

	}
//	@Bean
//    public ResourceBundleMessageSource messageSource() {
//        ResourceBundleMessageSource rbms = new ResourceBundleMessageSource();
//        rbms.setBasename("i18n/message");
//        return rbms;
//    }
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver localResolver=new SessionLocaleResolver();
		localResolver.setDefaultLocale(new Locale("es","ES"));
		return localResolver;
	}
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor  localeChangeInterceptor =new LocaleChangeInterceptor ();
		localeChangeInterceptor.setParamName("lang");
		return localeChangeInterceptor;

	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(localeChangeInterceptor());
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);


    registry.addResourceHandler("/uploads/**")
    .addResourceLocations("file:/D:/TEMP/uploads/");
 // registry.addResourceHandler("/uploads/**")
 // .addResourceLocations("file:/uploads/");
  	registry.addResourceHandler("/uploadsGaleria/**")
  	.addResourceLocations("file:/D:/TEMP/uploadsGaleria/");
//	registry.addResourceHandler("/uploadsGaleria/**")
//	.addResourceLocations("file:/uploadsGaleria/");
  	registry.addResourceHandler("/uploadsAnuncios/**")
  	.addResourceLocations("file:/D:/TEMP/uploadsAnuncios/");
//	registry.addResourceHandler("/uploadsAnuncios/**")
//	.addResourceLocations("file:/uploadsAnuncios/");
  	registry.addResourceHandler("/imagenesRutas/**")		
  	.addResourceLocations("file:/D:/TEMP/imagenesRutas/");
//	registry.addResourceHandler("/imagenesRutas/**")
//	.addResourceLocations("file:/imagenesRutas/");
  	registry.addResourceHandler("/uploadsDocumentos/**")		
  	.addResourceLocations("file:/D:/TEMP/uploadsDocumentos/");
//	registry.addResourceHandler("/uploadsDocumentos/**")
//	.addResourceLocations("file:/uploadsDocumentos/");
  	registry.addResourceHandler("/uploadsMercadillo/**")		
  	.addResourceLocations("file:/D:/TEMP/uploadsMercadillo/");
//			registry.addResourceHandler("/uploadsMercadillo/**")
//				.addResourceLocations("file:/uploadsMercadillo/");
  	registry.addResourceHandler("/uploadsPiscina/**")		
  	.addResourceLocations("file:/D:/TEMP/uploadsPiscina/");
//			registry.addResourceHandler("/uploadsPiscina/**")
//				.addResourceLocations("file:/uploadsPiscina/");
  	registry.addResourceHandler("/uploadsHistoria/**")		
  	.addResourceLocations("file:/D:/TEMP/uploadsHistoria/");
//			registry.addResourceHandler("/uploadsPiscina/**")
//				.addResourceLocations("file:/uploadsPiscina/");
  	registry.addResourceHandler("/uploadsEnlaces/**")		
  	.addResourceLocations("file:/D:/TEMP/uploadsEnlaces/");
//			registry.addResourceHandler("/uploadsEnlaces/**")
//				.addResourceLocations("file:/uploadsEnlaces/");
	
	}



}
