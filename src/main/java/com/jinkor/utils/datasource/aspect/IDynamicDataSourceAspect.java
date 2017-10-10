package com.jinkor.utils.datasource.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.jinkor.utils.datasource.annotation.IDynamicDataSourceAnnotation;
import com.jinkor.utils.datasource.handler.IDynamicDataSourceHandler;

@Aspect
@Order(-9999)
@Component
public class IDynamicDataSourceAspect {

	@Pointcut("execution(* com.jinkor.service.*.*(..))")
	public void aspectMethod() {}
	
	/**
     * 在进入Service方法之前执行
     * @param point 切面对象
     * @throws SecurityException 
     * @throws NoSuchMethodException 
     */
	@Before(value = "aspectMethod()")
    public void before(JoinPoint point) throws NoSuchMethodException, SecurityException {
    	MethodSignature methodSignature = (MethodSignature) point.getSignature();  
    	Method method = methodSignature.getMethod(); 
    	routingCheck(method, point.getTarget().getClass());
    }
    
    
    private void routingCheck(Method method, Class<?> clazz) throws NoSuchMethodException, SecurityException {
    	String key = null;
    	//判断被代理的对象是否有 DynamicDataSourceRouting注解
    	method = clazz.getDeclaredMethod(method.getName(), method.getParameterTypes());
    	if (method.isAnnotationPresent(IDynamicDataSourceAnnotation.class)) {
    		key = method.getAnnotation(IDynamicDataSourceAnnotation.class).value();
    	} else {
    		if(clazz.isAnnotationPresent(IDynamicDataSourceAnnotation.class)) {
    			key = clazz.getAnnotation(IDynamicDataSourceAnnotation.class).value();
    		} else {
    			key = IDynamicDataSourceHandler.MASTER;
    		}
    	}
    	IDynamicDataSourceHandler.putDataSourceKey(key);
    }
}
