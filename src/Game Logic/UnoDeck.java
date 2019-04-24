/* Author: Jacob Villarreal */

import java.util.*;

/* Represents the deck in Uno */
public class UnoDeck extends UnoCardPile
{
	/* Constructor. Creates the cards needed for the pile
	 * to be a standard 108 card Uno deck. */
	public void UnoDeck()
	{
		/* Green, Red, Yellow, and Blue cards */
		for (int color = UnoCard.green; 
		     color <= UnoCard.blue;
		     ++color)
		{
			/* One 0, two 1-9 and specials. */
			this.cards.add(new Card(0, color));
			
			for (int type = 1;
			     type <= UnoCard.drawTwo;
			     ++type)
			{
				this.cards.add(new Card(type, color)); 
			}
		}
		
		/* 4 of each kind of wild card */
		for (int counter = 1;
		     counter <= 4;
		     ++counter)
		{
			this.cards.add(new Card(UnoCard.wildCard, UnoCard.wildColor));
			this.cards.add(new Card(UnoCard.wildDrawFour, UnoCard.wildColor));
		}
	}

	/* Wrapper functions */
	public UnoCard drawTopCard()
	{
		return this.cards.pollFirst();
	}
	
	public void shuffle()
	{
		Collections.shuffle(this.cards);
	}

	/* Used when cards are added from the discard pile
	 * to replenish the deck. */
	public void replenishDeck(LinkedList<UnoCard> newDeck)
	{
		this.cards = newDeck;
		this.shuffle();		
	}
}