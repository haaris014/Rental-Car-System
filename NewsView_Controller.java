package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class NewsView_Controller implements Initializable
{ 

    @FXML
    private TableView<View_News> News_View;

    @FXML
    private TableColumn<View_News,Integer> News_ID;

    @FXML
    private TableColumn<View_News,String> Title_Col;

    @FXML
    private TableColumn<View_News,String> Desc_Col;

    public void initialize(URL url , ResourceBundle resourseBundle)
    {
    	try 
		{
        	News_ID.setCellValueFactory(cellData -> cellData.getValue().getIDP().asObject());
        	Title_Col.setCellValueFactory(cellData -> cellData.getValue().getTitleP());
        	Desc_Col.setCellValueFactory(cellData -> cellData.getValue().getDescP());

        	Database_Handler Handle = new Database_Handler();
	       	ObservableList<View_News> Fix;
	        Fix = Handle.Get_News();
	    	
	    	News_View.setItems(Fix);
    	} 
		catch 	(Exception e)
    	{
            e.printStackTrace();;
            System.out.println("error");
        } 	
    }
}
