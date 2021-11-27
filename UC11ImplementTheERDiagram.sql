use payroll_service;
create table company (companyID int primary key not null auto_increment, CompanyName varchar(200) not null);
show tables;
create table Department (DepartmentID int primary key auto_increment not null, DepartmentName varchar(200) not null, EmployeeID int null);
create table Employee (EmployeeID int primary key not null, 
EmployeeName varchar(100),
companyID int,
DepartmentID int,
PayrollID int,
CONSTRAINT fk_Company_CompanyID FOREIGN KEY (companyID)  
  REFERENCES company(companyID)  
  ON DELETE CASCADE  
  ON UPDATE CASCADE,  
  CONSTRAINT fk_Company_DepartmentID FOREIGN KEY (DepartmentID)  
  REFERENCES Department(DepartmentID)  
  ON DELETE CASCADE  
  ON UPDATE CASCADE,  
  CONSTRAINT fk_Company_PayrollID FOREIGN KEY (PayrollID)  
  REFERENCES employee_payroll(ID)  
  ON DELETE CASCADE  
  ON UPDATE CASCADE 
)
select * from Employee
