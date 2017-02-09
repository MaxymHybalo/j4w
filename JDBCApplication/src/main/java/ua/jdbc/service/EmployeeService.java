package ua.jdbc.service;

import ua.jdbc.domain.Employee;
import ua.jdbc.utils.JDBCAdapter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    private static final String EMPLOYEE_INSERT = "INSERT INTO employee (id,name) values(?,?)";
    private static final String EMPLOYEE_SELECT = "SELECT * FROM employee";

    public void add(Employee employee) throws SQLException{

        JDBCAdapter adapter = new JDBCAdapter();
        PreparedStatement preparedStatement = adapter.getPreparedStatement(EMPLOYEE_INSERT);
        preparedStatement.setInt(1,employee.getId());
        preparedStatement.setString(2,employee.getName());
        System.out.println("[ADDED] Employee: " + employee.getName());
        adapter.insert(preparedStatement);

    }

    public List<Employee> findAll() throws  SQLException{
        JDBCAdapter adapter = new JDBCAdapter();
        PreparedStatement preparedStatement = adapter.getPreparedStatement(EMPLOYEE_SELECT);
        ResultSet rs = preparedStatement.executeQuery();
        List<Employee> result = new ArrayList<Employee>();
        while (rs.next()){
            Employee e = new Employee(rs.getInt("id"), rs.getString("name"));
            result.add(e);
        }
        return result;
    }


}
