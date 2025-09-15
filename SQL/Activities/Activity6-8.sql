-- Create a table named orders
create table orders(
    order_no int primary key, purchase_amount float, order_date date,
    customer_id int, salesman_id int);

-- Add values to the table
INSERT ALL
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002) 
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005)
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001)
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003)
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002)
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001)
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001)
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006)
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003)
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002)
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007)
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001)
SELECT 1 FROM DUAL;
select * from orders;

--Activity 6
select DISTINCT salesman_id from orders;
select order_no from orders order by order_date;
select order_no from orders order by purchase_amount desc;
select * from orders where purchase_amount < 500;
select * from orders where purchase_amount between 1000 and 2000;

--Activity 7
select SUM(purchase_amount) as "Total purchase Amount" from orders;
select avg(purchase_amount) as "Average purchase amount" from orders;
select max(purchase_amount) as "Maximum purchase amount" from orders;
select min(purchase_amount) as "Minimum purchase amount" from orders;
select count(distinct salesman_id) as "Salesman Count" from orders;

--Activity 8
select customer_id, max(purchase_amount) as "Max purchase" from orders group by customer_id order by customer_id;
--Write an SQL statement to find the highest purchase amount on '2012-08-17' for each salesman with their ID.
select salesman_id, max(purchase_amount) as "Max purchase" from orders where order_date=TO_DATE('2012/08/17', 'YYYY/MM/DD')  group by salesman_id;
--Write an SQL statement to find the highest purchase amount with their ID and order date, for only those customers who have a higher purchase amount within the list [2030, 3450, 5760, 6000].
select customer_id, order_date, max(purchase_amount) as "Max purchase" from orders group by customer_id,order_date having max(purchase_amount) IN (2030, 3450, 5760, 6000);