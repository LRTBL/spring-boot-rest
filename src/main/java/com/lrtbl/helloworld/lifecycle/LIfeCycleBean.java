package com.lrtbl.helloworld.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LIfeCycleBean implements BeanNameAware {

    private static final Logger log = LoggerFactory.getLogger(LIfeCycleBean.class);
    @Override
    public void setBeanName(String s) {
        log.info("mi nombre es {}", s);
    }

    @PostConstruct
    public void init () {
        log.info("me construi");
    }

    @PreDestroy
    public void destroy () {
        log.info("me destrui");
    }
}
