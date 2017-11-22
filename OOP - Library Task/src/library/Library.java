package library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import exceptions.CannotBeLentException;
import reading_material.*;

public class Library {
	public static final int INTEREST = 1; //percent
	private String name;
	private ArrayList<ReadingMaterial> inventory;
	private ConcurrentHashMap<String, Book> books;
	private ConcurrentHashMap<String, Magazine> magazines;
	private ConcurrentHashMap<String, StudyBook> studyBooks;
	private ConcurrentHashMap<String, ReadingMaterial> checkedOutBooks;
	private ConcurrentHashMap<String, Double> taxes;
	private ConcurrentHashMap<String, Thread> checkers;
	
	public Library(String name){
		this.name = name;
		this.inventory = new ArrayList<>();
		this.books = new ConcurrentHashMap<>();
		this.magazines = new ConcurrentHashMap<>();
		this.studyBooks = new ConcurrentHashMap<>();
		this.checkedOutBooks = new ConcurrentHashMap<>();
		this.taxes = new ConcurrentHashMap<>();
	}
	
	public void increaseTax(String name, double rent) {
		this.taxes.put(name, rent);	
	}
	
	public void addNewBook(String name, String author, String genre, String publisher){
		Book book = new Book(name, author, genre, publisher);
		this.books.put(book.getName(), book);
		this.inventory.add(book);
	}
	
	public void addNewMagazine(String name, String publisher, int issue, String category){
		Magazine magazine = new Magazine(name, publisher, issue, category);
		this.magazines.put(magazine.getName(), magazine);
		this.inventory.add(magazine);
	}
	
	public void addNewStudyBook(String name, String author, String theme, String publisher){
		StudyBook sbook = new StudyBook(name, author, publisher, theme);
		studyBooks.put(sbook.getName(), sbook);
		this.inventory.add(sbook);
	}

	public synchronized ReadingMaterial rentBook() throws CannotBeLentException {
		ReadingMaterial book = this.inventory.get(new Random().nextInt(this.inventory.size()));
		if(book instanceof Magazine) throw new CannotBeLentException();
		book.CheckOut();
		if(book instanceof Book) this.books.remove(book.getName());
		else this.studyBooks.remove(book.getName());
		this.inventory.remove(book);
		this.taxes.put(book.getName(), book.RENT_TAX);
		this.checkedOutBooks.put(book.getName(), book);
		Thread checker = new LentBookChecker(book, this);
		checker.start();
		this.checkers.put(name, checker);
		return book;
	}

	public synchronized void returnBook(ReadingMaterial rented) {
		rented.Return();
		Thread check = this.checkers.get(rented.getName());
		check.interrupt();
		if(rented instanceof Book) this.books.put(rented.getName(), (Book) rented);
		else this.studyBooks.put(rented.getName(), (StudyBook) rented);
		this.inventory.add(rented);
		this.checkedOutBooks.remove(rented.getName());
	}
	
	public void revision(){
		System.out.println("The library currently has " + this.inventory.size() + " reading materials ready for rent");
		//generate file 10 points
		//generate file 10 points
	}
	
	public void printMagazines(){
		String categ = null;
		String tempCateg = null;
		for(Magazine mag : this.magazines.values()){
			tempCateg = mag.getCategory();
			if(tempCateg != categ){
				categ = tempCateg;
				System.out.println(categ + ": ");
			}
			System.out.println(mag);
		}
	}

}
