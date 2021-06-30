package game.snakeandladder;
import game.snakeandladder.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Input {
	public static String nameOfPlayer;
	public static int noOfSnakes, noOfLadders, noOfPlayers, head, tail;
	public static ArrayList<Player> players = new ArrayList<>();
	public static Map<Integer,Integer> snakeOrLadder = new HashMap<Integer,Integer>();
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("============SNAKE AND LADDER GAME========\n\n");
		System.out.print("Enter the number of snakes you want on your board:");
		noOfSnakes = sc.nextInt();
		
		System.out.println("\nEnter the head and tail of the snake::");
		for(int i=0; i<noOfSnakes; i++){
			System.out.print("Head=");
			head = sc.nextInt();
			System.out.print("\tTail=");
			tail = sc.nextInt();
			snakeOrLadder.put(head, tail);
		}
		
		System.out.print("\n\nEnter the number of ladders you want on your board:");
		noOfLadders = sc.nextInt();
		
		System.out.println("\nEnter the start and end of the ladder::");
		for(int i=0; i<noOfLadders; i++){
			System.out.print("Start=");
			head = sc.nextInt();
			System.out.print("\tEnd=");
			tail = sc.nextInt();
			snakeOrLadder.put(head, tail);
		}
		
		System.out.print("\n\nEnter the number of players: ");
		noOfPlayers = sc.nextInt();
		
		for(int i=0; i<noOfPlayers; i++) {
			System.out.print("Name of Player " + (i+1) + ": ");
			players.add(new Player(sc.next()));
		}
		System.out.println("");
		Logic logic = new Logic();
		logic.startGame(snakeOrLadder, players);
		
		sc.close();
	}
}
