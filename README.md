#EnergyAustralia MusicFestival Assesment  #Mobile-QE-Role  #Andriod Application Testing

To Run the Test cases:

testng.xml --> Run As -->TestNG Suite

Pre-Requisites:

Step1: Load the source code to the Android Studio

Step2: Install any Android device and start the Virtual Device (emulator)

Step3: Install and start Appium Server

Test Cases:

All the test cases are added under the class MusicFestival.java file.

    path: path: /src/test/java under package com.EnergyAustralia.Test;
    
Ran the test cases multiple times (Added the test class to testng xm 4 times) as the app retrieved the details each time differently.

Test Case1: validateEmptyResponse()

   Description: Test cases will fetch the Music Festival details and validate any exception is thrown.
   
Validation:

   pass --> If any Festival details are fetched.
   
   Fail --> If the exception is thrown at android app as "Response wasn't successful or data empty. Response code: 429"
   
Test Case2: validateBandDetails()

   Description: Test cases will fetch the Music Festival details and validate any exception for Band Names
   
Validation:

   pass --> If any Band Names are fetched.
   
   Fail --> If the Band Name contains the exception at android app as "Something went badly wrong".
  
 Test Case3: validateFestivalDetails()
 
   Description: Test cases will fetch the Music Festival details and validate any exception for Festival Names
   
 Validation:
 
   pass --> If any Festival Names are fetched.
   
   Fail --> If the Festival Name contains the exception at android app as "Unknown”.


Framework Implementation steps:

Step1: Created the Maven project.

Step2: Added the required dependencies to POM.xml file.

step3: Created the testng.xml to run the test cases.

step2: Crated Generic class to link the Appium server, emulator and to initiate the driver.

       path: /src/main/java under package com.EnergyAustralia.helpers
       
step3: Created a page class using POM concept to identify the adnriod element and to fetch the details.

      path: /src/main/java under package com.EnergyAustralia.pageobjects;
      
step4: Created a test class to create the test cases.

      path: /src/test/java under package com.EnergyAustralia.Test;
      
step5: Created a custom exception class to throw user defeined exception.

      path:path: /src/main/java under package com.EnergyAustralia.helpers
