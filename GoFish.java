//Handsomely coded by Tim Lee
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class GoFish{

   private static Deck dMain;
   private static Player robot;
   private static Player human;

   public static void main(String[]args){
      //initialize deck
      String[] ranks52 =
         {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
      String[] suits52 =
         {"spades", "hearts", "diamonds", "clubs"};
      dMain = new Deck(ranks52, suits52);
      dMain.shuffle();
      
      
      
      robot = new Player(dMain.deal(5) , "robot");
      human = new Player(dMain.deal(5) , "human");
      
      turn();
   
   
   }
   
   public static void turn(){
      human.checkPairInitial();
      robot.checkPairInitial();
      human.showHand();//prints your cards
      System.out.println("--------");
      robot.showHand();//prints robots cards
      Scanner in = new Scanner(System.in);
      int rand = 0;
      while (true){
      
      
      //Human Behavior
         
         
         System.out.println("\nEnter a card that you have and want to ask");
         String input = in.next();
         
         if (human.indexOf(input) <= -1)
            while (true){
               System.out.println("You do not have that card enter another card");
               input = in.next();
               if (human.indexOf(input) > -1)
                  break;
            }
         human.ask(input, robot, dMain);
         human.checkPair();
         human.showHand();
      
      //Check if no remaining cards
         if (human.hand.size() < 1 ){
            if (human.pairs > robot.pairs)
               System.out.println("Human Has WON!");
            else if (human.pairs < robot.pairs)
               System.out.println("Robot has WON");
            else
               System.out.println("It's a tie!");
            break;
         }
      //Robot Behavior
         String rAsk = "";
         rand = (int)(Math.random() * robot.hand.size());
         int range = 0;
         for (int c = 0; c < robot.hand.size(); c ++){
            if (robot.mem.indexOf(robot.hand.get(c).getRank()) > -1){
               range++;
                       
            }
            
         }
         if (range < 1){
            robot.ask(robot.hand.get(rand).getRank(), human, dMain);
         }
         else {
            rAsk = robot.hand.get((int)(Math.random() * range)).getRank();   
            robot.ask(rAsk, human, dMain);
         }
         robot.checkPair();
         robot.showHand();
       //Check if no remaining cards
         if (robot.hand.size() < 1){
            if (human.pairs > robot.pairs)
               System.out.println("Human Has WON!");
            else if (human.pairs < robot.pairs)
               System.out.println("Robot has WON");
            else
               System.out.println("It's a tie!");
            break;
         }
      
      }
   }
   
   
   
  
}