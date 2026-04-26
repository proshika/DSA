# Write your MySQL query statement below
SELECT event_day as day, e.emp_id ,SUM(out_time-in_time) as total_time from Employees e group by event_day,emp_id;