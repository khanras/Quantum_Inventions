# Quantum_Inventions Seleium - TestNG Project

1.	Total workspace GitHub repository link is here: 
https://github.com/khanras/Quantum_Inventions
2.	I have used TestNG for creating this framework and created very basic and simple 7 test cases. 	
3.	Testng XML file (Control.xml) is kept under “.\TestNGXML” folder.
4.	If you need to run the test cases serially/parallel then you need to configure the TestNG XML.
5.	Test Data: Under the "test_data" folder of the workspace you will get “TestConfiguration.xlsx” and “PropData.properties” file. You need to configure accordingly.
      •	Using this PropData.properties file you can set the TestConfiguration.xlsx file's path and TestNG xml file's (here it is Control.xml) path.
      •	In the TestConfiguration.xlsx file you can configure the browser(only 2 browser supported-chrome & Firefox), WebDriver path, POM, test data.	
6.	As per the requirement, to run the application from CMD, you need to do the below steps:
      •	Copy JAR folder from the GitHub workspace to any location in your computer.
      •	If you want you can configure the test data, you can do else run it using by default value.
      •	By default it will run 7 test cases parallel on Chrome browser only.
      •	Open JAR folder in CMD and run the below command as I have used log4j2 logging in my application:
        "java -Dlog4j.configurationFile=.\log4j2.xml -jar QI.jar"
7.	After the run complete, you will get a log4j2 log from the “.\log” folder (i.e. TestNG.log).
8.	If any test case failed you will get the screenshot from ".\FailedScreenShot" folder.
9.	You also can get the TestNG html report file from the below location:
".\test-output\emailable-report.html"

I have tried my best to cover some of the requirements given from your end.
Please let me know if you will face any concern.

