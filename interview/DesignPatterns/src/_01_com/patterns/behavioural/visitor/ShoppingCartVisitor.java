package _01_com.patterns.behavioural.visitor;

public interface ShoppingCartVisitor {

	int visit(Book book);

	int visit(Fruit fruit);
}