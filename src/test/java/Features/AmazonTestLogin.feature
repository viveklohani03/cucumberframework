Feature: Feature to test amazon.in login
@logintest
Scenario Outline: Verify username with invalid data
Given Verify user is on amazon.in home page
When User clicks Sign In icon and navigate to SignIn page
Then Enter "<username>" and click Continue
And Verify error on signin page
Examples:
|username  |
|abc       |        
|99718800  |

@logintest
Scenario Outline: Verify password with invalid data
Given Verify user is on amazon.in home page
When User clicks Sign In icon and navigate to SignIn page
Then Enter "<username>" and click Continue
Then Enter "<password>" and click signin
And Verify error on signin page

Examples:
|username  |password|
|9971880063|  pwd   |  

@exceltest
Scenario Outline: Verify login using data from excel
Given Verify user is on amazon.in home page
When User clicks Sign In icon and navigate to SignIn page
Then Enter username from "<path>","<sheetname>" and <colnum>
And Verify error on signin page
Examples:
|path                |sheetname|colnum|
|E:/vivek/Automation/cucumberjava/src/test/resources/Data.xlsx|Sheet1   |0     |