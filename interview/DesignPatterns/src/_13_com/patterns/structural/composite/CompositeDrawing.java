package _13_com.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeDrawing implements ComponentShape {

	// collection of Shapes
	private List<ComponentShape> shapes = new ArrayList<ComponentShape>();

	@Override
	public void draw(String fillColor) {
		for (ComponentShape sh : shapes) {
			sh.draw(fillColor);
		}
	}

	// adding shape to drawing
	public void add(ComponentShape s) {
		this.shapes.add(s);
	}

	// removing shape from drawing
	public void remove(ComponentShape s) {
		shapes.remove(s);
	}

	// removing all the shapes
	public void clear() {
		System.out.println("Clearing all the shapes from drawing");
		this.shapes.clear();
	}
}