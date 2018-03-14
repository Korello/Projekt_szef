package main_menagment;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class DataTable {
	private static JTextField textField;
	private static JTextField textField_1;
  public static void main(String args[]) 
  {
	    //deklaracja tablicy wierszy oraz nazw kolumn
	  	Object[][] rows = {};
		final Object[] columnNames = {"Id", "Name", "Salary"};
		 
		// zmienna pomocnicza do ustawienia id
		Employee q = new Employee();
		
		
	    //deklaracja tabeli
		DefaultTableModel listTableModel;
	    listTableModel = new DefaultTableModel(rows, columnNames);
		 
    //deklaracja i zdefiniowanie wygl¹du okna
    JFrame frame = new JFrame("Workers Data Table");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    JTable table = new JTable(listTableModel);
    JScrollPane pane = new JScrollPane(table);
    pane.setBounds(0, 99, 447, 169);
    frame.getContentPane().add(pane);
    
    //pole pierwsze imie i nazwisko
    textField = new JTextField();
    textField.setBounds(161, 28, 114, 20);
    frame.getContentPane().add(textField);
    textField.setColumns(10);
    
    // pole drugie kwota rocznej pensji
    textField_1 = new JTextField();
    textField_1.setBounds(301, 28, 114, 20);
    frame.getContentPane().add(textField_1);
    textField_1.setColumns(10);
   
    //pusta label do wyswietlania wiadomosci
    JLabel Message = new JLabel("");
    Message.setBounds(188, 70, 247, 16);
    frame.getContentPane().add(Message);
    frame.setSize(463, 306);
    frame.setVisible(true);
   
    // zdefiniowanie dzia³ania przycisku dodaj¹cego dane do tabeli
    JButton btnNewButton = new JButton("Add worker");
    btnNewButton.setToolTipText("");
    btnNewButton.setBounds(12, 7, 114, 26);
    btnNewButton.addActionListener(new ActionListener() 
    {
    	public void actionPerformed(ActionEvent e) 
    	{
    		Message.setText("");
    		// zdefioniowanie miejsca z którego bêd¹ pobierane dane do tabeli
    		if(!textField.getText().equals(""))
    		
    			try
    			{
    				Double a;
    	    		a = Double.parseDouble(textField_1.getText());
    	    		//double g = Double.parseDouble("");
    	    		String o1;
    				o1 = textField.getText();
    	    		q.setId();
    				listTableModel.addRow(new Object[]{  q.getId(),textField.getText(), textField_1.getText()});
    			}
    			catch (Exception e1) 
    			{
    				Message.setText("Salary must be a number");
    			}
    			 else
    			{
    				Message.setText("Must be name and forname ");
    				
    			}
    	}
    });
    frame.getContentPane().add(btnNewButton);
    
    // pola z testem opisuj¹cym pola do wype³nienia
    JLabel lblNewLabel = new JLabel("Name & Forname");
    lblNewLabel.setBounds(169, 0, 106, 16);
    frame.getContentPane().add(lblNewLabel);
    
    JLabel lblSalary = new JLabel("Salary");
    lblSalary.setBounds(326, 0, 56, 16);
    frame.getContentPane().add(lblSalary);
    
    // przycisk usuwania danego wiersza
    JButton btnNewButton_1 = new JButton("Delete Row");
    btnNewButton_1.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) 
    	{
    		
    		DefaultTableModel model =(DefaultTableModel) table.getModel();
    		try
    		{
    		int SelectedrowIndex = table.getSelectedRow();
    		model.removeRow(SelectedrowIndex);
    		}
    		catch(Exception ex)
    		{
    			JOptionPane.showMessageDialog(frame, "Nothing is selected");
    		}
    	}
    });
    btnNewButton_1.setBounds(12, 61, 114, 26);
    frame.getContentPane().add(btnNewButton_1);
    
    
  }
}


