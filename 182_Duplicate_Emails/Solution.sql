/*
182. Duplicate Emails  QuestionEditorial Solution  My Submissions
Total Accepted: 22102
Total Submissions: 58236
Difficulty: Easy
Write a SQL query to find all duplicate emails in a table named Person.

+----+---------+
| Id | Email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+
For example, your query should return the following for the above table:

+---------+
| Email   |
+---------+
| a@b.com |
+---------+
Note: All emails are in lowercase.

Have you met this question in a real interview? Yes  
*/
# Write your MySQL query statement below
select email as Email from (
    select Email as email, count(Email) as countNum  from Person group by Email
) as table1 where countNum > 1;