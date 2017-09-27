
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

	public String getSuit() //returns suit of card(diamonds, hearts, clubs, spades)
   {
		return this.suit;
   }

	public String getRank() //returns rank of card(aces,2,3,...,jack, queen, king)
   {
		return this.rank;
   }
   
   public boolean matches(Card otherCard) //checks to see if two cards have the same rank
   {
      if((this.rank).compareTo(otherCard.getRank())!= 0)
         return false;
      else 
         return true;
	}

	@Override
	public String toString() //outputs card rank and suit in a sentence
   {
		return this.rank + " of " + this.suit;
	}

}
