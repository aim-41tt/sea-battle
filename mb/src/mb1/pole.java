package mb1;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;



public class pole extends JPanel {
	//pole
		private Image fon,paluba,ranen,ubit,bomba,end1,end2,boomboom;
		private JButton btnexit,btnnewgame;
		private Timer tmdraw;
		private game myGame;
		
		private int mx,my;
		//КЛАСС ДЛЯ ОБРАБОТКИ МЫШИ 	
		public class mymous1 implements MouseListener{

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
     	    }
			@Override
			public void mousePressed(MouseEvent e) {
				
				
				//1 cliced LCM 1 
				if(e.getButton()==1 && e.getClickCount()==1){
					//opr x y 
				mx=e.getX();
				my=e.getY();
				//если курсор на поле 
				if(mx>100 && mx<400 && my>100 && my<400){
					//ход игры
					if(myGame.endg==0 && !myGame.bothod){
						int i=(my-100)/30;
						int j=(mx-100)/30;
					
						if(myGame.masbot[i][j]<=4){
							myGame.vistrplay(i,j);
						}
					}
				}
				
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
		}
		
		
		
		//ОБРАБОТКА МЫШИ В ДВИЖЕНИИ
		public class mymous2  implements MouseMotionListener{

			@Override
			public void mouseDragged(MouseEvent e) {
		
			}

			@Override
			public void mouseMoved(MouseEvent e) {
			mx=e.getX();
			my=e.getY();
			
				if(mx>100 && mx<400 && my>100 && my<400){
					setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
			}
				else{
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			}
		}
		
		public pole(){
			myGame=new game();
			this.addMouseListener(new mymous1());
			addMouseMotionListener(new mymous2());
			setFocusable(true);
			myGame.start();
			
			try{
			boomboom= ImageIO.read(new File("boom1.png"));
			fon= ImageIO.read(new File("fon.png"));
			paluba= ImageIO.read(new File("paluba.png"));
			ranen= ImageIO.read(new File("ranen.png"));
			ubit= ImageIO.read(new File("ubit.png"));
			bomba= ImageIO.read(new File("bomba.png"));
			end1= ImageIO.read(new File("end1.png"));
			end2= ImageIO.read(new File("end2.png"));
			} catch (Exception e) {
		JOptionPane.showMessageDialog(null,"lol");
		}	

		
		tmdraw=new Timer(50,new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		repaint();
			}
		});
	 tmdraw.start();
	 
	 setLayout(null);
	 
	 btnexit=new JButton();
	 btnexit.setForeground(Color.blue);
	 btnexit.setFont(new Font("serif",0,30));
	 btnexit.setText("next");
	 btnexit.setBounds(530, 450, 200, 80);
	 btnexit.addActionListener(new ActionListener() {
		 
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
	});
	 add(btnexit);
	 
	 
	 btnexit=new JButton();
	 btnexit.setForeground(Color.RED);
	 btnexit.setFont(new Font("serif",0,30));
	 btnexit.setText("new game");
	 btnexit.setBounds(130, 450, 200, 80);
	 btnexit.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			myGame.start();
		}
	});
	add(btnexit);
	 
	 btnexit=new JButton();
	 btnexit.setForeground(Color.RED);
	 btnexit.setFont(new Font("serif",0,30));
	 btnexit.setText("boom");
	 btnexit.setBounds(380, 450, 120, 30);
	 btnexit.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			myGame.boom();
		}
	});
	add(btnexit);

		}
		
		
		public void paintComponent(Graphics gr){

			super.paintComponent(gr);//очистка игр поля
			gr.drawImage(fon,0,0,900,600,null);
			gr.setFont(new Font("serf",3,40));
			gr.setColor(Color.RED);
			gr.drawString("PC", 200,60);
			gr.drawString("PLAYER", 570,60);
			
			for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				
				//dli bot
				if(myGame.masbot[i][j]!=0){
					if(myGame.masbot[i][j]>=8 && myGame.masbot[i][j]<=11){
						gr.drawImage(ranen, 100+j*30, 100+i*30, 30, 30,null);
						
					}else if(myGame.masbot[i][j]>=15){
						gr.drawImage(ubit, 100+j*30, 100+i*30, 30, 30,null);
					}
					if(myGame.masbot[i][j]>=5){
						gr.drawImage(bomba, 100+j*30, 100+i*30, 30, 30,null);
					}
				}
				
				
				
				//dli play
				
				if(myGame.masplay[i][j]!=0){
						
				if(myGame.masplay[i][j]>=1 && myGame.masplay[i][j]<=4){
					gr.drawImage(paluba, 500+j*30, 100+i*30, 30, 30,null);
				}
				else
				if(myGame.masplay[i][j]>=8 && myGame.masplay[i][j]<=11){
					gr.drawImage(ranen, 500+j*30, 100+i*30, 30, 30,null);
					
				}else if(myGame.masplay[i][j]>=15){
					gr.drawImage(ubit, 500+j*30, 100+i*30, 30, 30,null);
				}
				if(myGame.masplay[i][j]>=5){
					gr.drawImage(bomba, 500+j*30, 100+i*30, 30, 30,null);
				}
					}
				

				
			}}
			//закрас клетки с курсорам
			if(mx>100 && mx<400 && my>100 && my<400){ //если курсор в поле пк
				if(myGame.endg==0 && !myGame.bothod){
					int i=(my-100)/30;
					int j=(mx-100)/30;
				
				if(myGame.masbot[i][j]<=4){
					gr.fillRect(100+j*30, 100+i*30,30,30);
				}
				
				}
			}
			
			gr.setColor(Color.GREEN);
			for(int i=0;i<11;i++){
				//pc
				gr.drawLine(100+i*30, 100 ,100+i*30, 400);
				gr.drawLine(100, 100+i*30, 400, 100+i*30);
				//player
				gr.drawLine(500+i*30, 100 ,500+i*30, 400);
				gr.drawLine(500, 100+i*30, 800, 100+i*30);
			}
			gr.setFont(new Font("serif",0,20));
			gr.setColor(Color.BLACK);
			for(int i=1;i<11;i++){
				gr.drawString(""+i, 73, 90+i*30);
				gr.drawString(""+i, 473, 90+i*30);
				
				gr.drawString(""+(char)('A'+i-1), 78+i*30,93);
				gr.drawString(""+(char)('A'+i-1), 478+i*30,93);
			}
			//next play
			if(myGame.endg==1){
				gr.drawImage(end1, 300, 200, 300, 100, null);
				
			}else{if(myGame.endg==2){
				gr.drawImage(end2, 300, 200, 300, 100, null);
				
			}
				
			}
			
			if(myGame.bom1==true) {
				gr.drawImage(boomboom,0,0,900,600,null);
				if (myGame.bom1==true) {
					gr.drawImage(end1, 300, 200, 300, 100, null);
				}
			}
			
		}

		
		
}
