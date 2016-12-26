package ua.jdbc.service;


import ua.jdbc.domain.Employee;
import ua.jdbc.domain.Salary;
import ua.jdbc.utils.JDBCAdapter;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SalaryService {

    private static final String SALARY_INSERT = "INSERT INTO salary (id,date,value,empl_id) values(?,?,?,?)";
    private static final String SALARY_SELECT = "SELECT * FROM salary";
    private static final String SALARY_BY_EMPLOYEE = "SELECT * FROM salary WHERE empl_id = ?";

    public void add(Salary salary) throws SQLException{
        JDBCAdapter adapter = new JDBCAdapter();
        PreparedStatement preparedStatement = adapter.getPreparedStatement(SALARY_INSERT);
        preparedStatement.setInt(1,salary.getId());
        preparedStatement.setDate(2, Date.valueOf(salary.getDate()));
        preparedStatement.setDouble(3,salary.getValue());
        preparedStatement.setInt(4,salary.getEmplId());
        System.out.println("[ADDED] Salary: " + salary.getEmplId());
        adapter.insert(preparedStatement);
    }

    public List<Salary> findAll() throws  SQLException{
        JDBCAdapter adapter = new JDBCAdapter();
        PreparedStatement preparedStatement = adapter.getPreparedStatement(SALARY_SELECT);
        ResultSet rs = preparedStatement.executeQuery();
        List<Salary> result = new ArrayList<Salary>();
        while (rs.next()){
            Salary s = new Salary(rs.getInt("id"),
                    rs.getDate("date").toLocalDate(),
                    rs.getDouble("value"),
                    rs.getInt("empl_id"));

            result.add(s);
        }
        return result;
    }

    public List<Salary> findByEmployee(Employee employee) throws  SQLException{
        JDBCAdapter adapter = new JDBCAdapter();
        PreparedStatement preparedStatement = adapter.getPreparedStatement(SALARY_BY_EMPLOYEE);
        preparedStatement.setInt(1,employee.getId());
        ResultSet rs = preparedStatement.executeQuery();
        List<Salary> result = new ArrayList<Salary>();
        while (rs.next()){
            Salary s = new Salary(rs.getInt("id"),
                    rs.getDate("date").toLocalDate(),
                    rs.getDouble("value"),
                    rs.getInt("empl_id"));

            result.add(s);
        }
        return result;
    }
}
