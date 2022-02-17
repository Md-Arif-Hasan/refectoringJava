package workshop;


import java.util.List;


public class FizzBuzz {
	private List<PatternMatcher> patternMatchers;
	private PatternMatcher nullObjectPattern;
	public FizzBuzz(List<PatternMatcher> patternMatchers, PatternMatcher nullObjectPattern) {
		super();
		this.patternMatchers = patternMatchers;
		this.nullObjectPattern = nullObjectPattern;
	}

	public String say(int number) {
		String strReturn = nullObjectPattern.generateRresponse();

		for (PatternMatcher patternMatcher : patternMatchers) {
			if (patternMatcher.matches(number)) strReturn += patternMatcher.generateRresponse();
		}

		if(strReturn.equals(""))strReturn+=String.valueOf(number);

		return strReturn;
	}
}