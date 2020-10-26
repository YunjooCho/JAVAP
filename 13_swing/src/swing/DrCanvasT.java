package swing;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


//���찳 ��� ������

public class DrCanvasT extends Canvas { //�׸��� �׸� ȭ���� ĵ������ ������ �־����(ĵ������ ������ ���� �� ��������)
										//������ ���� �� ����(�������� ��� �Ұ�) - JPanel�� �������� ->�������� �ʿ�

	private MsPaintT mp;
	private ShapeDTO dto;
	private Image bufferImage;
	private Graphics bufferG; //paint()�� �׸��� �Ű����� g�� ����ϸ� ������ update()�� �׸��Ƿ� ���ο� �ʵ带 ����,
	                          //�ش� �ʵ�� �׸��� �׸�
	
	
	
	public DrCanvasT(MsPaintT mp) {
		this.mp = mp; //MsPaintT�� ���� �Ѱܹ��� ��ü�� ��������(�ּҰ�)�� �� �ʵ忡 �����ϱ�
		this.setBackground(new Color(200,200,255));
		
		//�̺�Ʈ(keyListener) - escŰ�� ������ �����(Mspaint���� �ȸ���)
		addKeyListener(new KeyAdapter() {
	         @Override
	         public void keyPressed(KeyEvent e) {

	            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
	               System.exit(0);
	            }
	         }
	      });
	}
	
	@Override
		public void update(Graphics g) {//paint()ȣ��  : paint()�� �ִ� ������ update�� �Űܿ�
		
		//Image bufferImage //�̹�����ü ������ �׸��� �׸� ����
		//Graphics bufferG  //�޼ҵ� �Ű���(Graphics g)�� update()�޼ҵ� �����̹Ƿ� ������ �� �� ����
		//����ȭ���� ũ��� ĵ������ ũ��� ���ƾ� ��(���� �ٿ��� �ϱ� ����)
		Dimension d = this.getSize(); //Dimension(Ŭ����?) : �簢���� ������ ��� ���� - ĵ������ ũ�⸸ŭ ���۸� ����
		if(bufferG == null) {//���� �� ������ ������ ����ؼ� Image��ü�� �����Ͽ� ������ ���� �����
							 //�ܻ��� ����
			bufferImage = createImage(d.width,d.height);
			bufferG = bufferImage.getGraphics(); //���⿡ �׸��� �׸�
		}
		
		
		//����� - �ܻ� ���ֱ�
		//���� ĵ������ �������� ������
		Color c = this.getBackground(); //������ ���콺 ������  ���� �������
										//���ﶧ�� �� ���� ������ ���� ������ �������
		bufferG.setColor(c);
		bufferG.fillRect(0, 0, d.width, d.height);
		
		
		
		
		int x1, y1, x2, y2, z1, z2;
		//�۾� �ǵ�����
		//��ǥ(6��)�� ���ÿɼ�(ä���, ����, ����)�� ���� ������ ������ �־�� �� - Ŭ������ �����(ShapeDTO)->��̸���Ʈ�� ����
		//��̸���Ʈ ���� ������ �ϳ��� ������ �ٽ� �׷��ش�(����)
		
		//<������ Ǯ��>
		for(ShapeDTO dto : mp.getList()) {
			//DTO�� ��ǥ�� ������
			x1 = dto.getX1();
			y1 = dto.getY1();
			x2 = dto.getX2();
			y2 = dto.getY2();
			z1 = dto.getZ1();
			z2 = dto.getZ2();
			
			//DTO�� ��
			switch(dto.getColor()) {//index�� ��������, getSelectedItem -> ����� ���ڿ��� ������
			case 0 : bufferG.setColor(new Color(255,0,0)); //this - ĵ����
					 break;
			case 1 : bufferG.setColor(new Color(0,255,0));
					 break;
			case 2 : bufferG.setColor(new Color(0, 0, 255));
					 break;
			case 3 : bufferG.setColor(new Color(255, 0, 255));
					 break;
			case 4 : bufferG.setColor(new Color(0, 255, 255));
					 break;
			
			}
			
			if(dto.isFill()) {
				if(dto.getShape() == Figure.LINE) {
					bufferG.drawLine(x1, y1, x2, y2);
					//Math.min(x1,x2), Math.min(y1, y2)�� �Է�
				}else if(dto.getShape() == Figure.CIRCLE) {
					bufferG.fillOval(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1));
				}else if(dto.getShape() == Figure.RECT) {
					bufferG.fillRect(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1));
				}else if(dto.getShape() == Figure.ROUND_RECT) {
					bufferG.fillRoundRect(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1), z1, z2); //�������� �ձ� �κ��� �󸶳� ���� - 50���� ������ ���� �־���(����)
				}else if(dto.getShape() == Figure.PEN) {
					bufferG.drawLine(x1, y1, x2, y2);
				}
			}else {
				if(dto.getShape() == Figure.LINE) {
					bufferG.drawLine(x1, y1, x2, y2);
				}else if(dto.getShape() == Figure.CIRCLE) {
					bufferG.drawOval(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1)); //���⼭ x2-x1, y2-y1���� ǥ���ϰ� �ֱ� ������ �ٸ� ���⿡�� �׸��� ǥ�Ⱑ �ȵ�
				}else if(dto.getShape() == Figure.RECT) {
					bufferG.drawRect(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1));
				}else if(dto.getShape() == Figure.ROUND_RECT) {
					bufferG.drawRoundRect(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1), z1, z2);
				}else if(dto.getShape() == Figure.PEN) {
					bufferG.drawLine(x1, y1, x2, y2);
				}
			}
			
					
		}//for
		
		
		
		//���ο� �׸�
		//MsPaintT mp = new MsPaintT(); - ���� �� �ٸ� ��ü�� �����ǹǷ� �ϸ� �ȵ�
		//��ǥ ����(TextField�� ����� ���� ����)
			x1 = Integer.parseInt(mp.getX1T().getText().trim()); //trim() - �յ� ������ ����
			y1 = Integer.parseInt(mp.getY1T().getText().trim());
			x2 = Integer.parseInt(mp.getX2T().getText().trim());
			y2 = Integer.parseInt(mp.getY2T().getText().trim());
			z1 = Integer.parseInt(mp.getZ1T().getText().trim());
			z2 = Integer.parseInt(mp.getZ2T().getText().trim());
			
			
			//��
			switch(mp.getCombo().getSelectedIndex()) {//index�� ��������, getSelectedItem -> ����� ���ڿ��� ������
				case 0 : bufferG.setColor(new Color(255,0,0));
						 break;
				case 1 : bufferG.setColor(new Color(0,255,0));
						 break;
				case 2 : bufferG.setColor(new Color(0, 0, 255));
						 break;
				case 3 : bufferG.setColor(new Color(255, 0, 255));
						 break;
				case 4 : bufferG.setColor(new Color(0, 255, 255));
						 break;
				
			}
			
			//���� 
			if(mp.getFill().isSelected()) { //���� ä���� ���� 
													//isSelected : ����ڰ� �����ߴ��� ���ߴ����� �˷���, ������ ��� true�� ��ȯ
				 									//==true�����ص� ��
				if(mp.getLine().isSelected()) {
					bufferG.drawLine(x1, y1, x2, y2);
					//Math.min(x1,x2), Math.min(y1, y2)�� �Է�  x1 < x2 ? x1 : x2   y1 < y2 ? y1 : y2
				}else if(mp.getCircle().isSelected()) {
					bufferG.fillOval(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1));
				}else if(mp.getRect().isSelected()) {
					bufferG.fillRect(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1));
				}else if(mp.getRoundRect().isSelected()) {
					bufferG.fillRoundRect(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1), z1, z2); //�������� �ձ� �κ��� �󸶳� ���� - 50���� ������ ���� �־���(����)
				}
				
			}else {
				if(mp.getLine().isSelected()) {
					bufferG.drawLine(x1, y1, x2, y2);
				}else if(mp.getCircle().isSelected()) {
					bufferG.drawOval(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1)); //���⼭ x2-x1, y2-y1���� ǥ���ϰ� �ֱ� ������ �ٸ� ���⿡�� �׸��� ǥ�Ⱑ �ȵ�
				}else if(mp.getRect().isSelected()) {
					bufferG.drawRect(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1));
				}else if(mp.getRoundRect().isSelected()) {
					bufferG.drawRoundRect(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1), z1, z2);
				}
				
			}
			
			paint(g); //paint()�޼ҵ� ȣ��
		}//update()
	
	
	@Override
	public void paint(Graphics g) { //�����ϸ� setVisible�� �ڵ����� paint�޼ҵ带 �θ�, ���� �ʱ�ȭ ���� ���� �����̱� ������ �Ʒ��� ���� ������ ��
								    //Exception in thread "AWT-EventQueue-0" java.lang.NumberFormatException: For input string: ""
									//��� : Mspaint���� �����ÿ� �ʱ갪�� ��
		g.drawImage(bufferImage, 0, 0, this); //bufferImage�� �� this�� ���̱�(��ƼĿ ���� ����), ��ǥ 0,0�� �������� ������ ���缭 ���̱�
		
	}

	

	
	
}

//x1 = ???; //login�� loginresult�� ����

//1.x1T�� ���� ���� ������
//2.���ڿ��� ������ "100"�� ���������� ��ȯ


//PEN
//���� x1,y1�� ����(x2,y2�� ������)
//������ x2,y2�� �ٽ� x1,y1�� ��(x1,y1�� �ٲ�) temp?


//ĵ������ ���� ũ���� ���۸� ����(�׸��� ���ۿ� �׸�), �װ� ȭ�鿡 �ٽ� �ű� - ���ʷ� �׸��� �����Ÿ��� ������(ȭ�鿡 �� �ѹ� ����)
//��ǥ���� �� ���� ���ۿ��� ������(�������)
//�ݹ�޼ҵ��� - repaint()�Ҷ� �Ҹ�
//update() - paint()������ ȣ��


//		for(int i = 0; i < mp.getList().size(); i++){
//		
//			//int x1, y1, x2, y2, z1, z2;
//			
//			x1 = mp.getList().get(i).getX1();
//			y1 = mp.getList().get(i).getY1();
//			x2 = mp.getList().get(i).getX2();
//			y2 = mp.getList().get(i).getY2();
//			z1 = mp.getList().get(i).getZ1();
//			z2 = mp.getList().get(i).getZ2();
//			
//			switch(mp.getList().get(i).getColor()) {//index�� ��������, getSelectedItem -> ����� ���ڿ��� ������
//			case 0 : bufferG.setColor(new Color(255,0,0));
//					 break;
//			case 1 : bufferG.setColor(new Color(0,255,0));
//					 break;
//			case 2 : bufferG.setColor(new Color(0, 0, 255));
//					 break;
//			case 3 : bufferG.setColor(new Color(255, 0, 255));
//					 break;
//			case 4 : bufferG.setColor(new Color(0, 255, 255));
//					 break;
//			
//		}
//			if(mp.getList().get(i).isFill()) {
//				if(mp.getList().get(i).getShape() == Figure.LINE) {
//					bufferG.drawLine(x1, y1, x2, y2);
//					//Math.min(x1,x2), Math.min(y1, y2)�� �Է�
//				}else if(mp.getList().get(i).getShape() == Figure.CIRCLE) {
//					bufferG.fillOval(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1));
//				}else if(mp.getList().get(i).getShape() == Figure.RECT) {
//					bufferG.fillRect(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1));
//				}else if(mp.getList().get(i).getShape() == Figure.ROUND_RECT) {
//					bufferG.fillRoundRect(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1), z1, z2); //�������� �ձ� �κ��� �󸶳� ���� - 50���� ������ ���� �־���(����)
//				}else if(mp.getList().get(i).getShape() == Figure.PEN) {
//					bufferG.drawLine(x1, y1, x2, y2);
//				}
//			}else {
//				if(mp.getList().get(i).getShape() == Figure.LINE) {
//					bufferG.drawLine(x1, y1, x2, y2);
//				}else if(mp.getList().get(i).getShape() == Figure.CIRCLE) {
//					bufferG.drawOval(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1)); //���⼭ x2-x1, y2-y1���� ǥ���ϰ� �ֱ� ������ �ٸ� ���⿡�� �׸��� ǥ�Ⱑ �ȵ�
//				}else if(mp.getList().get(i).getShape() == Figure.RECT) {
//					bufferG.drawRect(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1));
//				}else if(mp.getList().get(i).getShape() == Figure.ROUND_RECT) {
//					bufferG.drawRoundRect(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1), z1, z2);
//				}else if(mp.getList().get(i).getShape() == Figure.PEN) {
//					bufferG.drawLine(x1, y1, x2, y2);
//				}
//			}
//			
//		}//for��