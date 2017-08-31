package vn.com.imic.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
	
	@Value("${jdbc.driverClassName}")
	private String driverClass;

	@Value("${jdbc.password}")
	private String password;

	@Value("${jdbc.username}")
	private String username;
	
	@Value("${hibernate.dialect}")
	private String hibernateDialert;
	
	@Value("${jdbc.url}")
	private String url;

	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClass);
		dataSource.setPassword(password);
		dataSource.setUsername(username);
		dataSource.setUrl(url);
		return dataSource;
	}
	
	@Bean
	@Autowired
	public LocalSessionFactoryBean sessionFactory(DriverManagerDataSource dataSource) {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan("vn.com.imic.model");
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}
	
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(sessionFactory);
       return txManager;
    }
    
    @Bean
    @Autowired
    public HibernateTemplate hibernateTemplate(SessionFactory sessionFactory) {
    	return new HibernateTemplate(sessionFactory);
    }
    
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", hibernateDialert);
        properties.put("hibernate.show_sql", false);
        properties.put("hibernate.format_sql", false);
        properties.put("hibernate.enable_lazy_load_no_trans", true);
        //TODO Comment dong nay sau khi chay chuong trinh de tao database
		//properties.put("hibernate.hbm2ddl.auto", "create");
        return properties;        
    }

}
