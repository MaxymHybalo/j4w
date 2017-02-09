package ua.jdbc;

import ua.jdbc.domain.Employee;
import ua.jdbc.domain.Salary;
import ua.jdbc.ui.SimpleJTable;
import ua.jdbc.utils.JDBCAdapter;
import ua.jdbc.service.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Main {

    Main() throws SQLException{

        JDBCAdapter adapter = new JDBCAdapter();
        /*
         * To Create new table's
         */
        adapter.createTable(JDBCAdapter.EMPLOYEE_TABLE);
        adapter.createTable(JDBCAdapter.SALARY_TABLE);

        /*
         * To set data into table's
         */
        EmployeeService employeeService = new EmployeeService();
        employeeService.add(new Employee(1,"Alex"));
        employeeService.add(new Employee(2,"Rob"));
        employeeService.add(new Employee(3,"Ted"));

        SalaryService salaryService = new SalaryService();
        salaryService.add(new Salary(1,LocalDate.of(2016,1,7),500,1));
        salaryService.add(new Salary(2,LocalDate.of(2016,2,7),800,1));
        salaryService.add(new Salary(3,LocalDate.of(2016,3,7),600,1));

        salaryService.add(new Salary(4,LocalDate.of(2016,1,7),300,2));
        salaryService.add(new Salary(5,LocalDate.of(2016,2,7),400,2));
        salaryService.add(new Salary(6,LocalDate.of(2016,3,7),500,2));

        salaryService.add(new Salary(7,LocalDate.of(2016,1,7),1000,3));
        salaryService.add(new Salary(8,LocalDate.of(2016,2,7),1800,3));
        salaryService.add(new Salary(9,LocalDate.of(2016,3,7),1600,3));
        /*
         * To show result table
         */
        showTable(generateTableData(employeeService,salaryService));

    }
    public static void main(String[] args){

        try{

            new Main();

        }catch(SQLException e){
            System.out.println("Something wrong: \n" + e.getMessage());
        }

    }

    private Object[][] generateTableData(EmployeeService employeeService, SalaryService salaryService) throws SQLException{
        List<Employee> employees = employeeService.findAll();
        Object [][] result = new Object[employees.size()][3];
        for (int i = 0; i < employees.size(); i++) {
            result[i][0] = employees.get(i).getId();
            result[i][1] = employees.get(i).getName();
            result[i][2] = getSalaryAmount(salaryService.findByEmployee(employees.get(i)));
        }
        return result;
    }

    private double getSalaryAmount(List<Salary> salaries){
        double result = salaries.stream()
                .map(s -> s.getValue())
                .reduce(new Double("0"),(x,y)->x+=y);
        return result;
    }

    private void showTable(Object [][] data){

        Object [] headers = {"#","Name","Salary Amount"};

        new SimpleJTable("JDBC - task",
                data,
                headers);
    }
}
