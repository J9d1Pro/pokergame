import java.util.List;
import java.util.ArrayList;

public class PokerGame {
    public static void main(String[] args) {
        try {
            // Создаем дилера
            Dealer dealer = new Dealer();

            // Создаем игроков
            Player player1 = new Player("Player 1");
            Player player2 = new Player("Player 2");
            Player player3 = new Player("Player 3");

            // Добавляем игроков в список
            List<Player> players = new ArrayList<>();
            players.add(player1);
            players.add(player2);
            players.add(player3);

            // Раздаем каждому игроку 2 карты
            dealer.dealHands(players, 2);

            // Печатаем руки игроков
            for (Player player : players) {
                System.out.println(player);
            }

            // Раздаем карты на доску (флоп, терн, ривер)
            List<Card> board = dealer.dealBoard();
            System.out.println("Board: " + board);

            // Определение победителя
            dealer.validateBoard(board);
            dealer.determineWinner(players, board);

        } catch (InvalidPokerBoardException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
