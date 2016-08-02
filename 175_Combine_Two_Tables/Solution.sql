/*
175. Combine Two Tables  QuestionEditorial Solution  My Submissions
Total Accepted: 24014
Total Submissions: 69738
Difficulty: Easy
Table: Person

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| PersonId    | int     |
| FirstName   | varchar |
| LastName    | varchar |
+-------------+---------+
PersonId is the primary key column for this table.
Table: Address

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| AddressId   | int     |
| PersonId    | int     |
| City        | varchar |
| State       | varchar |
+-------------+---------+
AddressId is the primary key column for this table.

Write a SQL query for a report that provides the following information for each person in the Person table, regardless if there is an address for each of those people:

FirstName, LastName, City, State
Have you met this question in a real interview? Yes  
*/
# Write your MySQL query statement below
select FirstName, LastName, City, State from Person left join Address on Person.PersonId = Address.PersonId;