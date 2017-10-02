//Coded by Zach Richey and Anna Herms
import java.util.List;
public class Player
{
   public List<Card> hand;
   public int pairs;
   
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
      for(int i = 0; i < hand.size() - 1; i ++){
         for(int j = i + 1; j < hand.size(); j ++){
            if(hand.get(i).matches(hand.get(j)))
            {
               pairs ++;
               hand.remove(j);
               hand.remove(i);
               i = 0;
               j = 1;
            }
         }
      }
   }
   
   //Just like checkPairInitial but only checks if there is a pair involving the last card
   public void checkPairHuman()
   {
      for(int i = 0; i < hand.size() - 1; i ++)
         if(hand.get(i).matches(hand.get(hand.size() - 1)))
         {
            pairs ++;
            System.out.println("Good job! You got a pair of " + (hand.get(i)).getRank() + "s.");
            hand.remove(hand.size() - 1);
            hand.remove(i);
         }
   }
   
   public void checkPairBot()
   {
      for(int i = 0; i < hand.size() - 1; i ++)
         if(hand.get(i).matches(hand.get(hand.size() - 1)))
         {
            pairs ++;
            System.out.println("Robot got a pair of " + (hand.get(i)).getRank() + "s.");
            hand.remove(hand.size() - 1);
            hand.remove(i);
         }
   }
   
   //Prints the player's current hand
   public void showHand()
   {
      System.out.println("Your hand:");
      for(Card c: hand)
         System.out.println(c);
      System.out.println();
   }
   
   //Adds a card to hand
   //public void add(Card c)
   //{
   //   hand.add(c);
   //}
   
   //Adds a card of the given rank from hand to p.hand. Removes the card from hand
   public void giveCard(String rank, Player p)
   {
      p.hand.add(this.hand.get(this.indexOf(rank)));
      this.hand.remove(this.indexOf(rank));
   }
            
   //Asks other player for a card
   public void askHuman(String rank, Player p, Deck d)
   {
      if(p.indexOf(rank) > -1)
      {
         System.out.println("\nYou asked for a " + rank + ". You took robot's " + rank + ".");
         this.hand.add(p.hand.get(p.indexOf(rank)));
         p.hand.remove(p.indexOf(rank));
      }
      else
      {
       this.hand.add(d.deal());
       System.out.println("\nRobot did not have a " + rank + ". You drew a " + this.hand.get(hand.size()-1) + ".");
      }
   }
   
   public void askBot(String rank, Player p, Deck d)
    {
      if(p.indexOf(rank) > -1)
      {
         System.out.println("\nRobot asked for a " + rank + ". Robot took your " + rank + ".");
         this.hand.add(p.hand.get(p.indexOf(rank)));
         p.hand.remove(p.indexOf(rank));
         this.checkPairBot();
         p.showHand();
       }
      else
      {
         System.out.println("\nRobot asked for " + rank + ". You did not have a " + rank + ". Robot drew a card.");
         this.hand.add(d.deal());
         this.checkPairBot();
      }
   }
}//end Player
