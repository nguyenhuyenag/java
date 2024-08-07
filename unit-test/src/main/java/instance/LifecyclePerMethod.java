package instance;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(Lifecycle.PER_METHOD)
public class LifecyclePerMethod {

	@BeforeAll
	static void beforeAllInit() {
		System.out.println("running before all");
	}

	@AfterAll
	static void afterAllCleanUp() {
		System.out.println("running after all");
	}

	@BeforeEach
	void init() {
		System.out.println("running before each...");
	}

	@AfterEach
	void cleanUp() {
		System.out.println("running after each...");
	}

	@Test
	void test1() {
		assertEquals(2, 2);
	}
	
	@Test
	void test2() {
		assertEquals(true, true);
	}
	
	@Test
	void test3() {
		assertEquals(true, false);
	}

}
