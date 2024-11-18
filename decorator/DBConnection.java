package lab10.decorator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lombok.SneakyThrows;

public class DBConnection {

    private static DBConnection dbconnection;
    private Connection connection;

    @SneakyThrows
    private DBConnection() {
        this.connection = DriverManager
                        .getConnection("/Users/bagiro4ka2410icloud.com/Desktop/lab10/cache.db");
        }

    @SneakyThrows
    public String getDocument(String gcsPath) {
        PreparedStatement statement =
        connection.prepareStatement("SELECT * FROM DOCUMENT WHERE path=?");
        statement.setString(1, gcsPath);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.getString("parsed");
    }

    @SneakyThrows
    public void createDocument(String gcsPath, String parse) {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO test(path, parsed) VALUES(?,?)");
        preparedStatement.setString(1, gcsPath);
        preparedStatement.setString(2, gcsPath);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public static DBConnection getInstance() {
        if (dbconnection == null) {
            dbconnection = new DBConnection();
        }
        return dbconnection;
    }

}
