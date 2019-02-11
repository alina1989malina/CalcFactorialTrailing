package com.factorial.calcFactorialTrailing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

import static com.factorial.calcFactorialTrailing.service.FactorialService.getFactorialTrail;
import static org.junit.Assert.assertTrue;
import static com.factorial.calcFactorialTrailing.service.FactorialService.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalcFactorialTrailingApplicationTests {

	@Test
	public void test() {
		assertTrue(getFactorialTrail(0L) == 0);

		assertTrue(getFactorialTrail(1L) == 0);

		assertTrue(getFactorialTrail(2L) == 0);

		assertTrue(getFactorialTrail(4L) == 0);

		assertTrue(getFactorialTrail(5L) == 1);

		assertTrue(getFactorialTrail(6L) == 1);

		assertTrue(getFactorialTrail(12L) == 2);

		assertTrue(getFactorialTrail(120L) == 28);

		assertTrue(getFactorialTrail(555L) == 137);
	}

	@Test
	public void randomTestForMonotonyProperty() {

		Random randomno = new Random();

		for(int i = 0; i < 2; i++){
			long value1 = randomno.nextInt();
			long value2 = randomno.nextInt();
			if (value1 > value2)
				assert(getFactorialTrail(value1) >= getFactorialTrail(value2));
			else
				assert(getFactorialTrail(value1) <= getFactorialTrail(value2));
		}

	}

}

