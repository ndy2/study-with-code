package com.study.ac;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.BDDAssertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.study.ac.code.Hello;
import com.study.ac.code.Printer;
import com.study.ac.code.StringPrinter;

class AcApplication2Test {
	@Test
	void staticApplicationContext_registerSingleton_사용() {
		//given
		StaticApplicationContext ac = new StaticApplicationContext();
		ac.registerSingleton("안녕", Hello.class);

		//when
		Hello hello = ac.getBean("안녕", Hello.class);

		then(hello).isNotNull();
	}

	@Test
	void staticApplicationContext_registerBeanDefinition_사용() {
		//given
		StaticApplicationContext ac = new StaticApplicationContext();
		BeanDefinition beanDefinition = BeanDefinitionBuilder
			.rootBeanDefinition(Hello.class)
			.addPropertyValue("name", "하하")
			.getBeanDefinition();

		ac.registerBeanDefinition("안녕", beanDefinition);

		//when
		Hello hello = ac.getBean("안녕", Hello.class);

		then(hello.sayHello()).isEqualTo("Hello 하하");
	}

	@Test
	void Hello_와_Printer_를_연결하여_빈등록() {
		//given
		StaticApplicationContext ac = new StaticApplicationContext();
		// 프린터 등록
		ac.registerSingleton("프린터", StringPrinter.class);

		// 안녕 등록
		ac.registerBeanDefinition("안녕", BeanDefinitionBuilder
			.rootBeanDefinition(Hello.class)
			.addPropertyValue("name", "하하")
			.addPropertyValue("printer", new RuntimeBeanReference("프린터"))
			.getBeanDefinition());

		//when
		Hello hello = ac.getBean("안녕", Hello.class);
		Printer printer = ac.getBean("프린터", Printer.class);

		//then
		hello.print();
		assertThat(hello.sayHello()).isEqualTo("Hello 하하");
		assertThat(printer.toString()).isEqualTo("Hello 하하");
	}

	@Test
	void GenericApplicationContext_XmlBeanDefinitionReader() {
		//given
		GenericApplicationContext ac = new GenericApplicationContext();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(ac);
		reader.loadBeanDefinitions("classpath:bean-definition.xml");
		ac.refresh();

		//when
		Hello hello = ac.getBean("안녕", Hello.class);

		//then
		assertThat(hello.sayHello()).isEqualTo("Hello 하하");
	}


	@Test
	void GenericApplicationContext_PropertiesBeanDefinitionReader() {
		//given
		GenericApplicationContext ac = new GenericApplicationContext();
		PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(ac);
		reader.loadBeanDefinitions("classpath:bean-definition.properties");
		ac.refresh();

		//when
		Hello hello = ac.getBean("hello", Hello.class);

		//then
		assertThat(hello.sayHello()).isEqualTo("Hello haha");
	}

	@Test
	void GenericXmlApplicationContext() {
		//given
		GenericApplicationContext ac = new GenericXmlApplicationContext(new ClassPathResource("bean-definition.xml"));

		//when
		Hello hello = ac.getBean("안녕", Hello.class);

		//then
		assertThat(hello.sayHello()).isEqualTo("Hello 하하");
	}

}