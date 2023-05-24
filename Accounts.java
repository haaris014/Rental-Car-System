package application;

import javafx.scene.control.Alert;

public class Accounts 
{
	private String Email;
	private String Password;
	private String Name;
	private String Phone;
	private String DOB;
	Accounts() 
	{
		Email = "";
	}
	
	Accounts(String EM, String PW , String NA , String CN , String DB)
	{
		setEmail(EM);
		setPassword(PW);
		setName(NA);
		setPhone(CN);
		setDOB(DB);
	}
	
	public String getEmail() 
	{
		return Email;
	}

	public void setEmail(String email) 
	{
		Email = email;
	}

	public String getPassword() 
	{
		return Password;
	}
	
	public void setPassword(String password) 
	{
		Password = password;
	}

	public String getName() 
	{
		return Name;
	}

	public void setName(String name) 
	{
		Name = name;
	}

	public String getPhone() 
	{
		return Phone;
	}

	public void setPhone(String Phone_Num) 
	{
		Phone = Phone_Num;
	}

	public String getDOB() 
	{
		return DOB;
	}

	public void setDOB(String dOB) 
	{
		DOB = dOB;
	}

	int emailvalidation ()
    {
    	char[] Email_Validation = new char[Email.length()];
    	
    	int Capitals=0;
    	int At_Rate=0;
    	int Index = 0;
    	int At_Rate_pos=0;
    	
    	for (int i = 0; i < Email.length(); i++) 
        {
          Email_Validation[i] = Email.charAt(i);
        }
        
    	for (int i = 0; i < Email.length(); i++) 
        {
        	if( Email_Validation[i]>'A' && Email_Validation[i]<'Z' )
        	{
        		Capitals++;
        	}
        	if( Email_Validation[i]=='@' )
        	{
        		At_Rate++;
        		At_Rate_pos = i-1;
        	}
        	if( Email_Validation[i]=='.' )
        	{
        		Index=i;
        	}
        }
      	if (Email.length()==0)
    	{
    		String Errors = "EMAIL IS REQUIRED";				
    		Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Email Validation");
            alerta.setContentText(Errors);
            alerta.show();    
            return 0;   				
    	}
  
    	if (Capitals>0)
 		{
            String Errors = "EMAIL CANNOT BE IN BLOCK LETTERS!\n";
    		Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Email Validation");
            alerta.setContentText(Errors);
            alerta.show();    
            return 0;
 		}
  
    	if (At_Rate!=1)
 		{
            String Errors = "@ MISSING OR USED MORE THEN ONES\n";
    		Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Email Validation");
            alerta.setContentText(Errors);
            alerta.show();    
            return 0;
 		}
    	if( Email_Validation[Index]=='.' && Email_Validation[Index+1]=='c' && Email_Validation[Index+1]=='o' && Email_Validation[Index+1]=='m'   )
    	{
        	String Errors = "INCORRECT DOMAIN NAME\n";				
    		Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Email Validation");
            alerta.setContentText(Errors);
            alerta.show();    
            return 0;
    	}
    	if (Index==0 || Index==At_Rate_pos || Email.length()==0)
    	{
           	String Errors = ".com ERROR\n";				
    		Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Email Validation");
            alerta.setContentText(Errors);
            alerta.show();    
            return 0;   		
    	}
    	return 1;
    }

	int passwordvalidation()
	{
		if (Password.length()==0)
        {
    		String Errors = "PASSWORD IS REQUIRED";				
    		Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Password Validation");
            alerta.setContentText(Errors);
            alerta.show();    
            return 0;
        }
    	if (Password.length() > 20 || Password.length() < 8)
        {
    		String Errors = "PASSWORD LENGHT SHOULD BE ATLEAST 8 LETTERS AND LESS THAN 20";				
    		Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Password Validation");
            alerta.setContentText(Errors);
            alerta.show();    
            return 0;
        }

    	char[] Password_Validation = new char[Password.length()];
    	
    	for (int i = 0; i < Password.length(); i++) 
        {
    		Password_Validation[i] = Password.charAt(i);
        }
        
		int isCaps = 0;
    	int isNum = 0;
    	int isLower = 0;
    	
    	
    	for (int i = 0; i < Password.length(); i++) 
    	{
    		if( Password_Validation[i]>'A' && Password_Validation[i]<'Z' )
    		{
    			isCaps = 1;
    		}
    		if( Password_Validation[i]>'0' && Password_Validation[i]<'9' )
    		{
    			isNum = 1;
    		}
    		if( Password_Validation[i]>'a' && Password_Validation[i]<'z' )
    		{
    			isLower = 1;
    		}
    	}  	
    	if (isCaps==0)
        {
    		String Errors = "PASSWORD SHOULD BE ATLEAST 1 CAPITAL LETTER";				
    		Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Password Validation");
            alerta.setContentText(Errors);
            alerta.show();    
            return 0;
        }
    	if (isLower==0)
        {
    		String Errors = "PASSWORD SHOULD BE ATLEAST 1 SMALL LETTER";				
    		Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Password Validation");
            alerta.setContentText(Errors);
            alerta.show();    
            return 0;
        }
    	if (isNum==0)
        {
    		String Errors = "PASSWORD SHOULD BE ATLEAST 1 NUMBER";				
    		Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Password Validation");
            alerta.setContentText(Errors);
            alerta.show();    
            return 0;
        }
        return 1;
	}

	int namevalidation()
	{
		if (Name.length()==0)
        {
    		String Errors = "NAME IS REQUIRED";				
    		Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Name Validation");
            alerta.setContentText(Errors);
            alerta.show();    
            return 0;
        }
		return 1;
	}

	int Phonevalidation()
	{
		if (Phone.length()==0)
        {
    		String Errors = "Phone IS REQUIRED";				
    		Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Phone Validation");
            alerta.setContentText(Errors);
            alerta.show();    
            return 0;
        }
		
		if (Phone.length()!=11)
        {
    		String Errors = "ENTER A VALID Phone NUMBER";				
    		Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Phone Validation");
            alerta.setContentText(Errors);
            alerta.show();    
            return 0;
        }
		
		
		return 1;
	}
	
	void DisplayDetails()
	{
    	Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("USER DETAILS");
        alerta.setContentText("Email: "    + Email    + "\n" +
        		 			  "Password: " + Password + "\n" +
        		 			  "Name: " 	   + Name     + "\n" + 
        		 			  "Phone: "     + Phone     + "\n" +
        		 			  "DOB: "      + DOB      + "\n\n" +
        		 			  "SIGNED UP SUCCESSFULLY");
        alerta.show();
	}

	public int Search_Account(String Email )
	{
		Database_Handler Handle = new Database_Handler();
		int Status = Handle.SearchAccount(Email);
		return Status;
	}
	
	public void Delete_Account(String Email)
	{
		Database_Handler Handle = new Database_Handler();
		Handle.DeleteAccount(Email);
	}


}
