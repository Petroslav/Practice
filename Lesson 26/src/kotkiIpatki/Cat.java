package kotkiIpatki;

public class Cat {

	private int mustacheLength;
	private String name;
	private String color;
	private int age;
	
	public Cat(String name, int age, String color, int mustacheLength) {
		this.mustacheLength = mustacheLength;
		this.name = name;
		this.color = color;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Cat [mustacheLength=" + mustacheLength + ", name=" + name + ", color=" + color + ", age=" + age + "]";
	}

	public int getMustacheLength() {
		return mustacheLength;
	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public int getAge() {
		return age;
	}
	
}
