package com.supportingframework;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.supportingframework.annotations.AutoCreate;
import com.supportingframework.annotations.Scope;
import com.supportingframework.exception.AutocreateAnnotationNotFound;

@SuppressWarnings("rawtypes")
public class DIFactory {
	final static Logger logger = Logger.getLogger(DIFactory.class);
	private DIFactory() {}
	
    private static class SingletonClassHolder {
        static final DIFactory SINGLE_INSTANCE = new DIFactory();
    }
    public static DIFactory getInstance() {
        return SingletonClassHolder.SINGLE_INSTANCE;    
    }

	private static Map<Class, Object> applicationScope = new HashMap<>();

	public Object getBean(Class interfaceClass) throws InstantiationException, IllegalAccessException, ClassNotFoundException, AutocreateAnnotationNotFound {
		
		Annotation[] annotationClass=interfaceClass.getAnnotations();
		if(annotationClass==null || annotationClass.length == 0) {
			logger.debug("class does not have autocreate annotations ..");
			throw new AutocreateAnnotationNotFound("autocreate annotation not found for given class");
		}
		
		AutoCreate obj = (AutoCreate) interfaceClass.getAnnotations()[0];
		
		if (Scope.SINGLETON.equals(obj.scope())) {
			logger.debug("singleton");
			if (applicationScope.containsKey(interfaceClass)) {
				logger.debug("exisiting returned..");
				return applicationScope.get(interfaceClass);
			}
			System.out.println("new created..");
			synchronized (applicationScope) {
				Object service = interfaceClass.newInstance();
				applicationScope.put(interfaceClass, service);
				return service;
			}
		} else {
			Object service = interfaceClass.newInstance();
			return service;
		}
	}
}
