package com.EnergyAustralia.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.EnergyAustralia.helpers.Generic;
import com.EnergyAustralia.helpers.MusicFestivalDetailsNotFound;
import com.EnergyAustralia.pageobjects.MusicFestivalResultsPage;

import io.appium.java_client.android.AndroidElement;

public class MusicFestival extends Generic{
	
	public static List<AndroidElement> list;
	public static Map<String, String> music_festivals=new HashMap<>();
	public static MusicFestivalResultsPage page=new MusicFestivalResultsPage();
	public static String emptyResponse="Response wasn't successful or data empty. Response code: 429";
	public static String negativeBandDetails="Something went badly wrong";
	public static String negativeFestivalMessgae="Unknown";

	//Verifying whether app is returning any empty exceptions
	@Test
	public void validateEmptyResponse() throws MusicFestivalDetailsNotFound {
		
		music_festivals = page.fetchMusicFestivalDetails();
		for(Map.Entry<String, String> music_festival:music_festivals.entrySet()) {
			if(music_festival.getKey().contains(emptyResponse)) {
				//throwing Custom Exception appending with App error message
				throw new MusicFestivalDetailsNotFound("APP Throwing Exception - UI Exception is:"+emptyResponse);
			}
		}

	}

	//Verifying whether band names are displayed or any error message
	@Test
	public void validateBandDetails() throws MusicFestivalDetailsNotFound {
		
		music_festivals = page.fetchMusicFestivalDetails();
		for(Map.Entry<String, String> music_festival:music_festivals.entrySet()) {
			if(music_festival.getKey().contains(negativeBandDetails)) {
				//throwing Custom Exception appending with App error message
				throw new MusicFestivalDetailsNotFound("APP Throwing Exception - UI Exception is:"+music_festival.getKey());
			}
		}
	}

	//Verifying whether festive detail names are displayed or any error message
	@Test
	public void validateFestivalDetails() throws MusicFestivalDetailsNotFound {
		
		music_festivals = page.fetchMusicFestivalDetails();
			if(music_festivals.containsValue(negativeFestivalMessgae)) {
				//throwing Custom Exception appending with App error message
				throw new MusicFestivalDetailsNotFound("APP Throwing Exception - UI Exception is:"+negativeFestivalMessgae);
			}
	}
	


}
