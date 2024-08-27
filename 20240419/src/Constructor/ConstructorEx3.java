//// 미완성
//package Constructor;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
///*
// * 접근 제어자
// * → 사용자가 알 필요없는 정보는 사용자로부터 숨겨야 한다 (ex. 패스워드 등)
// * 
// * private (비공개)
// * → 같은 클래스(선언한 클래스)에서만 사용 가능
// * → 외부 클래스 사용 불가
// * 
// */
//class MemberT {
//	private String id;
//	private String name;
//	private String password;
//	private String email;
//	private char gender;
//	private int age;
//
//	MemberT() {
//
//	}
//
//	MemberT(String i, String n, String p, String e, char g, int a) {
//		id = i;
//		name = n;
//		password = p;
//		email = e;
//		gender = g;
//		age = a;
//	}
//
//	String toStr() {
//		return String.format("%s %s %s %s %s %d", id, name, password, email, gender, age);
//	}
//
//	// setter & getter 생성
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public char getGender() {
//		return gender;
//	}
//
//	public void setGender(char gender) {
//		this.gender = gender;
//	}
//
//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}
//
//	// inform - MemberT 클래스의 모든 필드 값들을 합쳐 반환
//	@Override
//	public String toString() {
//		return id + " " + name + " " + password + " " + email + " " + gender + " " + age;
//	}
//
//}
//
//class MemberMenu {
//	MemberMenu() {
//
//	}
//
//}
//
//public class ConstructorEx3 {
//	// 함수 밖에 선언하여 클래스 내의 모든 함수가 이용할 수 있도록 Scanner 선언
//	public static Scanner sc = new Scanner(System.in);
//	public static int count = 10;
//
//	public static int menu(int count) {
//		System.out.println("최대 등록 가능한 회원 수는 10명입니다.");
//		System.out.println("현재 등록된 회원 수는 " + count + "명 입니다.");
//		System.out.println("1. 새 회원 등록");
//		System.out.println("2. 회원 검색");
//		System.out.println("3. 회원 정보 수정");
//		System.out.println("4. 회원 삭제");
//		System.out.println("5. 모두 출력");
//		System.out.println("9. 끝내기");
//		System.out.print("메뉴 번호: ");
//		int menu = sc.nextInt();
//
//		return menu;
//	}
//
//	public static String duplicationId(MemberT[] memberList) {
//		System.out.print("아이디 : ");
//		String id = sc.nextLine();
//
//		boolean check = false; // 삼항 연산자 이용해서 고민해보기!
//
//		// 중복 검사
//		while (!check) {
//			for (int i = 0; i < count; i++) {
//				if (id.equals(memberList[i].getId())) {
//					System.out.println("중복된 아이디입니다. 아이디를 다시 입력해주세요.");
//					// break;만 쓰면 → while문으로 다시 돌아가게 됨
//					// 아이디를 다시 입력할 수 있도록 if문 안에서 반복할 수 있도록
//					break;
//				} else {
//					check = !check;
//				}
//			}
//		}
//		return id;
//	}
//
//		public static void main(String[] args) {
//
//		MemberT[] memberList = { new MemberT("aaaaa", "박신우", "aa", "aaa@aaa.aaa", 'F', 33),
//				new MemberT("bbbbb", "강고결", "bb", "bbb@bbb.bbb", 'M', 34),
//				new MemberT("ccccc", "남나눔", "cc", "ccc@ccc.ccc", 'M', 28),
//				new MemberT("ddddd", "도대담", "dd", "ddd@ddd.ddd", 'M', 35),
//				new MemberT("eeeee", "류라라", "ee", "eee@eee.eee", 'F', 17),
//				new MemberT("fffff", "문미미", "ff", "fff@fff.fff", 'F', 20),
//				new MemberT("ggggg", "박보배", "gg", "ggg@ggg.ggg", 'M', 26),
//				new MemberT("hhhhh", "송성실", "hh", "hhh@hhh.hhh", 'M', 41),
//				new MemberT("iiiii", "윤예의", "ii", "iii@iii.iii", 'F', 28),
//				new MemberT("jjjjj", "정재주", "jj", "jjj@jjj.jjj", 'M', 23), null, null, null, null };
//
////		System.out.println(Arrays.toString(memberList));
//		while (true) {
//			int menuNum = menu(count);
//
//			// 숫자 입력 받은 후 문자를 입력 받기 전에 버퍼 비워주는 용도
//			sc.nextLine();
//
//			if (menuNum == 1) {
//				duplicationId(memberList);
//
//				System.out.print("이름 : ");
//				String name = sc.nextLine();
//
//				System.out.print("비밀번호 : ");
//				String password = sc.nextLine();
//
//				System.out.print("이메일 : ");
//				String email = sc.nextLine();
//
//				System.out.print("성별(M/F) : ");
//				char gender = sc.nextLine().charAt(0);
//
//				System.out.print("나이 : ");
//				int age = sc.nextInt();
//
//				// MemberT 변수 생성
//				MemberT member = new MemberT(id, name, password, email, gender, age);
//
//				// 배열 생성 후 저장
//				memberList[count] = member;
//				System.out.println("정상적으로 추가되었습니다.");
//				count++;
//
//			} else if (menuNum == 2) {
//				System.out.println("1. 아이디로 검색하기");
//				System.out.println("2. 이름으로 검색하기");
//				System.out.println("3. 이메일로 검색하기");
//				System.out.println("9. 메인으로");
//				System.out.print("메뉴: ");
//				int sel = sc.nextInt();
//
//				sc.nextLine();
//
//				if (sel == 1) {
//					System.out.print("아이디: ");
//					String findId = sc.nextLine();
//
//					boolean check = false;
//					for (int i = 0; i < count; i++) {
//						// 객체 배열의 아이디
//						String member = memberList[i].getId();
//
//						if (member.equals(findId)) {
//							System.out.println(memberList[i].toStr());
//							break;
//						}
//					}
//					if (check) {
//						System.out.println("검색한 아이디를 찾을 수 없습니다.");
//					}
//
//				} else if (sel == 2) {
//					System.out.print("이름: ");
//					String findName = sc.nextLine();
//
//					boolean check = false;
//					for (int i = 0; i < count; i++) {
//						// 객체 배열의 아이디
//						String member = memberList[i].getName();
//
//						if (member.equals(findName)) {
//							System.out.println(memberList[i].toStr());
//							break;
//						}
//					}
//					if (check) {
//						System.out.println("검색한 이름을 찾을 수 없습니다.");
//					}
//
//				} else if (sel == 3) {
//					System.out.print("이메일: ");
//					String findEmail = sc.nextLine();
//
//					boolean check = false;
//					for (int i = 0; i < count; i++) {
//						String member = memberList[i].getEmail();
//
//						if (member.equals(findEmail)) {
//							System.out.println(memberList[i].toStr());
//							break;
//						}
//					}
//					if (check) {
//						System.out.println("검색한 이메일을 찾을 수 없습니다.");
//					}
//
//				} else if (sel == 9) {
//					break; // 메인 메뉴로 돌아가기
//				}
//
//			} else if (menuNum == 3) {
//				updateMember(memberList, count);
//			} else if (menuNum == 4) {
//
//			} else if (menuNum == 5) {
//
//			} else if (menuNum == 9) {
//
//			} else {
//				System.out.println("메뉴를 다시 입력해주세요.");
//			}
//
//		}
//
//	}
//
//	public static void updateMember(MemberT[] memberList, int count) {
//
//		System.out.println("1. 비밀번호 수정하기");
//		System.out.println("2. 이름 수정하기");
//		System.out.println("3. 이메일 수정하기");
//		System.out.println("9. 메인으로 돌아가기");
//		System.out.print("메뉴: ");
//		int sel = sc.nextInt();
//
//		sc.nextLine();
//		if (sel == 1) {
//			// id와 pw를 입력 받은 값이 배열에 저장 되어있다면 수정할 pw로 입력받기
//			System.out.print("저장된 아이디 : ");
//			String id = sc.nextLine();
//			System.out.print("저장된 비밀번호 : ");
//			String password = sc.nextLine();
//
//			for (int i = 0; i < count; i++) {
//				String findId = memberList[i].getId();
//				String findPassword = memberList[i].getPassword(); // MemberT 클래스의 객체의 password를 찾기 위해 getter를 이용한 것!
//
//				if (findId.equals(id) && findPassword.equals(password)) {
//					System.out.print("수정할 비밀번호 : ");
//					String newPassword = sc.nextLine();
//
//					memberList[i].setPassword(newPassword); // MemberT 클래스의 객체의 password를 수정하기 위해 setter를 이용한 것!
//				} else {
//					System.out.println("아이디와 비밀번호가 틀렸습니다. 다시 입력해주세요.");
//				}
//			}
//
//		} else if (sel == 2) {
//
//		} else if (sel == 3) {
//
//		} else if (sel == 9) {
//			return; // main 함수가 아니기에 updateMember 함수를 종료하라는 return으로 마무리해야한다
//		}
//
//	}
//
//}
