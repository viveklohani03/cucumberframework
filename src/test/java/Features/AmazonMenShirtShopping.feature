Feature: feature to test amazon.in

@FirstTest
Scenario: Verify price after updating quantity on cart
Given Verify user is on amazon.in home page
When Click hemburgericon and select menuItem
Then Verify user navigated to shirt page
Then Select shirtsize with quantity more than two
And Add shirt in cart
Then Select quantity from shirt dropdown
Then Verify two shirt is added with correct price
@FirstTest
Scenario: Verify item gets deleted from cart after deletion
Given Verify user is on amazon.in home page
When Click hemburgericon and select menuItem
Then Verify user navigated to shirt page
Then Select shirtsize with quantity more than two
And Add shirt in cart
Then Click delete link and verify that cart is empty

@FirstTest
Scenario: Verify the item saved for later on clicking save-for-later 
Given Verify user is on amazon.in home page
When Click hemburgericon and select menuItem
Then Verify user navigated to shirt page
Then Select shirt having quantity more than two
And Add shirt in cart
Then Click save-for-later and verify the page

@FirstTest
Scenario: Verify user added shirt after navigating back on shirt page
Given Verify user is on amazon.in home page
When Click hemburgericon and select menuItem
Then Verify user navigated to shirt page
Then Select shirt with only quantity one
And Add shirt in cart
Then Select quantity from shirt dropdown
Then Select shirt having quantity more than two
And Add shirt in cart
Then Select quantity from shirt dropdown






