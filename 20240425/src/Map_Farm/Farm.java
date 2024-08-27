package Map_Farm;

public class Farm {
	private String kind;
	
	public Farm(){
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	@Override
	public String toString() {
		return kind + ": ";
	}
}

class Fruit extends Farm{
	private String name;
	
	Fruit(){
	}

	public Fruit(String kind, String name) {
		super();
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
		return super.toString() + name;
	}
}

class Vegetable extends Farm{
	private String name;
	
	Vegetable(){
	}

	public Vegetable(String kind, String name) {
		super();
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
		return super.toString() + name;
	}
}

class Nut extends Farm{
	private String name;
	
	Nut(){
	}

	public Nut(String kind, String name) {
		super();
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
		return super.toString() + name;
	}
}