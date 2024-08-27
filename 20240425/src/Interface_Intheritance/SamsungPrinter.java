package Interface_Intheritance;

public class SamsungPrinter implements Printer{
	
	// 삼성에서 프린터를 만든다
	@Override
	public void printBlack(String fileName) {
		 System.out.println("삼성 흑백 출력: " + fileName);
		
	}
	
}

class ColorPrintSamsung implements ColorPrinter{

	@Override
	public void printBlack(String fileName) {
		System.out.println("삼성 흑백 출력: " + fileName);
	}

	@Override
	public void printColor(String fileName) {
		System.out.println("삼성 컬러 출력: " + fileName);
	}
	
}
