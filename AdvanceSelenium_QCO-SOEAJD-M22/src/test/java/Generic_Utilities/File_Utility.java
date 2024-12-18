package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility {

	/**
	 * This method is used to read data from properties_file (External Resource)
	 * @param Key
	 * @return
	 * @author Priya
	 * @throws Throwable
	 */
	public String getKeyAndValuePair(String Key) throws Throwable {

		FileInputStream fis = new FileInputStream("./src/test/resources/CommomData.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(Key);
		return value;
	}
}































//..........................................
/*
 package Generic_Uilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import http://java.util.Properties;

public class File_Utility {

	/**
	 * This method is used to read data from properties_file (External Resource)
	 * @param Key
	 * @return
	 * @author Priya
	 * @throws Throwable
	 */
	/*public String getKeyAndValuePair(String Key) throws Throwable {

		FileInputStream fis = new FileInputStream("./src/test/resources/CommonDatas.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(Key);
		return value;

	}
}
 */
//.................................
/*
 File_utility

package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility {

	/**
	 * its used return the value from property file based on key
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author Shobha
	 */
	/*public String getKeyAndValueData(String key) throws Throwable
	{
	 FileInputStream fis = new FileInputStream("./src/test/resources/CommonData10am.properties");
	 Properties pro = new Properties();
	 pro.load(fis);
	 return pro.getProperty(key);
	}
}
*/
 
 