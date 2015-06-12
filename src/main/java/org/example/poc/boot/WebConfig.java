package org.example.poc.web.app;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Jackson2Helper;
import com.github.jknack.handlebars.Options;
import com.github.jknack.handlebars.springmvc.HandlebarsViewResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@SuppressWarnings("unused")
public class WebConfig extends WebMvcConfigurerAdapter
{
    @Autowired
    private Environment environment;

    @Value("${app.cacheTemplates}")
    private boolean cacheTemplates;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/webjars/**")) {
            registry.addResourceHandler("/webjars/**").addResourceLocations(
                    "classpath:/META-INF/resources/webjars/");
        }
    }

    @Bean
    public ViewResolver getViewResolver() {
        HandlebarsViewResolver viewResolver = new HandlebarsViewResolver();

        viewResolver.registerHelper("json", Jackson2Helper.INSTANCE);
        viewResolver.registerHelper("prop", new Helper<String>() {
            @Override
            public CharSequence apply(String name, Options options) {
                return environment.getProperty(name);
            }
        });

        viewResolver.setCache(cacheTemplates);
        viewResolver.setPrefix("classpath:/templates");
        viewResolver.setSuffix(".hbs");

        return viewResolver;
    }
}
