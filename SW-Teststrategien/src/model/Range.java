package model;

public class Range {

 public int checkForCorrectRange(int start, int end, int actualValue) {
		
		if (actualValue >= start && actualValue <= end) {
			return actualValue;
		}
		return -1;
	}
 
 public int checkCorrectRangeForDecibel(int start, int end, int actualValue) throws Exception {
		
		if (actualValue >= start && actualValue <= end) {
			
			if(start < 10) {
				throw new Exception("Start must be at least 10 decibel");
			}
			else if (start >= 150) {
				throw new Exception("Start can't be 150 decibel or greater");
			}
			else if (end <= 10) {
				throw new Exception("End can't be 10 decibel or smaller");
			}
			else if (end > 150) {
				throw new Exception("End can't greater than 150 decibel");
			}
			return actualValue;
		}
		throw new Exception("Decibel must be between 10 and 150");
	}
 
}
