package com.kosmo88.logistics_erp.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class AopLogger {

	private static final Logger logger = LoggerFactory.getLogger(AopLogger.class);

//	logger.info("Welcome home! The client locale is {}.", locale);
	@Before("execution(* com.kosmo88.logistics_erp..*.*(..))")
	public void logging(JoinPoint jp) {
		logger.info("-------------------------------");
		logger.info("메소드 실행 : " + jp.getSignature().toShortString());
		logger.info("아-규멘또 : " + Arrays.toString(jp.getArgs()));
		logger.info("-------------------------------");
	}// end of startLog()
}// end of class SampleAdvice{}
