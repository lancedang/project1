package com.ppdai.tutorial;

import java.io.IOException;

public class Driver {
	public static void main(String[] args) throws IOException {
		DataMonth dataMonth = new DataMonth("data/june_2015.csv");

		System.out.println(dataMonth);

	}
}
