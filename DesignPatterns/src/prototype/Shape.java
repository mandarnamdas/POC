package prototype;

public abstract class Shape implements Cloneable {

	public String type;
	
	abstract public void draw();
	
	public Object clone() {
		Object object = null;
		try {
			// Shallow Copy
			object = super.clone();
			
			// Deep Copy
			// object = new Circle();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return object;		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
