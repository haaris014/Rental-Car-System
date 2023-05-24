package application;

import java.time.LocalDate;

import javafx.scene.control.Alert;

public class Match 
{
	private String Dated;
	private String Team1;
	private String Team2;
	private int Enc1_Seats;
	private int Enc2_Seats;
	private int Enc3_Seats;
	private String Time;

	Match()
	{
		Enc1_Seats = 0;
		Enc2_Seats = 0;
		Enc3_Seats = 0;
		
	}
	
	Match ( String Dat , String T1 , String T2, int EN1 , int EN2 , int EN3 , String Ti )
	{
		this.setDating(Dat);
		this.setTeam1(T1);
		this.setTeam2(T2);
		this.setEnc1_Seats(EN1);
		this.setEnc2_Seats(EN2);
		this.setEnc3_Seats(EN3);
		this.setTime(Ti);
	}
	public String getDate() 
	{
		return Dated;
	}
	public void setDate(int Day , int Month , int Year) 
	{
		LocalDate today = LocalDate.now();
		if (Year<today.getYear())
		{
		    String Errors = "You cannot add date in History";
			Alert alerta = new Alert(Alert.AlertType.ERROR);
	        alerta.setTitle("Date Validation");
	        alerta.setContentText(Errors);
	        alerta.show();    	
		}
		
		
		Dated = Integer.toString(Day) + "/" + Integer.toString(Month) + "/" + Integer.toString(Year);	
	}
	public String getTeam1() 
	{
		return Team1;
	}
	public void setTeam1(String team1) 
	{
		Team1 = team1;
	}
	public String getTeam2() 
	{
		return Team2;
	}
	public void setTeam2(String team2) 
	{
		Team2 = team2;
	}
	public int getEnc1_Seats() 
	{
		return Enc1_Seats;
	}
	public void setEnc1_Seats(int enc1_Seats) 
	{
		Enc1_Seats = enc1_Seats;
	}
	public int getEnc2_Seats() 
	{
		return Enc2_Seats;
	}
	public void setEnc2_Seats(int enc2_Seats) 
	{
		Enc2_Seats = enc2_Seats;
	}
	public String getTime() 
	{
		return Time;
	}
	public void setTime(String time) 
	{
		Time = time;
	}
	public int getEnc3_Seats() 
	{
		return Enc3_Seats;
	}
	public void setEnc3_Seats(int enc3_Seats) 
	{
		Enc3_Seats = enc3_Seats;
	}
	
	public int DateValidation( String Day , String Month , String Year)
	{
		if ( Day.length()==0 || Month.length()==0 || Year.length()==0 )
		{
		    String Errors = "Date Fields are Required";
			Alert alerta = new Alert(Alert.AlertType.ERROR);
	        alerta.setTitle("Date Validation");
	        alerta.setContentText(Errors);
	        alerta.show();    
	        return 0;
		}
		return 1;
	}

	public void Add_To_Database()
	{
		Database_Handler Handle = new Database_Handler();
		Handle.Record_Matches(Dated,Team1,Team2,Enc1_Seats,Enc2_Seats,Enc3_Seats,Time);
	}
	public void setDating(String dated)
	{
		Dated = dated;
	}
	
	public int Search_Fixtures(String Dt , String Tm1 , String Tm2 )
	{
		Database_Handler Handle = new Database_Handler();
		int Status = Handle.SearchFixture(Dt ,Tm1 ,Tm2);
		return Status;
	}
	
	public void Delete_Fixture(String Dt , String Tm1 , String Tm2 )
	{
		Database_Handler Handle = new Database_Handler();
		Handle.DeleteFixture(Dt ,Tm1 ,Tm2);
	}
	
}
