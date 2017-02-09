package ua.jdbc.utils;

import ua.jdbc.domain.Employee;

import java.sql.*;

public class JDBCAdapter {

    private static final String DB_LOCALE = "jdbc:h2:~/accounting";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";

    public static final String EMPLOYEE_TABLE = "DROP TABLE IF EXISTS employee;" +
                                                "CREATE TABLE employee(id integer primary key,"
                                                                    + "name varchar(128))";

    public static final String SALARY_TABLE =   "DROP TABLE IF EXISTS salary;" +
                                                "CREATE TABLE salary(id integer primary key," +
                                                                    "date date," +
                                                                    "value double," +
                                                                    "empl_id int)";

    private PreparedStatement preparedStatement;
    Connection connection;

    public  void createTable(String query){
        connection = connect();
        try {

            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public  PreparedStatement getPreparedStatement(String query) throws SQLException{
        this.connection = connect();
        this.preparedStatement = connection.prepareStatement(query);
        return this.preparedStatement;
    }

    public void insert(PreparedStatement preparedStatement){
        try {
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }catch (SQLException se){se.printStackTrace();}
        }

    }


    private  Connection connect(){
        connection = null;
        try{
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(DB_LOCALE,DB_USERNAME,DB_PASSWORD);
            System.out.println("[connection created]");

        }
        catch (ClassNotFoundException cne){
            cne.printStackTrace();
        }
        catch (SQLException se){
            se.printStackTrace();
        }
        return connection;
    }

}
