package com.bookstore.daos;

import com.bookstore.config.PropertiesConfig;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Logger;


public abstract class BaseDAO {

    protected Connection conn ;
    protected Statement stmt;
    protected PreparedStatement preparedStatement ;
    protected ResultSet rs ;
    protected String BOOK_SCHEME;

    protected final String DB_URL = PropertiesConfig.getPropertiesConfig().getDB_BASE_URL();
    protected final String USER = PropertiesConfig.getPropertiesConfig().getUSER();
    protected final String PASS = PropertiesConfig.getPropertiesConfig().getPASS();


    private String BOOKSTORE_SCHEME;

    public BaseDAO (){

        String properties_file_name = "scheme.properties";
        InputStream ctxConfigProperties = this.getClass().getClassLoader().getResourceAsStream(properties_file_name);

        Properties properties = new Properties();
        try {
            properties.load(ctxConfigProperties);
            BOOKSTORE_SCHEME = properties.getProperty("BOOK_SCHEME");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Register JDBC driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void logDebug(String msg){
        Logger.getLogger(this.getClass().getName()).info(msg);
    }
}
