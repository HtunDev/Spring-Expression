package com.HAH.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class ExpressionTest {
	
	@Test
	void firstExpression() {
		var StrExpression = "15 + 32";
		
		var parser = new SpelExpressionParser();
		var expression = parser.parseExpression(StrExpression);
		var result = expression.getValue(expression);
		assertEquals(47, result);
	}

}
