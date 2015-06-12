package org.example.poc.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("org.example.poc")
@EnableAutoConfiguration
public class Boot
{
    private static Logger logger = LoggerFactory.getLogger(Boot.class);

    @Autowired
    private ConfigurableApplicationContext appContext;

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication();
        // TODO: read plugins dir and add thier packages via setSources
        //app.setSources();
        app.run(Boot.class, args);
    }

    public void stop() {
        logger.info("Stopping..");
        appContext.close();
    }
}
