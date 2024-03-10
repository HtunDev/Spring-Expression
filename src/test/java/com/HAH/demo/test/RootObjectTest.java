package com.HAH.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import com.HAH.demo.bean.Address;
import com.HAH.demo.bean.Student;

public class RootObjectTest {

	ExpressionParser parser;

	@BeforeEach
	void gettingParser() {
		parser = new SpelExpressionParser();
	}

	@Test
	void rootTest() {
		var student = new Student("Htun Aung Hlaing", 23, List.of("Java", "Spring", "Angular", "React"));

		var expression = parser.parseExpression("name");
		var expressName = (String) expression.getValue(student);
//		var expressName = expression.getValue(student,String.class);
		System.out.println(expressName);

		if (expression.isWritable(student)) {
			expression.setValue(student, "Maung Maung");
		}
		
		System.out.println(student.getName());

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

	@Test
	void recordTest() {
		var address = new Address("San Pya", "120/F", "Pyi G Thakon");
		var expression = parser.parseExpression("street");
		var expressStreet = (String) expression.getValue(address);
		System.out.println(expressStreet);
		assertEquals(address.street(), expressStreet);

		expression = parser.parseExpression("building");
		var expressBuilding = (String) expression.getValue(address);
		System.out.println(expressBuilding);
		assertEquals(address.building(), expressBuilding);

		expression = parser.parseExpression("townShip");
		var expressTownShip = (String) expression.getValue(address);
		System.out.println(expressTownShip);
		assertEquals(address.townShip(), expressTownShip);
	}

}
