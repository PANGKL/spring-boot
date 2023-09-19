package com.hkjava.demoresttemplate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// Hamcrest -> Matchers
// JUnit5 -> Jupiter -> @Mock, @InjectMock, Mockito (when)
// What is SpringTest


// I am going test the Server Start Process, with
@SpringBootTest // With a complete context
// mvn test -> Simulate App Server Start & Bean Injection on Context
class DemoResttemplateApplicationTests {

	@Test
	void contextLoads() {} // test Server Start

}
