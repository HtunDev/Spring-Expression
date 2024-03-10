package com.HAH.demo.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

import com.HAH.demo.bean.Address;

public class SimpleEvaluationTest {

	ExpressionParser parser;

	@BeforeEach
	void gettingParser() {
		parser = new SpelExpressionParser();
	}

	@Test
	void simpleTest() {
		var address = new Address("San Pya", "120/F", "Pyi G Thakon");
		var expression = parser.parseExpression("building + ' , ' + street + ' , ' + townShip");
		var context = SimpleEvaluationContext.forReadOnlyDataBinding().withRootObject(address).build();
		var addressExpression = expression.getValue(context, String.class);
		System.out.println(addressExpression);
	}

}
