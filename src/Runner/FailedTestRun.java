package Runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class FailedTestRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TestNG runner = new TestNG();
		
		List<String> list = new ArrayList <String> ();
		list.add("C:\\Users\\ADMIN\\eclipse-workspace\\Basic\\test-output\\FailedTCExecution\\testng-failed.xml");
		
		runner.setTestSuites(list);
		
		runner.run();
	}

}
