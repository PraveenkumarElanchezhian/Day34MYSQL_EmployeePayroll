use payroll_service;
ALTER TABLE employee_payroll ADD EmpPhone int not null, add address varchar(100) default 'TamilNadu' , add department varchar(20) not null;
select * from employee_payroll