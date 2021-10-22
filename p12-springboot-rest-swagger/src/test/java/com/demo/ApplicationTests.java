package com.demo;

import com.demo.exceptions.SomeException;
import com.utils.Calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

	@Test
	public void testCondition(){
		int x = 55;
		int y = 41;

		// requirement is x should be greater than y
		Assertions.assertEquals(true, x>y);
	}


	@Test
	public void shouldAdd5nums(){
		Calculator calc = new Calculator();
		int r = calc.add(1,2,3,4,5);

		Assertions.assertEquals(15, r);
	}

	@Test
	public void shouldNotDivByZero() throws SomeException{
		Calculator calc = new Calculator();

		Assertions.assertThrows(SomeException.class, ()->{
			calc.div(5, 0);
		});



	}
}
