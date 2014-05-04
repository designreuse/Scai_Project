/**
 * 
 */
package net.com.scaiprojectv.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.jolbox.bonecp.BoneCPDataSource;

/**
 * Comment(s): Classe de configuração do Spring no módulo "Core"
 * 
 * @author Paulo Garcia
 * @Feb 11, 2014
 * @7:39:45 PM
 *
 * Scai Project_V®
 *
 * Developed by Paulo Garcia
 */
@Configuration
@ComponentScan(basePackages = {"net.com.scaiprojectv.service","net.com.scaiprojectv.repository.impl"})
@ImportResource("classpath:applicationcontext.xml")
@PropertySource("classpath:application.properties")
public class ApplicationContext {

	private static final Logger logger = Logger.getLogger(ApplicationContext.class);
	
	@Resource
	private Environment em;
	
	@Bean
	public DataSource dataSource() {
		logger.info("Inicializando DATASOURCE...");
		BoneCPDataSource ds = new BoneCPDataSource();
		ds.setDriverClass(em.getRequiredProperty("db.driver"));
		ds.setJdbcUrl(em.getRequiredProperty("db.url"));
		ds.setUsername(em.getRequiredProperty("db.username"));
		ds.setPassword(em.getRequiredProperty("db.password"));
		logger.info("DATASOURCE anicializado com sucesso!");
		return ds;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		logger.info("Inicializando entityManagerFactory...");
		LocalContainerEntityManagerFactoryBean local = new LocalContainerEntityManagerFactoryBean();
		local.setDataSource(dataSource());
		local.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		local.setPackagesToScan(em.getRequiredProperty("entitymanager.packages.to.scan"));
		Properties p = new Properties();
		p.put("hibernate.dialect", em.getRequiredProperty("hibernate.dialect"));
		p.put("hibernate.format_sql", em.getRequiredProperty("hibernate.format_sql"));
		p.put("hibernate.hbm2ddl.auto", em.getRequiredProperty("hibernate.hbm2ddl.auto"));
		p.put("hibernate.ejb.naming_strategy", em.getRequiredProperty("hibernate.ejb.naming_strategy"));
		p.put("hibernate.show_sql", em.getRequiredProperty("hibernate.show_sql"));
		local.setJpaProperties(p);
		logger.info("entityManagerFactory inicializado com sucesso!");
		return local;
	}
	
	@Bean
	public JpaTransactionManager transactionManager() {
		logger.info("Inicializando transactionManager...");
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		logger.info("transactionManager inicializado com sucesso!");
		return transactionManager;
	}
	
}
