use payroll_service;
insert into company(CompanyName) values ('Bridge');
insert into company(CompanyName) values ('Labz');
insert into company(CompanyName) values ('BridgeLabz');
select * from company;
insert into Department(DepartmentName) values ('Developer');
insert into Department(DepartmentName) values ('Tester');
insert into Department(DepartmentName) values ('AutomationTester');
select * from Department;
select * from employee_payroll;
DELETE FROM employee_payroll WHERE Id=2;
ALTER TABLE Employee CHANGE EmployeeID EmployeeID INT AUTO_INCREMENT ;
insert into Employee (EmployeeName,companyID,DepartmentID,PayrollID) values ('praveen',3,1,1);
insert into Employee (EmployeeName,companyID,DepartmentID,PayrollID) values ('Aruna',2,2,5);
insert into Employee (EmployeeName,companyID,DepartmentID,PayrollID) values ('Arjuna',1,3,3);
select * from Employee;
select * from employee_payroll inner join  Employee on employee_payroll.Id = Employee.EmployeeID where EmployeeName = 'Aruna';
select SUM(salary),avg(salary),min(salary),max(salary),count(salary) from employee_payroll inner join  Employee on employee_payroll.Id = Employee.EmployeeID;

