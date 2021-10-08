package com.kosmo88.logistics_erp.util.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
	private void wms() {
	}

	@Pointcut("execution(* dtoFunction..*.*(..))")
	private void dtoFunction() {
	}

	@Before("execution(* com.kosmo88.logistics_erp.wms..*.*(..))")
	public void beforeLog(JoinPoint jp) {
		logger.info("---- 메소드 실행 : " + jp.getSignature().toShortString() + "----");
		logger.info("--아-규멘또 : " + Arrays.toString(jp.getArgs()));
//		logger.info("------------------------------------------------------------");
	}

//	@After("wms()")
//	public void afterLog(JoinPoint jp) {
//		logger.info("--- " + jp. + "----");
//		logger.info("--아-규멘또 : " + Arrays.toString(jp.getArgs()));
//	}

	@AfterReturning(value = "wms()", returning = "obj")
	public void afterReturningLog(JoinPoint jp, Object obj) {
		logger.info("---- 메소드 종료 : " + jp.getSignature().toShortString() + "----");
		System.out.println("return: " + obj);
//		logger.info("------------------------------------------------------------");
	}


}// end of class SampleAdvice{}
