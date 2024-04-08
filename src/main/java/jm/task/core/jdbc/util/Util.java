package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static Connection connection;
    private String database = "jdbc:mysql://localhost:3306/testDB";
    private String userName = "root";
    private String password = "5986";
    private Util() {
        try {
            connection = DriverManager.getConnection(database, userName, password);
            System.out.println("Соединение успешно");
        } catch (SQLException exception) {
            throw new RuntimeException("Проблема с подключением к базе данных.");
        }
    }
    public static Connection getConnection() {
        if (connection == null) {
            new Util();
        }
        return connection;
    }
    public static void closeConnection() {
        try {
            connection.close();
            System.out.println("Успешное закрытие соединения");
        } catch (SQLException exception) {
            throw new RuntimeException("Не существует подключения для закрытия");
        }
    }
}
