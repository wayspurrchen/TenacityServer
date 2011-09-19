package tenacity.Entity.Mind.Data;

public class Color extends Data {
	public Color(String color) {
		type = "color";
		value = color;
		duplicable = true;
		inheritMemorizable = true;
	}
}
