class Card{
    int cardValue;
    String cardSuit;

    public Card(int cardVal, String cSuit){
        cardValue = cardVal;
        cardSuit = cSuit;
    }

    static Card makeCard(String cardArg){
        int cardNumber = 0;
        String cardSuit = "Error";

        if(cardArg.length() > 1){
            String lowerCardArg = cardArg.toUpperCase();
            char first = lowerCardArg.charAt(0);
            char second = lowerCardArg.charAt(1);
            
            if ((int) first == 49){
                if (cardArg.length() > 2){
                    if ((int) second > 47 && (int) second < 53){
                        if (lowerCardArg.charAt(2) == 'S'
                        || lowerCardArg.charAt(2) == 'H'
                        || lowerCardArg.charAt(2) == 'C'
                        || lowerCardArg.charAt(2) == 'D'){
                            cardSuit = Character.toString(lowerCardArg.charAt(2));
                            cardNumber = 10 + (int) second - 48;
                        }
                    }    
                }
                 
            }
            else if (first == 'J'){
                if (lowerCardArg.charAt(1) == 'S'
                || lowerCardArg.charAt(1) == 'H'
                || lowerCardArg.charAt(1) == 'C'
                || lowerCardArg.charAt(1) == 'D'){
                    cardSuit = Character.toString(lowerCardArg.charAt(1));
                    cardNumber = 11;
                }
            }
            else if (first == 'Q'){
                if (lowerCardArg.charAt(1) == 'S'
                || lowerCardArg.charAt(1) == 'H'
                || lowerCardArg.charAt(1) == 'C'
                || lowerCardArg.charAt(1) == 'D'){
                    cardSuit = Character.toString(lowerCardArg.charAt(1));
                    cardNumber = 12;
                }
            }
            else if (first == 'K'){
                if (lowerCardArg.charAt(1) == 'S'
                || lowerCardArg.charAt(1) == 'H'
                || lowerCardArg.charAt(1) == 'C'
                || lowerCardArg.charAt(1) == 'D'){
                    cardSuit = Character.toString(lowerCardArg.charAt(1));
                    cardNumber = 13;
                }
            }
            else if (first == 'A'){
                if (lowerCardArg.charAt(1) == 'S'
                || lowerCardArg.charAt(1) == 'H'
                || lowerCardArg.charAt(1) == 'C'
                || lowerCardArg.charAt(1) == 'D'){
                    cardSuit = Character.toString(lowerCardArg.charAt(1));
                    cardNumber = 14;
                }
            }
            else if (Integer.valueOf(Character.toString(first)) > 1 && Integer.valueOf(Character.toString(first)) < 10){
                if (lowerCardArg.charAt(1) == 'S'
                || lowerCardArg.charAt(1) == 'H'
                || lowerCardArg.charAt(1) == 'C'
                || lowerCardArg.charAt(1) == 'D'){
                    cardSuit = Character.toString(lowerCardArg.charAt(1));
                    cardNumber = Integer.valueOf(Character.toString(first));
                }
            }
        }

        Card myCard = new Card(cardNumber, cardSuit);
        return myCard;
    }
        
    static int Value(Card object){
        return object.cardValue;
    }

    static String Suit(Card object){
        String cardSuit = object.cardSuit;
        if (object.cardSuit == "spades" || object.cardSuit == "S"){
            cardSuit = "S";
        }
        if (object.cardSuit == "clubs" || object.cardSuit == "C"){
            cardSuit = "C";
        }
        if (object.cardSuit == "diamonds" || object.cardSuit == "D"){
            cardSuit = "D";
        }
        if (object.cardSuit == "hearts" || object.cardSuit == "H"){
            cardSuit = "H";
        }

        return cardSuit;
    }

    static String toString(Card object){
        int cardValue = Value(object);
        String valueString = "Error";
        if (cardValue < 11){
            valueString = Integer.toString(cardValue);
        }
        else if (cardValue == 11){
            valueString = "J";
        }
        else if (cardValue == 12){
            valueString = "Q";
        }
        else if (cardValue == 13){
            valueString = "K";
        }
        else if (cardValue == 14){
            valueString = "A";
        }
        
        String cardSuit = Suit(object);
        String returnString = valueString + cardSuit;
        return returnString;
    } 
}

class Deck{
    static Card allMyCards[] = new Card[52];

    static void initialize(){
    for (int i = 0; i<13; i++){
        allMyCards[i*4] = new Card(i+2, "spades");
        allMyCards[i*4+1] = new Card(i+2, "hearts");
        allMyCards[i*4+2] = new Card(i+2, "clubs");           
        allMyCards[i*4+3] = new Card(i+2, "diamonds");
        }
    }

    static String toString(Card[] allMyCards){
        String cardInfo;
        String allCardInfo = "";
        int i = 0;
        while (i < allMyCards.length){
            cardInfo = Card.toString(allMyCards[i]);
            allCardInfo += cardInfo + " ";
            i++;
        }
        return allCardInfo;
    }

    static void shuffle(){
    
    }
}

public class MyCardDeck {

    public static void main( String[] args){
        if (args.length > 0){
            Card myCard = Card.makeCard(args[0]);
            String myCardString = Card.toString(myCard);
            System.out.println(myCardString);
        }

        if (args.length == 0){
            Deck.initialize();
            Deck.shuffle();
            System.out.println(Deck.toString(Deck.allMyCards));
        }
        
    }
}