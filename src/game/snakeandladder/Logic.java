package game.snakeandladder;
import game.snakeandladder.Player;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class Logic {
	public int dice() {
		return new Random().nextInt(6) + 1;
	}
	
	public void startGame(Map<Integer,Integer> snakeOrLadder, ArrayList<Player> players) {
//		for(Map.Entry sol: snakeOrLadder.entrySet()) {
//			System.out.println(sol.getKey() + " " + sol.getValue());
//		}
//		for(Player p: players) {
//			System.out.println("Name:" + p.getName() + " Position:" + p.getPosition());
//		}
		
		int check=0, move, i, initial;
		Player play;
		
		while(check<25) {
			i = 0;
			while(i<players.size()) {
				play = players.get(i);
				initial = play.getPosition();
				move = dice();
				if(play.getPosition()==0 && move==6) {
					play.setPosition(1);
					System.out.println(play.getName() + " rolled a " + move + " and moved from " + initial + " to " + play.getPosition());
				}
				else if(play.getPosition()>0 && play.getPosition() + move <= 25) {
					play.setPosition(play.getPosition() + move);
					
					if(snakeOrLadder.containsKey(play.getPosition())) {
						play.setPosition(snakeOrLadder.get(play.getPosition()));
					}
					System.out.println(play.getName() + " rolled a " + move + " and moved from " + initial + " to " + play.getPosition());
				}
				else {
					System.out.println(play.getName() + " rolled a " + move + " and moved from " + initial + " to " + play.getPosition());
				}
				if(play.getPosition()==25) {
					check = 25;
					System.out.println(play.getName() + " wins the game");
					break;
				}
				if(move!=6) {
					i++;
//					System.out.println(i + play.getName() + " " + play.getPosition());
				}
			}
			System.out.println("");
		}
	}
}
