# SupportFramework
A simple DI that enables us experience the pre 2002 days, where DI is not yet invented.


# Project Description
## DIDemo: 
This is the demo module which uses supporting framework as dependency. In this module, we demo the creation 
and utilization of dependency framework we created.

## SupportingFramework:
This module is the key module where we see the implementation of key logic and it's declaration along with 
definition. This mainly focuses on entities that creates the beans and exceptions that are passed to any module 
uses this framework.

## Usage
The following snippet explains how to use this framework that gives you dependency injection utility.

		@AutoCreate
		public class MessageVO {
			public String getMessage() {
				return "Message from " + this.getClass().getName();
			}
		}

The above is a simple class with a simple annoation '@AutoCreate' which does the magic of makin this class avaialble
anywhere you want in your project. 

You can access the above 'MessageVO' class in your project with just one following line.

MessageVO messageClass = DIFactory.getInstance().getBean(MessageVO.class);


## Build project
Clone the following repo to your machine to build the project.
https://github.com/balakrishna1985/SupportFramework.git

After clone, we need to build our supportingFramework module ready for your project.
Execute the following command from supportingFramework.

		mvn eclipse:eclipse

## Run project
After building supportingFramework, it creates a jar and made available in your local maven repository.
From your main demo module, run the following to run your main project.

		mvn clean install
