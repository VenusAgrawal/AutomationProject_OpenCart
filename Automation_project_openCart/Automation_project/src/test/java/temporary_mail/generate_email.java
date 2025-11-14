package temporary_mail;

import java.util.Date;

public class generate_email {

	public static void main(String[] args) {
		
		Date date = new Date();
		
		//convert date to string
		String dateString = date.toString();
		
		//remove spaces from string
		String NoSpaceDateString = dateString.replaceAll(" ", "");
		//String NoSpaceDateString = dateString.replaceAll("//s", ""); can also be used //s is for space
		
		//remove :
		String NoSpaceColondateString = NoSpaceDateString.replaceAll(":", "");
		//String NoSpaceColondateString = NoSpaceDateString.replaceAll("//:", ""); alternate method
		
		//append with @gmail.com to generate different emails by timestamp
		String emailWithTimeStamp = NoSpaceColondateString + "@gmail.com";
		System.out.println(emailWithTimeStamp);
	}
}
