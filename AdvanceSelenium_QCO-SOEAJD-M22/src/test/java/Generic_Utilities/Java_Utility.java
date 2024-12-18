package Generic_Utilities;

import java.util.Random;

public class Java_Utility {

	/**
	 * This method is used to avoid duplicate values
	 * @author Shobha
	 * @return
	 */
	public int getRandomNum() {

		Random ran = new Random();
		int value = ran.nextInt(1000);
		return value;

	}
}
 //...............................
/*
 *package Generic_Uilities;

import java.util.Random;

public class Java_Utility {

	/**
	 * This method is used to avoid duplicate values
	 * @author Shobha
	 * @return
	 */
	/*public int getRandomNum() {

		Random ran = new Random();
		int value = ran.nextInt(1000);
		return value;

	}
}
 */
//..................................................
/*
                                       Generic Libraries / Utility

What is Generic components in Automation Framework?
it’s one of the automation framework components which is common for all the application
its collection of generic class contains reusable methods / libraries 
      The methods which can be used to any application is called Generic/common methods
 - This is a package created in src/main/java source folder 
 - It is used to store all the generic classes
What is the advantages of Generic components?
	Reusability of code
	Code Optimization 
	Test script development is faster
	Test Code readability
	Generic libraries are common to all automation projects
	Avoid duplicate Code
	no need to remember the syntax every time , just create once & use multiple times.


1.	Java Utility Libraries 
 
  Java Utility is one class in generic component, which contain java specific methods which can be used across the test Scripts / Application 
 its contains several generic reusable methods like
	getRandomNum() : it’s used to  generate random number for every invocation

package Generic_Utilities;

import java.util.Date;
import java.util.Random;

public class Java_Utility {

	/**
	 * This Method is used to avoid Duplicates
	 * @return
	 * @author Shobha
	 */
	/*public int getRandomNum()//dpn't command just for correction used command symbol
	{
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		return ranNum;
	}
}

 */
 
 
