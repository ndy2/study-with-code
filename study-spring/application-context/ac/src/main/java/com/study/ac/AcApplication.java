package com.study.ac;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

import lombok.Getter;

/**
 * ApplicationContext study based on
 * 토비 - <a href="http://y2u.be/f017PD5BIEc">[스프링 부트 앱에 초기화 코드를 넣는 방법 3가지]</a>
 */
@SpringBootApplication
public class AcApplication {

	public static void main(String[] args) {
		final ConfigurableApplicationContext ac = SpringApplication.run(AcApplication.class, args);
		ac.addApplicationListener(e -> System.out.println("hello ApplicationEvent source : " + e.getSource()));
		ac.publishEvent(new ApplicationEvent("source") {
		});

		ac.addApplicationListener(
			(ApplicationListener<MyEvent>)e -> System.out.println("hello my event message: " + e.getMessage()));
		ac.publishEvent(new MyEvent("source", "message"));
	}

	//1. CommandLineRunner
	@Bean
	public CommandLineRunner myCommandLineRunner() {
		return args -> System.out.println("Hello CommandLineRunner");
	}

	//2. ApplicationRunner
	@Bean
	public ApplicationRunner myApplicationRunner() {
		return args -> System.out.println("Hello ApplicationRunner");
	}

	//3. @EventListener(ApplicationReadyEvent.class)
	@EventListener(ApplicationReadyEvent.class)
	public void helloApplicationReadyEvent() {
		System.out.println("hello ApplicationReadyEvent");
	}

	//4. ApplicationEvent + EventListener
	@Getter
	static class MyEvent extends ApplicationEvent {

		private final String message;

		public MyEvent(final Object source, final String message) {
			super(source);
			this.message = message;
		}
	}
}
