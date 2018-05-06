package com.wise.bcms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wise.bcms.dto.Employee;
import com.wise.bcms.util.DBUtility;

public class EmployeeDAO {

	//adding an employee
	 public int add(Employee employee) {
		 int status = 0;
			final String QUERY = "insert into employee(employee_id,employee_name,role,doj,email, phone_no, password, activate)values(?, ?, ?, ?, ?, ?, ?, ?)";
			try(Connection connection = DBUtility.getConnection()){
				PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
				preparedStatement.setInt(1, employee.getId());
				preparedStatement.setString(2,employee.getName());
				preparedStatement.setString(3,employee.getRole());
				preparedStatement.setDate(4,(Date) employee.getDoj());
				preparedStatement.setString(5, employee.getEmail());
				preparedStatement.setLong(6, employee.getPhno());
				preparedStatement.setString(7, employee.getPassword());
				preparedStatement.setInt(8, employee.getActivate());
				status = preparedStatement.executeUpdate();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			return status;
	    }

	//gets list of employees
	public List<Employee> get() {
	 	final String QUERY = "select employee_id, employee_name, role, doj, email, phone_no, password from employee";
    	ResultSet resultSet = null;
    	List<Employee> list = new ArrayList<Employee>();
    	PreparedStatement preparedStatement = null;
    	try(Connection connection = DBUtility.getConnection()) {
    		preparedStatement = connection.prepareStatement(QUERY);
    		resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Employee employee = new Employee();
    
				employee.setId(resultSet.getInt(1));
				employee.setName(resultSet.getString(2));
				employee.setRole(resultSet.getString(3));
				employee.setDoj(DBUtility.convertFromSQLDateToUTILDate(resultSet.getDate(4)));
				employee.setEmail(resultSet.getString(5));
				employee.setPhno(resultSet.getInt(6));
				employee.setPassword(resultSet.getString(7));
				employee.setActivate(resultSet.getInt(8));
				list.add(employee);					
			}
		}catch(SQLException exception) {
			exception.printStackTrace();
		}
		finally {
			DBUtility.close(resultSet,preparedStatement);
		}
		return list;
	 }
	 
	 
	//gets an employ info for given id
	public Employee get(int employeeId) {
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		Employee employee = new Employee();
			final String QUERY = "select employee_id, employee_name, role, doj, email, phone_no, password from employee where id = ?";
			try(Connection connection = DBUtility.getConnection()){
				preparedStatement = connection.prepareStatement(QUERY);
				preparedStatement.setInt(1, employeeId);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					employee.setId(resultSet.getInt(1));
					employee.setName(resultSet.getString(2));
					employee.setRole(resultSet.getString(3));
					employee.setDoj(DBUtility.convertFromSQLDateToUTILDate(resultSet.getDate(4)));
					employee.setEmail(resultSet.getString(5));
					employee.setPhno(resultSet.getInt(6));
					employee.setPassword(resultSet.getString(7));
					employee.setActivate(resultSet.getInt(8));
				}
				
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			finally {
				DBUtility.close(resultSet,preparedStatement);
			}
		return employee;
	 }
	 
	 	//updates password of an employee
		public int update(int employeeId , String password) {
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			Employee employee = new Employee();
		int status = 0;
		Connection connection = DBUtility.getConnection();
		final String QUERY = "update employee set password = ? where employee_id = ?";
		try {
			preparedStatement = connection.prepareStatement(QUERY);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
			
			employee.setPassword(resultSet.getString(1));
			employee.setId(resultSet.getInt(2));
			
			status = preparedStatement.executeUpdate();
		}catch(SQLException exception) {
			exception.printStackTrace();
		}finally {
			DBUtility.close(preparedStatement, resultSet);
		}
		return status;
	}
}