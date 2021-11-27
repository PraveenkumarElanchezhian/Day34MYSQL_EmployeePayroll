use payroll_service;
ALTER TABLE employee_payroll Add BasicPay double, Add Deductions double, Add TaxablePay double, add IncomeTax double, add NetPay double;
select * from employee_payroll;