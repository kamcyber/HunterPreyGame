import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class Map extends JFrame implements Runnable{
	JFrame map ;
	static Game game = new Game();
	static boolean gameControl = true;
	key k1 = new key();
	
	private class key implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			
			if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W){
				if(game.isEaten()){
					map.removeKeyListener(k1);
					gameControl = false;
					map.removeKeyListener(k1);
				}
				game.p.move(0);
				if(game.isEaten()){
					map.removeKeyListener(k1);
					gameControl = false;
					map.removeKeyListener(k1);
				}
			}else if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S){
				if(game.isEaten()){
					map.removeKeyListener(k1);
					gameControl = false;
					map.removeKeyListener(k1);
				}
				game.p.move(1);
				if(game.isEaten()){
					map.removeKeyListener(k1);
					gameControl = false;
					map.removeKeyListener(k1);
				}
			}else if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D){

				if(game.isEaten()){
					map.removeKeyListener(k1);
					gameControl = false;
					map.removeKeyListener(k1);
				}
				game.p.move(2);
				if(game.isEaten()){
					map.removeKeyListener(k1);
					gameControl = false;
					map.removeKeyListener(k1);
				}
			}else if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A){
				if(game.isEaten()){
					map.removeKeyListener(k1);
					gameControl = false;
					map.removeKeyListener(k1);
				}
				game.p.move(3);
				if(game.isEaten()){
					map.removeKeyListener(k1);
					gameControl = false;
					map.removeKeyListener(k1);
				}
			}
			game.moveHunters();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		map = new JFrame("HunterPreyGame v2.0");
		map.setSize(400,400);
		map.setResizable(false);
		map.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		map.setVisible(true);
		game.setVisible(true);
		game.setBackground(Color.BLACK);
		map.addKeyListener(k1);
		game.properPlaces();
		map.add(game);
		int i = 0;
		while(gameControl){
		//	game.getPlacesForHunters(); random is kinda broken it takes too long to get them a random place
		//	game.getPlacesForPrey();  random is kinda broken it takes too long to get them a random place
			
			
			
	//looks for 0.2 chance to kill a hunter in every second
			if(i%100 == 0)
				game.killHunter();
			
			if(game.isEaten()){
				map.removeKeyListener(k1);
				gameControl = false;
				map.removeKeyListener(k1);
			}
			
			if(game.p.check()){
				game.repaint();
				if(game.isEaten()){
					map.removeKeyListener(k1);
					gameControl = false;
					map.removeKeyListener(k1);
					break;
				}
				if(game.isEaten()){
					map.removeKeyListener(k1);
					gameControl = false;
					map.removeKeyListener(k1);
				}
			}
			
			if(i%25 == 0 ){
				game.changeHunterDirection();
				if(game.isEaten()){
					map.removeKeyListener(k1);
					gameControl = false;
					map.removeKeyListener(k1);
				}				
			}
			game.moveHunters();
			
			
			if(game.isEaten()){
				map.removeKeyListener(k1);
				gameControl = false;
				map.removeKeyListener(k1);
			}
			
				
			if(i%100 == 0)
				map.setTitle("HunterPreyGame v2.0 - "+i/100+" Seconds passed.");
			i++;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch blockS
			}
			//if(game.check())
			//	game.repaint();
		}

		map.removeKeyListener(k1);
		for(int i1 = 10 ; i1 > 0 ; i1--){
			map.setTitle("Game Over - Lived "+i/100+" secs -Closing in "+i1+" secs");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			}
		}
		System.exit(0);
		
			
		
	}
	
	public static void main(String[] args) throws InterruptedException{
		Thread t = new Thread(new Map());
		t.start();
		
	}


}
