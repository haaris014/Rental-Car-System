package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Database_Handler 
{

	public int Record_News( String Title , String Decs )
	{
		int ID = 0 ;
		try 
		{
	      File myObj = new File("News_Record.txt");
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) 
	      {
	        String data = myReader.nextLine();
	        ID = Integer.parseInt(data);
	      }
	      myReader.close();
	    } 
		catch (FileNotFoundException e) 
		{
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
		
		ID++;
		
		try 
		{
		      FileWriter myWriter = new FileWriter("News_Record.txt");
		      myWriter.write(Integer.toString(ID));
		      myWriter.close();
		 } 
		catch (IOException e) 
		{
		      System.out.println("An error occurred.");
		      e.printStackTrace();
	    }
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PCB","root","Salis2002");
			Statement stmt = con.createStatement();
			
			String Query = "insert into News " + " (Id,Title,Description) " + " values ( " + ID + ",'"  + Title   + "','"  + Decs  + "')";
			stmt.executeUpdate(Query);
			con.close();
		}
		catch( Exception e)
		{
			System.out.print(e);
		}
	ID--;
	return ID;
	}

	public void Record_Matches( String Dated, String Team1 , String Team2, int Enc1_Seats, int Enc2_Seats , int Enc3_Seats, String Time)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PCB","root","Salis2002");
			Statement stmt = con.createStatement();
			
			String Query = "insert into Fixtures " + " (Date,Team1,Team2,Enclosure1,Enclosure2,Enclosure3,Time) " + " values ( '" +  Dated + "','" + Team1 + "','" + Team2 + "'," + Enc1_Seats + "," + Enc2_Seats + "," + Enc3_Seats + ",'" + Time + "');"   ;   
			stmt.executeUpdate(Query);
			con.close();
		}
		catch( Exception e)
		{
			System.out.print(e);
		}
	
	}

	public ObservableList<Fixture_View> Get_Fixtures()
	{
		ObservableList<Fixture_View> All_Fixtures = FXCollections.observableArrayList();
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PCB","root","Salis2002");
			
			
			PreparedStatement ps = con.prepareStatement("select * from fixtures");
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next())
			{
				Fixture_View Fix = new Fixture_View();
				Fix.setDate(rs.getString("Date"));
				Fix.setTeam1(rs.getString("Team1"));
				Fix.setTeam2(rs.getString("Team2"));
				Fix.setENC1(rs.getInt("Enclosure1"));
				Fix.setENC2(rs.getInt("Enclosure2"));
				Fix.setENC3(rs.getInt("Enclosure3"));
				Fix.setTime(rs.getString("Time"));
				All_Fixtures.add(Fix);
			}
			con.close();
		}
		catch( Exception e)
		{
			System.out.print(e);
		}
		return All_Fixtures;
	}

	public ObservableList<View_News> Get_News()
	{
		ObservableList<View_News> All_News = FXCollections.observableArrayList();
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PCB","root","Salis2002");
			
			
			PreparedStatement ps = con.prepareStatement("select * from news");
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next())
			{
				View_News Fix = new View_News();
				Fix.setID(rs.getInt("Id"));
				Fix.setTitle(rs.getString("Title"));
				Fix.setDescription(rs.getString("Description"));
				All_News.add(Fix);
			}
			con.close();
		}
		catch( Exception e)
		{
			System.out.print(e);
		}
		return All_News;
	}

	public int SearchFixture(String Date , String Team1 , String Team2)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PCB","root","Salis2002");
			
			
			PreparedStatement ps = con.prepareStatement("select * from fixtures");
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next())
			{
				
				if (rs.getString(1).equalsIgnoreCase(Date) )
				{
					if (rs.getString(2).equalsIgnoreCase(Team1)  )
					{
						if (rs.getString(3).equalsIgnoreCase(Team2)   )
						{	
								return 1;
						}
					}
				}
			}
			con.close();
		}
		catch( Exception e)
		{
			System.out.print(e);
		}
		return 0;
	}

	public void DeleteFixture(String Date , String Team1 , String Team2)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PCB","root","Salis2002");
			
			
			PreparedStatement ps = con.prepareStatement("select * from fixtures");
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next())
			{
				
				if (rs.getString(1).equalsIgnoreCase(Date) )
				{
					if (rs.getString(2).equalsIgnoreCase(Team1)  )
					{
						if (rs.getString(3).equalsIgnoreCase(Team2)   )
						{	
							Statement stmt = con.createStatement();
							stmt.execute("DELETE FROM fixtures WHERE Date='" + rs.getString(1) + "'AND  Team1='" + rs.getString(2) + "'AND Team2='" + rs.getString(3) + "';" );
							
						}
					}
				}
			}
			
			con.close();
		}
		catch( Exception e)
		{
			System.out.print(e);
		}
	}

	public int SearchNews(int ID)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PCB","root","Salis2002");
			
			
			Statement stmt     = con.createStatement();
			ResultSet rs1       = stmt.executeQuery("select 1 from news where Id="+ ID + ";" );
	        boolean isPresent = rs1.next();
			
			if (isPresent)
			{
				return 1;		
			}
			con.close();
		}
		catch( Exception e)
		{
			System.out.print(e);
		}
		return 0;
	}

	public void DeleteNews( int ID)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PCB","root","Salis2002");
					
			Statement stmt     = con.createStatement();
			ResultSet rs1       = stmt.executeQuery("select 1 from news where Id="+ ID + ";" );
	        boolean isPresent = rs1.next();
			
			if (isPresent)
			{
				Statement stmt1 = con.createStatement();
				stmt1.execute("DELETE FROM news WHERE Id='" + ID + "';" );
		
			}
	
			con.close();
		}
		catch( Exception e)
		{
			System.out.print(e);
		}
	}

	public int SearchAccount(String Email)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PCB","root","Salis2002");
			
			
			PreparedStatement ps = con.prepareStatement("select * from accounts");
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next())
			{
				
				if (rs.getString(1).equalsIgnoreCase(Email) )
				{
								return 1;
				}
			}
			con.close();
		}
		catch( Exception e)
		{
			System.out.print(e);
		}
		return 0;
	}

	public void DeleteAccount(String Email)
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PCB","root","Salis2002");
			
			
			PreparedStatement ps = con.prepareStatement("select * from accounts");
			ResultSet rs = ps.executeQuery();
			
			while ( rs.next())
			{
				
				if (rs.getString(1).equalsIgnoreCase(Email) )
				{
							Statement stmt = con.createStatement();
							stmt.execute("DELETE FROM accounts WHERE Email='" + rs.getString(1) + "';" );
				}
			}
			
			con.close();
		}
		catch( Exception e)
		{
			System.out.print(e);
		}
	}

}
