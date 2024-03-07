package time;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {

	@Test
	void testGetTotalSecondsGood() {
		int result = Time.getTotalSeconds("05:05:05:14");
		assertTrue("Seconds not calculated properly",result==18305);
	}
	
	@Test
	void testGetTotalSecondsBoundary() {
		int result = Time.getTotalSeconds("23:59:59:13");
		assertTrue("Seconds not calculated properly",result==86399);
	}
	
	

	@Test
	void testGetTotalSecondBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class,
				()-> {Time.getTotalSeconds("10:00");});
	}

	
	@Test 
	void testGetSecondsGood() {
		int seconds= Time.getSeconds("20:00:15:99");
		assertTrue("Seconds not calculated properly",seconds==15);
	}
	
	@Test 
	void testGetSecondsBoundary() {
		int seconds= Time.getSeconds("23:59:00:786");
		assertTrue("Seconds not calculated properly",seconds==0);
	}
	
	@Test
	void testGetSecondsBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class,
				()-> {Time.getSeconds("20:0");});
	}
	
	

	
	@ParameterizedTest
	@ValueSource(strings = { "00:15:00:09", "59:15:15:12",
	"59:15:59:45" })
	void testGetTotalMinutesGoodandBoundary(String candidate) {
	int minutes = Time.getTotalMinutes(candidate);
	assertTrue("The minutes were not calculated properly",
	minutes ==15);
	}
	
	
	@Test
	void testGetTotalMinutesBad() {
		assertThrows(
				NumberFormatException.class,
				()-> {Time.getTotalSeconds("10:00:29:2024");});
	}
	
	

	@ParameterizedTest
	@ValueSource(strings = { "05:00:00", "05:15:15:34",
	"05:59:59" })
	void testGetTotalHoursGoodandBoundary(String candidate) {
	int hours = Time.getTotalHours(candidate);
	assertTrue("The hours were not calculated properly",
	hours ==5);
	}



	@Test
	void testGetTotalHoursBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class,
				()-> {Time.getTotalSeconds("10,00");});
	}
	
	@Test
	void testGetMillisecondsGood() {
		int milliSeconds= Time.getMilliseconds("20:00:15:50");
		assertTrue("Milliseconds not calculated properly",milliSeconds==50);
		
		
	}
	
	@Test
	void testGetMillisecondsBoundary() {
		int milliSeconds= Time.getMilliseconds("20:00:15:999");
		assertTrue("Milliseconds not calculated properly",milliSeconds==999);
		
		
	}
	@Test
	void testGetMilliSecondsBad() {
		assertThrows(
				StringIndexOutOfBoundsException.class,
				()-> {Time.getMilliseconds("20");});
	}
	
	
	
}
