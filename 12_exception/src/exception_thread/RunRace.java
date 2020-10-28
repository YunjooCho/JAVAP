package exception_thread;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RunRace extends Frame implements ActionListener{ //Racer가 스레드가 됨
	//1.필드 선언
	private Button btn; //출발버튼
	private int count;  //말 마리 수
	private Racer[] r;  //말 마리 수만큼의 객체 생성
	
	//-.생성자(기본생성자)
	public RunRace () {
		
	}
	
	
	//2.생성자(문자열을 파라미터로 하는 생성자) - 프레임, 버튼, 마리수, 배열, 사진을 올릴 패널
	public RunRace(String[] args) { //String[] args는 Run Configuration으로 값을 받음
		//4.생성
		btn = new Button("출발");
		count = Integer.parseInt(args[0]);
		r = new Racer[count]; //캔버스클래스 - 1.배열생성
		
		//7.사진을 올릴 패널을 추가
		Panel p = new Panel(new FlowLayout(FlowLayout.RIGHT)); 
		//Panel의 Layout : FlowLayout
		//FlowLayout의 기본은 Center이지만, Right로 변환하여 버튼의 위치를 옮김
		p.add(btn);
		
		for(int i = 0; i < count; i++) {
			r[i] = new Racer(args[i+1]); //2.클래스 생성
			add("Center",r[i]); //밑에 겹쳐서 보이지 않음
		}
		//5.버튼 올리기
		add("South",p);
//		add("Center",r);
//		add("Center", r[0]); //실제로 가운데 츨력되지 않는 이유는 이미지 크기가 작기 때문에 FlowLayout과 다르게 센터중심이 아닌가봄
//		add("Center", r[1]);
//		add("Center", r[2]);
		
		
		//3.패널에 해당 객체를 추가하여 프레임에 출력
		Panel p2  = new Panel(new GridLayout(count,1)); //프레임은 하나 이상 올라가지 않아 Panel에 넣어서 출력함
		for(int i = 0; i < count; i++) {
			p2.add(r[i]);
			
		}
		add("Center", p2);
		
		//3. 프레임 창 생성 - 말 생성후 밑에 내려오는게 좋음
		setBounds(700,300,600,400);
		setVisible(true);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//이벤트
		btn.addActionListener(this);
		
	}
	
	public int getCount() {
		return count;
	}

	//오버라이드
	@Override
	public void actionPerformed(ActionEvent e) {
		 //버튼 비활성화
		 btn.setEnabled(false);
		 
		 //배열 생성 
		 Thread[] t = new Thread[count];
		 //스레드 생성
		 for(int i = 0; i < count; i++) {
			 t[i] = new Thread(r[i]); //racer를 스레드로 만들고 싶은 것
			 t[i].setPriority((int)(Math.random()*10+1)); //우선순위 - 어떤 말 객체가 먼저 출발할지 모름
			 //스레드 시작 - 스레드 실행(운영체제) - run()
			 t[i].start();
		 }//for
	}

	public static void main(String[] args) {
		//String[] args를 통해 말의 마리수와 각 말의 이름을 입력함
		if(args.length < 2) { //매개변수의 갯수 //★2가 어디서 나온 숫자인지 다시 정리
			System.out.println("Usage : java RunRace count name1, ..."); // 사용법 : 말의 마리수와 이름 입력
			 															 // Run Configuration 사용
			System.exit(0);//형식이 틀리면(입력값(매개값)이 제대로 입력되지 않은 경우, 강제 종료)
		}
		
		if(Integer.parseInt(args[0]) != args.length -1) { //args.length - 1 하는 이유 : 매개값이 마리수 + 애들 이름으로 마리수항목 때문에 말 수보다 1개 더 있음
			System.out.println("말 마리수와 이름의 개수가 맞지 않습니다.");
			System.exit(0);
		}
		
		new RunRace(args);
	}
}
