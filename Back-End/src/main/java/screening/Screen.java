package screening;

import Upload.ProcessofFile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.*;
public class Screen {
	ProcessofFile pof;
	static final String DB_URL="jdbc:mysql://localhost/citi";
	static final String USER="root";
	static final String PASS="sakshi@7598";
	private static final ArrayList ArrayList = null;
	public static  ArrayList<String> names = new ArrayList<String>(); 
public void screening()
{
	Connection conn=null;
	Statement stmt=null;
	
	int n;
	
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Connecting to the DATABASE...");
		
		conn=DriverManager.getConnection(DB_URL,USER,PASS);
		stmt=conn.createStatement();
		System.out.println("Connection Established!");
		
				
					
				
					System.out.println("DATABASE contains...");
					
					String query="select * from list";
					
					int count=0;
					
					ResultSet rs=stmt.executeQuery(query);
					while(rs.next())
					{
						String name=rs.getString("name");
						names.add(name.toLowerCase());
					}
					System.out.print(names);
                    pof.checkscreen(names);
	}
	
	catch(Exception e)
	{
		System.out.println(e);
	}
}
}