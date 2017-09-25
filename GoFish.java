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
      int[] pointValues52 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
      dMain = new Deck(ranks52, suits52, pointValues52);
      dMain.shuffle();
   
   
   
   }
   
   
   public static void initialize(){
      Player robot = new Player();
      Player user = new Player();
      for (int i = 0; i < 5; i ++){
      robot.hand.add(dMain.deal());
      user.hand.add(dMain.deal());
      }
      }
   public static void turn(){
   boolean turn = false;
   if false
      player
      turn true
   else 
      robot 
   
   }
   }
}