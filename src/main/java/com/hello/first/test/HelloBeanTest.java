package com.hello.first.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hello.first.HelloJava;
import com.hello.first.Printer;

public class HelloBeanTest {
	public static void main(String[] args) {
		// IoC �����̳� ����
		ApplicationContext context =
				new GenericXmlApplicationContext("config/beans.xml");
		
		// HelloJava Bean ��������
		HelloJava hello = (HelloJava) context.getBean("HelloJava");
		
		System.out.println(hello.sayHello());
		hello.print();
		
		// StringPrinter Bean �������� 
		Printer printer = (Printer) context.getBean("printer");
		System.out.println(printer.toString());
		
		
		HelloJava hello2 = context.getBean("HelloJava", HelloJava.class);
		hello2.print();
		
		System.out.println(hello == hello2);	// true : IoC�����̳ʰ� Bean�� Singleton���� �����Ѵ�
	}
}
