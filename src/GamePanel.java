import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel{
	int[] board = {0,0,0,0,0,0,0,0,0};
	ArrayList<Rectangle> gameBoard = new ArrayList<Rectangle>();
	ArrayList<Boolean> clicked = new ArrayList<Boolean>();
	int turnCounter = 1;
	int player1Score = 0, player2Score = 0;
	GamePanel(){
		gameBoard.add(new Rectangle(0, 0, 300, 300));//0
		gameBoard.add(new Rectangle(300, 0,300, 300));//1
		gameBoard.add(new Rectangle(600, 0, 300, 300));//2
		gameBoard.add(new Rectangle(0, 300, 300, 300));//3
		gameBoard.add(new Rectangle(300, 300, 300, 300));//4
		gameBoard.add(new Rectangle(600, 300, 300, 300));//5
		gameBoard.add(new Rectangle(0, 600, 300, 300));//6
		gameBoard.add(new Rectangle(300, 600, 300, 300));//7
		gameBoard.add(new Rectangle(600, 600, 300, 300));//8
		for(int i = 0; i < 9; i++) {
			clicked.add(false);
		}
	}
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == 1) {
			for(int i = 0; i < gameBoard.size(); i++) {
				if(gameBoard.get(i).contains(getMousePosition())) {
					if(clicked.get(i) == false) {
						clicked.set(i, true);
						if(turnCounter % 2 != 0) {
							udpateGraphics(this.getGraphics(), Color.RED, gameBoard.get(i));
							board[i] = 1;
							if(checkWin()) {
								System.out.println("player 1 won");
								player1Score++;
								reset();
							}
						}else {
							udpateGraphics(this.getGraphics(), Color.BLUE, gameBoard.get(i));
							board[i] = 2;
							if(checkWin()) {
								System.out.println("player 2 won");
								player2Score++;
								reset();
							}
						}
						
						turnCounter++;
					}
				}
			}
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
		g.drawLine(300, 0, 300, 900);
		g.drawLine(600, 0, 600, 900);
		g.drawLine(0, 300, 900, 300);
		g.drawLine(0, 600, 900, 600);
		g.drawString("player 1: ", 50, 925);
		g.drawString(Integer.toString(player1Score), 100, 925);
		g.drawString("player 2: ", 50, 950);
		g.drawString(Integer.toString(player2Score), 100, 950);
	}
	public void udpateGraphics(Graphics g, Color c, Rectangle location) {
		g.setColor(c);
		g.fillRect((int)location.getX(), (int)location.getY(), 300, 300);
		g.setColor(Color.white);
		g.fillRect(0, 900, 900, 100);
		g.setColor(Color.BLACK);
		g.drawString("player 1: ", 50, 925);
		g.drawString(Integer.toString(player1Score), 100, 925);
		g.drawString("player 2: ", 50, 950);
		g.drawString(Integer.toString(player2Score), 100, 950);
	}
	public boolean checkWin() {
		boolean cats = true;
		if(board[0] != 0 && board[0] == board[1] && board[0] == board[2]) {
			System.out.println("condition 1");
			return true;
		}
		if(board[3] != 0 && board[3] == board[4] && board[3] == board[5]) {
			System.out.println("condition 2");
			return true;
		}
		if(board[6] != 0 && board[6] == board[7] && board[6] == board[8]) {
			System.out.println("condition 3");
			return true;
		}
		if(board[0] != 0 && board[0] == board[3] && board[0] == board[6]) {
			System.out.println("condition 4");
			return true;
		}
		if(board[1] != 0 && board[1] == board[4] && board[1] == board[7]) {
			System.out.println("condition 5");
			return true;
		}
		if(board[2] != 0 && board[2] == board[5] && board[2] == board[8]) {
			System.out.println("condition 6");
			return true;
		}
		if(board[0] != 0 && board[0] == board[4] && board[0] == board[8]) {
			System.out.println("condition 7");
			return true;
		}
		if(board[2] != 0 && board[2] == board[4] && board[2] == board[6]) {
			System.out.println("condition 8");
			return true;
		}
		for(int i = 0; i < board.length - 1; i++) {
			if(board[i] == 0 ) {
				cats = false;
			}
		}
		if(cats) {
			System.out.println("cats game");
			reset();
		}
		return false;
	}
	public void reset() {
		paint(this.getGraphics());
		for(int i = 0; i < 9; i++) {
			board[i] = 0;
			clicked.set(i, false);
		}
		turnCounter = 1;
	}
}
