package com.jinkor.utils.datasource.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jinkor.utils.datasource.handler.IDynamicDataSourceHandler;

@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface IDynamicDataSourceAnnotation {
	String value() default IDynamicDataSourceHandler.MASTER;
}
