/**
 * 
 */
package net.com.scaiprojectv.config.test;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.core.env.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.jolbox.bonecp.BoneCPDataSource;

/**
 * Comment(s): 
 * 
 * @author Paulo Garcia
 * @Feb 20, 2014
 * @5:55:29 PM
 *
 * Scai Project_V®
 *
 * Developed by Paulo Garcia
 */
@Configuration
@ComponentScan(basePackages = {"net.com.scaiprojectv.service","net.com.scaiprojectv.repository.impl"})
@ImportResource("classpath:SpringTestConfiguration/applicationcontext-test.xml")
@PropertySource("classpath:SpringTestConfiguration/configuration-test.properties")
public class ApplicationContextTest {

	@Resource
	private Environment em;
	
	@Bean
	public DataSource dataSource() {
		BoneCPDataSource ds = new BoneCPDataSource();
		ds.setDriverClass(em.getRequiredProperty("db.driver"));
		ds.setJdbcUrl(em.getRequiredProperty("db.url"));
		ds.setUsername(em.getRequiredProperty("db.username"));
		ds.setPassword(em.getRequiredProperty("db.password"));
		return ds;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
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
		return local;
	}
	
	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}
	
}
