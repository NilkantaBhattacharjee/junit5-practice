package com.nil.business;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

public class UtilityTest {

	private Utility utility;

	@BeforeEach
	public void initialize() {
		utility = new Utility();
	}

	@Test
	public void testAdd() {
		assertEquals(4, utility.add(2, 2), "Add two numbers");
	}

	@Test
	public void testDivideWithExceptionScenario() {
		assertThrows(ArithmeticException.class, () -> utility.divide(1, 0));
	}
	
	@Test
	@DisplayName("Test for non-implemented method")
	@Disabled
	public void testNonImplementedMethod() {
		fail("This test class should not be run");
	}
	
	@Nested
	class AddTest {
		@Test
		@DisplayName("Test Adding two positive numbers")
		public void TestAddTwoPositiveNumbers() {
			assumeTrue(utility != null);
			// assumeFalse(utility != null);
			assertEquals(10, utility.add(4, 6));
		}
		
		@Test
		@DisplayName("Test Adding two negative numbers")
		@EnabledOnOs(value = OS.WINDOWS)
		@EnabledOnJre(value = JRE.JAVA_8)
		public void TestAddTwoNegativeNumbers() {
			assertEquals(-2, utility.add(4, -6));
		}
		
		@Test
		@DisplayName("Test Adding two negative numbers")
		@EnabledOnOs(value = OS.LINUX)
		@EnabledOnJre(value = JRE.JAVA_8)
		public void TestAddTwoNegativeNumbersOnLinux() {
			assertEquals(-2, utility.add(4, -6));
		}
	}
	
	@Test
	public void testAddWithAssertAll() {
		assertAll(
			() -> assertEquals(10, utility.add(4, 6)),
			() -> assertEquals(100, utility.add(40, 60)),
			() -> assertEquals(2, utility.add(-4, 6))
		);
	}
}
