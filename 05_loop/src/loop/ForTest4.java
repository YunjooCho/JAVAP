package loop;

public class ForTest4 {

	public static void main(String[] args) {
		//µÅÁöÀú±İÅë
		int sum = 0; //ÇÕ
		int mul = 1; //°ö
		
		for(int i = 1; i <= 10; i++) {
			
			sum += i;//sum = sum + i;
			mul *= i;//mul = mul * i;
			System.out.println(i + "\t" + sum + "\t" + mul);
			
			
			
		}//for

	}

}
