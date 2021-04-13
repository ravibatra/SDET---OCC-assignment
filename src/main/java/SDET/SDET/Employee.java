package SDET.SDET;

class Employee {
		int Salary;
		String Fname,Lname, address,age;

		// Constructor
		public Employee(String Fname, String Lname,String address, String age,int Salary)
		{
			this.Fname = Fname;
			this.Lname = Lname;
			this.address = address;
			this.age = age;
			this.Salary = Salary;
		}

		// Used to print Employee details in main()
		public String toString()
		{
			return this.Fname + ","
				+ this.Lname+ ","+ this.address + ","
						+ this.age + ","+this.Salary;
		}
	}
