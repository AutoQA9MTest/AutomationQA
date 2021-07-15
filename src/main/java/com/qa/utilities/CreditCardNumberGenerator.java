package com.qa.utilities;

import java.util.ArrayList;

public class CreditCardNumberGenerator {
	public String strNameOnCard;
	public String strCCNumber;
	public String strExpireDate;
	public String strCVVNumber;
	
	
	private String[] VISA_PREFIX_LIST = new String[] {"4"};
	private String[] MASTER_PREFIX_LIST = new String[] { "51",
			"52", "53", "54", "55" };
	private String[] AMEX_PREFIX_LIST = new String[] { "34", "37" };
	private String[] DISCOVER_PREFIX_LIST = new String[] { "6011" };

	/***
	 * Name of Function 	:- fnGetCardDetails
	 * Class Name :- CreditCardNumberGenerator 
	 * Function Description :- To Generate Credit Card Details
	 */	
	public CreditCardNumberGenerator fnGetCardDetails()
	{
		CreditCardNumberGenerator objCCDetails=new CreditCardNumberGenerator();
		objCCDetails.strNameOnCard=getNameOnCard();
		objCCDetails.strCCNumber=generateMasterCardNumbers();
		objCCDetails.strExpireDate=getExpireDate();
		objCCDetails.strCVVNumber=getCVVNumber();
		return objCCDetails;		
	}
	
	/***
	 * Name of Function 	:- getCreditCardNumber
	 * Class Name :- CreditCardNumberGenerator 
	 * Function Description :- To Generate Credit Card Number
	 */	
   public String getCreditCardNumber(String[] prefixList, int length)
   {

		int randomArrayIndex = (int) (Math.random()* prefixList.length);
		String ccnumber = prefixList[randomArrayIndex];
		
		// generate digits

		while (ccnumber.length() < (length - 1)) {
			ccnumber += new Double((int)(Math.random() * 10)).intValue();
		}

		// reverse number and convert to int

      StringBuilder stb=new StringBuilder(ccnumber);
      
		String reversedCCnumberString = (stb.reverse()).toString();

		ArrayList<Integer> reversedCCnumberList = new ArrayList<Integer>();
		for (int i = 0; i < reversedCCnumberString.length(); i++) {
			reversedCCnumberList.add(new Integer(String
					.valueOf(reversedCCnumberString.charAt(i))));
      
		}

		// calculate sum

		int sum = 0;
		int pos = 0;

		Integer[] reversedCCnumber = reversedCCnumberList
				.toArray(new Integer[reversedCCnumberList.size()]);
		while (pos < length - 1) {

			int odd = reversedCCnumber[pos] * 2;
			if (odd > 9) {
				odd -= 9;
			}

			sum += odd;

			if (pos != (length - 2)) {
				sum += reversedCCnumber[pos + 1];
			}
			pos += 2;
		}

		// calculate check digit

		int checkdigit = new Double(
				((Math.floor(sum / 10) + 1) * 10 - sum) % 10).intValue();
		ccnumber += checkdigit;

		return ccnumber;

  }

   /***
	 * Name of Function 	:- generateMasterCardNumbers
	* Class Name :- CreditCardNumberGenerator 
	 * Function Description :- To Generate Masrer Credit Card Number
	 */	
	public  String generateMasterCardNumbers()
   {
      int length=(int)(Math.random()*3)+16;
      return getCreditCardNumber(MASTER_PREFIX_LIST, length);
	}
   
	 /***
	 * Name of Function 	:- generateVisaCardNumbers
	 * Class Name :- CreditCardNumberGenerator 
	 * Function Description :- To Generate Visa Credit Card Number
	 */	
   public  String generateVisaCardNumbers() 
   {
       int length=(int)(Math.random()*3)+13;

		return getCreditCardNumber(VISA_PREFIX_LIST, length);
	}
   /***
	 * Name of Function 	:- generateAmexCardNumbers
	* Class Name :- CreditCardNumberGenerator 
	 * Function Description :- To Generate Amex Credit Card Number
	 */	
   public  String generateAmexCardNumbers() 
   {
      
		return getCreditCardNumber(AMEX_PREFIX_LIST, 15);
	}
   /***
  	 * Name of Function 	:- generateAmexCardNumbers
  	 * Class Name :- CreditCardNumberGenerator 
  	 * Function Description :- To Generate Discover Credit Card Number
  	 */	
   public  String generateDiscoverCardNumbers() 
   {
      
		return getCreditCardNumber(DISCOVER_PREFIX_LIST, 16);
	}
   
   /***
 	 * Name of Function 	:- getCVVNumber
 	* Class Name :- CreditCardNumberGenerator 
 	 * Function Description :- To Generate CVV Number
 	 */	
   public String getCVVNumber()
   {
		int cvv = 100 + (int)(Math.random() * ((999 - 100) + 1));
		return String.valueOf(cvv);
   }
   /***
	 * Name of Function 	:- createRandomIntBetween
	* Class Name :- CreditCardNumberGenerator 
	 * Function Description :- To Generate Rasndom Number
	 */
   public static int createRandomIntBetween(int start, int end) {
       return start + (int) Math.round(Math.random() * (end - start));
   }
   /***
	 * Name of Function 	:- getExpireDate
	* Class Name :- CreditCardNumberGenerator 
	 * Function Description :- To Generate Expire Date
	 */	
   public String getExpireDate()
   {
	   String strFinal="";
	   int month = createRandomIntBetween(1, 12);
       int year = createRandomIntBetween(20, 24);
       String strMonth=null;
       if(month<10)
       {
    	   strMonth="0"+String.valueOf(month);
       }
       else
       {
    	   strMonth=String.valueOf(month);
       }
       strFinal=strMonth+String.valueOf(year);
       return strFinal;
   }
   /***
	 * Name of Function 	:- getNameOnCard
	* Class Name :- CreditCardNumberGenerator 
	 * Function Description :- To Generate Name On Card
	 */	
   
   public String getNameOnCard()
   {
	   String strNameOnCard1="";
	   String strNameOnCard2="";
	 	int name1 = 0 + (int)(Math.random() * ((10 - 0) + 1));
		if(name1 == 0) {strNameOnCard1="Raja";}
		if(name1 == 1) {strNameOnCard1="Madan";}
		if(name1 == 2) {strNameOnCard1="Pankaj";}
		if(name1 == 3) {strNameOnCard1="Indraja";}
		if(name1 == 4) {strNameOnCard1="Jagdish";}
		if(name1 == 5) {strNameOnCard1="Pavan";}
		if(name1 == 6) {strNameOnCard1="Vikash";}
		if(name1 == 7) {strNameOnCard1="Mohan";}
		if(name1 == 8) {strNameOnCard1="Srinivas";}
		if(name1 == 9) {strNameOnCard1="Cyrile";}    
		if(name1 == 10) {strNameOnCard1="Gopal";}    

		int name2 = 0 + (int)(Math.random() * ((10 - 0) + 1));
		        System.out.print(" ");
		if(name2 == 0) {strNameOnCard2="Sweta";}
		if(name2 == 1) {strNameOnCard2="Ashok";}
		if(name2 == 2) {strNameOnCard2="Balaji";}
		if(name2 == 3) {strNameOnCard2="Vidya";}
		if(name2 == 4) {strNameOnCard2="Suresh";}
		if(name2 == 5) {strNameOnCard2="Honey";}
		if(name2 == 6) {strNameOnCard2="Anki";}
		if(name2 == 7) {strNameOnCard2="Priya";}
		if(name2 == 8) {strNameOnCard2="Sasi";}
		if(name2 == 9) {strNameOnCard2="Arjun";}          
		if(name2 == 10) {strNameOnCard2="Gabbar";}
		String strName= strNameOnCard1 + " " + strNameOnCard2;
	//	System.out.println("Name on Card ==> " +strName);
		return strName;
   }
   
}
