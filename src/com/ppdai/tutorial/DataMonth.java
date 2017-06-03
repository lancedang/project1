package com.ppdai.tutorial;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * 
 * @author CS2334. Modified by: ?????
 *         <P>
 *         Date: 2015-09-10 <BR>
 *         Project 1
 *         <P>
 *         This class represents the data for all of the days within a single
 *         month
 *
 */

public class DataMonth {
	/** The set of days. */
	private ArrayList<DataDay> days;

	// TODO: complete implementation
	private double windSpeedMax;
	private double windSpeedAverage;
	private double windSpeedMin;

	private double solarRadiationMax;
	private double solarRadiationAverage;
	private double solarRadiationMin;
	private double solarRadiationTotal;

	private int year;
	private int month;

	private String stationID;

	/**
	 * DataMonth constructor
	 * <P>
	 * This constructor:
	 * <UL>
	 * <LI>Reads in the file, creating one DataDay object for each row
	 * <LI>Places each DataDay object into an ArrayList
	 * <LI>Closes the file
	 * <LI>Computes the solar radiation and windSpeed statistics
	 * <LI>Sets the month and year to be equal to those of the first day
	 * </UL>
	 * 
	 * @param fileName
	 *            The name of a file that contains the data for a month. For
	 *            this project, it will be of the form "data/YYYY.csv"
	 * 
	 * @throws IOException
	 *             Error reading the file
	 */
	public DataMonth(String fileName) throws IOException {
		// TODO: complete implementation
		days = new ArrayList<>();

		FileReader fileReader = new FileReader(fileName);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		DataDay dataDay;
		String dayLine = bufferedReader.readLine();
		dayLine = bufferedReader.readLine();

		while (dayLine != null) {
			// get every item
			String[] items = dayLine.split(",");

			int year = Integer.parseInt(items[0]);
			int month = Integer.parseInt(items[1]);
			int day = Integer.parseInt(items[2]);

			String stationID = items[3];
			Sample solarRadiation = new Sample(Double.parseDouble(items[4]));

			Sample windSpeedMax = new Sample(Double.parseDouble(items[5]));
			Sample windSpeedMin = new Sample(Double.parseDouble(items[6]));
			Sample windSpeedAverage = new Sample(Double.parseDouble(items[7]));

			dataDay = new DataDay(year, month, day, stationID, solarRadiation, windSpeedMax, windSpeedMin,
					windSpeedAverage);
			days.add(dataDay);

			// read next line
			dayLine = bufferedReader.readLine();
		}

		// initialize the DataMonth's year and month
		this.year = days.get(0).getYear();
		this.month = days.get(0).getMonth();
		this.stationID = days.get(0).getStationID();

		// close file
		fileReader.close();
		bufferedReader.close();

		// call private function to initialize instance variable
		computeSolarRadiationStats();
		computeWindSpeedStats();

	}

	/**
	 * Compute and fill in the solar radiation-related statistics
	 * (solarRadiationMin, solarRadiationMax, solarRadiationAverage, and
	 * solarRadiationTotal).
	 * <P>
	 * Notes:
	 * <UL>
	 * <LI>Only valid samples can be used in these computations
	 * <LI>You may assume that every month has at least one valid sample
	 * </UL>
	 */
	private void computeSolarRadiationStats() {

		double min = days.get(0).getSolarRadiation().getValue();
		double max = min;
		double total = 0;
		int invalidCount = 0;

		for (DataDay day : days) {
			double tmp = day.getSolarRadiation().getValue();
			if (tmp <= -900) {
				invalidCount++;
				continue;
			}
			if (min > tmp) {
				min = tmp;
			}
			if (max < tmp) {
				max = tmp;
			}
			total += tmp;
		}

		//save in 4 digit
		DecimalFormat decimalFormat = new DecimalFormat("####0.0000");

		solarRadiationMin = Double.parseDouble(decimalFormat.format(min));
		solarRadiationMax = Double.parseDouble(decimalFormat.format(max));
		solarRadiationTotal = Double.parseDouble(decimalFormat.format(total));
		solarRadiationAverage = Double.parseDouble(decimalFormat.format(total / (days.size() - invalidCount)));

	}

	/**
	 * Compute and fill in the windSpeed-related statistics:
	 * <UL>
	 * <LI>windSpeedMin: minimum of the daily windSpeedMins
	 * <LI>windSpeedMax: maximum of the daily windSpeedMaxes
	 * <LI>windSpeedAverage: average of the daily windSpeedAverages
	 * </UL>
	 * <P>
	 * Notes:
	 * <UL>
	 * <LI>Only valid samples can be used in these computations
	 * </UL>
	 */
	private void computeWindSpeedStats() {
		// TODO: complete implementation
		double min = days.get(0).getWindSpeedMin().getValue();
		double max = days.get(0).getWindSpeedMax().getValue();
		double total = 0;

		for (DataDay day : days) {
			double tmpMin = day.getWindSpeedMin().getValue();
			double tmpMax = day.getWindSpeedMax().getValue();

			if (min > tmpMin) {
				min = tmpMin;
			}
			if (max < tmpMax) {
				max = tmpMax;
			}
			total += day.getWindSpeedAverage().getValue();
		}

		DecimalFormat decimalFormat = new DecimalFormat("#####0.0000");

		windSpeedMin = Double.parseDouble(decimalFormat.format(min));
		windSpeedMax = Double.parseDouble(decimalFormat.format(max));
		windSpeedAverage = Double.parseDouble(decimalFormat.format(total / days.size()));
	}

	// TODO: provide specified getters only

	public ArrayList<DataDay> getDays() {
		return days;
	}

	public double getWindSpeedMax() {
		return windSpeedMax;
	}

	public double getWindSpeedAverage() {
		return windSpeedAverage;
	}

	public double getWindSpeedMin() {
		return windSpeedMin;
	}

	public double getSolarRadiationMax() {
		return solarRadiationMax;
	}

	public double getSolarRadiationAverage() {
		return solarRadiationAverage;
	}

	public double getSolarRadiationMin() {
		return solarRadiationMin;
	}

	public double getSolarRadiationTotal() {
		return solarRadiationTotal;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public String getStationID() {
		return stationID;
	}

	/**
	 * Describe the month
	 * 
	 * @return A string describing all of the days and the statistics for the
	 *         month
	 */
	public String toString() {
		// TODO: complete implementation
		String windMin = String.format("%.4f", this.windSpeedMin);
		String windAve = String.format("%.4f", this.windSpeedAverage);
		String windMax = String.format("%.4f", this.windSpeedMax);

		String solarMin = String.format("%.4f", this.solarRadiationMin);
		String solarAve = String.format("%.4f", this.solarRadiationAverage);
		String solarMax = String.format("%.4f", this.solarRadiationMax);
		String solarTotal = String.format("%.4f", this.solarRadiationTotal);

		//output like "06"
		String mon = this.month < 10 ? "0" + this.month : this.month + "";

		return this.year + "-" + mon + ", " + "TISH: Wind = [" + windMin + ", " + windAve + ", " + windMax
				+ "], " + "Solar Radiation = [" + solarMin + ", " + solarAve + ", " + solarMax + ", " + solarTotal
				+ "]";

	}

}
