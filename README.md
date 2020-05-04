# cse237-project

ITERATION 3:

1. Completed user stories:
- Top 10 countries infected
- Test your susceptibility
- Search for cities and its stats
- User can run from command line

2. Implemented but currently not working:
- Country comparison
- Heat map

3. To run the program

    a. From Eclipse, select CoronaClass and simply click run.
    
    b. From command line, open up terminal, navigate to the Corona folder.
    
        - for Window, run java -cp .;json-20190722.jar CoronaClass
    
        - for Mac, run java -cp .:json-20190722.jar CoronaClass
    
    *** if the class did not run or not compile, run <<< javac -cp .;json-20190722.jar *.java >>>, then run the above command again. ***









_________________________________________________________________________________________________


ITERATION 1

What user stories were completed this iteration?
 
As a collective, the goal for this project was to allow people to be aware of the conditions of the 
COVID-19 pandemic. While we were aware that everyone has been keeping up with the corona virus 
progressions and its outreach, our team believed that there was a lack of actual knowledge of the 
spread of the virus. 
 
For this iteration, we decided to create the very basic foundation of this project. We aimed to 
achieve a platform for the user to be able to retrieve information about COVID-19’s effects and 
spread throughout the world. With our project, we are able to provide the user instant real time data 
of the total number of cases that have been recorded worldwide by country. The platform has an 
impeccable user interface which was designed to keep the environment user-friendly and simple. Upon 
running the project the user will observe a pop up window which prompts the user to type in a search 
box. Here the user will be allowed to type in a name of a country. Next to the search box is a button 
which upon a click event will output a print statement that will inform the user about the current 
reported cases of the particular country that the user typed in.
 
We successfully completed several user stories:
 
Each group member was able to make their own branch successfully, and spent this iteration getting 
comfortable with the different ways of handling and manipulating code through these branches.  
 
To make an interactive user interface, we made use of buttons that would refresh the data that has 
been loaded on the pop-up window to reflect the latest data available.
 
Functionality and logic added to our project to pull the most up-to-date information from an API 
regarding COVID-19 that reflects very accurately with real world information on it.
 
Buttons were added to enhance the layout of the pop-up window and to make the appearance more user 
friendly. Buttons also have the functionality that allows the user to select the country to be 
displayed.
 
Search bar has been added to allow easy look up of the desired country for the user.
 
Query API for countries statistic and store in global class so that it can be further manipulated for 
future iterations.
 
Added 8 test cases which check whether the information is being successfully accessed and retrieved 
from an API or not, and further checks whether the retrieved information from the API is accurate or 
not. 
 
What user stories do you intend to complete next iteration?
 
Check for invalid input and display the correct outputs guiding the user about how to correctly input 
into the search box.
 
Successfully run the project from the command line as instructed in the guidelines.
 
Add reported cases by City.
 
Add reported cases by Continent.
 
Add reported deaths by Country.
 
Add reported deaths by City.
 
Add reported deaths by Continent.
 
Add reported cures by the City.
 
Add reported cures by Continent.
 
Add reported cures by Country.
 
Is there anything that you implemented but doesn't currently work?
 
We intended to implement the start functionality of the project from the command line before the end 
of this iteration. However, due to the limitation of time we were not able to complete this user 
story. An executive decision was made and it was decided to push this to the next iteration. Thus, no 
implementation for this user story took place.


ITERATION 2

What user stories were completed this iteration?

As mentioned before, the goal for this project was to allow people to be aware of the conditions of 
the COVID-19 pandemic. In our last iteration, we were successfully able to implement the very basic 
core structure for our framework which allowed the user to check the current cases that have been 
reported thus far by country. 

For this iteration, we decided to build upon the framework that we had established in the previous 
iteration. We initially implemented different parsing methods to parse different kinds of information 
from the API. We introduced parsing methods to get very specific pieces of information that would 
enhance the user’s knowledge on the current situation of the corona virus’s status and spread, and 
would give the user a more clear perspective and detailed insight. Our Parsing method scopes into the 
api to get information that covers recovered cases, deaths, new cases, new deaths, total cases, and 
total deaths. We were also able to implement specific scoping into the api and retrieve information 
specific to the province entered. We believe that this will allow the user to be more aware regarding 
where the spread is most prevalent in a certain country.

We successfully completed several user stories:

After the first iteration, the first user story that we completed was acting upon the feedback that 
we received. Therefore, we removed the individual branches that we had created and made testing 
branches for each different portion of the project. Now, our project has a branch which is in charge 
of a certain functionality of the project. This was definitely a great feedback, as we did not run 
into any merge conflict in this iteration.

To add upon our interactive user interface, we implemented additional buttons that would not only 
refresh the data but also allow the user to search a more specific area for information. The addition 
visually enhances the layout of the pop-up window and  adds to the user friendliness of the UI. 
Buttons also have the functionality that allows the user to select the country as well as provinces 
to be displayed. A checkbox is used to specify whether the user is searching for national information or provincial information.

Further logic and functionality were added to the program by introducing specificity and detail to 
our project to pull the most up-to-date information from an API regarding COVID-19 that reflects very 
accurately with real world information on it. The additions allow the user to fetch more specific 
information regarding COVID-19 and give a more well rounded picture of the current scenario.

12 new test cases were added to the project as advised in the feedback which check the functionality 
of the methods that are running the code. These test methods check different scenarios for the JSON 
parse method and make sure that there is no breaking point in the functionality of our principal 
parsing method. These tests also check whether a stable connection with the API is being formed or 
not. Furthermore, these tests also specify why a connection with the API would have failed which 
guides where the error might be. Our experiences with faulty API servers inspired us to write this 
test case as we would invest unnecessary time in figuring out the issue when the API servers went 
down.

We were able to run the code from the command line successfully for this iteration as we had planned.

We were also able to implement a scrolling feature to our pop up window which contributes to the 
aesthetic appeal of our project. It also allows the user to make multiple search entries without 
worrying about figuring out a way to scroll down.

We were also successfully able to run the project from the command line as instructed in the 
guidelines.
 
What user stories do you intend to complete next iteration?

Check for invalid input and display the correct outputs guiding the user about how to correctly input 
into the search box.

Add reported cases by City.

Add reported cases by Continent.

Add reported deaths by City.

Add reported deaths by Continent.

Add reported cures by the City.

Add reported cures by Continent.

Adding a button to select whether you’re getting the info for a country / province

Add the flag of the country next to its information.

Make the display more pleasing.

Is there anything that you implemented but doesn't currently work?

We tried to implement a flag that would pop up next to the information of the stats of the country 
that the user typed in. We were able to find a working API for it, however we decided to push this 
for the next iteration. It seemed logical to all of us to more this to the next iteration as our goal 
for the next iteration is to work on the visual/display side if the project and focus on its 
immediate appeal. 
