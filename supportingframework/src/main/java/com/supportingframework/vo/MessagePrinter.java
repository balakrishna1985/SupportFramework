package com.supportingframework.vo;

import com.supportingframework.annotations.AutoCreate;
import com.supportingframework.annotations.Scope;

@AutoCreate(scope= Scope.PROTOTYPE)
public class MessagePrinter{
	
	public int ojbectCount=0;

	public String getMessage() {
		return "Hello ....this is protorype class.."+ ++ojbectCount;
	}
}
