package AnalyzerTest;


import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1 {
	
	@Test
	(retryAnalyzer = AnalyzerTest.RetryAnalyzer.class)
	public void test1()
	{
		Assert.assertEquals(false, true);
	}
	
	@Test
	public void test2()
	{
		Assert.assertEquals(true, true);
	}
	

}
