import java.util.List;
import java.util.ArrayList;

public class Dealer {

    private Deck deck;

    public Dealer() {
        deck = new Deck();
    }

    // Метод для раздачи карт нескольким игрокам
    public void dealHands(List<Player> players, int numberOfCards) {
        for (Player player : players) {
            List<Card> hand = new ArrayList<>();
            for (int i = 0; i < numberOfCards; i++) {
                Card card = deck.dealCard();
                if (card != null) {
                    hand.add(card);
                }
            }
            player.setHand(hand);
        }
    }

    // Метод для раздачи карт на стол (флоп, терн, ривер)
    public List<Card> dealBoard() {
        List<Card> board = new ArrayList<>();

        // Флоп (3 карты)
        for (int i = 0; i < 3; i++) {
            Card card = deck.dealCard();
            if (card != null) {
                board.add(card);
            }
        }

        // Терн (1 карта)
        Card turn = deck.dealCard();
        if (turn != null) {
            board.add(turn);
        }

        // Ривер (1 карта)
        Card river = deck.dealCard();
        if (river != null) {
            board.add(river);
        }

        return board;
    }

    // Проверка корректности доски
    public void validateBoard(List<Card> board) throws InvalidPokerBoardException {
        if (board.size() != 5) {
            throw new InvalidPokerBoardException("Invalid board. There should be exactly 5 cards (flop, turn, and river).");
        }
    }

    // Метод для определения победителя
    public void determineWinner(List<Player> players, List<Card> board) {
        Player winner = null;
        int highestCardValue = 0;

        for (Player player : players) {
            List<Card> allCards = new ArrayList<>(player.getHand());
            allCards.addAll(board);

            // Для простоты, мы просто находим самую старшую карту
            Card bestCard = allCards.get(0);
            for (Card card : allCards) {
                if (card.getValue() > bestCard.getValue()) {
                    bestCard = card;
                }
            }

            if (bestCard.getValue() > highestCardValue) {
                highestCardValue = bestCard.getValue();
                winner = player;
            }
        }

        // Печатаем победителя
        if (winner != null) {
            System.out.println("The winner is: " + winner.getName());
        } else {
            System.out.println("It's a tie!");
        }
    }
}



