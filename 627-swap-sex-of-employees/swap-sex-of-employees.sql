# Write your MySQL query statement below
UPDATE Salary
Set sex=case
  when sex='m' then 'f'
  else 'm'
  end;