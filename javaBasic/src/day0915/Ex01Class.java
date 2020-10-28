package day0915;

public class Ex01Class {
	//java는 3세대 언어이다.
	//3세대 언어는 객체지향적 프로그래밍(Object Oriented Programming)을 목표로 한다.
	//그렇다면 객체지향적 프로그래밍이란 무엇인가?
	//객체는 무엇인가?
	
	//2세대 언어 절차지향적 언어에서는
	//프로그램을 기능의 집합으로 보고
	//그 기능들을 만들어서 우리가 필요할때마다 재사용하는 것을 목표로 하였다.
	
	//3세대 언어 객체지향적 언어에서는
	//프로그램을 기능의 집합이 아니라 작은 프로그램들의 잡합으로 보게 되었다.
	//즉 하나의 커다란 프로그램이
	//작은 프로그램의 변수를 만들어서 그 변수의 내부적으로 발생하는 메시지를 활용하게 ->????????
	//만드는 것이 바로 객체지향적 언어가 된다.
	
	//자바에서는 프로그램을 클래스에 구현한다.
	//클래스의 변수는 우리가 객체라고 부른다.
	
	//즉 여러 클래스를 만들어서
	//하나의 커다란 클래스가 그 클래스의 변수, 즉 객체를 활용하는게 객체지향적 프로그램이란 것이다.
	
	//예를 들어
	//우리가 메인 메소드가 있는 클래스에서
	//문자열을 다룰 때에는 스트링 클래스 변수를 만들어서
	//필요에 따라 해당 스트링 클래스의 메소드를 실행한다든지
	//그런 방법으로 내부적으로 메시지를 만들어서 메인 메소드가 다루게 된다 ->?????????
	
	//즉 객체란 클래스의 변수를 객체라고 하는 것이다.
	//예시 : String string1 = new String();
	//	       여기서 string1은 String 객체가 된다.
	
	//클래스는 필드와 메소드로 이루어져 있다
	//A. 필드(인스턴스 변수)
	//	  필드란, 해당 클래스의 객체들이 가지고 있을 정보의 종류를 규정하게 된다.
	//	  예를 들어, 학생이라는 클래스는 이름. 나이, 국어, 영어, 수학 점수 등의
	//   정보를 가질 수 있도록 우리가 규정하게 된다.
	//   메소드 안이 아닌, 클래스 밑에 직접 들어가 있는 변수
	
	//B. 메소드
	//	  메소드란 해당 클래스의 객체들이 공통적으로 가지고 있는 기능들을 말한다.
	//	  예를 들어, 학생의 평균을 구하는 메소드라면
	//   모든 클래스가 똑같이 돌아가지만, 해당 학생 클래스의 객체가 가지고 있는
	//   국영수 점수에 따라서 결과가 달라지게 된다.
	//   예를 들어서 학생1은 80 81 82 점을 가지고 있고
	//   학생2는 70 71 72를 가지고 있다고 가정하면
	//   학생1과 학생2의 평균을 계산하는 방법은 다를까? -같은 식(방법)으로 계산
	//   다른것은 그 객체들이 어떤 필드값을 가지고 있느냐가 다름
	
	//생성자 
	//   형태 : 예시)public new String() 또는 public new Student(파라미터)
	//   생성자란 해당 클래스의 객체가 초기화될때
	//	  필드의 값을 셋팅하거나 추가적인 작업을 우리가 적어줄 수 있다.
	//	  생성자의 경우 메소드와 같은 형태이지만
	//   리턴타입도 없고 메소드의 이름이 클래스의 이름과 똑같다
	//   만약 우리가 클래스에 생성자를 따로 만들어주지 않으면
	//   자바가 기본적으로 제공해주는 생성자를 사용하게 된다.
	//	  자바가 기본적으로 제공해주는 생성자는
	//   객체의 필드만 초기화 해준다.
	//   만약 필드가 기본형 데이터타입이면 0으로 초기화하고
	//   참조형 데이터타입이면  null로 초기화해준다
	
	//   우리가 생성자를 따로 만들어주게 되면
	//   자바가 기본적으로 제공해주는 기본 생성자는 더이상 사용할 수 없다.
	//   그렇게 때문에 유의해야할 것이 있는데
	//   만약 파라미터가 있는 생성자만 만들어준다면(()안에 값을 넣음?)
	//   더이상 파라미터가 없는 생성자는 호출할 수 없다.
	
	//메소드 오버로딩
	//   변수와는 다르게 메소드는 똑같은 이름을 가진 여러개의 메소드가 존재할 수도 있다.
	//   단 한가지 조건이 붙는데, 똑같은 이름을 갖는다고 하더라도
	//   파라미터는 달라야 한다는 것이다.
	//   이렇게 파라미터가 다른 같은 이름의 메소드를 만들어 주는 것을 우리가
	//   메소드 오버로딩이라고 한다.
	
	//Q1. 오버로딩 왜 해요?
	//    똑같은 역할을 하지만 파라미터가 여러개 들어올 것을 대비하여
	//	    이름을 통일시켜주어 코드의 가독성을 높여주기 위한 방법이다.
	//Q2. 파라미터가 다르다는건 무슨 의미인가요?
	//    파라미터가 다르다는건 ()에 적혀진 파라미터들의 자료형의 순서가 다르다는 의미이다
	//    예시: printInfo(String name, int age, String phone)의 경우
	//   	     자료형의 순서는 String, int, String 이다
	//         이럴 경우, 오버로딩을 할 때 파라미터의 내용이 String, int, String 순이 아니어야만 한다.
	//         printInfo(String name, int age)는 가능
	//	       printInfo(String phone, int age, String address)는 불가능(순서가 String, int, String 이기 때문에)
	//	            그러면 printInfo("a",5,"b")는 무슨 메소드를 호출해야 될까요~
	
	//null이란 무엇인가
	//참조형 데이터타입(String등)의 필드 혹은 변수가
	//주소값은 부여가 되었지만
	//해당 주소에 공간은 초기화 되지 않은 상태이다
	//null인 변수 혹은 필드에는 메소드 호출 등이 불가능하다
	
	// null vs new String()
	// null : 공간이 확보 안됨. 따라서 아무런 작업도 할 수 없음
	// new String(): 스트링 공간이 확보 되었고 메소드 호출 등의 작업이 가능함. 다만 아무런 문자도 들어있지 않은 빈 상태일 뿐
	
	//접근제한자(Access Modifier) - 보라색(예약어), 변수를 만들어 줄 수 없음
	//접근 제한자란 해당 필드 혹은 메소드를 외부 클래스 어디서 접근 가능한지를 지정해준다
	//public > protected > package > private 순으로 범위가 좁아진다.
	//A. public: 퍼블릭은 해당 필드 혹은 메소드를 외부 패키지의 다른 클래스까지도 접근 가능하게 설정한다.
	//B. protected: 프로텍티드는 해당 클래스와 같은 패키지면 다른 클래스들도 접근 가능하다.
	//              만약 다른 패키지라면 그 클래스를 상속받는 클래스들만 접근 가능하다.
	//C. package: 패키지는 해당 클래스와 같은 패키지의 다른 클래스들만 접근 가능하다
	//			   만약 다른 패키지면 모두 접근 할 수 없다.
	//            패지키 접근 제한자는 우리가 아무것도 적어주지 않으면 적용된다.
	//            이미 자바에서 package와 default라는 단어에 다른 기능을 부여해놨기 때문에 (package는 java Project밑에 폴더 같은거, default는 switch에서 사용)
	//            반드시 패키지 접근 제한자를 적용할 때에는 아무런 접근 제한자를 적어주지 않아야 한다.
	//            예)day0914패키지 Ex05DynaminAllocT의 indexOf메소드
	//D. private: 같은 패키지건 다른 패키지건 외부 클래스의 접근은 모두 다 막아버린다.(해당 클래스 내에서만 사용 가능한 메소드, 필드 등에 적용)

	//여기 우리가 가장 많이 사용하는 접근 제한자는 무엇일까요?
	//정답은 private이다.
	
	//데이터의 은닉화 그리고 캡슐화라는 개념때문에 이제 우리는 클래스에서 외부가 정말 써야하는 메소드를 제외하고선
	//모든 필드 그리고 외부가 필요로 하지 않는 메소드들은 모두다 private으로 지정한다.
	//하지만 필드가 private으로 되어있으면 더이상 다른 클래스에서 그 필드에 값을 초기화하거나 호출할 수 없다.
	//그래서 우리는 메소드를 통해서 값을 저장하고 메소드를 통해서 해당 필드의 현재 값을 호출해야 한다.
	//이렇게 메소드를 이용해서 값을 저장하고 호출하는 것을 캡슐화라고 한다.
	//필드에 값을 저장하는 메소드를 setter라고 하고
	//셋터 메소드는 다음과 같은 양식을 갖춘다.◆◆◆◆◆◆◆◆◆◆
	//public void set필드명(필드타입 필드이름){
	//  this.필드명 = 필드명;
	// }
	
	//필드의 현재값을 호출하는 메소드를 getter 라고 하고(자기자신의 정보를 호출, 자기자신의 정보를 쓰면 되는 거기 때문에 필드가 필요없음)
	//getter메소드는 다음과 같은 양식을 갖춘다◆◆◆◆◆◆◆◆◆◆◆
	//public 필드타입 get필드명(){
	//    return 필드명;
	// }
	
	//상속 part 1.
	//상속을 하는 이유 : 부모 클래스의 메소드를 자식 클래스가 다시 입력하지 않고 편하게 쓰려고
	//자바의 모든 클래스(내가 만든 것, 자바가 만든 것, 다른 회사가 만든 것)들의 공통된 부모클래스는 바로 java.lang.Object이다.
	//이 java.lang.Object라는 클래스는
	//자바가 제공해주는 기본 생성자, equals(), toString()등의 메소드들이 선언과 구현되어있다.
	//단, 매우 두리뭉실하게 만들어져 있다.
	
	//예를 들어서 equals()의 경우에는 파라미터로 넘어온 객체가
	//이 equals()메소드를 실행하는 객체와 같은 객체인지 확인하는 메소드인데
	//실제 우리가 원하는 equals()비교는 객체의 필드값 간의 비교여야하지만
	//java.lang.Object는 주소값 비교한다
	//public boolean equals(Object obj){ //equals메소드의 선언과 구현
	//		return this == obj;
	// }
	
	//따라서 우리가 java.lang.Object의 메소드들을 제대로 쓰려면
	//해당 클래스에서 재정의 해주어야 한다.
	
	//이렇게 부모클래스로부터 상속받은 메소드를 자식 클래스가
	//재정의해주는 것을 오버라이딩이라고 한다.
	//단 오버라이딩을 할 때 주의해야 할 점은
	//부모클래스가 선언한 메소드의 선언식을
	//자식 클래스가 똑같이 선언해주어야 한다는 것이다
	
	//System.out.println()에 파라미터로 객체를 넣어주면 어떻게 될까?
	//그러면 System.out.println에 파라미터로 넘어온 객체의 toString()을 실행시킨
	//결과값을 출력한다.
	//toString() : 객체의 필드내용을 스트링으로 바꿔주는 메소드
	
	
	
} 
