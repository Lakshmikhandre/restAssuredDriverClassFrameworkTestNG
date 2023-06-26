import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import commonFunctionspackage.utility_Common_Function;


public class driverClass {


		//import testClass.Post_TC_1;
	
		public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		//Post_TC_1.execute();
		ArrayList<String> testcaserun=utility_Common_Function.readdataexcel("Postrunner","TestCasenametoexecute");
		int count =testcaserun.size();
		System.out.println(count);
		for (int i=1;i<count;i++)
		{
		String testcasename=testcaserun.get(i);
		System.out.println(testcasename);
		// call the testcaseclass on runtime by using java.lang.reflect package
		Class<?> testclassname=Class.forName("testClassPackage."+ testcasename);
		// call the execute method belonging to test class captured in variable testclassname by using java.lang.reflect.method class
		Method executemethod=testclassname.getDeclaredMethod("execute");
		// set the accessibility of method true 
		executemethod.setAccessible(true);
		// create the instance of testclass captured in variable name testclassname
		Object instanceoftestclass=testclassname.getDeclaredConstructor().newInstance();
		// execute the testclass captured in variable name testclass name
		executemethod.invoke(instanceoftestclass);
		}
		}


		}


