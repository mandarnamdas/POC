package com;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	@Pointcut("execution(private * com.*.*(..))")
	public void publicMethod(){
		
	}
	
	@Around("publicMethod()")
	public Object insertLog(ProceedingJoinPoint joinPoint) throws Throwable {		
		System.out.println("INSIDE");
		Object object = joinPoint.proceed();
		System.out.println("OUTSIDE");
		return object;		
	}
}
