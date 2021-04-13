package SDET.SDET;

import java.util.Comparator;

class SortSalary implements Comparator<Employee> {
	// Used for sorting in ascending order of
	// salary
	public int compare(Employee a, Employee b)
	{
		return a.Salary - b.Salary;
	}
}