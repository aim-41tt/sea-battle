package mb1;

import java.awt.Container;

import javax.swing.JFrame;



public class okno extends JFrame{
	public okno() {

		this.setBounds(0,0,900,600);         //this.setBounds(0,0,900,600);
		setTitle("my play\"морской бой\"");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		//созд панели игр поля
		pole pan=new pole();
		Container cont=getContentPane();
		cont.add(pan);
		setVisible(true);
		 
		
	}	
	
}
