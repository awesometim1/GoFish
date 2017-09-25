//Coded by Zach Richey
import java.util.List;
public class Player
{
   private List<Card> hand;
   private int pairs;
   
   public Player(List<Card> dealtHand)
   {
      hand = dealtHand;
      pairs = 0;
   }
   
   //Checks the player's hand and returns true if they have a card eith the given rank
   public boolean hasa(String rank)
   {
      for(Card c: hand)
         if(c.getRank().equals(rank))
            return true;
      return false;
   }
   
   //Checks the player's hand for a pair.  Puts one card 
   public void checkPairInitial()
   {
      for(int i = 0; i < hand.size() - 1; i ++)
         for(int j = i + 1; j < hand.size(); j ++)
            if(hand.get(i).matches.hand.get(j))
            {
               pairs ++;
               hand.remove(j);
               hand.remove(i);
            }
   }
   
   public void checkPair()
   {
      for(int i = 0; i < hand.size() - 1; i ++)
         if(hand.get(i).matches(hand.get(hand.size() - 1)))
         {
            pairs ++;
            hand.remove(hand.size() - 1);
            hand.remove(i);
         }
   }
}//end Player