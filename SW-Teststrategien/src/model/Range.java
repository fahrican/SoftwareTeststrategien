package model;

public class Range {

 public int checkForCorrectRange(int start, int end, int actualValue) {
		
		if (actualValue >= start && actualValue <= end) {
			return actualValue;
		}
		return -1;
	}
}
