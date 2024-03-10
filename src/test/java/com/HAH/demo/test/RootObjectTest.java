package com.HAH.demo.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import com.HAH.demo.bean.Student;

public class RootObjectTest {

	@Test
	void rootTest() {
		var student = new Student("Htun Aung Hlaing", 23, List.of("Java", "Spring", "Angular", "React"));
		var parser = new SpelExpressionParser();
		var expression = parser.parseExpression("name");
		var expressName = (String) expression.getValue(student);
//		var expressName = expression.getValue(student,String.class);
		System.out.println(expressName);

		expression = parser.parseExpression("age");
		var expressAge = expression.getValue(student, Integer.class);
		System.out.println(expressAge);

		expression = parser.parseExpression("interest");
		var expressInterest = expression.getValue(student, List.class);
		System.out.println(expressInterest);
		System.out.println(expressInterest.get(0));

		expression = parser.parseExpression("interest[0]");
		var expressInterest1 = expression.getValue(student, String.class);
		System.out.println(expressInterest1);

	}

}
