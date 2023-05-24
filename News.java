package application;

public class News 
{
private String News_Heading;
private String Description;



	News()
	{
		setNews_Heading("");
		setDescription("");
	}

	public String getNews_Heading() 
	{
		return News_Heading;
	}

	public void setNews_Heading(String news_Heading) 
	{
		News_Heading = news_Heading;
	}

	public String getDescription() 
	{
		return Description;
	}

	public void setDescription(String description) 
	{
		Description = description;
	}
	
	public int Add_To_Database()
	{
		Database_Handler Handle = new Database_Handler();
		int ID = Handle.Record_News(this.News_Heading , this.Description);
		return ID;
	}
	
	public int Search_News(int ID )
	{
		Database_Handler Handle = new Database_Handler();
		int Status = Handle.SearchNews(ID);
		return Status;
	}
	
	public void Delete_News(int ID )
	{
		Database_Handler Handle = new Database_Handler();
		Handle.DeleteNews(ID);
	}

	

	
}
