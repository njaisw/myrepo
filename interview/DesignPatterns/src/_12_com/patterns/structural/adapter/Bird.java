package _12_com.patterns.structural.adapter;
// Java implementation of Adapter pattern 

interface Bird {
	// birds implement Bird interface that allows
	// them to fly and make sounds adaptee interface
	public void fly();

	public void makeSound();
}
