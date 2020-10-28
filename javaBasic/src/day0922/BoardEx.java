package day0922;

import java.io.IOException;

import viewer.UserViewer;

public class BoardEx {//메인메소드 실행을 위해서만 사용
	public static void main(String[] args) throws IOException {
		
		UserViewer userViewer = new UserViewer();
		userViewer.index(); //▶예전 showMene와 유사, 홈페이지 전제 출력(예) 로그인 -> 메인메뉴 출력
		
	}
}
