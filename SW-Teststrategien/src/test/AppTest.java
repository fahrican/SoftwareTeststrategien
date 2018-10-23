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
		String input = tf.getText();
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
	
	@Test
	public void testLimitArea1() {
		Dezibelwiedergabe dw = new Dezibelwiedergabe();
		dw.setTextFieldDecibel(new JTextField("10"));
		String input = dw.getTextFieldDecibel().getText();
	    assertThat(Integer.parseInt(input), allOf(greaterThan(9), lessThan(21)));
	}
	
	@Test
	public void testAC2() {
		Dezibelwiedergabe dw = new Dezibelwiedergabe();
		JTextField tf = dw.getTextFieldDecibel();
		String input = tf.getText();
	    assertThat(Integer.parseInt(input), allOf(greaterThan(19), lessThan(31)));
	}
	
	@Test
	public void testAC3() {
		Dezibelwiedergabe dw = new Dezibelwiedergabe();
		JTextField tf = dw.getTextFieldDecibel();
		String input = tf.getText();
	    assertThat(Integer.parseInt(input), allOf(greaterThan(29), lessThan(41)));
	}
	
	public boolean isNumeric(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
