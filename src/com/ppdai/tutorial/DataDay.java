package com.ppdai.tutorial;

/**
 * 
 * @author CS2334. Modified by: ?????
 *         <P>
 *         Date: 2015-09-10 <BR>
 *         Project 1
 *         <P>
 *         This class represents a summary of one day's data from a single
 *         Mesonet station.
 *
 */

public class DataDay {
	/** Year in which the data were sampled */
	private int year;
	/** Month in which the data were sampled */
	private int month;
	/** The day on which the data were sampled (1=January, 2=February, etc */
	private int day;

	// TODO: Fill in remaining components
	private String stationID;

	private Sample windSpeedMax;
	private Sample windSpeedMin;
	private Sample windSpeedAverage;
	private Sample solarRadiation;

	/**
	 * DataDay constructor
	 * 
	 * @param year
	 *            Year of the sample
	 * @param month
	 *            Month of the sample
	 * @param day
	 *            Day of the sample
	 * @param solarRadiation
	 *            Amount of solar radiation (in Mj/m^2)
	 * @param stationID
	 *            Station identifier
	 * @param windSpeedMin
	 *            Minimum wind speed
	 * @param windSpeedAverage
	 *            Average wind speed
	 * @param windSpeedMax
	 *            Maximum wind speed
	 */
	public DataDay(int year, int month, int day, String stationID, Sample solarRadiation, Sample windSpeedMax, Sample windSpeedMin,
			Sample windSpeedAverage) {

		// TODO: complete implementation
		this.year = year;
		this.month = month;
		this.day = day;
		this.stationID = stationID;
		this.solarRadiation = solarRadiation; //column ATOT in csv file
		this.windSpeedMin = windSpeedMin;
		this.windSpeedAverage = windSpeedAverage;
		this.windSpeedMax = windSpeedMax;
	}

	// TODO: supply the getters

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public String getStationID() {
		return stationID;
	}

	public Sample getWindSpeedMax() {
		return windSpeedMax;
	}

	public Sample getWindSpeedMin() {
		return windSpeedMin;
	}

	public Sample getWindSpeedAverage() {
		return windSpeedAverage;
	}

	public Sample getSolarRadiation() {
		return solarRadiation;
	}

	/**
	 * Describe the data for the day
	 * 
	 * @return String describing the day
	 */
	public String toString() {
		// TODO: complete the implementation
		return this.year + "-" + this.month + "-" + this.day + ", " + "UPLAND: Wind = [" + this.windSpeedMin + ", "
				+ this.windSpeedAverage + ", " + this.windSpeedMax + "], " + "Solar Radiation = " + this.solarRadiation;
	}
}
