package mx.indexpro.dao;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conecta {
	private static Connection connection = null;
    public static Connection getConnection() {
        if (connection != null) {
            System.out.println("success!!!");
            return connection;
        }
        else {
            try {
            	Properties prop = new Properties();
                InputStream inputStream = Conecta.class.getClassLoader().getResourceAsStream("mx/indexpro/dao/config.properties");
                prop.load(inputStream);
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            System.out.println(driver+" "+url+ " "+user+" "+password);
            } catch (ClassNotFoundException e) {
                System.out.println("error!!!!");
            } catch (SQLException e) {
            } catch (FileNotFoundException e) {
            } catch (IOException e) {
            }
            return connection;
        }

    }
}
