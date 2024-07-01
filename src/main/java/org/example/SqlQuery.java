package org.example;


public class SqlQuery {
    public final static String GetEmployeByID="select * from employees where employeeNumber=? ";
    public final static String GetEmployeeByOfficeCode= "select * from employees where officeCode > ? ";
}
