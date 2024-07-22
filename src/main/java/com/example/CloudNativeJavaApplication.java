package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

@SpringBootApplication()
public class CloudNativeJavaApplication implements ApplicationListener {

	public static void main(String[] args) {
		SpringApplication.run(CloudNativeJavaApplication.class, args);
	}

	@Override
	public void onApplicationEvent(ApplicationEvent event) {

	}

}
