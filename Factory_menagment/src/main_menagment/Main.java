package main_menagment;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Main {

public static void main(String[] args) {

	Object[][] rowData = {};
	 Object[] columnNames = {"Name", "Salary"};
	 
	ArrayList<Employee> staff = new ArrayList<>();
	
	staff.add(new Employee("julka tulka", 33333));
	staff.add(new Employee("julka asd", 22222));
	
	 
	
	
	DefaultTableModel listTableModel;
    listTableModel = new DefaultTableModel(rowData, columnNames);
	
    for (Employee e : staff)
    {
        String rowString = e.getName();
        listTableModel.addRow(new Object[]{rowString, e.getSalary(),e.getName()});
    }

    

    JTable listTable;
    listTable = new JTable(listTableModel);
   
    listTable.setCellEditor(null);
   
    
    
    JFrame frame = new JFrame("Scrollless Table");
    frame.add(listTable);
    frame.setVisible(true);
    frame.pack();
    frame.setSize(300, 150);
    

}
}


class Employee
{
	private static int nextId = 1;
	
	private String name;
	private double salary;
	private int id;
	
	
	public Employee(String n, double s)
	{
	
		name = n;
		salary = s;
		id = 0;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	public int geId()
	{
		return id;
	}
	
	public void setId()
	{
		id = nextId;
		nextId++;
	}
	
	public static int getNextId()
	{
		return nextId;
	}
	
}
	        
