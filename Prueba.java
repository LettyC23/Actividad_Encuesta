import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;


class HiloMostrarDatos extends Thread{

	int contSi=0;
	@Override
	public void run() {
String v [] = new String [10000000];
		
		String vector [] = {"Si", "No"};
		
		Random a = new Random();
		for (int i = 0; i <v.length; i++) {
			 v[i] = vector[new Random().nextInt(vector.length)];
		}
		
		for (int i = 0; i < v.length; i++) {
			if (v[i]=="Si") {
				contSi++;
				//System.out.println(v[i]);
			}
		}
	}
	
}

class HiloObtenerDatos extends Thread{

	
	int contNo=0;
	
	
	@Override
	public void run() {
		String v [] = new String [10000000];
		
		String vector [] = {"Si", "No"};
		
		Random a = new Random();
		for (int i = 0; i <v.length; i++) {
			 v[i] = vector[new Random().nextInt(vector.length)];
		}
		for (int i = 0; i < v.length; i++) {
			if (v[i]=="No") {
				contNo++;
				//System.out.println(v[i]);
			}	
		}
	}
	
}


class Bar extends JFrame implements ActionListener{
	
	JProgressBar bar, barNo;
	JButton button;
	
	public Bar() {
		setSize(220,200);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		
		barNo = new JProgressBar();
		barNo.setMaximum(10000000);
		barNo.setValue(0);
		barNo.setStringPainted(true);
		
		
		bar = new JProgressBar();
		bar.setMaximum(10000000);
		bar.setValue(0);
		bar.setStringPainted(true);
		
		button = new JButton("Iniciar");
		button.addActionListener(this);
		
		add(button);
		add(bar);
		add(new JLabel("Si"));
		add(barNo);
		add(new JLabel("No"));
	}
	

	public void startChange(ChangeEvent a) {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int contNo=0, contSi=0;
		String v [] = new String [10000000];
		
		String vector [] = {"Si", "No"};
		
		Random a = new Random();
		for (int i = 0; i <v.length; i++) {
			 v[i] = vector[new Random().nextInt(vector.length)];
		}
		
		for (int i = 0; i < v.length; i++) {
			if (v[i]=="Si") {
				contSi++;
			}else if(v[i]=="No"){
				contNo++;
			}
		}
		//System.out.println(contSi);
		//System.out.println(contNo);
			bar.setValue(contSi);
			barNo.setValue(contNo);
		
		
		
	}
	
}




public class Prueba {
  public static void main(String args[]) {
	  
	  HiloMostrarDatos h = new HiloMostrarDatos();
	  h.start();
	  HiloObtenerDatos h1 = new HiloObtenerDatos();
	  h1.start();
	  
    SwingUtilities.invokeLater(new Runnable() {
		
		@Override
		public void run() {
			
			
			new Bar();
			
		}
	});
  }
}

	
