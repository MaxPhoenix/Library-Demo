package com.bookstore.config;



import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;

public class PropertiesConfig  {

    private static PropertiesConfig propertiesConfig;

    private String JDBC_DRIVER;
    private String DB_BASE_URL;
    private String USER ;
    private String PASS ;

    private PropertiesConfig(){
        initializeParams();
    }

    private void initializeParams() {


        String properties_file_name = "jdbc.properties";
        InputStream ctxConfigProperties = this.getClass().getClassLoader().getResourceAsStream(properties_file_name);

        Properties properties = new Properties();
        try {
            properties.load(ctxConfigProperties);
            JDBC_DRIVER = properties.getProperty("JDBC_DRIVER");
            DB_BASE_URL = properties.getProperty("DB_BASE_URL");
            USER = properties.getProperty("USER");
            PASS = properties.getProperty("PASS");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static PropertiesConfig getPropertiesConfig() {
        return propertiesConfig;
    }

    public String getJDBC_DRIVER() {
        return JDBC_DRIVER;
    }

    public String getDB_BASE_URL() {
        return DB_BASE_URL;
    }

    public String getUSER() {
        return USER;
    }

    public String getPASS() {
        return PASS;
    }
}
