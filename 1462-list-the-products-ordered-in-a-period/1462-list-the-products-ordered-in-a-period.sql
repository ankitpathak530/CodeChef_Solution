# Write your MySQL query statement below

SELECT p.product_name, sum(o.unit) as unit
FROM ORDERS o JOIN PRODUCTS p 
ON o.product_id = p.product_id
WHERE o.order_date BETWEEN '2020-02-01' AND '2020-02-29'
GROUP BY o.product_id
HAVING sum(o.unit) >= 100;