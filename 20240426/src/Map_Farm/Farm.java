package Map_Farm;

public class Farm {
	private String kind; // 분류
	
	public Farm(){
	}

	public Farm(String kind) {
		this.kind = kind;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	@Override
	public String toString() {
		return kind;
	}
	
}

class Fruit extends Farm{
	private String name;
	
	public Fruit() {
	}

	public Fruit(String kind, String name) {
		super(kind);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return super.toString() + " " + name;
	}
	
}

class Vegetable extends Farm{
	private String name;
	
	public Vegetable() {
	}

	public Vegetable(String kind, String name) {
		super(kind);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return super.toString() + " " + name;
	}
	
}

class Nut extends Farm{
	private String name;
	
	public Nut() {
	}

	public Nut(String kind, String name) {
		super(kind);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return super.toString() + " " + name;
	}
	
}


