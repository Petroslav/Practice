package Notepad_v2;

public class Page {

	private String headline = null;
	private String content;
	
	
	
	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public void write(String text){
		if(this.content == null) this.content = text;
		else{
			this.content += "\n";
			this.content += text;
		}
	}
	
	public void clearPage(){
		this.content = null;
	}
	
	public void viewPage(){
		System.out.println("=== " + this.headline + " ===");
		System.out.println();
		System.out.println(this.content);
		System.out.println();
		System.out.println();
	}
	
	public boolean searchWord(String word){
		if(this.content.contains(word)) return true;
		else return false;
	}
	
	public boolean containsDigits(){
		for (int i = 0; i < this.content.length(); i++) {
			if(this.content == null) return false;
			if(Character.isDigit(this.content.charAt(i))) return true;
		}
		return false;
	}
}
