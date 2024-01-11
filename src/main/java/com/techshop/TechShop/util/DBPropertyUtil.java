package com.techshop.TechShop.util;

import java.util.Properties;

public class DBPropertyUtil {
	
	public static String getConnectionString() {
		
        Properties properties = new Properties();
        properties.setProperty("db.url", "jdbc:mysql://localhost:3306/techshop");
        properties.setProperty("db.user", "Lucky");
        properties.setProperty("db.password", "password123");
        String url = properties.getProperty("db.url", "");
        String user = properties.getProperty("db.user", "");
        String password = properties.getProperty("db.password", "");
        return url +"?useSSL=false&user=" + user + "&password=" + password;
    }

}
