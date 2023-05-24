package application;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.scene.control.Alert;

public class Payment 
{
	private String Ticket_Number;
	private String CardHolder_Name;
	private String Card_Number;
	private String Expiry_Date;
	private String Cvc;
	private String Type;

	Payment()
	{
		setTicket_Number("");
		setCardHolder_Name("");
		setCard_Number("");
		setExpiry_Date("");
		setCvc("");
		setType("");
	}
//////////////////////////////SETTER AND GETTERS ///////////////////////////////////////////////////
	public String getTicket_Number() 
	{
		return Ticket_Number;
	}
	public void setTicket_Number(String ticket_Number) 
	{		
		Ticket_Number = ticket_Number;
	}
	public String getCardHolder_Name() 
	{
		return CardHolder_Name;
	}
	public void setCardHolder_Name(String cardHolder_Name) 
	{
		CardHolder_Name = cardHolder_Name;
	}
	public String getCard_Number() 
	{
		return Card_Number;
	}
	public void setCard_Number(String card_Number) 
	{
		Card_Number = card_Number;
	}
	public String getExpiry_Date() 
	{
		return Expiry_Date;
	}
	public void setExpiry_Date(String expiry_Date) 
	{
		Expiry_Date = expiry_Date;
	}
	public String getCvc() 
	{
		return Cvc;
	}
	public void setCvc(String cvc) 
	{
		Cvc = cvc;
	}
	public String getType() 
	{
		return Type;
	}
	public void setType(String type) 
	{
		Type = type;
	}

//////////////////////////////////////// VALIDATIONS ///////////////////////////////////////////
	
	public int Validation_CardNumber()
	{
		if (Card_Number.length()!=19)
		{
		    String Errors = "Incorrect Card Number or Format";
    		Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Card Number Validation");
            alerta.setContentText(Errors);
            alerta.show();    
            return 0;
		}
		if (Card_Number.length()==0)
		{
		    String Errors = "Card Number is required";
    		Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Card Number Validation");
            alerta.setContentText(Errors);
            alerta.show();    
            return 0;
		}
		
		char[] Card_Validation = new char[Card_Number.length()];
    	
    	for (int i = 0; i < Card_Number.length(); i++) 
        {
    		Card_Validation[i] = Card_Number.charAt(i);
        }
    	
    	ArrayList<String> Array = new ArrayList<String>();    	
    	int Index=0;
    	for (int i = 0; i < Card_Number.length(); i++) 
        {
    		if (Card_Validation[i]==32)
    		{
    			Array.add(Integer.toString(i));
    			Index++;
    		}
        }
    	
    	int Condtion=0;
    	for (int i = 0; i < Index ; i++)
    	{
    		if (Integer.valueOf(Array.get(i))==4)
    		{
    			Condtion++;
    		}   
    		if (Integer.valueOf(Array.get(i))==9)
    		{
    			Condtion++;
    		}
    		if (Integer.valueOf(Array.get(i))==14)
    		{
    			Condtion++;
    		}
    	}
            
    	if (Condtion!=3)
    	{
    	    String Errors = "Incorrect Card Number or Format";
    		Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Card Number Validation");
            alerta.setContentText(Errors);
            alerta.show();    
            return 0;
		}
    	
    	int Digits=0;
    	for (int i = 0; i < Card_Number.length() ; i++)
    	{
    		if ( Card_Validation[i]>'0' && Card_Validation[i]<'9')
    		{
    			Digits++;
    		}
    	}
		
    	if (Digits!=16)
    	{
    	    String Errors = "Card Number can only be numbers";
    		Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Card Number Validation");
            alerta.setContentText(Errors);
            alerta.show();    
            return 0;
		}
		return 1;
	}
	
	public int Validation_Expiry()
	{
		if (Expiry_Date.length()==0)
		{
		    String Errors = "Expiry Date is required";
    		Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Date Validation");
            alerta.setContentText(Errors);
            alerta.show();    
            return 0;
		}
		if (Expiry_Date.length()!=5)
		{
		    String Errors = "Incorrect Format";
    		Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Date Validation");
            alerta.setContentText(Errors);
            alerta.show();    
            return 0;
		}
		
		char[] Date_Validation = new char[Expiry_Date.length()];
    	
    	for (int i = 0; i < Expiry_Date.length(); i++) 
        {
    		Date_Validation[i] = Expiry_Date.charAt(i);
        }
    	
    	if (Date_Validation[2]!='/')
    	{
    	    String Errors = "Incorrect Format";
    		Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Date Validation");
            alerta.setContentText(Errors);
            alerta.show();    
            return 0;	
    	}
    	
    	int Digits=0;
    	for (int i = 0; i < Expiry_Date.length() ; i++)
    	{
    		if ( Date_Validation[i]>='0' && Date_Validation[i]<='9')
    		{
    			Digits++;
    		}
    	}
		
    	if (Digits!=4)
    	{
    	    String Errors = "Expiry can only be numbers";
    		Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Date Validation");
            alerta.setContentText(Errors);
            alerta.show();    
            return 0;
		}

    	
    	int Month =  Integer.parseInt(String.valueOf(Date_Validation[0]));
    	Month = Month*10;
    	Month = Month +  Integer.parseInt(String.valueOf(Date_Validation[1]));
    	LocalDate today = LocalDate.now();
    	
    	if (Month<today.getMonthValue() ||  Month>12)
    	{
    	    String Errors = "Your card is expired";
    		Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Date Validation");
            alerta.setContentText(Errors);
            alerta.show();    	
    	}
    	
    	int Year =  Integer.parseInt(String.valueOf(Date_Validation[3]));
    	Year = Year*10;
    	Year = Year +  Integer.parseInt(String.valueOf(Date_Validation[4]));
    	Year = Year +2000;
    	
    	if ( Year<today.getYear())
    	{
    	    String Errors = "Your card is expired";
    		Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Date Validation");
            alerta.setContentText(Errors);
            alerta.show();    	
    	}
    	return 1;
	}

	public int Validation_CVC()
	{
		if (Cvc.length()==0)
		{
		    String Errors = "CVC is required";
    		Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("CVC Validation");
            alerta.setContentText(Errors);
            alerta.show();    
            return 0;
		}
		if (Cvc.length()!=3)
		{
		    String Errors = "Incorrect Cvc";
    		Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("CVC Validation");
            alerta.setContentText(Errors);
            alerta.show();    
            return 0;
		}
		
		int Digits=0;
    	for (int i = 0; i < Cvc.length() ; i++)
    	{
    		if ( Cvc.charAt(i)>='0' && Cvc.charAt(i)<='9')
    		{
    			Digits++;
    		}
    	}
    	
    	if (Digits!=3)
		{
		    String Errors = "CVC cannot be other then numbers";
    		Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("CVC Validation");
            alerta.setContentText(Errors);
            alerta.show();    
            return 0;
		}
		return 1;
		
	}
}
