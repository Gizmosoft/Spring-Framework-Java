package com.accenture.lkm.looselycoupled;

@SuppressWarnings("unused")
public class UITester {

	public static void main(String[] args) {
		Address address = new Address();
		Employee employee = new Employee(address);
		Address address1 = new Address();
		Employee employee2 = new Employee(address1);
		
	}

}
// code is creating the object and giving it to run time..
// IOC -- runtime should create the objects give to the code...
// Decoupling is the main stuff for which Spring is needed...

// but how to finally get rid of object creation ??
