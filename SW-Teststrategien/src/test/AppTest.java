package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import model.Range;

import javax.swing.JTextField;

import org.junit.Test;

import ui.Dezibelwiedergabe;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.CoreMatchers.allOf;

/**
 * Unit test for simple AppTest.
 */
public class AppTest 
{
    
	@Test
	public void testTextFieldNotNull() {
		//assign
		Dezibelwiedergabe dw = new Dezibelwiedergabe();
		//act
		JTextField tf = dw.getTextFieldDecibel();
		//String input = tf.getText();
		//assert
		assertNotNull(tf);
	}
	

	@Test(expected = Exception.class)
	public void testTextFieldDecibelAsString() throws Exception {
		//assign
		Dezibelwiedergabe dw = new Dezibelwiedergabe();
		dw.setTextFieldDecibel(new JTextField("test"));
		String val = dw.getTextFieldDecibel().getText();
		
		int myInt = Integer.parseInt(val);
		//fail("Exception expected");
	}
	
	public boolean isNumeric(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Test
	public void testTextFieldDecibelIsNumeric() {
		//assign
		Dezibelwiedergabe dw = new Dezibelwiedergabe();
		//act
		dw.setTextFieldDecibel(new JTextField("150"));
		JTextField tf = dw.getTextFieldDecibel();
		String input = tf.getText();
		//assert
		assertTrue(isNumeric(input));
	}
	
	@Test
	public void testTextFieldDaysIsNumeric() {
		//assign
		Dezibelwiedergabe dw = new Dezibelwiedergabe();
		//act
		dw.setTextFieldDays(new JTextField("10"));
		JTextField days = dw.getTextFieldDays();
		//assert
		assertTrue(isNumeric(days.getText()));
	}
	
	@Test
	public void testRangeValueSmallerThanStart() {
		
		Range range = new Range();
		int actualValue = range.checkForCorrectRange(10, 150, 9);
		assertEquals(-1, actualValue);
	}
	
	@Test
	public void testRangeValueGreaterThanEnd() {
		
		Range range = new Range();
		int actualValue = range.checkForCorrectRange(10, 150, 151);
		assertEquals(-1, actualValue);
	}
	
	@Test(expected = Exception.class)
	public void testTextFieldDecibelSmallerThanTen() throws Exception  {
		
		Range range = new Range();
		range.checkCorrectRangeForDecibel(10, 150, 9);
	}
	
	@Test(expected = Exception.class)
	public void testTextFieldDecibelGreater150() throws Exception  {
		
		Range range = new Range();
		range.checkCorrectRangeForDecibel(10, 150, 151);
	}
	
	@Rule public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testTextFieldDecibelStartSmallerTen() throws Exception  {
		
		Range range = new Range();
		
		thrown.expect(Exception.class);
		thrown.expectMessage("Start must be at least 10 decibel");
		
		range.checkCorrectRangeForDecibel(9, 150, 80);
		//fail("Exception expected");
	}
	
	@Test
	public void testTextFieldDecibelEndGreater150() throws Exception  {
		
		Range range = new Range();
		
		thrown.expect(Exception.class);
		thrown.expectMessage("End can't greater than 150 decibel");
		
		range.checkCorrectRangeForDecibel(10, 160, 80);
		//fail("Exception expected");
	}
	
}
