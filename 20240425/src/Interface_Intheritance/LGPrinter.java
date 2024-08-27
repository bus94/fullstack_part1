package Interface_Intheritance;

public class LGPrinter implements Printer{

	@Override
	public void printBlack(String fileName) {
		System.out.println("LG 흑백 출력: " + fileName);
	}
	
}

class ColorPrintLG implements ColorPrinter{

	@Override
	public void printBlack(String fileName) {
		System.out.println("LG 흑백 출력: " + fileName);
	}

	@Override
	public void printColor(String fileName) {
		System.out.println("LG 컬러 출력: " + fileName);
	}
	
}
