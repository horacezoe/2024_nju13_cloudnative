package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Nju13CloudNativeApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	void exampleTest() {
		int expected = 42;
		int actual = 40 + 2;
		assertEquals(expected, actual, "The sum should be 42");
	}

}
