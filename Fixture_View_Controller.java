package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Fixture_View_Controller implements Initializable
{

    @FXML
    private TableView<Fixture_View> Fix_View;

    @FXML
    private TableColumn<Fixture_View, String> Date_Col;

    @FXML
    private TableColumn<Fixture_View,String> Team1_Col;

    @FXML
    private TableColumn<Fixture_View,String> Team2_Col;

    @FXML
    private TableColumn<Fixture_View,Integer> ENC1;

    @FXML
    private TableColumn<Fixture_View,Integer> ENC2;

    @FXML
    private TableColumn<Fixture_View,Integer> ENC3;

    @FXML
    private TableColumn<Fixture_View,String> Time_Col;

    public void initialize(URL url , ResourceBundle resourseBundle)
    {
    	try 
		{
        	Date_Col.setCellValueFactory (cellData -> cellData.getValue().getDateP());
        	Team1_Col.setCellValueFactory (cellData -> cellData.getValue().getTeam1P());
        	Team2_Col.setCellValueFactory (cellData -> cellData.getValue().getTeam2P());
        	ENC1.setCellValueFactory(cellData -> cellData.getValue().getEnc1_Seats().asObject());
        	ENC2.setCellValueFactory(cellData -> cellData.getValue().getEnc2_Seats().asObject());
        	ENC3.setCellValueFactory(cellData -> cellData.getValue().getEnc3_Seats().asObject());
        	Time_Col.setCellValueFactory (cellData -> cellData.getValue().getTimeP());
        	
        	Database_Handler Handle = new Database_Handler();
	       	ObservableList<Fixture_View> Fix;
	        Fix = Handle.Get_Fixtures();
	    	
	    	Fix_View.setItems(Fix);
    	} 
		catch 	(Exception e)
    	{
            e.printStackTrace();;
            System.out.println("error");
        } 	
    }

}

