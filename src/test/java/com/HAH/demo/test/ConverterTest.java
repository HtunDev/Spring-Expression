package com.HAH.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class ConverterTest {
	
	@Test
	void converterTest() {
		var parser = new SpelExpressionParser();
		var expression = parser.parseExpression("'100'");
		var result = expression.getValue(Integer.class);
		System.out.println(result);
	}

}
