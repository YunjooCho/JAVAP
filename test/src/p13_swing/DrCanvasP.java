package p13_swing;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

public class DrCanvasP extends Canvas {

	//4.캔버스 만들기
	private MsPaintTP mp;
	private ShapeDTOP dto;
	private Image bufferImage;
	private Graphics bufferG;
	
	public DrCanvasP(MsPaintTP mp) {
		this.mp = mp;
		this.setBackground(new Color(200, 200, 255));
		
		
	}//DrCanvasP
	
	@Override
	public void update(Graphics g) {
		Dimension d = this.getSize();
		if(bufferG == null) {
			bufferImage = createImage(d.width, d.height);
			bufferG = bufferImage.getGraphics();
		}
		
		//지우기(잔상없애기)
		Color c = this.getBackground();
		bufferG.setColor(c);
		bufferG.fillRect(0, 0, d.width, d.height);
		
		int x1, y1, x2, y2, z1, z2;
		//이전 작업 가져오기
		//<좌표>
		for(ShapeDTOP dto : mp.getList()) {
			x1 = dto.getX1();
			y1 = dto.getY1();
			x2 = dto.getX2();
			y2 = dto.getY2();
			z1 = dto.getZ1();
			z2 = dto.getZ2();

		
		
		//<색>
		switch(dto.getColor()) {
			case 0 : bufferG.setColor(new Color(255,0,0));
					 break;
			case 1 : bufferG.setColor(new Color(0,255,0));
				     break;
			case 2 : bufferG.setColor(new Color(0,0,255));
				     break;
			case 3 : bufferG.setColor(new Color(255,255,0));
				     break;
			case 4 : bufferG.setColor(new Color(0, 255, 255));
			         break;
		}
		
		
		//<도형>
		if(dto.getFill()) {
			if(dto.getShape() == Figure.LINE) {
				bufferG.drawLine(x1, y1, x2, y2);
			}else if(dto.getShape() == Figure.CIRCLE) {
				bufferG.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
			}else if(dto.getShape() == Figure.RECT) {
				bufferG.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
			}else if(dto.getShape() == Figure.ROUND_RECT) {
				bufferG.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
			}
		}else {
			if(dto.getShape() == Figure.LINE) {
				bufferG.drawLine(x1, y1, x2, y2);
			}else if(dto.getShape() == Figure.CIRCLE) {
				bufferG.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
			}else if(dto.getShape() == Figure.RECT) {
				bufferG.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
			}else if(dto.getShape() == Figure.ROUND_RECT) {
				bufferG.drawRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
			}
			
		}
	}
		
		//새로운 그림
		//<좌표>
		x1 = Integer.parseInt(mp.getX1T().getText().trim());
		y1 = Integer.parseInt(mp.getY1T().getText().trim());
		x2 = Integer.parseInt(mp.getX2T().getText().trim());
		y2 = Integer.parseInt(mp.getY2T().getText().trim());
		z1 = Integer.parseInt(mp.getZ1T().getText().trim());
		z2 = Integer.parseInt(mp.getZ2T().getText().trim());
		
		//<색>
		switch(mp.getCombo().getSelectedIndex()) {
		 case 0 : bufferG.setColor(new Color(255,0,0));
		 	      	break;
		 case 1 : bufferG.setColor(new Color(0,255,0));
		 		    break;
		 case 2 : bufferG.setColor(new Color(0,0,255));
		 	        break;
		 case 3 : bufferG.setColor(new Color(255,0,255));
		 		    break;
		 case 4 : bufferG.setColor(new Color(0,255,255));
		 			break;
		}
		
		//<도형>
		if(mp.getFill().isSelected()) {
			if(mp.getLine().isSelected()) {
				bufferG.drawLine(x1, y1, x2, y2);
			}else if(mp.getCircle().isSelected()) {
				bufferG.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
			}else if(mp.getRect().isSelected()) {
				bufferG.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
			}else if(mp.getRoundRect().isSelected()) {
				bufferG.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
			}
		}else {
			if(mp.getLine().isSelected()) {
				bufferG.drawLine(x1, y1, x2, y2);
			}else if(mp.getCircle().isSelected()) {
				bufferG.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
			}else if(mp.getRect().isSelected()) {
				bufferG.drawRect(Math.min(x1, x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
			}else if(mp.getRoundRect().isSelected()) {
				bufferG.drawRoundRect(Math.min(x1, x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
			}
		}
		
		paint(g);
		
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(bufferImage, 0, 0,this);
	}
}
