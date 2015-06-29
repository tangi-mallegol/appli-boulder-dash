package boulderDash.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class PanneauInfoJeu extends JPanel implements Observer{
	private JLabel temps, score;
	
	public PanneauInfoJeu(){
		setLayout(new GridLayout(2,1));
		
		temps = new JLabel("TEMPS : 00:00:00");
		score = new JLabel("SCORE : 0");
		

		//Timer timer = new Timer(1000, new MyTimerActionListener(0));
	    //timer.start();
		
		add(temps);
		add(score);
	}

	public void update(Observable o, Object arg) {		
		Integer[] tableau_param = (Integer[])arg;
		int secondes = tableau_param[1]%60;
		int minutes = tableau_param[1]/60;
		int heures = tableau_param[1]/3600;
		
		temps.setText("TEMPS : " + (heures < 10 ? "0" + heures : heures) +":" + (minutes < 10 ? "0" + minutes : minutes) + ":" + (secondes < 10 ? "0" + secondes : secondes));

		score.setText("SCORE : " + tableau_param[0]);
	}
	
	public class MyTimerActionListener implements ActionListener {
	    private Integer time;
	 
	    public MyTimerActionListener(int init) {
	          super();
	          this.time = init;
	    }

		@Override
		public void actionPerformed(ActionEvent arg0) {
			this.time++;
	          temps.setText(time.toString());
			
		}
	}
}
