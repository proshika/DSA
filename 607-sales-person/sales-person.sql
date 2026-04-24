# Write your MySQL query statement below
SELECT name from SalesPerson where sales_id not in(SELECT sales_id from Orders WHERE com_id=(SELECT com_id FROM company WHERE name="RED"));