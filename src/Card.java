public class Card {
    private Suit suit;  // Масть (перечисление Suit)
    private String rank; // Ранг карты (2, 3, 4, ..., J, Q, K, A)

    public Card(Suit suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    // Получаем строковое представление карты (например, "2 of Hearts")
    @Override
    public String toString() {
        return rank + " of " + suit.toString();  // Используем toString() перечисления для масти
    }

    // Получаем числовое значение карты для упрощения сравнения
    public int getValue() {
        switch (rank) {
            case "2": return 2;
            case "3": return 3;
            case "4": return 4;
            case "5": return 5;
            case "6": return 6;
            case "7": return 7;
            case "8": return 8;
            case "9": return 9;
            case "10": return 10;
            case "J": return 11;
            case "Q": return 12;
            case "K": return 13;
            case "A": return 14;
            default: return 0; // На случай некорректной карты
        }
    }
}

