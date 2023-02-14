package com.EnergyAustralia.pageobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.EnergyAustralia.helpers.Generic;

import io.appium.java_client.android.AndroidElement;

public class MusicFestivalResultsPage extends Generic {

	public static List<AndroidElement> band_Name_List;
	public static Map<String, String> musicFestivals;

	//Fetching all the festival details with bands or adding the error to the map
	public Map<String, String> fetchMusicFestivalDetails() {

		band_Name_List = new ArrayList<>();
		musicFestivals = new HashMap<>();

		//Band names list
		band_Name_List = driver.findElementsById("com.energyaustralia.codingtestsample:id/titleTextView");
		
		for (int i = 0; i < band_Name_List.size(); i++) {
			
			//band name
			String band_Name = driver.findElementsByClassName("android.widget.LinearLayout").get(i)
					.findElementById("com.energyaustralia.codingtestsample:id/titleTextView").getText();
			//festival name
			String festival_Name = driver.findElementsByClassName("android.widget.LinearLayout").get(i)
					.findElementById("com.energyaustralia.codingtestsample:id/festivalTextView").getText();
			
			if(i==8) {
				break;
			}

			musicFestivals.put(band_Name, festival_Name);
			
		}
		return musicFestivals;
	}

}
