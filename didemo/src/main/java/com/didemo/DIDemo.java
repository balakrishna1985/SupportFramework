package com.didemo;

import org.apache.log4j.Logger;

import com.supportingframework.DIFactory;
import com.supportingframework.exception.AutocreateAnnotationNotFound;
import com.supportingframework.vo.Message;
import com.supportingframework.vo.MessagePrinter;
import com.supportingframework.vo.SingletonMessagePrinter;

public class DIDemo {
	
	final static Logger logger = Logger.getLogger(DIDemo.class);
	public static void main(String args[]) throws InstantiationException, IllegalAccessException, ClassNotFoundException, AutocreateAnnotationNotFound {
		logger.debug("this is starting of supporting framework");

		DIFactory context = DIFactory.getInstance();

		MessagePrinter printer1 = (MessagePrinter) context.getBean(MessagePrinter.class);
		logger.debug(printer1.getMessage());

		MessagePrinter printer2 = (MessagePrinter) context.getBean(MessagePrinter.class);
		logger.debug(printer2.getMessage());

		SingletonMessagePrinter singleton1 = (SingletonMessagePrinter) context.getBean(SingletonMessagePrinter.class);
		logger.debug(singleton1.getMessage());

		SingletonMessagePrinter singleton2 = (SingletonMessagePrinter) context.getBean(SingletonMessagePrinter.class);
		logger.debug(singleton2.getMessage());

		MessageVO demoVO = (MessageVO) context.getBean(MessageVO.class);
		logger.debug(demoVO.getMessage());
		
		Message message;
		try {
			message = (Message) context.getBean(Message.class);
			logger.debug(message.getMessage());
		} catch (Exception e) {
			logger.error("getting instance of Message class got error and error is : #" + e.getMessage());
		}

	}

}
