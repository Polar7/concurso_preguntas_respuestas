package model.dataBase;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Clase que permite conectarse a una base de datos
 */
public class ConnectionDB
{
    private static ConnectionDB dataSource = null;
    private Connection con;

    private ConnectionDB()
    {
        Properties conProperties = new Properties();

        try
        {
            conProperties.load(new FileInputStream("data/connection.properties"));

            String url = conProperties.getProperty("url");
            String user = conProperties.getProperty("user");
            String password = conProperties.getProperty("password");

            con = DriverManager.getConnection(url, user, password);

            System.out.println("Successful connection");

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static ConnectionDB getInstance()
    {
        if (dataSource == null){
            dataSource = new ConnectionDB();
        }
        return dataSource;
    }

    public boolean runExecuteUpdate(String sql)
    {

        int rows=0;
        try {
            Statement statement = con.createStatement();
            rows = statement.executeUpdate(sql);
            System.out.println("Successful query: "+sql);
            return true;
        } catch (SQLException e) {
            System.out.println("Query error: "+e.getMessage());
            return false;
        }
    }
}
