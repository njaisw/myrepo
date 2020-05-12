package _05_com.patterns.behavioural.chainofresponsibility;

public interface DispenseChain {

	void setNextChain(DispenseChain nextChain);

	void dispense(Currency cur);
}