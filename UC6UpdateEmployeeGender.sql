use payroll_service;
ALTER TABLE employee_payroll ADD Gender varchar(5) not null AFTER Name ;
ALTER TABLE employee_payroll MODIFY Gender varchar(6) not null;
update employee_payroll set Gender = 'Male' where Gender is null;
insert into employee_payroll (Name,Salary,StartDate) values ('Aruna',45000.0,'2021-09-19');
insert into employee_payroll (Name,Salary,StartDate) values ('Kavi',55000.0,'2021-09-19');
update employee_payroll set Gender = 'Female' where name = 'Aruna' or name = 'Kavi';
update employee_payroll set Salary = 45000.0  where name = 'Aruna' ;
update employee_payroll set Salary = 55000.0  where name = 'Kavi' 
