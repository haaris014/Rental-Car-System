package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Fixture_View 
{
	private StringProperty Dated;
	private StringProperty Team1;
	private StringProperty Team2;
	private IntegerProperty Enc1_Seats;
	private IntegerProperty Enc2_Seats;
	private IntegerProperty Enc3_Seats;
	private StringProperty Time;
	
	Fixture_View()
	{
		this.Dated = new SimpleStringProperty();
		this.Team1 = new SimpleStringProperty();
		this.Team2 = new SimpleStringProperty();
		this.Enc1_Seats = new SimpleIntegerProperty();
		this.Enc2_Seats = new SimpleIntegerProperty();
		this.Enc3_Seats = new SimpleIntegerProperty();
		this.Time = new SimpleStringProperty();
	}

    public String getDate()
    {
    	return Dated.get();
    }
    public void setDate(String Date)
    {
    	this.Dated.set(Date);
    }
    public String getTeam1()
    {
    	return Team1.get();
    }
    public void setTeam1(String Date)
    {
    	this.Team1.set(Date);
    }
    public String getTeam2()
    {
    	return Team2.get();
    }
    public void setTeam2(String Date)
    {
    	this.Team2.set(Date);
    }
    public String getTime()
    {
    	return Time.get();
    }
    public void setTime(String Date)
    {
    	this.Time.set(Date);
    }
    
    public int getENC1()
    {
    	return Enc1_Seats.get();
    }
    public void setENC1(int In)
    {
    	this.Enc1_Seats.set(In);
    }
    
    public int getENC2()
    {
    	return Enc2_Seats.get();
    }
    public void setENC2(int In)
    {
    	this.Enc2_Seats.set(In);
    }
    public int getENC3()
    {
    	return Enc3_Seats.get();
    }
    public void setENC3(int In)
    {
    	this.Enc3_Seats.set(In);
    }

	public IntegerProperty getEnc1_Seats() 
	{
		return Enc1_Seats;
	}
	public IntegerProperty getEnc2_Seats() 
	{
		return Enc2_Seats;
	}
	public IntegerProperty getEnc3_Seats() 
	{
		return Enc3_Seats;
	}

	public StringProperty getDateP() 
	{
		return Dated;
	}
	public StringProperty getTeam1P() 
	{
		return Team1;
	}
	public StringProperty getTeam2P() 
	{
		return Team2;
	}
	public StringProperty getTimeP() 
	{
		return Time;
	}
}
