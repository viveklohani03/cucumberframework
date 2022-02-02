Feature: feature to test amazon.in

Background:
Given Verify user is on amazon.in home page
When Click hemburgericon and select menuItem
Then Select shirtsize
And Add shirt in cart

@FirstTest
Scenario: Verify price after updating quantity on cart
And Select quantity from shirt dropdown
Then Verify two shirt is added with correct price

Scenario: Verify item gets deleted from cart after deletion
Then Click delete link and verify that cart is empty


Scenario: Verify the item saved for later on clicking save-for-later 
Then Click save-for-later and verify the page
