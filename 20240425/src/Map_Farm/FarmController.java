package Map_Farm;

import java.util.ArrayList;
import java.util.HashMap;

public class FarmController {
	HashMap<Farm, Integer> hMap = new HashMap<Farm, Integer>();
	ArrayList<Farm> list = new ArrayList<>();
	
	public boolean addNewKind(Farm f, Integer amount) { 
		hMap.put(f, amount);
		// int를 Integer 객체 형태로 자동으로 바꿔준다 (이러한 과정: boxing 이라고 한다)
		Integer s = hMap.get(f);
		s += amount;
		// 받은 객체의 s 값을 다시 hMap에게 set해줘야 한다
		hMap.replace(f, s);
		return true;
	}
	
//	public boolean removeKind(Farm f) {
//		
//	}
//	
//	public boolean changeAmount(Farm f, int amount) {
//		
//	}
//	
//	public HashMap<Farm, Integer> printFarm(){
//		
//	}
//	
//	public boolean buyFarm(Farm f) {
//		
//	}
//	
//	public boolean removeFarm(Farm f) {
//		
//	}
//	
//	public ArrayList<Farm> printBuyFarm(){
//		
//	}
	
}

