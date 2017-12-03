import java.util.Date;

public class Receipt {

	private int gasLoaded;
	private int type;
	private int column;
	private Date date;
	
	
	
	public Receipt(int gasLoaded, int type, int column, Date date) {
		this.gasLoaded = gasLoaded;
		this.type = type;
		this.column = column;
		this.date = date;
	}

	public int getType() {
		return type;
	}
	
	public int getGasLoaded() {
		return gasLoaded;
	}
	
	public void setGasLoaded(int gasLoaded) {
		this.gasLoaded = gasLoaded;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public void setColumn(int column) {
		this.column = column;
	}
	
	public int getColumn() {
		return column;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receipt other = (Receipt) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		return true;
	}
	
	
}
