
/**
 * Anna Herms, Zach Richey, Tim Lee
 * Edited for GO FISH
 */
public class Card 
{

	private String suit;//String value that holds the suit of the card

	private String rank;//String value that holds the rank of the card

	public Card(String cardRank, String cardSuit) 
   {
		suit = cardSuit;
      rank = cardRank;
  	}

	public String getSuit() 
   {
		return this.suit;
   }

	public String getRank() 
   {
		return this.rank;
   }
   
   public boolean matches(Card otherCard) 
   {
      if((this.rank).compareTo(otherCard.getRank())!= 0)
         return false;
      else 
         return true;
	}

	@Override
	public String toString() 
   {
		return this.rank + " of " + this.suit;
	}

}
