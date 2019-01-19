package com.bookstore.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;


public abstract class BaseDAO {

    protected Connection conn ;
    protected Statement stmt ;
    protected ResultSet rs ;

    private String BOOKSTORE_SCHEME;

    public BaseDAO (){
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
