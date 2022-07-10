package com.example.myapplication;
import java.sql.Connection;
import java.sql.DriverManager;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

public class ConnectionHelper {
    Connection con;
    String uname;
    String pass;
    String ip;
    String port;
    String database;
    private Log log;
    @SuppressLint("NewApi")
    public Connection connectionClass()
    {
        ip= "192.168.0.149";
        database= "Compras";
        uname= "compras";
        pass= "Start001";
        port="1433";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String ConnectionURL = null;

        try
        {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURL ="jdbc:jtds:sqlserver://"+ip+":"+port+";"+"databasename="+database+";user="+uname+";password="+pass+";";
            connection = DriverManager.getConnection(ConnectionURL);

        }
        catch (Exception ex)
        {

            Log.e("Error ", ex.getMessage());

        }
        return connection;
    }

}
