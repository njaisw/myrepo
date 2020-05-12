package _13_com.patterns.structural.composite;

public class Triangle implements ComponentShape {

	@Override
	public void draw(String fillColor) {
		System.out.println("Drawing Triangle with color " + fillColor);
	}

}