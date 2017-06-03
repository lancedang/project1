package com.ppdai.tutorial.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.ppdai.tutorial.DataMonth;

public class DataMonthTest {

	@Test
	public void testDataMonthConstructor() throws IOException {
		DataMonth dataMonth2 = new DataMonth("data/june_test.csv");
		DataMonth dataMonth = new DataMonth("data/june_test2.csv");
		assertEquals(2014, dataMonth.getYear());
		assertEquals(11, dataMonth.getMonth());
		assertEquals("TISH", dataMonth.getStationID());

		assertEquals(22.7, dataMonth.getSolarRadiationMin(), 0.01);
		assertEquals(27.67, dataMonth.getSolarRadiationMax(), 0.01);
		assertEquals(25.185, dataMonth.getSolarRadiationAverage(), 0.01);
		assertEquals(50.37, dataMonth.getSolarRadiationTotal(), 0.01);

		assertEquals(19.75, dataMonth.getWindSpeedMax(), 0.01);
		assertEquals(1.11, dataMonth.getWindSpeedMin(), 0.01);
		assertEquals(9.1733, dataMonth.getWindSpeedAverage(), 0.01);
	}

	@Test
	public void testToString() throws IOException {
		DataMonth dataMonth = new DataMonth("data/june_test.csv");
		String result = "2014-06, TISH: Wind = [1.1100, 9.1733, 19.7500], "
				+ "Solar Radiation = [22.7000, 25.1850, 27.6700, 50.3700]";
		assertEquals(result, dataMonth.toString());
	}

}
