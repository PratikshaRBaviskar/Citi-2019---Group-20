package Upload;
import java.util.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import bean.Transaction;
import Validation.validation;

public class ProcessofFile {

	ArrayList<Transaction> validtransactions=new ArrayList<Transaction>();
	ArrayList<Transaction> invalidtransactions=new ArrayList<Transaction>();
	ArrayList<Transaction> screenpass=new ArrayList<Transaction>();
	ArrayList<Transaction> screenfail=new ArrayList<Transaction>();
	Transaction records;
	validation validateFile;

	public void readFile() 
	{
		File file = new File("C:\\Users\\Admin\\Documents\\file.txt"); 

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String transactionFeed = new String();
			String feed=new String();
			while((transactionFeed = br.readLine())!=null)
				setTransaction(transactionFeed);
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setTransaction(String feed)
	{
		records=new Transaction();
		validateFile=new validation();
		StringTokenizer stringTokenizer = new StringTokenizer(feed,"	");

		 records.setRef_id(stringTokenizer.nextToken());
		 records.setTransaction_date(stringTokenizer.nextToken());
		 records.setPayer_name(stringTokenizer.nextToken());
		 records.setPayer_accno(stringTokenizer.nextToken());
		 records.setPayee_name(stringTokenizer.nextToken());
		 records.setPayee_accno(stringTokenizer.nextToken());
		 records.setAmt(Double.parseDouble(stringTokenizer.nextToken()));
		 boolean status=validationofInput();
		 records.setStatus(status);
		 if(status==true)
			 validtransactions.add(records);
		 else
			 invalidtransactions.add(records);
	}
	
	public boolean validationofInput()
	{
		 validateFile.checkisValidAccno(records.getRef_id());
		 validateFile.checkValidDate(records.getTransaction_date());
		 validateFile.checkisValidAccName(records.getPayer_name());
		 validateFile.checkisValidAccno(records.getPayer_accno());
		 validateFile.checkisValidAccName(records.getPayee_name());
		 validateFile.checkisValidAccno(records.getPayee_accno());
		 validateFile.checkisValidAmount(records.getAmt());
		 boolean st=validateFile.getFeedStatus();
		 return st;	
	}
	
	public void output()
	{
		System.out.println("Valid transactions are:");
		for(int i=0;i<validtransactions.size();i++)
		{
			String rid=validtransactions.get(i).getRef_id();
			String dt=validtransactions.get(i).getTransaction_date();
			String pnm=validtransactions.get(i).getPayer_name();
			String pan=validtransactions.get(i).getPayer_accno();
			String pnm1=validtransactions.get(i).getPayee_name();
			String pan1=validtransactions.get(i).getPayee_accno();
			double a=validtransactions.get(i).getAmt();
			System.out.println(rid+"	"+dt+"	"+pnm+"	"+pan+"	"+pnm1+"	"+pan1+"	"+a);
	   }
		System.out.println("Invalid Transactions are:");
		for(int i=0;i<invalidtransactions.size();i++)
		{
			String rid1=invalidtransactions.get(i).getRef_id();
			String dt1=invalidtransactions.get(i).getTransaction_date();
			String pnm1=invalidtransactions.get(i).getPayer_name();
			String pan1=invalidtransactions.get(i).getPayer_accno();
			String pnm2=invalidtransactions.get(i).getPayee_name();
			String pan2=invalidtransactions.get(i).getPayee_accno();
			double a1=invalidtransactions.get(i).getAmt();
			System.out.println(rid1+"	"+dt1+"	"+pnm1+"	"+pan1+"	"+pnm2+"	"+pan2+"	"+a1);
	   }
	}
	
	public void checkscreen(ArrayList<String> names) {
		for(int i=0;i<validtransactions.size();i++)
		{
			if(names.contains(validtransactions.get(i).getPayee_name().toLowerCase()) || names.contains(validtransactions.get(i).getPayer_name().toLowerCase()))
			{
				
				
				screenfail.add(validtransactions.get(i));
				//System.out.println(validtransactions.get(i).getPayee_name());
			}
			else
			{
				
				screenpass.add(validtransactions.get(i));
				//System.out.println(validtransactions.get(i).getPayee_name());
			}
		}
		
		System.out.println("Screen pass");
	    for(int i=0;i<screenpass.size();i++)
	    {
	    	String rid2=screenpass.get(i).getRef_id();
			String dt2=screenpass.get(i).getTransaction_date();
			String pnm2=screenpass.get(i).getPayer_name();
			String pan2=screenpass.get(i).getPayer_accno();
			String pnm22=screenpass.get(i).getPayee_name();
			String pan22=screenpass.get(i).getPayee_accno();
			double a2=screenpass.get(i).getAmt();
			System.out.println(rid2+"	"+dt2+"	"+pnm2+"	"+pan2+"	"+pnm22+"	"+pan22+"	"+a2);
	    }
	    
	    System.out.println("Screen fail");
	    for(int i=0;i<screenfail.size();i++)
	    {
	    	String rid3=screenfail.get(i).getRef_id();
			String dt3=screenfail.get(i).getTransaction_date();
			String pnm3=screenfail.get(i).getPayer_name();
			String pan3=screenfail.get(i).getPayer_accno();
			String pnm33=screenfail.get(i).getPayee_name();
			String pan33=screenfail.get(i).getPayee_accno();
			double a3=screenfail.get(i).getAmt();
			System.out.println(rid3+"	"+dt3+"	"+pnm3+"	"+pan3+"	"+pnm33+"	"+pan33+"	"+a3);
	    }
	}
}



