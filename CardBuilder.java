// CardBuilder.java
public class CardBuilder {
    private int digital = -1;
    private String color = "black";
    private int skip = 0;
    private int takeTwo = 0;
    private int reverse = 0;
    private int blackActive = 0;
    private int blackActive4 = 0;

    public CardBuilder setDigital(int digital) {
        this.digital = digital;
        return this;
    }

    public CardBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public CardBuilder setSkip(int skip) {
        this.skip = skip;
        return this;
    }

    public CardBuilder setTakeTwo(int takeTwo) {
        this.takeTwo = takeTwo;
        return this;
    }

    public CardBuilder setReverse(int reverse) {
        this.reverse = reverse;
        return this;
    }

    public CardBuilder setBlackActive(int blackActive) {
        this.blackActive = blackActive;
        return this;
    }

    public CardBuilder setBlackActive4(int blackActive4) {
        this.blackActive4 = blackActive4;
        return this;
    }

    public Card build() {
        return new Card(digital, color, skip, takeTwo, reverse, blackActive, blackActive4);
    }
}
