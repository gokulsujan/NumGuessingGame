import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GuessGame implements ActionListener{
	
	JFrame jf;
	JButton guessBtn;
	JTextField number;
	JLabel messageScreen;
	JButton newGuess;
	ImageIcon icon;
	
	Random rand = new Random();
	int randomNum = rand.nextInt(100);
	
	public GuessGame() {
		jf = new JFrame("Guess Game");
		jf.setLayout(null);
		jf.setBounds(300, 150, 600, 600);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		icon = new ImageIcon("C:\\Users\\Gokul Sujan\\eclipse-workspace\\jee\\GuessGame\\src\\icon.png");
		jf.setIconImage(icon.getImage());
		
		number = new JTextField();
		number.setBounds(30, 50, 540, 40);
		number.setBackground(Color.white);
		jf.add(number);	
		
		guessBtn = new JButton("Check");
		guessBtn.setBounds(30, 100, 540, 30);
		guessBtn.addActionListener(this);
		jf.add(guessBtn);
		
		messageScreen = new JLabel("Hai");
		messageScreen.setBounds(225, 140, 150, 50);
		messageScreen.setBackground(Color.white);
		messageScreen.setOpaque(true);
		messageScreen.setHorizontalAlignment(SwingConstants.CENTER);
		jf.add(messageScreen);
		
		newGuess = new JButton("Guess Again");
		newGuess.setBounds(225, 200, 150, 50);
		newGuess.addActionListener(this);
		jf.add(newGuess);
		
		
		
	}
	
	public static void main(String[] args) {
		new GuessGame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newGuess) {
			randomNum = rand.nextInt(100);
			messageScreen.setText("New number guessed!!");
		} else {
			try {
				int randomInt = Integer.parseInt(number.getText());
				if(randomInt>randomNum) {
					messageScreen.setText("Lower");
				} else if(randomInt == randomNum){
					messageScreen.setText("Correct");
				} else {
					messageScreen.setText("Higher");
				}
				
			} catch (NumberFormatException nfe) {
				messageScreen.setText("Not a number");
			}
			
		}
				
		
	}

}
