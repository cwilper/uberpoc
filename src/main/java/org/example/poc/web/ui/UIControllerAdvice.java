package org.example.poc.web.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
@SuppressWarnings("unused")
public class UIControllerAdvice
{
    @Autowired
    Environment environment;

    @ModelAttribute("useMinifiedJavascript")
    boolean useMinifiedJavascript() {
        return "true".equals(environment.getProperty("useMinifiedJavascript"));
    }
}
