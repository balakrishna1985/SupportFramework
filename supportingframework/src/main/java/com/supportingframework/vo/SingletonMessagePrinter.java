package com.supportingframework.vo;

import com.supportingframework.annotations.AutoCreate;
import com.supportingframework.annotations.Scope;

@AutoCreate(scope= Scope.SINGLETON)
public class SingletonMessagePrinter {
	public int ojbectCount=0;

	public String getMessage() {
		return "Hello this is Singgleton class...."+ ++ojbectCount;
	}
}
