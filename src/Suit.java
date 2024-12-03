public enum Suit {
    HEARTS, DIAMONDS, CLUBS, SPADES;

    @Override
    public String toString() {
        switch(this) {
            case HEARTS: return "Hearts";
            case DIAMONDS: return "Diamonds";
            case CLUBS: return "Clubs";
            case SPADES: return "Spades";
            default: return super.toString();
        }
    }
}


