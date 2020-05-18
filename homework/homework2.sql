USE course;

-- 1 
SELECT DISTINCT  job FROM employee;

-- 2
SELECT name, salary, deptid FROM employee WHERE job = 'clerk' ORDER BY deptid, salary DESC; 

-- 3
SELECT	name, hiredate FROM employee WHERE job = 'manager';

-- 4
SELECT * FROM employee WHERE job = 'clerk' OR job = 'analyst' ORDER BY name DESC;

-- 5
SELECT * FROM employee WHERE salary BETWEEN 2200 AND 4500;

-- 6
SELECT * FROM employee WHERE job <> 'manager'  AND job <> 'president' ORDER BY salary;

-- 7
SELECT * FROM employee WHERE salary > ( SELECT salary FROM employee WHERE name = 'blake');

-- 8
SELECT * FROM employee WHERE job = ( SELECT job FROM employee WHERE name = 'allen');

-- 9
SELECT * FROM employee WHERE salary = ANY ( SELECT salary FROM employee WHERE name = 'ford' OR name = 'smith');

-- 10
SELECT a.*, b.name AS manager_name, b. hiredate AS manager_hiredate FROM employee a, employee b WHERE a.manager = b.empid AND a.hiredate < b.hiredate;

-- 11
SELECT a.deptid, a.name, a.salary FROM employee a LEFT JOIN employee b ON a.deptid = b.deptid AND a.salary < b.salary WHERE b.deptid IS NULL ORDER BY a.deptid;  

-- 12
SELECT employee.name, department.name AS department FROM employee JOIN department ON employee.deptid = department.deptid;

-- 13
SELECT department.deptid, department.name, loc FROM employee RIGHT JOIN department ON employee.deptid = department.deptid WHERE empid IS NULL;

-- 14
SELECT * FROM employee ORDER BY salary DESC LIMIT 1 OFFSET 1;

-- 15
SELECT * FROM employee ORDER BY salary DESC LIMIT 1 OFFSET 2;

-- 16
SELECT 	job, SUM(salary) AS total_salary FROM employee GROUP BY job;

-- 17
SELECT department.deptid, department.name, AVG(salary) AS average_salary FROM employee JOIN department ON employee.deptid = department.deptid GROUP BY deptid;

-- 18
SELECT department.deptid, department.name, AVG(salary) AS average_salary FROM employee JOIN department ON employee.deptid = department.deptid GROUP BY deptid 
HAVING average_salary >= 2000;

-- 19
SELECT COUNT(*), deptid, job FROM employee GROUP BY deptid, job ORDER BY deptid;

-- 20
SELECT temp.deptid, name, loc, employee_num FROM department RIGHT JOIN
(SELECT COUNT(*) AS employee_num, deptid FROM employee GROUP BY deptid HAVING employee_num > 2) AS temp ON department.deptid = temp.deptid;

-- 21
SELECT t1.deptid, name, loc, employee_num, clerk_num FROM 
(SELECT temp.deptid AS deptid, name, loc, employee_num FROM department RIGHT JOIN
(SELECT COUNT(*) AS employee_num, deptid FROM employee GROUP BY deptid) AS temp ON department.deptid = temp.deptid)  t1
JOIN
(SELECT COUNT(*) AS clerk_num, deptid FROM employee GROUP BY deptid, job HAVING job = 'clerk' AND clerk_num >=  2) t2
ON t1.deptid = t2.deptid;

-- 22
SELECT deptid, name, loc, employee_num FROM department NATURAL JOIN
(SELECT COUNT(*) AS employee_num, department.deptid FROM employee JOIN department ON employee.deptid = department.deptid GROUP BY deptid ) AS temp ORDER BY employee_num DESC LIMIT 1;

-- 23
SELECT * FROM employee WHERE name LIKE '%a%';

-- 24
SELECT * FROM employee WHERE dayofmonth(hiredate) < 15;

-- 25
-- 18

-- 26
SELECT concat(name, '(', job, ')') AS employee_job FROM employee;

-- 27
SELECT a.deptid, a.name, a.salary FROM employee a LEFT JOIN employee b ON a.deptid = b.deptid AND a.salary > b.salary WHERE b.deptid IS NULL ORDER BY a.salary DESC;

-- 28
SELECT a.deptid, a.name, a.hiredate FROM employee a LEFT JOIN employee b ON a.deptid = b.deptid AND a.hiredate < b.hiredate WHERE b.deptid IS NULL ORDER BY a.hiredate;

-- 29
SELECT * FROM employee WHERE year(hiredate) = 1981;

-- 30
SELECT name, temp_table.deptid, junior_count, senior_count FROM department RIGHT JOIN (
SELECT junior_count_table.deptid, junior_count, COALESCE(senior_count, 0) AS senior_count FROM ((
SELECT deptid, COUNT(*) AS junior_count FROM 
(SELECT * FROM employee WHERE hiredate > STR_TO_DATE('1-5-1981','%d-%m-%Y')) AS all_junior 
GROUP BY deptid) junior_count_table
LEFT JOIN (
SELECT deptid, COUNT(*) AS senior_count FROM 
(SELECT * FROM employee WHERE hiredate <= STR_TO_DATE('1-5-1981','%d-%m-%Y')) AS all_senior
GROUP BY deptid) senior_count_table 
ON junior_count_table.deptid = senior_count_table.deptid)
UNION
SELECT senior_count_table.deptid, COALESCE(junior_count, 0) AS junior_count, senior_count FROM ((
SELECT deptid, COUNT(*) AS junior_count FROM 
(SELECT * FROM employee WHERE hiredate > STR_TO_DATE('1-5-1981','%d-%m-%Y')) AS all_junior 
GROUP BY deptid) junior_count_table
RIGHT JOIN (
SELECT deptid, COUNT(*) AS senior_count FROM 
(SELECT * FROM employee WHERE hiredate <= STR_TO_DATE('1-5-1981','%d-%m-%Y')) AS all_senior
GROUP BY deptid) senior_count_table 
ON junior_count_table.deptid = senior_count_table.deptid)
) AS temp_table ON department.deptid = temp_table.deptid;

-- 30 w/o departments with no name
SELECT junior_count_table.deptid, junior_count, COALESCE(senior_count, 0) AS senior_count FROM ((
SELECT deptid, COUNT(*) AS junior_count FROM 
(SELECT * FROM employee WHERE hiredate > STR_TO_DATE('1-5-1981','%d-%m-%Y')) AS all_junior 
GROUP BY deptid) junior_count_table
LEFT JOIN (
SELECT deptid, COUNT(*) AS senior_count FROM 
(SELECT * FROM employee WHERE hiredate <= STR_TO_DATE('1-5-1981','%d-%m-%Y')) AS all_senior
GROUP BY deptid) senior_count_table 
ON junior_count_table.deptid = senior_count_table.deptid)
UNION
SELECT senior_count_table.deptid, COALESCE(junior_count, 0) AS junior_count, senior_count FROM ((
SELECT deptid, COUNT(*) AS junior_count FROM 
(SELECT * FROM employee WHERE hiredate > STR_TO_DATE('1-5-1981','%d-%m-%Y')) AS all_junior 
GROUP BY deptid) junior_count_table
RIGHT JOIN (
SELECT deptid, COUNT(*) AS senior_count FROM 
(SELECT * FROM employee WHERE hiredate <= STR_TO_DATE('1-5-1981','%d-%m-%Y')) AS all_senior
GROUP BY deptid) senior_count_table 
ON junior_count_table.deptid = senior_count_table.deptid);

