package com.kosmo88.logistics_erp.util;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class ConverterContext {
    @Bean(name = "conversionService")
    @Autowired
    public ConversionService getConversionService(final Set<Converter<?, ?>> set) {
        ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
        set.add(new DateConverter());
        conversionServiceFactoryBean.setConverters(set);
        conversionServiceFactoryBean.afterPropertiesSet();
        return conversionServiceFactoryBean.getObject();
    }
}