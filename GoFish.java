//Handsomely coded by Tim Lee

import java.util.ArrayList;
import java.util.List;

public class GoFish{

   private static Deck dMain;


   public static void main(String[]args){
      //initialize deck
      String[] ranks52 =
         {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
      String[] suits52 =
         {"spades", "hearts", "diamonds", "clubs"};
      dMain = new Deck(ranks52, suits52);
      dMain.shuffle();
      
      
      
      Player robot = new Player(dMain.deal(5));
      Player human = new Player(dMain.deal(5));
   
   
   }
   
   public void turn(){
      human.checkPairInitial();
      robot.checkPairInitial();
      Scanner in = new Scanner(System.in);
      while (true){
      
      //Human Behavior
         System.out.println("Enter a card to ask numbers 1 - 13");
         int input = in.nextInt();
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
         int rand = (int)(Math.Random() * 13 + 1);
         robot.ask(rand, human, dMain);
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
