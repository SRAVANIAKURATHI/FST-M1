-- Create the customers table
create table customers (
    customer_id int primary key, customer_name varchar(32),
    city varchar(20), grade int, salesman_id int);

-- Insert values into it
INSERT ALL
    INTO customers VALUES (3002, 'Nick Rimando', 'New York', 100, 5001)
    INTO customers VALUES (3007, 'Brad Davis', 'New York', 200, 5001)
    INTO customers VALUES (3005, 'Graham Zusi', 'California', 200, 5002)
    INTO customers VALUES (3008, 'Julian Green', 'London', 300, 5002)
    INTO customers VALUES (3004, 'Fabian Johnson', 'Paris', 300, 5006)
    INTO customers VALUES (3009, 'Geoff Cameron', 'Berlin', 100, 5003)
    INTO customers VALUES (3003, 'Jozy Altidor', 'Moscow', 200, 5007)
    INTO customers VALUES (3001, 'Brad Guzan', 'London', 300, 5005)
SELECT 1 FROM DUAL;

--Activity 9
select s.salesman_name,c.customer_name from salesman s inner join customers c on s.salesman_id=c.salesman_id;
select c.customer_name, c.city, c.grade, s.salesman_name, s.salesman_city from customers c left join salesman s on s.salesman_id=c.salesman_id where grade < 300 order by customer_id;
select c.customer_name,s.salesman_name, s.commission from customers c left join salesman s on c.salesman_id=s.salesman_id where commission > 12;
select o.order_no,o.order_date,o.purchase_amount, c.customer_name, s.salesman_name, s.commission from orders o 
    inner join customers c on o.customer_id=c.customer_id
    inner join salesman s on o.salesman_id=s.salesman_id;

--Activity 10
select * from orders where salesman_id in (select salesman_id from orders where customer_id=3007);
select * from orders where salesman_id in (select salesman_id from salesman where salesman_city='New York');
select grade, count(customer_id) as c_count from customers group by grade having grade > (select avg(grade) from customers where city='New York');
select * from orders where salesman_id in (select salesman_id from salesman where commission=(select max(commission) from salesman));

--Activity 11
-- Write a query that produces the name and number of each salesman and each customer with more than one current order. Put the results in alphabetical order
SELECT customer_id, customer_name FROM customers a
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.customer_id = b.customer_id)
UNION
SELECT salesman_id, salesman_name FROM salesman a
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.salesman_id = b.salesman_id)
ORDER BY customer_name;

-- Write a query to make a report of which salesman produce the largest and smallest orders on each date.
SELECT a.salesman_id, a.salesman_name, o.order_no, 'highest on', o.order_date, o.purchase_amount FROM salesman a, orders o
WHERE a.salesman_id=o.salesman_id
AND o.purchase_amount=(SELECT MAX(purchase_amount) FROM orders c WHERE c.order_date = o.order_date)
UNION
SELECT a.salesman_id, a.salesman_name, o.order_no, 'lowest on', o.order_date, o.purchase_amount FROM salesman a, orders o
WHERE a.salesman_id=o.salesman_id
AND o.purchase_amount=(SELECT MIN(purchase_amount) FROM orders c WHERE c.order_date = o.order_date)
ORDER BY order_date;