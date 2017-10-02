//Handsomely coded by Tim Lee and Anna Herms
//Passive agressively tweaked by Zach Richey
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
      
      
      
      robot = new Player(dMain.deal(5));
      human = new Player(dMain.deal(5));
      
      turn();
   
   
   }
   
   public static void turn(){
      human.checkPairInitial();
      robot.checkPairInitial();
      human.showHand();//prints your cards
      Scanner in = new Scanner(System.in);
      while (true){
      
      
      //Human Behavior
         
         System.out.println("Your pairs: " + human.pairs);
         System.out.println("Robot's pairs: " + robot.pairs);
      
         System.out.println("\nEnter a card that you have and want to ask for.");
         String input = in.next();
         
         if (human.indexOf(input) <= -1)
            while (true){
               System.out.println("You do not have that card. Enter another card");
               input = in.next();
               if (human.indexOf(input) > -1)
                  break;
            }
         human.askHuman(input, robot, dMain);
         human.checkPairHuman();
         human.showHand();
      
      //Check if no remaining cards
         if (human.hand.size() < 1 ){
            if (human.pairs > robot.pairs)
               System.out.println("Human has WON!");
            else if (human.pairs < robot.pairs)
               System.out.println("Robot has WON");
            else
               System.out.println("It's a tie!");
            break;
         }
      //Robot Behavior
         int rand = (int)(Math.random() * robot.hand.size());
         robot.askBot(robot.hand.get(rand).getRank(), human, dMain);
         //robot.checkPairBot();
         
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
