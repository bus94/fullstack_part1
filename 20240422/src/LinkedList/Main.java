package LinkedList;

class Node {
	// 데이터 + 주소 한꺼번에 저장하는 노드
	int data; // 데이터
	Node next; // 다음 노드를 가리키는 주소 (노드 타입)

	// 생성자
	// new 키워드를 사용하는 것들은 데이터가 없다는 의미로 null
	public Node(int data) {
		this.data = data;
		this.next = null; // 초기화 할 시 다음 데이터가 없기 때문에 null값으로 설정
	}

}

class LinkedList {
	// 자동 초기값은 null
	private Node head;

	// 추가하는 함수
	public void addNode(int data) {
		// 먼저 추가할 노드(객체) 생성
		Node newNode = new Node(data);

		// 연결 리스트가 비어있는 경우
		if (head == null) {
			head = newNode;
			return;
		}
		// 비어있지 않으면 마지막 노드를 찾는다
		// next 값이 null인 객체를 찾는다
		// head는 연결리스트의 시작점이므로 절대로 주소값이 변하면 안된다
		Node current = head;
		
		while (current.next != null) {
			current = current.next;
		}
		// 가장 마지막 노드를 찾았다면(while문에서 current.next가 null이라면)
		current.next = newNode;
		
	}
	
	void printList() {
		Node current = head;
		
		while(current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println("출력완료!");
		System.out.println();
	}
}

public class Main {

	public static void main(String[] args) {
		
		// 배열 (유동적인 배열)
		
		// 리스트
		// 1) 선형 리스트 (배열)
		// 2) 연결 리스트 (각각의 객체들을 주소값을 이용하여 연결하는 것/배열과는 다른 구조/열차칸 연결하듯)
		// - 연결 리스트를 만들기 위해서는 데이터와 주소값을 저장하는 변수가 필요 (변수 Node)
		// 주소(포인터) : 노드끼리 연결할 때 필요한 것
		
		// 연결 리스트 종류
		// 1. 단방향 리스트 : 한 쪽 방향으로만 데이터를 저장하고 검색할 수 있다
		// 2. 양방향 리스트 : 양 쪽 방향으로 검색하고 추가할 수 있도록 사용할 수 있다
		// 3. 양방향 원형 연결 리스트
		
		// 연결 리스트의 시작점 head
		//  head 부분은 데이터를 저장하지 않는다 (연결하는 용도 / 기차에서 기관사가 있는 곳에 데이터 격인 승객이 탑승하진 않는다)
		
		LinkedList list = new LinkedList();
		
		list.addNode(10);
		list.addNode(20);
		list.addNode(30);
		
		// 10 20 30 으로 출력
		list.printList();
		
	}

}
