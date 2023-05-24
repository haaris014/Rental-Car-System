package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javafx.scene.Node;
import javafx.scene.Scene;

import java.sql.DriverManager;
import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;


public class PCB_Controller 
{
/*Button Links*/
    @FXML
    void Home_Button_Press(ActionEvent event) throws IOException 
    {
    	BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Payment.fxml"));
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	Scene scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
 
    @FXML
    void Add_Fixture_Button(ActionEvent event) throws IOException
    {
    	BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Add_Fixtures.fxml"));
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	Scene scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
    @FXML
    void News_Button(ActionEvent event) throws IOException
    {
    	BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Add_News.fxml"));
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	Scene scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
    @FXML
    void Show_News_Pressed(ActionEvent event) throws IOException
    {
     	BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("View_News.fxml"));
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	Scene scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
   
    }

    @FXML
	void View_Fixture_Pressed(ActionEvent event) throws IOException
	{
	   	BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("View_Fixtures.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

    
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
/////////////////////////////////////////////////SIGN-UP PAGE//////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
 	@FXML
    private TextField email_placeholder;
    @FXML
    private TextField password_placeholder;
    @FXML
    private Button signup_button;
    @FXML
    private TextField name_placeholder;
    @FXML
    private TextField cnic_placeholder;
    @FXML
    private TextField dob_placeholder;
    @FXML
    private Button Home_Button;
    
    @FXML
    void buttonPress(ActionEvent event) 
    {
    	Database_Handler handle = new Database_Handler();
    	
    	handle.Get_Fixtures();
    	Accounts ActObj = new Accounts(email_placeholder.getText(), password_placeholder.getText(),
 			   name_placeholder.getText() , cnic_placeholder.getText()    ,dob_placeholder.getText());
    	int isEmailValid = ActObj.emailvalidation();
    	int isPassValid = ActObj.passwordvalidation();
    	int isNameValid = ActObj.namevalidation();
    	int isPhoneValid = ActObj.Phonevalidation();
    	String Type = "Customer";
    	if (isEmailValid==1 && isPassValid==1 && isNameValid==1 && isPhoneValid==1)
    	{
    		try 
    		{
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PCB","root","Salis2002");
    			Statement stmt = con.createStatement();
    			
    			String Query = "insert into accounts " + " (Email,Password,Name,Phone,DOB,Type) " + " values ('" + ActObj.getEmail()   + "','" 
    																									   + ActObj.getPassword() + "','"
    																									   + ActObj.getName()     + "','"
    																									   + ActObj.getPhone()    + "','"
    																									   + ActObj.getDOB()    + "','"
    	    																							   + Type 	  + "')";
    			stmt.executeUpdate(Query);
    			con.close();
    		}
    		catch( Exception e)
    		{
    			System.out.print(e);
    		}
    		ActObj.DisplayDetails();
    	}
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
/////////////////////////////////////////////////	ADD FIXTURE PAGE///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
    @FXML
    private TextField Day;
    @FXML
    private TextField Team1_Name;
    @FXML
    private Button Fixture;
    @FXML
    private TextField Month;
    @FXML
    private TextField Year;
    @FXML
    private TextField Team2_Name;
    @FXML
    private TextField Enclusure1_Seats;
    @FXML
    private TextField Enclusure2_Seats;
    @FXML
    private TextField Enclusure3_Seats;
    @FXML
    private TextField Time;
    @FXML
    void Add_Fixture_Button1(ActionEvent event) 
    {
    	Match Fixture = new Match();
    	int ValidDate = Fixture.DateValidation(Day.getText(),Month.getText(),Year.getText());
    	
    	int Check = 0;
    	if (Team1_Name.getLength()==0 || Team2_Name.getLength()==0 || Enclusure1_Seats.getLength()<0 || Enclusure2_Seats.getLength()<0 || Enclusure3_Seats.getLength()<0 )
    	{
    		  	String Errors = "Enter all the Fields, There may be an error data entry";
    			Alert alerta = new Alert(Alert.AlertType.ERROR);
    	        alerta.setTitle("Field Validation");
    	        alerta.setContentText(Errors);
    	        alerta.show();    
    	        Check=1;
    	}
    	if (ValidDate==1 && Check==0)
    	{
    		Fixture.setDate(Integer.parseInt(Day.getText()),Integer.parseInt(Month.getText()),Integer.parseInt(Year.getText()));
    		Fixture.setTeam1(Team1_Name.getText());
    		Fixture.setTeam2(Team2_Name.getText());
    		Fixture.setEnc1_Seats(Integer.parseInt(Enclusure1_Seats.getText()));
    		Fixture.setEnc2_Seats(Integer.parseInt(Enclusure2_Seats.getText()));
    		Fixture.setEnc3_Seats(Integer.parseInt(Enclusure3_Seats.getText()));
    		Fixture.setTime(Time.getText());

    		Fixture.Add_To_Database();
    		
    		String Errors = "Fixture Successfully added";
			Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
	        alerta.setTitle("Fixture Status");
	        alerta.setContentText(Errors);
	        alerta.show();    

    	}
    
    	
    }

    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
/////////////////////////////////////////////////	MAKE PAYMENT  ///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

    @FXML
    private TextField Card_Holder_Name;
    @FXML
    private TextField Card_Number;
    @FXML
    private Button Pay_Now;
    @FXML
    private TextField Expiry_Date;
    @FXML
    private TextField Cvc;
    @FXML
    private TextField Card_Type;

    @FXML
    void Pay_Now_Pressed(ActionEvent event) 
    {
    	Payment Pay = new Payment();
    	Pay.setCard_Number(Card_Number.getText());
    	Pay.setCardHolder_Name(Card_Holder_Name.getText());
    	Pay.setExpiry_Date(Expiry_Date.getText());
    	Pay.setCvc(Cvc.getText());
    	Pay.setType(Card_Type.getText());
    	
    	int Valid_Card = Pay.Validation_CardNumber();
   		int Valid_Exp = Pay.Validation_Expiry();
   		int Cvc = Pay.Validation_CVC();
   		
   		if ( Cvc==1 && Valid_Exp==1 && Valid_Card==1)
   		{
   		    String Errors = "Payment Successful";
    		Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Payment Status");
            alerta.setContentText(Errors);
            alerta.show();    
    
   		}
   		
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
/////////////////////////////////////////////////	ADD NEWS  ///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

    @FXML
    private TextField New_Title;

    @FXML
    private Button Add_News;

    @FXML
    private TextArea News_Description;

    @FXML
    void Add_News_Pressed(ActionEvent event) 
    {
    	
    	News Add_News = new News();
    	Add_News.setNews_Heading(New_Title.getText());
    	Add_News.setDescription(News_Description.getText());
    	int Id = Add_News.Add_To_Database();
		String Errors = "News was successfully added with News ID: " + Integer.toString(Id);
		Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("News Status");
        alerta.setContentText(Errors);
        alerta.show();    

    }


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
/////////////////////////////////////////////////	ADMIN DASHBOARD  //////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
/////////////////////////////////////////////////	DELETE FIXTURE   //////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    void Delete_Fixture_Button(ActionEvent event) throws IOException 
    {
      	BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Delete_Fixtures.fxml"));
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	Scene scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
    

    @FXML
    private TextField Delete_Date;
    @FXML
    private TextField Delete_Team1;
    @FXML
    private Button Delete_Button;
    @FXML
    private TextField Delete_Team2;
    @FXML
    void Delete_Fixture_Pressed(ActionEvent event) 
    {
    	Match Fixture = new Match();
    	int Status = Fixture.Search_Fixtures(Delete_Date.getText(), Delete_Team1.getText() , Delete_Team2.getText());
    	if (Status!=1)
    	{
    		String Errors = "Fixture was not found";
    		Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Fixture");
            alerta.setContentText(Errors);
            alerta.show();    
    	}
    	else
    	{
    		Fixture.Delete_Fixture(Delete_Date.getText(), Delete_Team1.getText() , Delete_Team2.getText());
    		String Errors = "Fixture successfully deleted";
    		Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Fixture");
            alerta.setContentText(Errors);
            alerta.show();    

    	}
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
/////////////////////////////////////////////////	DELETE NEWS      //////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    void Delete_News_Pressed(ActionEvent event) throws IOException
    {
      	BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Delete_News.fxml"));
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	Scene scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
    
    @FXML
    private TextField Delete_ID;

    @FXML
    private Button Delete_N;

    @FXML
    void Delete_N_Pressed(ActionEvent event)
    {
    	News  Fixture = new News();
    	int Status = Fixture.Search_News(Integer.valueOf(Delete_ID.getText()));
    	if (Status!=1)
    	{
    		String Errors = "News was not found";
    		Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("News");
            alerta.setContentText(Errors);
            alerta.show();    
    	}
    	else
    	{
    		Fixture.Delete_News(Integer.valueOf(Delete_ID.getText()));
    		String Errors = "News successfully deleted";
    		Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("News");
            alerta.setContentText(Errors);
            alerta.show();    

    	}

    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
/////////////////////////////////////////////////	DELETE ACCOUNT  ///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    void Delete_Acct_Press(ActionEvent event) throws IOException
    {
      	BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Delete_Account.fxml"));
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	Scene scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
    
    @FXML
    private TextField Delete_Email;

    @FXML
    private Button Delete_Act;

    @FXML
    void Delete_Account_Pressed(ActionEvent event) 
    {
      	Accounts Fixture = new Accounts();
    	int Status = Fixture.Search_Account(Delete_Email.getText());
    	if (Status!=1)
    	{
    		String Errors = "Account not found";
    		Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Account");
            alerta.setContentText(Errors);
            alerta.show();    
    	}
    	else
    	{
    		Fixture.Delete_Account(Delete_Email.getText());
    		String Errors = "Account successfully deleted";
    		Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Account");
            alerta.setContentText(Errors);
            alerta.show();    

    	}

    }

}