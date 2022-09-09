package be.abvvfgtb.bali.member.facade.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Bali Member Facade Server main class.
 */

//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
/*@SpringBootApplication(exclude = {
        JdbcTemplateAutoConfiguration.class,
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        AopAutoConfiguration.class,
        ConfigurationPropertiesAutoConfiguration.class,
        LifecycleAutoConfiguration.class,
        PersistenceExceptionTranslationAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})*/
//@ComponentScan(basePackages = {"be.abvvfgtb.bali.member.facade.server.database"})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
