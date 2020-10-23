package day0914;
//�迭�� �����Ҵ�
//�츮�� ���ݱ��� �迭�� ����Ҷ�
//�׻� �迭�� ũ�⸦ �����ϰ�
//�ش� ũ��� �ʱ�ȭ�ؼ� �迭�� ����ߴ�.
//�̷��� �̸� ũ�⸦ �����ؼ� �迭�� ����°� �����Ҵ�(static Allocation)�̶�� �Ѵ�.

//�׿� ���� �迭�� ũ�⸦ �߰��ϸ� �þ�� �����ϸ� �پ��� ����� ����
//�����Ҵ�(dynamic Allocation)�̶�� �Ѵ�.

//�ڹٿ��� �츮�� �޼ҵ忡 �Ķ���͸� �Ѱ��ָ�
//�޼ҵ忡�� �ش� �Ķ���ͷ� �Ѿ�� �͵��� �����Ѵٰ� �ϴ���
//���� �Ķ���Ͱ� ȣ��� ���� �ִ� �������� ������ �ʴ´�. ->?????????
//���� ���� Ÿ���� �迭�� ������־�� �Ѵ�.
//�׷��� �޼ҵ忡�� ������ �ϰ� �� �Ķ���͸� �����ؼ�
//������ ������ ����� �־�� �Ѵ�!

public class Ex05DynamicAlloc {
	// �����Ҵ��� ���� �������� �޼ҵ带 ������
	
	//1. �迭�� ���� ũ�⸦ Ȯ���ϴ� size()�޼ҵ�
	static int size(int[] arr) {
		return arr.length;//1���� �迭��
	}
	
	//2. �迭�� ���ο� ��Ҹ� �߰��ϴ� �޼ҵ�
	static int[] add(int[] arr, int element) {
		//�츮�� �Ķ���ͷ� ���� element��
		//arr�� �߰��� ���ε�
		//������ arr�� ���� �� �ڿ� �ٿ��� ���̴�.
		//������ �츮�� arr�� ũ�⸦ ���������� �����ؾ� �ϱ� ������
		//1. arr�� �ӽ� �迭�� �����ϰ�
		//2. ����ũ�� + 1�� ũ��� �ʱ�ȭ�ϰ� ->�߰��� �����Ͱ� �� �迭���� ����
		//3. �ӽ� �迭�� ������ ���� ������ �����ϰ� ->���� �κ��� �ʱ�ȭ�ǹǷ� �ٸ� ���� ����
		//4. �� ������ ��ġ�� element�� �߰��ؼ�
		//5. arr�� return ���־�� �Ѵ�
		
		//�ӽù迭�� ����
		//�ӽù迭�� ũ��� �Ķ���ͷ� �Ѿ�� arr�� ũ��� ����.(���� ������ �����ؼ� �Űܾ��ϹǷ�)
		int size = arr.length;
		
		int[] temp = new int[size];
		
		//�ӽù迭�� ���� arr�� ������ ���ʴ�� ����������
		for(int i = 0; i < arr.length; i++) { //arr.length ��� size�� ����
			temp[i] = arr[i];
		}
		
		//���� �迭�� ���� ũ�� + 1�� �ʱ�ȭ���ش�.
		//new�� ������ ����
		//������ �迭�� �� �ִ� ��� ������
		//�� �������
		//���� arr�� �⺻�� ������Ÿ���� int�� �迭�̱� ������
		//��� �ε����� 0���� �ʱ�ȭ�ȴ�
		
		//���� �迭�� ���� ������ ������ ä ũ�⸦ �ø��� ���ؼ���
		//���� �迭�� ������ �ӽ� �迭�� �����ϰ�
		//ũ�⸦ �ø���
		//�ӽ� �迭�� ������ �ٽ� �����ؿ;� �Ѵ�.
		arr = new int[size+1]; //element�� �߰��ϱ� ���� ���ο� ĭ(?)�� ���� -> ������ �ִ� ������ ����(0���� �ʱ�ȭ)
		
		//���� �迭�� �ӽ� �迭�� ���� ���ʴ�� ����������
		for(int i = 0; i < size; i++) {
			arr[i] = temp[i];
		}
		
		
		//arr�� ���� ������ index�� element�� �ʱ�ȭ������
		//arr�� ó�� �Ķ���ͷ� �Ѿ�ö�
		//���� ������ �ε����� ���� ũ�� -1�̴�.
		//�� size - 1�̴�.
		//������ ������ ũ�Ⱑ 1 �þ���Ƿ�
		//���� ������ �ε����� size�� �ȴ�
		
		//int[] arr = new int[4]
		//�ش� �迭�� ���� ������ index ��ȣ�� ����ΰ�?
		//3
		//���� ũ���?
		//4
		
		//arr�� ũ�⸦ 1�ø���
		//���ο� ũ���?
		//5
		//������ �ε��� ��ȣ?
		//4
		
		arr[size] = element;//size ->�迭�� ���� ������ ĭ(?, ������ ũ�Ⱑ �ƴ� �ε��� ��ȣ�� ��)�� �����͸� �־���
		
		return arr;
	}
	//�Ķ���ͷ� �Ѿ�� �迭(int[]arr)�� �Ķ���ͷ� �Ѿ�� ��(int element)�� �����ϴ� üũ�ϴ� contains�޼ҵ�
	static boolean contains(int[] arr, int element) {
		//for���� �̿��ؼ�
		//arr�� �� �ε�����  element�� ���ؼ� ������ return true�� �Ѵ�.
		for(int i = 0; i < arr.length;i++) {
			if(arr[i] == element) {
				//i��° �ε����� element�� ���� �����Ƿ�
				//return true ���ش�.
				return true; //���⼭ return�� ������ for��,if�� ������� �ٷ� ��������
			}
		}
		
		return false;
	}
	
	
	//�Ķ���ͷ� �Ѿ�� �迭(int[] arr)�� �Ķ���ͷ� �Ѿ�� ��(int element)�� ��� �ε����� �ִ��� Ȯ�����ִ� indexOf�޼ҵ�
	static int indexOf(int[] arr, int element) {
		//���⼭ ����
		//���� element�� arr�� �������� �ʴ´ٸ�
		//�츮�� � ���� �������־�� �ұ�?
		//�ε����� ������ 0���� arrũ�� -1�̱� ������
		//���� ������ �츮�� �������� �ʴ´ٴ� ǥ�ø� ���ֱⰡ �����.
		//���� ���� �����߿� ���� ������ "-1"�� �����ؼ�
		//�ݾ� �迭�� �ش� ������Ʈ�� �������� ������
		//�ε����� -1�� �������ָ� �ȴ�.(int���̹Ƿ� false��� -1����?)
		
		//for���� ������
		//���� i��° �ε��� ���� element�� ������
		//i�� �������ָ� �ȴ�.
		for(int i = 0; i < arr.length;i++) {
			if(arr[i] == element) {
				return i;
			}
		}
		return -1;//�ش� ��(int element)�� �������� ������ �ǹ�
	}//indexOf
	
	
	public static void main(String[] args) {
		int[] arr2 = new int[5];
		arr2[0] = 10;
		System.out.println("arr2.length: " + arr2.length);
		arr2[1] = 20;
		System.out.println("arr2.length: " + arr2.length);
		arr2[2] = 30;
		System.out.println("arr2.length: " + arr2.length);
		
		
		int[] arr =  new int[0];//0���� �ʱ�ȭ
		
		System.out.println("arr�� ����ũ�� : " + size(arr));
		
		arr = add(arr,10);
		System.out.println("arr�� ����ũ�� : " + size(arr));
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		arr = add(arr, 5);
		System.out.println("arr�� ����ũ�� : " + size(arr));
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		arr = add(arr,4);
		System.out.println("arr�� ����ũ�� : " + size(arr));
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		//�츮�� arr�� add �޼ҵ��� ��������� ����ﶧ����
		//arr�� ���� ������ �Ǹ鼭 �þ�� ���� Ȯ�� �� �� �ִ�
		
		//contains �޼ҵ带 ������ �����
		System.out.println("============contains()==============");
		//arr�� 5�� �����մϱ�?
		System.out.println("contains(arr,5): " + contains(arr,5));
		//arr�� 25�� �����մϱ�?
		System.out.println("contains(arr,25): " + contains(arr,25));
		
		System.out.println("============indexOf()==============");
		//arr���� 5�� �ε����� ���Դϱ�?
		System.out.println("indexOf(arr,5): " + indexOf(arr,5));
		//arr���� 25�� �ε����� ���Դϱ�?
		System.out.println("indexOf(arr,25): " + indexOf(arr,25));
		
      arr = add(arr, 5);
      arr = add(arr, 4);
      arr = add(arr, 12);
      arr = add(arr, 51);
      //remove�� arr ���� ���
      System.out.println("remove �� arr ���� ���");
      for(int i = 0; i < arr.length; i++) {
         System.out.printf("arr[%d]: %d\n", i, arr[i]);
      }
      
      //removeByIndex(arr, 0) ����
      System.out.println("removeByIndex(arr, 0) ����");
      arr = removeByIndex(arr, 0);
      for(int i = 0; i < arr.length; i++) {
	         System.out.printf("arr[%d]: %d\n", i, arr[i]);
	      }
      
      //removeByIndex(arr, 5) ����
      System.out.println("removeByIndex(arr, 5) ����");
      arr = removeByIndex(arr, 5);
      for(int i = 0; i < arr.length; i++) {
         System.out.printf("arr[%d]: %d\n", i, arr[i]);
      }
      
      //removeByIndex(arr, 2) ����
      System.out.println("removeByIndex(arr, 2) ����");
      arr = removeByIndex(arr, 2);
      for(int i = 0; i < arr.length; i++) {
         System.out.printf("arr[%d]: %d\n", i, arr[i]);
      }
      
      //removeByIndex(arr, 9999) ����
      System.out.println("removeByIndex(arr, 9999) ����");
      arr = removeByIndex(arr, 9999);
      for(int i = 0; i < arr.length; i++) {
         System.out.printf("arr[%d]: %d\n", i, arr[i]);
      }
      
      //removeByElement()(������ ����) �������� �迭�� �ٽ� ��Ҹ� � �� �߰�����
      arr = add(arr, 281);
      arr = add(arr, 144);
      arr = add(arr, 82);
      System.out.println("add() ����");
      for(int i = 0; i < arr.length; i++) {
    	  System.out.printf("arr[%d]: %d\n", i, arr[i]);
      }
      System.out.println("removeByElement(arr,5) ����");
      arr = removeByElement(arr,5);
      for(int i = 0; i < arr.length; i++) {
    	  System.out.printf("arr[%d]: %d\n", i, arr[i]);
      }
      
      System.out.println("removeByElement(arr, 82) ����");
      arr = removeByElement(arr, 82);
      for(int i = 0; i < arr.length; i++) {
         System.out.printf("arr[%d]: %d\n", i, arr[i]);
      }
      
      System.out.println("removeByElement(arr, 12) ����");
      arr = removeByElement(arr, 12);
      for(int i = 0; i < arr.length; i++) {
         System.out.printf("arr[%d]: %d\n", i, arr[i]);
      }
      
      System.out.println("removeByElement(arr, 123456) ����");
      arr = removeByElement(arr, 123456);
      for(int i = 0; i < arr.length; i++) {
         System.out.printf("arr[%d]: %d\n", i, arr[i]);
      }
   }

      

	
	
	//�迭���� element�� �����ϴ� �޼ҵ� removeByIndex
	//�츮�� �迭�� ���(�迭�ȿ� ����ִ� ������ ��)�� �߰��ϸ� ũ�Ⱑ �þ��
	//�츮�� �迭�� ��Ҹ� �����ϸ�? ũ�Ⱑ �پ���� �Ѵ�!
	
	static int[] removeByIndex(int[] arr, int index) {
		//���� �����ϱ� ���� �ش� �ε�����
		//������ index�������� üũ�Ѵ�
		//���� �Ұ����� �ε������ arr�� �״�� �������ָ� �ȴ�.
		
		//�ε����� ������ ������ ����� ���ΰ�? 0 ~ arr.lenth-1
		if(index < 0 || index >= arr.length) {
			return arr;
		}
		
		//�迭�� ���� �ӽ� ������ temp�� ���������
		//temp�� ũ��� ���ΰ�?
		int[] temp = new int[arr.length];
		
		//�ӽ� �迭�� ���� ���� ��������
		for(int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}
		
		//arr�� ���� �ʱ�ȭ������
		//�̶� arr�� ũ��� ���ΰ�?
		arr = new int[arr.length - 1]; // 1�ε����� 0�϶� ���� �տ� �ִ� �ε����� �����ϰ� ����
		
		//���� �ش� �ε����� �����ϸ�
		//�츮�� 3���� ��쿡 ���δ�.
		//1. �ε����� 0�϶�
		//	 �ε����� 0�̸� �츮�� ���� ���� arr�� temp�� 1������ ������ �������ָ� �ȴ�!
		//	 �� ���� �տ� �ִ� �ε����� �����ϰ� �����ϸ� �ȴ�
		if(index == 0) {
			for(int i = 1; i < temp.length; i++) {
	            //������ ���⼭ �Ѱ��� �����ؾ��� ����
	            //temp�� 1��° ����
	            //arr�� 0��° ĭ�� �ְ�
	            //��ĭ�� ���ܿ;� �Ѵٴ� ���̴�.
	            arr[i-1] = temp[i];
	         }
		 }else if(index == temp.length - 1) {
			//2. �ε����� ���� �������϶�
			//�̶��� temp�� 0������ temp.length - 2������ 
			//arr�� �������ָ� �ȴ�
			//�ε����� -1�̰� �ű⼭ �ش� �ε��� ���� ���ֱ� ���� �� -1�� ��
			for(int i = 0; i < temp.length - 1; i++) {
				arr[i] = temp[i];
			}
			
		}else{
			//3. �ε����� �߰��� ��
			//index�� ��� �� ��� �̶��� �츮�� temp���� 0���� index������ ����
			//�׸��� �ε����� �ǳʶٰ� index �ĺ��� ������ ����
			//�̷��� ������־�� �Ѵ�.
			for(int i = 0; i < temp.length;i++) {
				if(i < index) {
					//0~index�������� ����
					arr[i] = temp[i];
				}else if(i > index){
					//�ε��� �������� ������ ����
					//temp = [0,1,2,3,4,5,6,7] //ũ�� 8
					//index = 3
					//arr = [0,1,2,4,5,6] // ũ�� 7
					arr[i-1] = temp[i];//���� �߻� ����
					//arr[i] = temp[i+1]�� �����߻�
					//ArrayIndexOutOfBoundsException(�迭 �ε����� ������ ���)
					//�����߻� ���� : ���ǽĿ� temp.length��� �Ǿ��־� 7���� ��
					//arr�� [7]�� �������� �����Ƿ� �����߻�
					
					   //<������ �ּ�>
					   //temp = [1,2,3,4,5,6,7]
		               //index = 5
		               //arr = [0,1,2,3,4,6,7]
		               //arr[i] = temp[i+1]; // �̷��� �ۼ��ϰ� �Ǹ�  ArrayIndexOutOfBoundsException - �迭 �ε����� ������ ��� ������ �߻��ϰ� �ȴ�.
		               //�� ������ ���� ���÷�
		               //temp.length�� ũ�Ⱑ 8�϶�
		               //i �� �ִ밪�� 7 �̹Ƿ�
		               //arr[7] = temp[8]�� �ǹǷ�
		               // temp�� ũ�Ⱑ 8�̸� �ε����� 0~7 ���� �����ϱ� ������ temp[8] �� �迭�� �ε��� ������ ��� ���� ��. �׷��� ���� �߻�.
		               // arr[7] ���� ������ ����� 1�ٿ� �������Ƿ� ũ�Ⱑ 7 �̱� ������ �� �� ��� ������ �߻��Ǵ� ���� ������ �Ǵ°���.
				}//i = index�� ���� �ƹ�ó�� ����(arr�迭�� �ű��� ����)
			}
			
		}
		return arr;
	}//removeByIndex
	
	//�Ķ���ͷ� �Ѿ�� element�� �迭���� �����Ͽ� �������ִ� removeByElement()
	static int[] removeByElement(int[] arr, int element) {
		//�� �޼ҵ�� �츮�� ������ �������� �޼ҵ带 ��Ȱ���ϸ� �ſ� ���� ����� �� �� �ִ�.
//		int index = indexOf(arr,element);
//		arr = removeByIndex(arr,index);
//		return arr;
		return removeByIndex(arr, indexOf(arr, element));
	}
}
