package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class View_News 
{
	private StringProperty Title;
	private StringProperty Description;
	private IntegerProperty ID;
	
	View_News()
	{
		this.Title = new SimpleStringProperty();
		this.Description = new SimpleStringProperty();
		this.ID = new SimpleIntegerProperty();
	}
	
	public String getTitle()
    {
    	return Title.get();
    }
    public void setTitle(String Date)
    {
    	this.Title.set(Date);
    }
    public String getDesc()
    {
    	return Description.get();
    }
    public void setDescription(String Date)
    {
    	this.Description.set(Date);
    }
    public void setID(int In)
    {
    	this.ID.set(In);
    }
    public int getID()
    {
    	return ID.get();
    }
    public IntegerProperty getIDP() 
	{
		return ID;
	}
    public StringProperty getTitleP() 
	{
		return Title;
	}
    public StringProperty getDescP() 
	{
		return Description;
	}
}
