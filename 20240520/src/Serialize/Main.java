package Serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception{

		/*
		 * 직렬화(Serialize) - 자바 언어에서 사용되는 Object, Data를 다른 컴퓨터에서 사용할 수 있도록 바이트스트림 형태로
		 * 연속적인 데이터를 변환하는 것 - 직렬화를 이용해서 응용하면 휘발성이 있는 캐싱 데이터를 영구적으로 저장이 필요할 때 사용
		 * 
		 * JSON - map 과 비슷하지만 모든 타입이 문자로 사용된다.
		 * 
		 */

		Signton singleton1 = Signton.getInstance();
		String name = "signton.obj";
		String name2 = "signton.ser";

		/*
		 * ObjectOutputStream 객체 객체가 직렬화 될 때 오직 객체의 인스턴스 필드값만 저장한다. static 필드나 메서드는 직렬화
		 * 하지 않는다.
		 * 
		 */

		// 직렬화할 고객 객체
		Customer customer = new Customer(1, "익준", "1234", 30);

		// 파일명 작성
		String fileName = "Customer.ser";

		// 파일스트림 객체를 생성
		// try with resource
		// - 자동으로 파일 생성 후 닫기 가능

		try (
				FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream out = new ObjectOutputStream(fos); // 파일이 나가는 것에 있어 보조 역할
		) {
			// 직렬화 가능 객체를 바이트 스트림으로 변환하고 파일에 저장
			out.writeObject(customer);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 역직렬화
		// 스트림으로부터 객체를 입력(읽기)
		
		try (
				FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream in = new ObjectInputStream(fis); 
		) {
			// 바이트 스트림을 다시 자바 객체로 변환
			// 이때 중요한 것 
			Customer deser = (Customer)in.readObject();
			System.out.println("역직렬화: " + deser);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 직렬화할 객체가 여러 개라면?
		Customer customer1 = new Customer(1, "익준", "1234", 30);
		Customer customer2 = new Customer(2, "준환", "1111", 30);
		Customer customer3 = new Customer(3, "석형", "2222", 30);
		
		// 리스트 생성
		List<Customer> cutlist = new ArrayList<Customer>();
		
		cutlist.add(customer1);
		cutlist.add(customer2);
		cutlist.add(customer3);
		
		// 리스트 자체로 객체 직렬화 가능하다.
		// 직렬화 할 때는 문제가 없지만 역 직렬화를 할 때는 순서와 일치해야된다.
		fileName = "object2.obj";
		FileOutputStream fos2 = new FileOutputStream(fileName);
		ObjectOutputStream out2 = new ObjectOutputStream(fos2);
		
		out2.writeObject(cutlist);
		out2.close();
		
		FileInputStream fis2 = new FileInputStream(fileName);
		ObjectInputStream in2 = new ObjectInputStream(fis2);
		
		List<Customer> deserList = (List<Customer>) in2.readObject();
		System.out.println(deserList);
		
	}

}
