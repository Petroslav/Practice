package reading_material;

public class StudyBook extends ReadingMaterial implements Comparable<StudyBook>{
	public static final int RENT_TAX = 3;
	public static final int CHECKOUT_LENGTH = 150; //seconds

	private String author;
	private String theme;

	public StudyBook(String name, String author, String publisher, String theme) {
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
	public int compareTo(StudyBook o) {
		if(theme.compareTo(o.theme) == 0) return this.getName().compareTo(o.getName());
		return theme.compareTo(o.theme);
	}
	
}
