package com.ppdai.tutorial.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ppdai.tutorial.Sample;

public class SampleTest {

	@Test
	public void testEmptySampleConstructor() {
		Sample sample = new Sample();

		assertEquals(0, sample.getValue(), 0.01);
		assertFalse(sample.isValid());
	}

	@Test
	public void testNotEmptySampleConstructor() {
		Sample sample1 = new Sample(10.45);
		Sample sample2 = new Sample(-1000.12345);

		assertEquals(10.45, sample1.getValue(), 0.01);
		assertTrue(sample1.isValid());

		assertEquals(-1000.12345, sample2.getValue(), 0.01);
		assertFalse(sample2.isValid());
	}

	@Test 
	public void testToString() {
		Sample sample1 = new Sample(10.45);
		Sample sample2 = new Sample(-1000.12345);

		assertEquals("10.4500", sample1.toString());
		assertEquals("invalid", sample2.toString());
	}

}
