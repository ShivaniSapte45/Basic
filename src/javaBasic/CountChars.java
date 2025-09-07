package javaBasic;

import java.util.HashMap;
import java.util.Map;

public class CountChars {
	public static void charCount(String name)
	{
		String plainStr = name.replaceAll("[^a-zA-Z0-9]", "");
		String plainStr1 = plainStr.replaceAll("[0-9]", "");
		
		Map <Character, Integer> charMap = new HashMap<Character, Integer> ();
		char strArray[] = plainStr1.toCharArray();
		
		for(char c : strArray)
		{
			if(!String.valueOf(c).isBlank()) { //will not count space
			if(charMap.containsKey(c))
			{
				charMap.put(c, charMap.get(c)+1);
			}
			else {
				charMap.put(c, 1);
			}
			}
		}
		System.out.println(name + " : "+charMap);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		charCount("Hello");
		charCount("Helloh");
		charCount("A count characters in java 14265 $^%$&%*");
		
		

	}
	

}
