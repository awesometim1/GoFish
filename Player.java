//Coded by Zach Richey
import java.util.List;
public class Player
{
   List<Card> hand;
   private int pairs;
   
   public Player(List<Card> dealtHand)
   {
      hand = dealtHand;
      pairs = 0;
   }
   
   //Checks the player's hand and returns the index of a card with the given rank
   public int indexOf(String rank)
   {
      for(int i = 0; i < hand.size(); i ++)
         if(hand.get(i).getRank().equals(rank))
            return i;
       return -1;
    }
   
   //Checks the player's whole hand for a pair. Increments pair and removes cards if one is found
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
   
   //Just like checkPairInitial but only checks if there is a pair involving the last card
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
   
   //Prints the player's current hand
   public void showHand()
   {
      for(Card c: hand)
         System.out.println(c);
   }
   
   //Adds a card to hand
   //public void add(Card c)
   //{
   //   hand.add(c);
   //}
   
   //Adds a card of the given rank from hand to p.hand. Removes the card from hand
   public void giveCard(String rank, Player p)
   {
      p.add(this.hand.get(this.indexOf(rank));
      this.hand.remove(this.indexOf(rank));
   }
            
   //Asks other player for a card
   public void ask(String rank, Player p, Deck d)
   {
      if(p.indexOf(rank) > -1)
      {
         this.hand.add(p.hand.get(p.indexOf(rank)));
         p.hand.remove(p.indexOf(rank));
      }
      else
      {
         this.hand.add(d.deal());
      }
   }
}//end Player
