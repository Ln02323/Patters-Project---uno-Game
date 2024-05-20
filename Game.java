import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Game class represet a game it holds a list of draw pile cards and a list of
 * players
 *
 * @author sevda imany
 * @version 0.0
 */
public class Game {

    private LinkedList<Card> cards;
    private ArrayList<Player> players;
    private int numplayers;
    private CardBuilderDirector cardDirector;
    private ScoreCalculator scoreCalculator = ScoreCalculator.getInstance();
    private GameContext context;

    /**
     * get draw pile cards
     *
     * @return LinkedList<Card>
     */
    public LinkedList<Card> getCards() {
        return cards;
    }

    /**
     * get a list of all players
     *
     * @return ArrayList<Player>
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    public CardBuilderDirector getCardDirector() {
        return cardDirector;
    }

    /**
     * creat a new game
     */
    public Game() {
        cards = new LinkedList<Card>();
        players = new ArrayList<Player>();
        this.cardDirector = new CardBuilderDirector(new CardBuilder());
        this.context = new GameContext();
        this.context.setGame(this);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * this method play uno game
     *
     * @param choose 1 for playing online and 2 for playing with friends
     */
    public void game(int choose) {
        PlaygroundFacade playgroundFacade = new PlaygroundFacade();
        int playerTurn = 0;
        int turn = 0;
        context.startGame();
        if (cardDirector.constructSpecialCard(cards.getFirst().getDigital(), cards.getFirst().getColor(), 0, 0, cards.getFirst().getReverse()).getReverse() == 1)
            turn = 1;
        else if (cardDirector.constructSpecialCard(cards.getFirst().getDigital(), cards.getFirst().getColor(), cards.getFirst().getSkip(), 0, 0).getSkip() == 1)
            playerTurn++;

        else if (cardDirector.constructSpecialCard(cards.getFirst().getDigital(), cards.getFirst().getColor(), 0, cards.getFirst().getTakeTwo(), 0).getTakeTwo() == 1) {
            for (int i = 0; i < 2; i++) {
                players.get(playerTurn).getCards().add(cards.getLast());
                cards.removeLast();
            }
        }
        playgroundFacade.printPlayground(players, cards, turn, playerTurn, choose);

        int m = 0;

        while (true) {
            try {

                if (m > 10 && m < 20) {
                    for (int i = 0; i < 4 * (m - 10); i++) {
                        players.get(playerTurn).getCards().add(cards.getLast());
                        cards.removeLast();
                    }
                    if (turn == 0) {
                        playerTurn++;
                        if (playerTurn == numplayers)
                            playerTurn = 0;
                    } else if (turn == 1) {

                        playerTurn--;
                        if (playerTurn == -1)
                            playerTurn = numplayers - 1;
                    }
                    m = 1;

                    clearScreen();
                    playgroundFacade.printPlayground(players, cards, turn, playerTurn, choose);
                } else if (m > 20 && m < 30) {
                    for (int i = 0; i < 2 * (m - 20); i++) {
                        players.get(playerTurn).getCards().add(cards.getLast());
                        cards.removeLast();
                    }

                    clearScreen();
                    playgroundFacade.printPlayground(players, cards, turn, playerTurn, choose);
                } else if (m == 4) {
                    for (int i = 0; i < 4; i++) {
                        players.get(playerTurn).getCards().add(cards.getLast());
                        cards.removeLast();
                    }
                    if (turn == 0) {
                        playerTurn++;
                        if (playerTurn == numplayers)
                            playerTurn = 0;
                    } else if (turn == 1) {
                        playerTurn--;
                        if (playerTurn == -1)
                            playerTurn = numplayers - 1;
                    }
                    m = 1;

                    clearScreen();
                    playgroundFacade.printPlayground(players, cards, turn, playerTurn, choose);
                }

                if (m == 5) {
                    for (int i = 0; i < 2; i++) {
                        players.get(playerTurn).getCards().add(cards.getLast());
                        cards.removeLast();
                    }

                    clearScreen();
                    playgroundFacade.printPlayground(players, cards, turn, playerTurn, choose);
                }

                m = choose(playerTurn, choose);

                if (m == 0) {
                    if (turn == 0)
                        turn = 1;
                    else
                        turn = 0;
                    m = 1;

                } else if (m == -1) {
                    players.get(playerTurn).getCards().add(cards.getLast());
                    cards.removeLast();
                    m = 1;
                } else if (m == 3) {

                    if (turn == 0) {
                        playerTurn++;
                        if (playerTurn == numplayers)
                            playerTurn = 0;
                    } else if (turn == 1) {
                        playerTurn--;
                        if (playerTurn == -1)
                            playerTurn = numplayers - 1;
                    }
                    m = 1;
                }

                if (turn == 0) {
                    playerTurn++;
                    if (playerTurn == numplayers)
                        playerTurn = 0;
                } else if (turn == 1) {
                    playerTurn--;
                    if (playerTurn == -1)
                        playerTurn = numplayers - 1;
                }

                TimeUnit.SECONDS.sleep(4);
                clearScreen();
                playgroundFacade.printPlayground(players, cards, turn, playerTurn, choose);

                if (context.checkEndOfGame()) {
                    winner();
                    return;
                }

            } catch (InterruptedException e) {
                System.out.println("Error");
            }
        }
    }

    /**
     * this method is for the first of a game and add 108 cards of a game to the
     * cards list
     */
    public void addAllCards() {
        for (int j = 0; j < 2; j++) {
            for (int i = 1; i < 10; i++) {
                cards.add(new Card(i, "red", 0, 0, 0, 0, 0));
            }
        }

        for (int j = 0; j < 2; j++) {
            for (int i = 1; i < 10; i++) {
                cards.add(new Card(i, "blue", 0, 0, 0, 0, 0));
            }
        }

        for (int j = 0; j < 2; j++) {
            for (int i = 1; i < 10; i++) {
                cards.add(new Card(i, "yellow", 0, 0, 0, 0, 0));
            }
        }

        for (int j = 0; j < 2; j++) {
            for (int i = 1; i < 10; i++) {
                cards.add(new Card(i, "green", 0, 0, 0, 0, 0));
            }
        }

        String color = null;
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 4; k++) {
                if (k == 0)
                    color = "red";
                else if (k == 1)
                    color = "blue";
                else if (k == 2)
                    color = "yellow";
                else if (k == 3)
                    color = "green";
                for (int i = 0; i < 3; i++) {
                    int n = 0;
                    int m = 0;
                    int l = 0;
                    if (i == 0)
                        n = 1;
                    else if (i == 1)
                        m = 1;
                    else if (i == 2)
                        l = 1;
                    cards.add(new Card(-1, color, n, m, l, 0, 0));
                }
            }
        }

        for (int i = 0; i < 4; i++)
            cards.add(new Card(-1, "black", 0, 0, 0, 1, 0));

        for (int i = 0; i < 4; i++)
            cards.add(new Card(-1, "black", 0, 0, 0, 0, 1));

        for (int i = 0; i < 4; i++) {
            if (i == 0)
                color = "red";
            else if (i == 1)
                color = "blue";
            else if (i == 2)
                color = "yellow";
            else if (i == 3)
                color = "green";

            cards.add(new Card(0, color, 0, 0, 0, 0, 0));
        }
    }

    /**
     * this method ask user that wants to play with how many player
     *
     * @return number of players
     */
    public int numPlayers() {
        Scanner sc = new Scanner(System.in);
        clearScreen();
        System.out.println("\n\n\t\t\t\t\t\t\t\t\t\t   " + ConsoleColors.YELLOW_BOLD_BRIGHT
                + "Please choose a number of players:(2 < n < 6)" + ConsoleColors.RESET);
        int numPlayer = sc.nextInt();
        this.numplayers = numPlayer;
        return numPlayer;
    }

    /**
     * this method choose a card for each player
     *
     * @param player
     * @param chooseMenu if 1 play online and if 2 play with friends and ask each
     *                   player which card wants to choose
     * @return -1 if player can not play with his cards , 0 if the chosen card is
     *         reverse, 3 if the chosen card is skip ,4 if the chosen card is
     *         wildcard+4 and didnt com on another +4 5 if the chosen card is +2 and
     *         didnt come on another +2 , a number between 20 and 30 if the chosen
     *         card is +2 and come on another +2 (a num of +2 come on each other is
     *         n -20) a number between 10 and 20 if the chosen cards is +4 and come
     *         on another +4 (a num of +4 come on each other is (n -10) ) otherwise
     *         return 1
     */
    private int choose(int player, int chooseMenu) {
        if (chooseMenu == 1) {
            if (player == 0) {
                int n = playYourTurn(0);
                return n;
            } else {
                Iterator<Card> it = players.get(player).getCards().iterator();
                Random random = new Random();
                String[] colors = {"red", "blue", "green", "yellow"};
                String color = colors[random.nextInt(4)];

                if (cardDirector.constructBlackCard4(cards.getFirst().getBlackActive4()).getBlackActive4() == 1) {
                    while (it.hasNext()) {
                        Card card = it.next();
                        if (cardDirector.constructBlackCard4(card.getBlackActive4()).getBlackActive4() == 1) {
                            int n = 10;
                            cards.addFirst(card);
                            players.get(player).getCards().remove(card);
                            cards.getFirst().setColor(color);
                            Iterator<Card> it5 = cards.iterator();
                            while (it5.hasNext()) {
                                if (cardDirector.constructBlackCard4(it5.next().getBlackActive4()).getBlackActive4() == 1) {
                                    n++;
                                } else {
                                    break;
                                }
                            }
                            return n;
                        }
                    }
                } else if (cardDirector.constructSpecialCard(cards.getFirst().getDigital(), cards.getFirst().getColor(), 0, cards.getFirst().getTakeTwo(), 0).getTakeTwo() == 1) {
                    it = players.get(player).getCards().iterator();
                    while (it.hasNext()) {
                        Card card = it.next();
                        if (cardDirector.constructSpecialCard(card.getDigital(), card.getColor(), 0, card.getTakeTwo(), 0).getTakeTwo() == 1) {
                            int n = 20;
                            cards.addFirst(card);
                            players.get(player).getCards().remove(card);
                            Iterator<Card> it6 = cards.iterator();
                            while (it6.hasNext()) {
                                if (cardDirector.constructSpecialCard(it6.next().getDigital(), it6.next().getColor(), 0, it6.next().getTakeTwo(), 0).getTakeTwo() == 1) {
                                    n++;
                                } else {
                                    break;
                                }
                            }
                            return n;
                        }
                    }
                } else if (cardDirector.constructSpecialCard(cards.getFirst().getDigital(), cards.getFirst().getColor(), cards.getFirst().getSkip(), 0, 0).getSkip() == 1) {
                    it = players.get(player).getCards().iterator();
                    while (it.hasNext()) {
                        Card card = it.next();
                        if (cardDirector.constructSpecialCard(card.getDigital(), card.getColor(), card.getSkip(), 0, 0).getSkip() == 1) {
                            cards.addFirst(card);
                            players.get(player).getCards().remove(card);
                            return 3;
                        }
                    }
                } else if (cardDirector.constructSpecialCard(cards.getFirst().getDigital(), cards.getFirst().getColor(), 0, 0, cards.getFirst().getReverse()).getReverse() == 1) {
                    it = players.get(player).getCards().iterator();
                    while (it.hasNext()) {
                        Card card = it.next();
                        if (cardDirector.constructSpecialCard(card.getDigital(), card.getColor(), 0, 0, card.getReverse()).getReverse() == 1) {
                            cards.addFirst(card);
                            players.get(player).getCards().remove(card);
                            return 0;
                        }
                    }
                } else {
                    it = players.get(player).getCards().iterator();
                    while (it.hasNext()) {
                        Card card = it.next();
                        if (cardDirector.constructCard(card.getDigital(), card.getColor()).getDigital() >= 0 &&
                                cardDirector.constructCard(card.getDigital(), card.getColor()).getDigital() ==
                                        cardDirector.constructCard(cards.getFirst().getDigital(), cards.getFirst().getColor()).getDigital()) {
                            cards.addFirst(card);
                            players.get(player).getCards().remove(card);
                            return 1;
                        }

                        if (cardDirector.constructCard(card.getDigital(), card.getColor()).getColor().equals(
                                cardDirector.constructCard(cards.getFirst().getDigital(), cards.getFirst().getColor()).getColor())) {
                            cards.addFirst(card);
                            players.get(player).getCards().remove(card);
                            if (cardDirector.constructSpecialCard(cards.getFirst().getDigital(), cards.getFirst().getColor(), 0, 0, cards.getFirst().getReverse()).getReverse() == 1)
                                return 0;
                            else if (cardDirector.constructSpecialCard(cards.getFirst().getDigital(), cards.getFirst().getColor(), cards.getFirst().getSkip(), 0, 0).getSkip() == 1)
                                return 3;
                            else if (cardDirector.constructSpecialCard(cards.getFirst().getDigital(), cards.getFirst().getColor(), 0, cards.getFirst().getTakeTwo(), 0).getTakeTwo() == 1)
                                return 5;
                            else
                                return 1;
                        }
                    }
                }
                it = players.get(player).getCards().iterator();
                while (it.hasNext()) {
                    Card card = it.next();
                    if (cardDirector.constructBlackCard(card.getBlackActive()).getBlackActive() == 1) {
                        cards.addFirst(card);
                        players.get(player).getCards().remove(card);
                        cards.getFirst().setColor(color);
                        return 1;
                    }
                }
                it = players.get(player).getCards().iterator();
                while (it.hasNext()) {
                    Card card = it.next();
                    if (cardDirector.constructBlackCard4(card.getBlackActive4()).getBlackActive4() == 1) {
                        cards.addFirst(card);
                        players.get(player).getCards().remove(card);
                        cards.getFirst().setColor(color);
                        return 4;
                    }
                }
                return -1;
            }
        } else {
            int n = playYourTurn(player);
            return n;
        }
    }

    /**
     * this method check if the chosen card is acceptable or not
     * @param numCard
     * @param player
     * @return {@code true} if the chosen card is acceptable otherwise return {@code false}
     */
    private boolean check(int numCard, int player) {
        Card currentPlayerCard = players.get(player).getCards().get(numCard);
        Card topCard = cards.getFirst();

        if (cardDirector.constructBlackCard4(currentPlayerCard.getBlackActive4()).getBlackActive4() == 1 &&
                cardDirector.constructBlackCard4(topCard.getBlackActive4()).getBlackActive4() == 1)
            return true;
        else if (cardDirector.constructBlackCard4(currentPlayerCard.getBlackActive4()).getBlackActive4() == 1 ||
                cardDirector.constructBlackCard(currentPlayerCard.getBlackActive()).getBlackActive() == 1) {
            if (!check(player))
                return true;
        }
        if (cardDirector.constructSpecialCard(currentPlayerCard.getDigital(), currentPlayerCard.getColor(), 0, 0, currentPlayerCard.getReverse()).getReverse() == 1 &&
                cardDirector.constructSpecialCard(topCard.getDigital(), topCard.getColor(), 0, 0, topCard.getReverse()).getReverse() == 1)
            return true;
        else if (cardDirector.constructSpecialCard(currentPlayerCard.getDigital(), currentPlayerCard.getColor(), 0, currentPlayerCard.getTakeTwo(), 0).getTakeTwo() == 1 &&
                cardDirector.constructSpecialCard(topCard.getDigital(), topCard.getColor(), 0, topCard.getTakeTwo(), 0).getTakeTwo() == 1)
            return true;
        else if (cardDirector.constructSpecialCard(currentPlayerCard.getDigital(), currentPlayerCard.getColor(), currentPlayerCard.getSkip(), 0, 0).getSkip() == 1 &&
                cardDirector.constructSpecialCard(topCard.getDigital(), topCard.getColor(), topCard.getSkip(), 0, 0).getSkip() == 1)
            return true;
        else if (cardDirector.constructCard(currentPlayerCard.getDigital(), currentPlayerCard.getColor()).getDigital() >= 0 &&
                cardDirector.constructCard(currentPlayerCard.getDigital(), currentPlayerCard.getColor()).getDigital() ==
                        cardDirector.constructCard(topCard.getDigital(), topCard.getColor()).getDigital())
            return true;
        else if (cardDirector.constructCard(currentPlayerCard.getDigital(), currentPlayerCard.getColor()).getColor().equals(
                cardDirector.constructCard(topCard.getDigital(), topCard.getColor()).getColor()))
            return true;

        return false;
    }

    /**
     * this method check if the player can play with his cards or not
     * @param player
     * @return {@code true} if the player has a choice to play otherwise return {@code false}
     */
    // Method to check if the player can play with his cards or not
    private boolean check(int player) {
        int n = players.get(player).getCards().size();
        Card topCard = cards.getFirst();

        List<PlayableStrategy> strategies = Arrays.asList(
                new ReverseStrategy(),
                new TakeTwoStrategy(),
                new SkipStrategy(),
                new DigitalStrategy(),
                new ColorStrategy()
        );

        for (int i = 0; i < n; i++) {
            Card playerCard = players.get(player).getCards().get(i);

            for (PlayableStrategy strategy : strategies) {
                if (strategy.canPlay(playerCard, topCard, cardDirector)) {
                    return true;
                }
            }
        }

        return false;
    }


    /**
     * this method check if the player can play with his cards or not
     * @param player
     * @return {@code true} if the player has a choice to play otherwise return {@code false}
     */
    private boolean checkPlay(int player) {
        int n = players.get(player).getCards().size();
        for (int i = 0; i < n; i++) {
            Card card = players.get(player).getCards().get(i);
            if (cardDirector.constructBlackCard(card.getBlackActive()).getBlackActive() == 1 ||
                    cardDirector.constructBlackCard4(card.getBlackActive4()).getBlackActive4() == 1) {
                return true;
            }
        }

        if (check(player))
            return true;

        return false;
    }

    /**
     * this method sum all players scores and print winner
     */
    private void winner() {
        ArrayList<Integer> scores = new ArrayList<Integer>();
        int numPlayers = players.size();
        for (int i = 0; i < numPlayers; i++) {
            int numPlayerCards = players.get(i).getCards().size();
            int sum = 0;
            for (int j = 0; j < numPlayerCards; j++) {
                sum += scoreCalculator.calculateScore(players.get(i).getCards().get(j));
            }
            scores.add(sum);
        }
        scoreCalculator.printScores(players, scores);
        ArrayList<Integer> numwinners = new ArrayList<Integer>();
        int min = Collections.min(scores);
        for (int i = 0; i < numPlayers; i++) {
            if (min == scores.get(i))
                numwinners.add(i);
        }

        System.out.print("\n\n\t\t\t\t\t\t\t\t\t\t   ");
        for (int i = 0; i < numwinners.size(); i++) {
            System.out.print(ConsoleColors.PURPLE_BOLD_BRIGHT + "player" + (numwinners.get(i) + 1) + ", ");
        }
        System.out.println("win the game." + ConsoleColors.RESET);
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

    /**
     * this method give each card a score
     * @param card
     * @return score of given card
     */


    /**
     * this method ask player to choose a card to play and check that the card be acceptable
     * @param player
     * @return -1 if player can not play with his cards , 0 if the chosen card is
     *         reverse, 3 if the chosen card is skip ,4 if the chosen card is
     *         wildcard+4 and didnt com on another +4 5 if the chosen card is +2 and
     *         didnt come on another +2 , a number between 20 and 30 if the chosen
     *         card is +2 and come on another +2 (a num of +2 come on each other is
     *         n -20) a number between 10 and 20 if the chosen cards is +4 and come
     *         on another +4 (a num of +4 come on each other is (n -10) ) otherwise
     *         return 1
     */
    private int playYourTurn(int player) {
        if (checkPlay(player) == false)
            return -1;

        Scanner sc = new Scanner(System.in);
        System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + "please choose your card: " + ConsoleColors.RESET);
        int choose = sc.nextInt();
        while (!check(choose - 1, player)) {
            System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + "please choose another card: " + ConsoleColors.RESET);
            choose = sc.nextInt();
        }

        cards.addFirst(players.get(player).getCards().get(choose - 1));
        players.get(player).getCards().remove(choose - 1);
        if (cards.getFirst().getBlackActive4() == 1 || cards.getFirst().getBlackActive() == 1) {
            sc.nextLine();
            System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + "Please choose a color: " + ConsoleColors.RESET);
            String color = sc.nextLine();
            cards.getFirst().setColor(color);
        }

        if (cards.getFirst().getReverse() == 1)
            return 0;
        else if (cards.getFirst().getBlackActive4() == 1 && cards.get(1).getBlackActive4() == 1) {
            int n = 10;
            Iterator<Card> it5 = cards.iterator();
            while (it5.hasNext()) {
                if (it5.next().getBlackActive4() == 1) {
                    n++;
                } else
                    break;
            }
            return n;
        } else if (cards.getFirst().getTakeTwo() == 1 && cards.get(1).getTakeTwo() == 1) {
            int n = 20;
            Iterator<Card> it6 = cards.iterator();
            while (it6.hasNext()) {
                if (it6.next().getTakeTwo() == 1) {
                    n++;
                } else
                    break;
            }
            return n;
        } else if (cards.getFirst().getSkip() == 1)
            return 3;
        else if (cards.getFirst().getTakeTwo() == 1) {
            return 5;
        } else if (cards.getFirst().getBlackActive4() == 1)
            return 4;
        else
            return 1;

    }
}
