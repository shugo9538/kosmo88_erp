package com.kosmo88.logistics_erp.util.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LogAdvice {

	private static final Logger logger = LoggerFactory.getLogger(LogAdvice.class);

	@Pointcut("execution(* com.kosmo88.logistics_erp.wms..*.*(..))")
    private void wms() {}

	@Pointcut("execution(* dtoFunction..*.*(..))")
    private void dtoFunction() {}


	@Before("execution(* com.kosmo88.logistics_erp.wms..*.*(..)) || dtoFunction()")
//	@Before("publicTarget()")
	public void logging(JoinPoint jp) {
		logger.info("-------------------------------");
		logger.info("메소드 실행 : " + jp.getSignature().toShortString());
		logger.info("아-규멘또 : " + Arrays.toString(jp.getArgs()));
		logger.info("-------------------------------");
		logger.trace(jp.toShortString());
		logger.debug(jp.getSignature().toString());
	}// end of startLog()
	
//	@Around("execution(* com.kosmo88.logistics_erp.wms..*.*(..))")
//	public void debug(JoinPoint jp) {
//	}
	
//	@Around("execution(* dtoFunction.DtoFunction.set*(..))")
//	public void logDtoProperties(JoinPoint jp) {
//	}

}// end of class SampleAdvice{}
