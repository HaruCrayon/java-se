package com.mhl.service;

import com.mhl.dao.EmployeeDAO;
import com.mhl.domain.Employee;

/**
 * @author LiJing
 * @version 1.0
 */
public class EmployeeService {
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    public Employee getEmployeeByIdAndPwd(String empId, String pwd) {
        Employee employee =
                employeeDAO.querySingle("select * from employee where empId = ? and pwd = md5(?)", Employee.class, empId, pwd);

        return employee;
    }
}
