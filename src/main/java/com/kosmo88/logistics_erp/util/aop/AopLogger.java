package com.kosmo88.logistics_erp.util.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class AopLogger {

	private static final Logger logger = LoggerFactory.getLogger(AopLogger.class);

//	@Pointcut("execution(* com.kosmo88.logistics_erp.wms..*.*(..))")
//    private void publicTarget() {
//    }


	@Before("execution(* com.kosmo88.logistics_erp.wms..*Service.*(..))")
//	@Before("publicTarget()")
	public void logging(JoinPoint jp) {
		logger.info("-------------------------------");
		logger.info("메소드 실행 : " + jp.getSignature().toShortString());
		logger.info("아-규멘또 : " + Arrays.toString(jp.getArgs()));
		logger.info("-------------------------------");
	}// end of startLog()
}// end of class SampleAdvice{}
