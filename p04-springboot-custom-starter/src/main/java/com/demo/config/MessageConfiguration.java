package com.demo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo.api.EnglishConvertor;
import com.demo.api.MessageConvertor;

@Configuration
@ConditionalOnClass(MessageConvertor.class)
public class MessageConfiguration {

	@Bean
	@ConditionalOnMissingBean
	public MessageConvertor messageConvertor() {
		return new EnglishConvertor();
	}
	
	
}
