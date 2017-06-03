package com.ppdai.tutorial.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ppdai.tutorial.DataDay;
import com.ppdai.tutorial.Sample;

public class DataDayTest {

	@Test
	public void testDataDayConstructor() {
		Sample solarRadation = new Sample(30.1234);
		Sample windMin = new Sample(3.1234);
		Sample windAve = new Sample(13.1234);
		Sample windMax = new Sample(23.1234);
		DataDay dataDay = new DataDay(2017, 6, 3, "station", solarRadation,windMax, windMin, windAve );

		assertEquals(2017, dataDay.getYear());
		assertEquals(6, dataDay.getMonth());
		assertEquals(3, dataDay.getDay());
		assertEquals("station", dataDay.getStationID());

		assertEquals(solarRadation, dataDay.getSolarRadiation());
		assertEquals(windMin, dataDay.getWindSpeedMin());
		assertEquals(windAve, dataDay.getWindSpeedAverage());
		assertEquals(windMax, dataDay.getWindSpeedMax());

	}

	@Test
	public void testToString() {
		Sample solarRadation = new Sample(30.34);
		Sample windMin = new Sample(3);
		Sample windAve = new Sample(13.12345);
		Sample windMax = new Sample(23.1234);
		DataDay dataDay = new DataDay(2017, 6, 3, "station", solarRadation,windMax, windMin, windAve );

		assertEquals("2017-6-3, UPLAND: Wind = [3.0000, 13.1235, 23.1234], Solar Radiation = 30.3400",
				dataDay.toString());
	}

}
