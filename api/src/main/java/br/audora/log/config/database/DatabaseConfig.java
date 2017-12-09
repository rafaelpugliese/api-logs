package br.audora.log.config.database;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.audora.log.config.properties.DataBaseProperties;

@Configuration
@EnableJpaRepositories("br.audora.log.repository")
@EnableTransactionManagement
public class DatabaseConfig {

	@Autowired
	private DataBaseProperties dataBaseProperties;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

		driverManagerDataSource.setDriverClassName(dataBaseProperties.getDriver());
		driverManagerDataSource.setUrl(dataBaseProperties.getUrl());
		driverManagerDataSource.setUsername(dataBaseProperties.getUser());
		driverManagerDataSource.setPassword(dataBaseProperties.getPassword());
		return driverManagerDataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean eMF = new LocalContainerEntityManagerFactoryBean();

		eMF.setDataSource(dataSource());
		eMF.setPackagesToScan("br.audora.log");

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		eMF.setJpaVendorAdapter(vendorAdapter);

		Properties properties = new Properties();
		properties.put("hibernate.dialect", dataBaseProperties.getDialect());
		properties.put("hibernate.show_sql", dataBaseProperties.isShow_sql());
		properties.put("hibernate.hbm2ddl.auto", dataBaseProperties.getHbm2ddl_auto());
		eMF.setJpaProperties(properties);

		return eMF;
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

}