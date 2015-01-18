package wybory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class PeselConfirmation 
{	
	public PeselConfirmation(String pesel)
	{
		this.pesel = new String(pesel);
	}
	
	public Boolean isValid()
	{
		if (checkDate() && checkSex() && checkControlSum() )
		{
			return true;			
		}
		return false;
	}
	
	public Boolean checkDate() 
	{
		String year = pesel.substring(0,2);
		String month = pesel.substring(2,4);
		String day = pesel.substring(4,6);
		int century = Integer.valueOf( pesel.substring(2,3) );
		
		String newYear = new String("");

		if(century == 1 || century == 0)
		{
			newYear = "19" + year;
		}
		else if(century == 2 || century == 3)
		{
			newYear = "20" + year;
		}
		
		StringBuffer dateBuffer = new StringBuffer();
		dateBuffer.append(newYear);
		dateBuffer.append(".");
		dateBuffer.append(month);
		dateBuffer.append(".");
		dateBuffer.append(day);
		
		String dateString = dateBuffer.toString();
		
		System.out.println(dateString);
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
		
		try {
			
			date = dateFormat.parse(dateString);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
 
	
		Calendar dateCalendar = new GregorianCalendar();
		dateCalendar.setTime(date);
		
		
//		Integer intMonth = Integer.valueOf(month);
//		Integer intDay = Integer.valueOf(day);
//		
//		
//		System.out.println(newYear);
//		System.out.println(intMonth);
//		System.out.println(intDay);
		return true;
	}

	public int Length()
	{
		return pesel.length();
	}
	
	public Boolean checkSex()
	{
		int male = Integer.parseInt(pesel.substring(9, 10));
		System.out.println(male);
		if (male % 2 == 0)
		{
			return false;
		}
		else
		{
			return true;			
		}
	}
	
	public Boolean checkControlSum() {
		
		int a = Integer.parseInt(pesel.substring(0,1));
		int b = Integer.parseInt(pesel.substring(1,2));
		int c = Integer.parseInt(pesel.substring(2,3));
		int d = Integer.parseInt(pesel.substring(3,4));
		int e = Integer.parseInt(pesel.substring(4,5));
		int f = Integer.parseInt(pesel.substring(5,6));
		int g = Integer.parseInt(pesel.substring(6,7));
		int h = Integer.parseInt(pesel.substring(7,8));
		int i = Integer.parseInt(pesel.substring(8,9));
		int j = Integer.parseInt(pesel.substring(9,10));
		
		int controlSum = 0;
		
		int sum = 1*a + 3*b + 7*c + 9*d + 1*e + 3*f + 7*g + 9*h + 1*i + 3*j;
		System.out.println("Suma to: " + sum);
		int rest = sum % 10;
		
		if (rest != 0)
		{
			controlSum = 10 - rest;
		}
		
		int lastInt = Integer.parseInt(pesel.substring(10, 11));
		
		if (controlSum == lastInt)
		{
			return true;
		}
		
		return false;
	}

	private String pesel;
}
