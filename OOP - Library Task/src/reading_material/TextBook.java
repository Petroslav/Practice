package reading_material;

public class TextBook extends ReadingMaterial implements Comparable<TextBook>{
	public static final int RENT_TAX = 3;
	public static final int CHECKOUT_LENGTH = 150; //seconds

	private String author;
	private String theme;

	public TextBook(String name, String author, String publisher, String theme) {
		super(name, publisher, CHECKOUT_LENGTH, RENT_TAX);
		this.author = author;
		this.theme = theme;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getTheme() {
		return theme;
	}

	@Override
	public int compareTo(TextBook o) {
		if(theme.compareTo(o.theme) == 0) return this.getName().compareTo(o.getName());
		return theme.compareTo(o.theme);
	}
	
}
