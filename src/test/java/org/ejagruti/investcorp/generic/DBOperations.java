package org.ejagruti.investcorp.generic;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;

public class DBOperations {

	
	public static java.sql.Connection GetDBConnectionObject(String MachineName,String DBName,String DBUser,String DBPassword,String DBPortNumber) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			java.sql.Connection conn= DriverManager.getConnection("jdbc:mysql://"+MachineName+":"+DBPortNumber+"/"+DBName,DBUser,DBPassword);
			return conn;
		
	}
	public static ArrayList<String> GetAllTables(java.sql.Connection dbConnectionObject) throws SQLException
	{
		ResultSet rs=dbConnectionObject.getMetaData().getTables(dbConnectionObject.getCatalog(), null, "%", null);
		ArrayList<String> allTables=new ArrayList<String>();
		while (rs.next()) {
			  allTables.add(rs.getString(3));
			}
		return allTables;
		
	}
	public static ArrayList<String> GetPrimaryKeyColumnName(java.sql.Connection dbConnectionObject,String TableName) throws SQLException
	{
		ArrayList<String> pkcolnames=new ArrayList<String>();
		String sql="SELECT distinct(column_name) FROM key_column_usage WHERE constraint_name='primary' AND"
				+ " table_name='"+TableName+"'";
		ResultSet res=dbConnectionObject.getMetaData().getPrimaryKeys(null, null, TableName);
		 while (res.next()) {
			 pkcolnames.add(res.getString("column_name"));
		  }
		 return pkcolnames;
	}
	public static String[] GetTableColumns(java.sql.Connection dbConnectionObject,String TableName,String DBName) throws SQLException
	{
		Statement st = dbConnectionObject.createStatement();
		String colNames="";
		ResultSet res = st.executeQuery("SELECT column_name FROM information_schema.`COLUMNS` WHERE table_name='"+TableName+"' and table_schema='"+DBName+"'");
		 while (res.next()) {
		 	 colNames=colNames+","+res.getString("column_name");
		  }
		 if(colNames.equals(""))
		 {
			 return null;
		 }
		 else
		 {
			 return colNames.replaceFirst(",", "").split(",");
		 }
	}
	public static Hashtable<Integer,String[]> RunSelectSQLQuery(java.sql.Connection dbConnectionObject,String SQLQuery) throws SQLException
	{
		Statement st = dbConnectionObject.createStatement();
		ResultSet res = st.executeQuery(SQLQuery);
		int colCount=res.getMetaData().getColumnCount();
		
		Hashtable<Integer,String[]> hstTable=new Hashtable<Integer, String[]>();
		int counter=0;
		 while (res.next()) {
			 String[] rowValues=new String[colCount];
		  	  for(int c=0;c<colCount;c++)
			  {
		  	//	long heapsize = Runtime.getRuntime().totalMemory();
		     //   System.out.println(counter+"heapsize is :: " + heapsize);
		  		rowValues[c]=res.getString(c+1);
			  }
		  	hstTable.put(counter, rowValues);
		  	counter++;
		  }
		return hstTable;
	}
	public static boolean RunUpdateInsertDeleteSQLQuery(java.sql.Connection dbConnectionObject,String SQLQuery) throws SQLException
	{
		boolean status=true;
		try{
		Statement st = dbConnectionObject.createStatement();
		int res = st.executeUpdate(SQLQuery);
		}
		catch(SQLException ex)
		{
			status=false;
		}
		catch(Exception ex)
		{
			status=false;
		}
		return status;
		
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
	  java.sql.Connection oConn=GetDBConnectionObject("localhost","finsys","root","admin","3306");
	  System.out.println(oConn);
	 String[] allColumns= GetTableColumns(oConn,"cities","finsys");
	 System.out.println(allColumns[0]+" "+allColumns[1]);
	 Hashtable<Integer,String[]> hstble= RunSelectSQLQuery(oConn, "select * from cities");
	 System.out.println(hstble.get(0)[0]);
	 System.out.println(hstble.get(0)[1]);
	 boolean val= RunUpdateInsertDeleteSQLQuery(oConn, "update cities set cityname='A.THEKKUR' where citycode='101'");
	System.out.println(val);
	}

}
