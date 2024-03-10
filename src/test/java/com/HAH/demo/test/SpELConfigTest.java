package com.HAH.demo.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.expression.spel.SpelEvaluationException;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import com.HAH.demo.bean.Employee;

public class SpELConfigTest {

	@Test
	void without_ConfigTest() {

		assertThrows(SpelEvaluationException.class, () -> {
			var employee = new Employee();
			var parser = new SpelExpressionParser();
			var expression = parser.parseExpression("list[0] = 'Mg Mg'");
			expression.getValue(employee);
		});

	}
	
	@Test
	void with_ConfigTest() {

		assertDoesNotThrow(() -> {
			var config = new SpelParserConfiguration(true, true);
			var parser = new SpelExpressionParser(config);
			var expression = parser.parseExpression("list[0] = 'Mg Mg'");
			var employee = new Employee();
			var expressEmployee = expression.getValue(employee);
			System.out.println(expressEmployee);
			assertEquals(1, employee.getList().size());
			assertEquals("Mg Mg", employee.getList().get(0));
		});

	}
	
	

}
