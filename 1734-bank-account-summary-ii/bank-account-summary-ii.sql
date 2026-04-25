# Write your MySQL query statement below
SELECT NAME,SUM(amount) as BALANCE from Users join Transactions on Users.account=Transactions.account group by Users.account  having BALANCE>10000;