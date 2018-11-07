package com.velan.zoho.utilities;

public class DriverFactory {
	
	
	private static String ChromeDriverExePath;
	private static String GeckoDriverExePath;
	private static String IEDriverExePath;
	private static String configPropetyFile;
	private static String gridPath;
	private static boolean isRemote;
	
	
	
	public static boolean isRemote() {
		return isRemote;
	}
	public static void setRemote(boolean isRemote) {
		DriverFactory.isRemote = isRemote;
	}
	public static String getChromeDriverExePath() {
		return ChromeDriverExePath;
	}
	public static void setChromeDriverExePath(String chromeDriverExePath) {
		ChromeDriverExePath = chromeDriverExePath;
	}
	public static String getGeckoDriverExePath() {
		return GeckoDriverExePath;
	}
	public static void setGeckoDriverExePath(String geckoDriverExePath) {
		GeckoDriverExePath = geckoDriverExePath;
	}
	public static String getIEDriverExePath() {
		return IEDriverExePath;
	}
	public static void setIEDriverExePath(String iEDriverExePath) {
		IEDriverExePath = iEDriverExePath;
	}
	public static String getConfigPropetyFile() {
		return configPropetyFile;
	}
	public static void setConfigPropetyFile(String configPropetyFile) {
		DriverFactory.configPropetyFile = configPropetyFile;
	}
	public static String getGridPath() {
		return gridPath;
	}
	public static void setGridPath(String gridPath) {
		DriverFactory.gridPath = gridPath;
	}
	

}
