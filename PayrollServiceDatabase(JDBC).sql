create database PayrollService;
show databases;
use PayrollService;
create table Emp_PayrollService(EmpID int auto_increment primary key, employee_name varchar (50), salary double);
insert into Emp_PayrollService (employee_name,salary) values ('Praveen',10000.0);
select * from Emp_PayrollService;
insert into Emp_PayrollService (employee_name,salary) values ('Kumar',20000.0);
insert into Emp_PayrollService (employee_name,salary) values ('Ravi',30000.0);
Alter table Emp_PayrollService add column date date after salary;
update Emp_PayrollService set date = '2021-12-02'where EmpID = 1;
update Emp_PayrollService set date = '2021-10-25'where EmpID = 2;
update Emp_PayrollService set date = '2021-07-07'where EmpID = 3;
insert into Emp_PayrollService (employee_name,salary) values ('Kavi',35000.0);
update Emp_PayrollService set date = '2021-08-07'where EmpID = 5;
update Emp_PayrollService set date = '2021-09-014'where EmpID = 4;
Alter table Emp_PayrollService add column Gender varchar(6) not null after employee_name;
update Emp_PayrollService set Gender = 'Female' where  EmpID = 5;
update Emp_PayrollService set Gender = 'Male' where  EmpID = 1;
update Emp_PayrollService set Gender = 'Male' where  EmpID = 2;
update Emp_PayrollService set Gender = 'Male' where  EmpID = 3;
update Emp_PayrollService set Gender = 'Male' where  EmpID = 4;
Select sum(salary)as sumsalary
,avg(salary),min(salary),max(salary),count(salary) from Emp_PayrollService where Gender = 'Male';