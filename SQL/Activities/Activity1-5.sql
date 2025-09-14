DROP table salesman;
--Activity 1
Create table salesman(salesman_id int PRIMARY KEY, salesman_name varchar2(20) NOT NULL, salesman_city varchar2(20), commission int);
Describe salesman;

--Activity 2
INSERT ALL 
    INTO salesman VALUES(5001, 'James Hong', 'New York', 15)
	INTO salesman VALUES(5002, 'Nail Knite', 'Paris', 13)
	INTO salesman VALUES(5005, 'Pit Alex', 'London', 11)
	INTO salesman VALUES(5006, 'McLyon', 'Paris', 14)
	INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13)
	INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12)
SELECT 1 FROM DUAL;
SELECT * FROM salesman;

--Activity 3
select salesman_id, salesman_city from salesman;
select * from salesman where salesman_city='Paris';
Select salesman_id, commission from salesman where salesman_name='Paul Adam';

--Activity 4
ALTER TABLE salesman ADD Grade int;
Update salesman SET Grade = 100;
select * from salesman;

--Activity 5
UPDATE salesman SET Grade=200 where salesman_city='Rome';
UPDATE salesman SET Grade=300 where salesman_name='James Hong';
UPDATE salesman SET salesman_name='Pierre' where salesman_name='McLyon';
select * from salesman;