package bean;

public class Transaction {
	String ref_id,Payer_accno,Payee_accno,transaction_date,Payer_name,Payee_name;
	double amt;
	boolean status;
	/*public Transaction(String ref_id,String date,String Payer_name,String Payer_accno,String Payee_name,String Payee_accno,double amt)
	{
		this.ref_id=ref_id;
		this.date=date;
		this.Payer_name=Payer_name;
		this.Payer_accno=Payer_accno;
		this.Payee_name=Payee_name;
		this.Payee_accno=Payee_accno;
		this.amt=amt;
	}*/
	public String getRef_id() {
		return ref_id;
	}
	public void setRef_id(String ref_id) {
		this.ref_id = ref_id;
	}
	public String getPayer_accno() {
		return Payer_accno;
	}
	public void setPayer_accno(String payer_accno) {
		Payer_accno = payer_accno;
	}
	public String getPayee_accno() {
		return Payee_accno;
	}
	public void setPayee_accno(String payee_accno) {
		Payee_accno = payee_accno;
	}
	
	public String getTransaction_date() {
		return transaction_date;
	}
	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}
	public String getPayer_name() {
		return Payer_name;
	}
	public void setPayer_name(String payer_name) {
		Payer_name = payer_name;
	}
	public String getPayee_name() {
		return Payee_name;
	}
	public void setPayee_name(String payee_name) {
		Payee_name = payee_name;
	}
	public double getAmt() {
		return amt;
	}
	public void setAmt(double amt) {
		this.amt = amt;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}


}
