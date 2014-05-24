/**
 * 
 */
package net.com.saciprojectv.configuration;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 * Comment(s): Classe de configuração do contexto do Spring
 * 
 * @author Paulo Garcia
 * @Feb 7, 2014
 * @12:00:03 PM
 * 
 *           Scai Project_V®
 * 
 *           Developed by Paulo Garcia
 */
@Configuration
@EnableWebMvc
@EnableScheduling
@ComponentScan(basePackages = { "net.com.scaiprojectv.controller" })
@EnableJpaRepositories(value = { "net.com.scaiprojectv.repository.impl" })
@Import(value = { net.com.scaiprojectv.config.ApplicationContext.class,
		WebSocketConfiguration.class })
public class ApplicationContext extends WebMvcConfigurerAdapter {

	private static final String DEFINICAO_TILES_PADRAO_GLOBAL = "/WEB-INF/web-tiles.xml";
	private static final String DEFINICAO_TILES_PADRAO_PAGINA = "/WEB-INF/views/**/tiles-*.xml";
	private static final String VIEW_RESOLVER_PREFIX = "/WEB-INF/views/";
	private static final String VIEW_RESOLVER_SUFFIX = ".jsp";

	private static final Logger logger = Logger
			.getLogger(ApplicationContext.class);

	@Override
	public void configureDefaultServletHandling(
			final DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations(
				"/resources/");
		registry.addResourceHandler("/css/**").addResourceLocations(
				"/resources/css/");
		registry.addResourceHandler("/fonts/**").addResourceLocations(
				"/resources/fonts/");
		registry.addResourceHandler("/images/**").addResourceLocations(
				"/resources/images/");
		registry.addResourceHandler("/js/**").addResourceLocations(
				"/resources/js/");
		registry.addResourceHandler("/less/**").addResourceLocations(
				"/resources/less/");
	}

	@Bean
	public TilesConfigurer configuracaoTiles() {
		logger.info("Inicializando Tiles Configurer...");
		TilesConfigurer config = new TilesConfigurer();
		String[] definicoes = new String[2];
		definicoes[0] = DEFINICAO_TILES_PADRAO_GLOBAL;
		definicoes[1] = DEFINICAO_TILES_PADRAO_PAGINA;
		config.setDefinitions(definicoes);
		return config;
	}

	@Bean
	public TilesViewResolver tileViewResolver() {
		logger.info("Inicializando Tiles ViewResolver...");
		return new TilesViewResolver();
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix(VIEW_RESOLVER_PREFIX);
		viewResolver.setSuffix(VIEW_RESOLVER_SUFFIX);

		return viewResolver;
	}

	@Bean
	public ObjectMapper objectMapper() {
		org.codehaus.jackson.map.ObjectMapper objectMapper = new org.codehaus.jackson.map.ObjectMapper();
		return objectMapper;
	}

	@Bean
	public MappingJacksonJsonView mappingJacksonJsonView() {
		MappingJacksonJsonView mappingJacksonJsonView = new MappingJacksonJsonView();
		mappingJacksonJsonView.setContentType("application/json");
		mappingJacksonJsonView.setObjectMapper(this.objectMapper());
		mappingJacksonJsonView.setEncoding(JsonEncoding.UTF8);
		mappingJacksonJsonView.setPrefixJson(false);
		return mappingJacksonJsonView;
	}

	@Bean
	public StringHttpMessageConverter stringHttpMessageConverter() {
		return new StringHttpMessageConverter(Charset.forName("UTF-8"));
	}

	@Bean
	public ContentNegotiatingViewResolver contentNegotiatingViewResolver() {
		List<ViewResolver> viewResolvers = new ArrayList<ViewResolver>();

		// Tiles
		viewResolvers.add(this.tileViewResolver());

		// Views
		List<View> defaultViews = new ArrayList<View>();
		defaultViews.add(this.mappingJacksonJsonView());

		ContentNegotiatingViewResolver contentNegotiatingViewResolver = new ContentNegotiatingViewResolver();

		contentNegotiatingViewResolver.setViewResolvers(viewResolvers);
		contentNegotiatingViewResolver.setDefaultViews(defaultViews);
		contentNegotiatingViewResolver.setOrder(0);

		return contentNegotiatingViewResolver;
	}

}
