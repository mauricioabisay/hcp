package mx.hcp.config;

import java.util.Hashtable;
import java.util.Map;

import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.sql.DataSource;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@Configuration
@EnableJpaRepositories(basePackages = "mx.hcp.repositories", 
entityManagerFactoryRef = "entityManagerFactoryBean",
transactionManagerRef = "jpaTransactionManager")
@EnableTransactionManagement
@ComponentScan(
		basePackages = "mx.hcp",
		excludeFilters = @ComponentScan.Filter(Controller.class)
)
public class RootConfig {
	
	@Bean
	public LocalValidatorFactoryBean localValidatorFactoryBean() {
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		validator.setProviderClass(HibernateValidator.class);
		return validator;
	}
	
	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor() {
		MethodValidationPostProcessor processor = new MethodValidationPostProcessor();
		processor.setValidator(this.localValidatorFactoryBean());
		return processor;
	}
	
	@Bean
    public DataSource springJpaDataSource() throws ClassNotFoundException {
        JndiDataSourceLookup lookup = new JndiDataSourceLookup();
        lookup.setResourceRef(true);        
        return lookup.getDataSource("jdbc/homeopata");
        
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() throws ClassNotFoundException {
        Map<String, Object> properties = new Hashtable<>();
        properties.put("javax.persistence.schema-generation.database.action",
                "none");

        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");

        LocalContainerEntityManagerFactoryBean factory =
                new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(adapter);
        factory.setDataSource(this.springJpaDataSource());
        factory.setPackagesToScan("mx.hcp.entities");
        factory.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE);
        factory.setValidationMode(ValidationMode.NONE);
        factory.setJpaPropertyMap(properties);
        return factory;
    }

    @Bean
    public PlatformTransactionManager jpaTransactionManager() throws ClassNotFoundException {
        return new JpaTransactionManager(
                this.entityManagerFactoryBean().getObject()
        );
    }
	
}