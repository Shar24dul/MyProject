package com.project.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class logging {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Before("execution(* com.project.*.*Impl.*(..))")
	public void logBefore() {
		log.info("Before Call");
	}
	
	@After("execution(* com.project.*.*Impl.*(..))")
	public void logAfter() {
		log.debug("After Call");
	}
	
	@Pointcut("within(@org.springframework.stereotype.Repository *)" +
	        " || within(@org.springframework.stereotype.Service *)" +
	        " || within(@org.springframework.web.bind.annotation.RestController *)")
	    public void springBeanPointcut() {
	        // Method is empty as this is just a Pointcut, the implementations are in the advices.
	    }
	
	@AfterThrowing(pointcut = "springBeanPointcut()", throwing = "e")
	public void logError(JoinPoint joinPoint, Throwable e) {
		log.error("Error Thrown");
		log.error(joinPoint.getSignature().getName()+" "+e.getMessage());
	}
}
