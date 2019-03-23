package com.illusory.i.shop.commons.context;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author Administrator
 * @version 1.0.0
 * @date 2019/3/23 0023
 */
public class SpringContext implements ApplicationContextAware, DisposableBean {
    private static final Logger logger = LoggerFactory.getLogger(SpringContext.class);
    private static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContext.applicationContext = applicationContext;
    }

    public void destroy() throws Exception {
        logger.info("清空 applicationContext");
        applicationContext = null;
    }

    public static <T> T getBean(String beanId) {
        return (T) applicationContext.getBean(beanId);
    }

    /**
     * 断言 Context 已经注入
     */
    private static void assertContextInjected() {
        Validate.validState(applicationContext != null, "applicationContext 属性未注入，请在 spring-context.xml 配置中定义 SpringContext");
    }
}
