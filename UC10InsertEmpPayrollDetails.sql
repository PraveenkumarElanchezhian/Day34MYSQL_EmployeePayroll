use payroll_service;
update employee_payroll set BasicPay = 10000,Deductions = 1000, TaxablePay = 500,IncomeTax = 700, NetPay = 13000 where gender = 'Male';
update employee_payroll set BasicPay = 11000,Deductions = 800, TaxablePay = 440,IncomeTax = 50, NetPay = 14000 where gender = 'Female';
select * from employee_payroll;