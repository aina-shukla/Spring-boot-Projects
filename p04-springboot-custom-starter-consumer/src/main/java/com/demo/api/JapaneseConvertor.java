package com.demo.api;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class JapaneseConvertor implements MessageConvertor {
	@Override
	public void translate(String s) {
		System.out.println("Japanese convertor: "+s);
	}
}
