package com.didemo;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.supportingframework.DIFactory;
import com.supportingframework.exception.AutocreateAnnotationNotFound;
import com.supportingframework.vo.Message;
import com.supportingframework.vo.MessagePrinter;
import com.supportingframework.vo.SingletonMessagePrinter;

import junit.framework.Assert;

/**
 * Unit test for simple App.
 */
public class AppTest {
	final static Logger logger = Logger.getLogger(AppTest.class);
	@Test
	public void getPrototypeBean_Success() throws ClassNotFoundException {
		DIFactory context = DIFactory.getInstance();

		MessagePrinter printer1;
		try {
			printer1 = (MessagePrinter) context.getBean(MessagePrinter.class);
			logger.debug("prototype ojbect created and message is ::" + printer1.getMessage());
			assertEquals(1, printer1.ojbectCount);
			MessagePrinter printer2 = (MessagePrinter) context.getBean(MessagePrinter.class);
			logger.debug("prototype ojbect created and message is ::" + printer2.getMessage());
			assertEquals(1, printer2.ojbectCount);

		} catch (Exception e) {
			logger.error("getting object for Message Printer gives error.");
			e.printStackTrace();
		}

	}

	@Test
	public void getSingletonBean_Success() throws ClassNotFoundException {
		DIFactory context = DIFactory.getInstance();

		SingletonMessagePrinter printer1;
		try {
			printer1 = (SingletonMessagePrinter) context.getBean(SingletonMessagePrinter.class);
			logger.debug("singleton ojbect created and message is ::" + printer1.getMessage());
			assertEquals(1, printer1.ojbectCount);
			SingletonMessagePrinter printer2 = (SingletonMessagePrinter) context.getBean(SingletonMessagePrinter.class);
			logger.debug("singleton ojbect created and message is ::" + printer2.getMessage());
			assertEquals(2, printer2.ojbectCount);

		} catch (Exception e) {
			logger.error("getting object for SingletonMessagePrinter gives error.");
			e.printStackTrace();
		}

	}

	@Test
	public void getBean_error() throws ClassNotFoundException {
		DIFactory context = DIFactory.getInstance();

		try {
			assertEquals("Expected Error while creating exception", context.getBean(Message.class));
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException| AutocreateAnnotationNotFound e) {
			Assert.assertEquals( "autocreate annotation not found for given class",  e.getMessage() );
		}
	}
}
