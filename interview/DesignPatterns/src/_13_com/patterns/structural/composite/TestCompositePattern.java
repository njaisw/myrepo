package _13_com.patterns.structural.composite;
public class TestCompositePattern {

	public static void main(String[] args) {
		ComponentShape tri = new Triangle();
		ComponentShape tri1 = new Triangle();
		ComponentShape cir = new LeafCircle();
		
		CompositeDrawing drawing = new CompositeDrawing();
		drawing.add(tri1);
		drawing.add(tri1);
		drawing.add(cir);
		
		drawing.draw("Red");
		
		drawing.clear();
		
		drawing.add(tri);
		drawing.add(cir);
		drawing.draw("Green");
	}

}