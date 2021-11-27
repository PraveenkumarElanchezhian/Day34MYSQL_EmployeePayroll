use payroll_service;
SELECT * FROM employee_payroll WHERE gender = 'Female' GROUP BY gender;
SELECT SUM(salary),avg(salary),min(salary),max(salary),count(salary),gender FROM employee_payroll GROUP BY gender;

