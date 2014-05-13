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
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
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
 *          Scai Project_V®
 * 
 *          Developed by Paulo Garcia
 */
@Configuration
@ComponentScan(basePackages = { "net.com.scaiprojectv.service",
		"net.com.scaiprojectv.repository.impl", "net.com.scaiprojectv.dto" })
@ImportResource("classpath:applicationcontext.xml")
@PropertySource("classpath:application.properties")
public class ApplicationContext {

	private static final Logger logger = Logger
			.getLogger(ApplicationContext.class);

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
		local.setPackagesToScan(em
				.getRequiredProperty("entitymanager.packages.to.scan"));
		Properties p = new Properties();
		p.put("hibernate.dialect", em.getRequiredProperty("hibernate.dialect"));
		p.put("hibernate.format_sql",
				em.getRequiredProperty("hibernate.format_sql"));
		p.put("hibernate.hbm2ddl.auto",
				em.getRequiredProperty("hibernate.hbm2ddl.auto"));
		p.put("hibernate.ejb.naming_strategy",
				em.getRequiredProperty("hibernate.ejb.naming_strategy"));
		p.put("hibernate.show_sql",
				em.getRequiredProperty("hibernate.show_sql"));
		local.setJpaProperties(p);
		logger.info("entityManagerFactory inicializado com sucesso!");
		return local;
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		logger.info("Inicializando transactionManager alterado...");
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory()
				.getObject());
		logger.info("transactionManager inicializado com sucesso!");
		return transactionManager;
	}

	@Bean
	public JavaMailSenderImpl mailSender() {
		logger.info("Carregando mailSender");
		JavaMailSenderImpl mail = new JavaMailSenderImpl();
		mail.setProtocol("smtp");
		mail.setHost("smtp.gmail.com");
		mail.setPort(587);
		mail.setUsername("gpaulo42@gmail.com");
		mail.setPassword("159000paulo");
		Properties properties = new Properties();
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.transport.protocol", "smtp");
		properties.setProperty("mail.debug", "true");
		mail.setJavaMailProperties(properties);
		return mail;
	}

	@Bean
	public SimpleMailMessage simpleMail() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("Paulo Garcia");
		message.setText("Testando o envio do email");
		message.setTo("gpaulo42@gmail.com");
		message.setFrom("gpaulo42@gmail.com");
		message.setReplyTo("gpaulo42@gmail.com");
		message.setCc("gpaulo42@gmail.com");
		return message;
	}

}
