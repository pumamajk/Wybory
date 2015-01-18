//import static org.junit.Assert.*;

//import static org.junit.Assert.*;

import org.fest.assertions.Assertions;
import org.junit.Test;

import wybory.PeselConfirmation;


public class testPeselConfirmation {

	@Test
	public void shouldReturnMale() throws Exception {
		
		//given
		String pesel = new String("89012800499");
		PeselConfirmation pConfirmation = new PeselConfirmation(pesel);
		//when 
		Boolean male = pConfirmation.checkSex();
		//then
		Assertions.assertThat(male).isEqualTo(true);
	}
	
	@Test
	public void shouldReturnFemale() throws Exception {
		
		//given
		String pesel = new String("89012800489");
		PeselConfirmation pConfirmation = new PeselConfirmation(pesel);
		//when 
		Boolean female = pConfirmation.checkSex();
		//then
		Assertions.assertThat(female).isEqualTo(false);
	}
	
	@Test
	public void shouldReturnCorrectControlSum() throws Exception {
		
		//given
		String pesel = new String("44051401359");
		PeselConfirmation pConfirmation = new PeselConfirmation(pesel);
		//when 
		pConfirmation.checkControlSum();
		Boolean male = pConfirmation.checkControlSum();
		//then
		Assertions.assertThat(male).isEqualTo(true);
	}
	
	@Test
	public void shouldReturnWrongControlSum() throws Exception {
		
		//given
		String pesel = new String("44051401358");
		PeselConfirmation pConfirmation = new PeselConfirmation(pesel);
		//when 
		pConfirmation.checkControlSum();
		Boolean male = pConfirmation.checkControlSum();
		//then
		Assertions.assertThat(male).isEqualTo(false);
	}
	
	@Test
	public void shouldReturnCorrectControlSumWithoutRestBy_10() throws Exception {
		
		//given
		String pesel = new String("44051401388");
		PeselConfirmation pConfirmation = new PeselConfirmation(pesel);
		//when 
		pConfirmation.checkControlSum();
		Boolean male = pConfirmation.checkControlSum();
		//then
		Assertions.assertThat(male).isEqualTo(false);
	}
	
	@Test
	public void shouldReturnCorrectDate() throws Exception {
		
		//given
		String pesel = new String("44051401388");
		PeselConfirmation pConfirmation = new PeselConfirmation(pesel);
		//when 
		
		Boolean date = pConfirmation.checkDate();
		
		//then
		Assertions.assertThat(date).isEqualTo(true);
	}
	
	@Test
	public void shouldReturnWrongDate() throws Exception {
		
		//given
		String pesel = new String("44131401388");
		PeselConfirmation pConfirmation = new PeselConfirmation(pesel);
		//when 
		
		Boolean date = pConfirmation.checkDate();
		
		//then
		Assertions.assertThat(date).isEqualTo(true);
	}
	
	@Test
	public void shouldReturnCorrectDate2() throws Exception {
		
		//given
		String pesel = new String("44131401388");
		PeselConfirmation pConfirmation = new PeselConfirmation(pesel);
		//when 
		
		Boolean date = pConfirmation.checkDate();
		
		//then
		Assertions.assertThat(date).isEqualTo(true);
	}
//	@Test
//	public void testName1() throws Exception {
//		
//		Assertions.assertThat(actual).is
	
}
