package com.demo.api;

public class EnglishConvertor implements MessageConvertor {
	@Override
	public void translate(String s) {
		System.out.println("English convertor: "+s);
	}
}
