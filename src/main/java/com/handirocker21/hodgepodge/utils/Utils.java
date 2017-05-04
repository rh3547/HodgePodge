package com.handirocker21.hodgepodge.utils;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.handirocker21.hodgepodge.Reference;

public class Utils {
	private static Logger logger;
	private static Lang lang;
	
	public static Logger getLogger() {
		if (logger == null) {
			logger = LogManager.getFormatterLogger(Reference.MOD_ID);
		}
		return logger;
	}
	
	public static Lang getLang() {
		if (lang == null) {
			lang = new Lang(Reference.MOD_ID);
		}
		return lang;
	}
	
	public static boolean randChance(int percentChance) {
		int num = (percentChance / 10);
		Random rand = new Random();
		
		if (rand.nextInt(10) < num)
			return true;
		
		return false;
	}
}
