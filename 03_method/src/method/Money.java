package method;


/*
  금액(money)이 5679원일때 다음과 같이 출력하시오
  (/, % 연산자로 풀기)
 
 [실행결과]
  금액 : 5679원
  천원 : 5장
  백원 : 6개
  십원 : 7개
  일원 : 9개
 */
public class Money {

	public static void main(String[] args) {
      int money = 5679;
      
      System.out.println("[실행결과]");
      System.out.println("금액 : " + money + "원");
      System.out.println("천원 : " + (money / 1000) + "장");
      System.out.println("백원 : " + (money % 1000 / 100) + "개");
      System.out.println("십원 : " + (money % 1000 % 100 / 10) + "개");
      System.out.println("일원 : " + (money % 1000 % 100 % 10) + "개");
      
      //<다른풀이>
      //int thousand = money / 1000;
      //int thousand_mod = money % 1000;
      //int hundred = thousand_mod / 100;
      //int hundred_mod = thousand_mod % 100;
      //int ten = hundred_mod / 10;
      //int one = hundred_mod % 10;
      
      //System.out.println("금액 : " + money + "원");
      //System.out.println("천원 : " + thousand + "장");
      //System.out.println("백원 : " + hundred + "개");
      //System.out.println("십원 : " + ten + "개");
      //System.out.println("일원 : " + one + "개");
      
      

	}

}
