package _13_com.patterns.structural.composite;

public class LeafCircle implements ComponentShape {

	@Override
	public void draw(String fillColor) {
		System.out.println("Drawing Circle with color " + fillColor);
	}

}