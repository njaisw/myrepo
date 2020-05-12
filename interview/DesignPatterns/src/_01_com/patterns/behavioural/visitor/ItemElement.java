package _01_com.patterns.behavioural.visitor;

public interface ItemElement {
	
   /*
    * 1: Accept Visitor
    */
	public int accept(ShoppingCartVisitor visitor);

}