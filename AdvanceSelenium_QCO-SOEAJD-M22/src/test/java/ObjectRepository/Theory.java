package ObjectRepository;

public class Theory {
	/*
	 * 1.	What is Object/Elements/POM Repository
Its collection of elements locators & business libraries in one place & its developed using POM design pattern 


2.	Why Object repository ? 
              As per the rule of the automation, we should not hardcode[fixed]elements with in test Scripts instead, we should get elements from Object Repository , because in Agile process due to frequent requirement changes , modification & maintenance of   elements is tedious job.

3.	What is the advantages repository?  
a.	Reusability of elements, no need to write xpath & other locators again & again
b.	Modification in Repository is easy, when GUI changes frequently
c.	Maintenance is easy, because all the elements we kept in one place
d.	Test Script Code Optimized via business reusable libraries
e.	More Readability
f.	Test Script development is faster due to business lib
g.	Handle Stale Elements Exception.

4.	What is POM?
          POM is a java design pattern preferred by google to develop object repository.  
5.	Why POM ? 
           It’s a well-organized structured design pattern, where we can maintain all the web elements in page wise, due to POM design pattern maintains & modification is easy & faster.

6.	Advantages of POM: 
1.	Well organized structure 
2.	Handle stale element exception.
3.	maintains & modification of element is easy
4.	We can directly store Web Elements in java class
5.	Better fit for Agile processes 
6.	Support Auto heal feature 

7.	Why @FindBy & @Findall annotation instead of driver.findElement(“locator”)
                  Ans : to avoid staleElementReferenceException & also we can use Auto heling feature in @findAll annoation

8.	What is staleElementReferenceException ?
It’s one of selenium Exception , whenever webdriver try to identify an element , element was available in GUI, but at time of performing an action on the elements element was not recognized due to  page got refreshed or elements may become old or element not attached to page in such case we get  staleElementReferenceException


9.	Rules of POM 
Rule 1 : create separte java class for every webpage in an application & class name should be same page name
Rule 2 : Identify all the elements using @findBy & @findAll , @findbys annotations & store them in speific pom / java class (Element declartion)
Rule3 : For Every POM class  create Constructor to get an Object of the POM class , inside the  Constructor use Pagefactory.initElement()  to initialize the Page Elements  at the time Object creation,  in order to initialize all the page Elements we should use Pagefactory.initElement() (Element initialization)
Rule 4 : declare all the WebElements as private & provide getters methods to accesses elements in testScripts class [this processes is called Encapsulation]
   Note : to create getters mtds inside the java class fallow below steps
              =>place cursor inside the class Right clicksource generate getters & setters  select the getters check box  click on ok button
Rule 5 : Go to every Page & identify the reusable business libraries & implement them in same POM class.


10.	Difference between POM & PageFactory design pattern?
             POM is java design pattern, where will maintain all the  Web element locator in well-organized manner
           Pagefactory it’s an extended design pattern of POM , which is used to create an Object to POM classes , & at the time of object creation it will execute all @findBy @findbys annotation then initialize all the elements


Difference between @findBy , @findAll &@findBys annotation
 All annotation available in Selenium webdriver, its traditional ways to identify the elements in GUI.
@findBy : used to identify the element using one locator or one condition
@findAll : it contains multiple @findBy annotation , it mean we can identify  the same element using multiple locator (multiple conditions) , it will use OR condition during execution of locator
     @findALL({ @findBy(@id=’username’) , @findBy(name=’user’)})
     Private Webelements userNAmeEdt;
   Note : using above concepts we can achieve Autohealing  technique 
 AutoHealing : during execution , if one locator fails to identify the element , it will retry to identify the same element using another locator 
@FindBys : it contains multiple @findBy annotation , it mean we can identify  the elements using multiple locator (multiple conditions) , it will use AND condition  during execution of locator
        @findBys({ @findBy(@id=’username’) , @findBy(name=’user’)})
     Private Webelements userNAmeEdt;

	 */

}
