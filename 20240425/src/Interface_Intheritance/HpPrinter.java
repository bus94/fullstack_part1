package Interface_Intheritance;

public class HpPrinter implements ColorPrinter{

	@Override
	public void printBlack(String fileName) {
		System.out.println("Hp 흑백 출력: " + fileName);
	}

	@Override
	public void printColor(String fileName) {
		System.out.println("Hp 컬러 출력: " + fileName);
	}

}
