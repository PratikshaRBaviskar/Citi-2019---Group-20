package Validation;
import java.text.SimpleDateFormat;
import java.util.Date;

public class validation {
	boolean invalidCharacterFlag;
	boolean invalidNumberFlag;
	boolean invalidDate;
	boolean nameLengthExceeded;
	boolean numberLengthInvalid;
	boolean InvalidAmountFlag;
	boolean balanceExceededFlag;
	boolean invalidDateFlag;;
	public validation()
	{
		invalidCharacterFlag = false;
		invalidNumberFlag = false;
		invalidDate = false;
		nameLengthExceeded = false;
		numberLengthInvalid = false;
		InvalidAmountFlag = false;
		balanceExceededFlag = false;
		invalidDateFlag = false;
	}
	
	public boolean checkisValidAccno(String str)
	{
		if(str.length()==0)
			return false;
		else if(str.length()>12 || str.length()<12) {
			numberLengthInvalid = true;
			return false;
		}
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) > 57 || str.charAt(i) < 48) 
			{
				if ((str.charAt(i) > 90 && str.charAt(i) < 97) || (str.charAt(i) > 122) || (str.charAt(i) < 65)) 
				{
					invalidNumberFlag = true;
					return false;
				}
			}
		}
		return true;
		
	}
	public boolean checkisValidAccName(String str)
	{
		if(str.length()==0)
			return false;
		else if(str.length()>35)
		{
			nameLengthExceeded = true;
			return false;
		}
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) > 57 || str.charAt(i) < 48) 	
			{
				if ((str.charAt(i) > 90 && str.charAt(i) < 97) || (str.charAt(i) > 122) || (str.charAt(i) < 65)) 
				{
					invalidCharacterFlag = true;
					return false;
				}
			}
		}
		return true;
		
	}
	public boolean checkisValidAmount(double amt)
	{
		if(amt<0.00)
		{
			InvalidAmountFlag = true;
			return false;
		}	
		else if(amt>9999999999.99)
		{
			balanceExceededFlag = true;
			return false;
		}
		else
			return true;
	}
	
	public boolean checkValidDate(String date)
	{
		Date objDate = new Date();
		String strDateFormat = "ddMMyyyy";
		SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
		//System.out.println(objSDF.format(objDate));
		String d=objSDF.format(objDate).toString();
		if(date.length()<8)
		{
			invalidDate=true;
			return false;
		}
		else if(date.compareTo(d)!=0)
		{
			invalidDateFlag = true;
			return false;
		}
		else
			return true;
	}
	
	public boolean getFeedStatus() {
		if (invalidCharacterFlag == false && invalidNumberFlag == false  && invalidDate == false && nameLengthExceeded == false
				&& numberLengthInvalid == false && InvalidAmountFlag == false && balanceExceededFlag == false && invalidDateFlag == false) {
			return true;
		}
		return false;
	}
}
