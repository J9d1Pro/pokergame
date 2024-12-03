import java.util.*;

public class PokerBoard {
    private final List<Card> boardCards = new ArrayList<>();

    public void addCard(Card card) {
        if (boardCards.size() >= 5) {
            throw new IllegalStateException("Poker board already has 5 cards.");
        }
        boardCards.add(card);
    }

    public List<Card> getBoardCards() {
        return boardCards;
    }

    public void clearBoard() {
        boardCards.clear();
    }

    public boolean isValid() {
        // Проверка на наличие пустых карт на доске (некорректные карты)
        return boardCards.size() == 5;
    }
}