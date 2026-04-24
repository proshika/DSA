# Write your MySQL query statement below
SELECT DISTINCT  product_id,product_name from Sales join Product using(product_id) where sale_date>='2019-01-01' AND sale_date<='2019-03-31' AND product_id NOT IN (
    SELECT product_id
    From sales
    where sale_date<'2019-01-01' OR sale_date>'2019-03-31'
);