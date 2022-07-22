package com.example.myapplication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class operaciones {
    Connection connect;
    String ConnectionResult = "";

     public int adduser()
     {
         ConnectionHelper connectionHelper = new ConnectionHelper();
         try
         {
             connect = connectionHelper.connectionClass();
             String query = "insert into tbpersonas values (1,'Cesar Vega test', 'cesar.test','9999')";
             Statement st = connect.createStatement();
             st.executeUpdate(query);
             return 1;
         }
         catch (Exception ex)
         {
             return 0;
         }

    }
    public int getPassword(String usuario, String contraseña)
    {
        ConnectionHelper connectionHelper = new ConnectionHelper();
        try
        {
            connect = connectionHelper.connectionClass();
            String query = "SELECT usuario, contraseña FROM tbusuarios WHERE usuario = '"+usuario+"' and contraseña = '"+contraseña+"'";
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next())
            {
                return 1;
            }
            return 0;
        }
        catch (Exception ex)
        {
            return 0;
        }
    }

    public String getUsarName (String nomina)
    {
        ConnectionHelper connectionHelper = new ConnectionHelper();
        try
        {
            connect = connectionHelper.connectionClass();
            String query = "SELECT Nombre FROM tbpersonas WHERE Nomina = '"+nomina+"'";
            Statement st = connect.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next())
            {
                String nombre = rs.getString(1);
                return nombre;
            }
        }
        catch (Exception ex)
        {
                return "No existe";
        }
        return "no existe";
    }




}
