package reading_material;

public class Magazine extends ReadingMaterial implements Comparable<Magazine>{

	private String category;
	private int issue;

	public Magazine(String name, String publisher, int issue, String category) {
		super(name, publisher, 0, 0);
		this.category = category;
		this.issue = issue;
	}

	@Override
	public int compareTo(Magazine o) {
		if(this.category.compareTo(o.category) == 0){
			if(this.getName().compareTo(o.getName()) == 0){
				return this.issue - o.issue;
			}
			else return this.getName().compareTo(o.getName());
		}
		return this.category.compareTo(o.category);
	}
	
	@Override
	public String toString() {
		return getName() + " - issue " + issue;
	}
	
	public String getCategory() {
		return category;
	}
	
}
