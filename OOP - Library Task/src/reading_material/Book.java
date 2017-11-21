package reading_material;

import java.util.Date;

public class Book extends ReadingMaterial implements Comparable<Book> {
	public static final int RENT_TAX = 2;
	public static final int CHECKOUT_LENGTH = 300; //seconds

	private String author;
	private Date releaseDate;
	private String genre;
	

	public Book(String name, String author, String genre, String publisher) {
		super(name, publisher, CHECKOUT_LENGTH, RENT_TAX);
		this.author = author;
		this.releaseDate = new Date();
		this.genre = genre;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public Date getReleaseDate() {
		return releaseDate;
	}

	@Override
	public int compareTo(Book o) {
		if(genre.compareTo(o.genre) == 0) return releaseDate.compareTo(o.releaseDate);
		return genre.compareTo(o.genre);
	}
}
