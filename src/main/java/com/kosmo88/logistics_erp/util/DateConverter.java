package com.kosmo88.logistics_erp.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(final String arg0) {
        if (StringUtils.isNotEmpty(arg0)) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(arg0);
            } catch (Throwable e) {
                return null;
            }
        } else {
            return null;
        }
    }
}