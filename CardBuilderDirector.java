public class CardBuilderDirector {
    private final CardBuilder builder;

    public CardBuilderDirector(CardBuilder builder) {
        this.builder = builder;
    }

    public Card constructCard(int digital, String color) {
        return builder.setDigital(digital)
                .setColor(color)
                .setSkip(0)
                .setTakeTwo(0)
                .setReverse(0)
                .setBlackActive(0)
                .setBlackActive4(0)
                .build();
    }

    public Card constructSpecialCard(int digital, String color, int skip, int takeTwo, int reverse) {
        return builder.setDigital(digital)
                .setColor(color)
                .setSkip(skip)
                .setTakeTwo(takeTwo)
                .setReverse(reverse)
                .setBlackActive(0)
                .setBlackActive4(0)
                .build();
    }

    public Card constructBlackCard(int blackActive) {
        return builder.setDigital(-1)
                .setColor("black")
                .setSkip(0)
                .setTakeTwo(0)
                .setReverse(0)
                .setBlackActive(blackActive)
                .setBlackActive4(0)
                .build();
    }

    public Card constructBlackCard4(int blackActive4) {
        return builder.setDigital(-1)
                .setColor("black")
                .setSkip(0)
                .setTakeTwo(0)
                .setReverse(0)
                .setBlackActive(0)
                .setBlackActive4(blackActive4)
                .build();
    }
}
