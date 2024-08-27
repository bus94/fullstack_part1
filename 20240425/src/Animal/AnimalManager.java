package Animal;

public class AnimalManager {
	static Animal[] animalList = new Animal[3];
	

	public static void main(String[] args) {
		animalList[0] = new Dog("망고", "시츄", 3);
		animalList[1] = new Cat("냥냥", "러시안블루", "한국", "검정색");
		animalList[2] = new Dog("앵두", "말티즈", 1);
		for(int i = 0; i < animalList.length; i++) {
			System.out.println(animalList[i].toString());
			((Speak) animalList[i]).speak();
			System.out.println();
		}
	}

	
}
