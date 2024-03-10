package com.HAH.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class ExpressionTest {

	ExpressionParser parser;

	@BeforeEach
	void gettingParser() {
		parser = new SpelExpressionParser();
	}

	@Test
	void firstExpression() {
		var expression = parser.parseExpression("15 + 32");
		var result = (Integer) expression.getValue();
		System.out.println(result);
		assertEquals(47, result);
	}

	@Test
	void usingGenericMethod() {
		var expression = parser.parseExpression("{1,2,3,4,5,6}");
		var result = (List<Integer>)expression.getValue();
		System.out.println(result.size());
		assertNotNull(result);
	}

}
