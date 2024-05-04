
public class ConsoleColors {
   // Reset
    public static final String RESET = "\033[0m"; // Text Reset

    // Regular Colors
    public static final ColorAttribute BLACK = ColorAttributeFactory.getColor("\033[0;30m");
    public static final ColorAttribute RED = ColorAttributeFactory.getColor("\033[0;31m");
    public static final ColorAttribute GREEN = ColorAttributeFactory.getColor("\033[0;32m");
    public static final ColorAttribute YELLOW = ColorAttributeFactory.getColor("\033[0;33m");
    public static final ColorAttribute BLUE = ColorAttributeFactory.getColor("\033[0;34m");
    public static final ColorAttribute PURPLE = ColorAttributeFactory.getColor("\033[0;35m");
    public static final ColorAttribute CYAN = ColorAttributeFactory.getColor("\033[0;36m");
    public static final ColorAttribute WHITE = ColorAttributeFactory.getColor("\033[0;37m");


    // Bold
    public static final ColorAttribute BLACK_BOLD = ColorAttributeFactory.getColor("\033[1;30m"); // BLACK
    public static final ColorAttribute RED_BOLD = ColorAttributeFactory.getColor("\033[1;31m"); // RED
    public static final ColorAttribute GREEN_BOLD = ColorAttributeFactory.getColor("\033[1;32m"); // GREEN
    public static final ColorAttribute YELLOW_BOLD =ColorAttributeFactory.getColor("\033[1;33m") ; // YELLOW
    public static final ColorAttribute BLUE_BOLD = ColorAttributeFactory.getColor("\033[1;34m"); // BLUE
    public static final ColorAttribute PURPLE_BOLD = ColorAttributeFactory.getColor("\033[1;35m"); // PURPLE
    public static final ColorAttribute CYAN_BOLD = ColorAttributeFactory.getColor("\033[1;36m"); // CYAN
    public static final ColorAttribute WHITE_BOLD =ColorAttributeFactory.getColor("\033[1;37m"); // WHITE

    // Underline
    public static final ColorAttribute BLACK_UNDERLINED = ColorAttributeFactory.getColor("\033[4;30m"); // BLACK
    public static final ColorAttribute RED_UNDERLINED =ColorAttributeFactory.getColor("\033[4;31m") ; // RED
    public static final ColorAttribute GREEN_UNDERLINED = ColorAttributeFactory.getColor("\033[4;32m"); // GREEN
    public static final ColorAttribute YELLOW_UNDERLINED =ColorAttributeFactory.getColor("\033[4;33m") ; // YELLOW
    public static final ColorAttribute BLUE_UNDERLINED = ColorAttributeFactory.getColor("\033[4;34m"); // BLUE
    public static final ColorAttribute PURPLE_UNDERLINED =ColorAttributeFactory.getColor("\033[4;35m") ; // PURPLE
    public static final ColorAttribute CYAN_UNDERLINED = ColorAttributeFactory.getColor("\033[4;36m"); // CYAN
    public static final ColorAttribute WHITE_UNDERLINED =ColorAttributeFactory.getColor("\033[4;37m") ; // WHITE

    // Background
    public static final ColorAttribute BLACK_BACKGROUND = ColorAttributeFactory.getColor("\033[40m"); // BLACK
    public static final ColorAttribute RED_BACKGROUND = ColorAttributeFactory.getColor("\033[41m"); // RED
    public static final ColorAttribute GREEN_BACKGROUND = ColorAttributeFactory.getColor("\033[42m"); // GREEN
    public static final ColorAttribute YELLOW_BACKGROUND = ColorAttributeFactory.getColor("\033[43m"); // YELLOW
    public static final ColorAttribute BLUE_BACKGROUND =ColorAttributeFactory.getColor("\033[44m"); // BLUE
    public static final ColorAttribute PURPLE_BACKGROUND = ColorAttributeFactory.getColor("\033[45m"); // PURPLE
    public static final ColorAttribute CYAN_BACKGROUND = ColorAttributeFactory.getColor("\033[46m"); // CYAN
    public static final ColorAttribute WHITE_BACKGROUND =ColorAttributeFactory.getColor ("\033[47m"); // WHITE

    // High Intensity
    public static final ColorAttribute BLACK_BRIGHT =ColorAttributeFactory.getColor("\033[0;90m"); // BLACK
    public static final ColorAttribute RED_BRIGHT = ColorAttributeFactory.getColor("\033[0;91m"); // RED
    public static final ColorAttribute GREEN_BRIGHT = ColorAttributeFactory.getColor("\033[0;92m"); // GREEN
    public static final ColorAttribute YELLOW_BRIGHT = ColorAttributeFactory.getColor("\033[0;93m"); // YELLOW
    public static final ColorAttribute BLUE_BRIGHT =ColorAttributeFactory.getColor("\033[0;94m"); // BLUE
    public static final ColorAttribute PURPLE_BRIGHT = ColorAttributeFactory.getColor("\033[0;95m"); // PURPLE
    public static final ColorAttribute CYAN_BRIGHT = ColorAttributeFactory.getColor("\033[0;96m"); // CYAN
    public static final ColorAttribute WHITE_BRIGHT = ColorAttributeFactory.getColor("\033[0;97m"); // WHITE

    // Bold High Intensity
    public static final ColorAttribute BLACK_BOLD_BRIGHT = ColorAttributeFactory.getColor("\033[1;90m"); // BLACK
    public static final ColorAttribute RED_BOLD_BRIGHT = ColorAttributeFactory.getColor("\033[1;91m"); // RED
    public static final ColorAttribute GREEN_BOLD_BRIGHT =ColorAttributeFactory.getColor("\033[1;92m"); // GREEN
    public static final ColorAttribute YELLOW_BOLD_BRIGHT = ColorAttributeFactory.getColor("\033[1;93m");// YELLOW
    public static final ColorAttribute BLUE_BOLD_BRIGHT = ColorAttributeFactory.getColor("\033[1;94m"); // BLUE
    public static final ColorAttribute PURPLE_BOLD_BRIGHT =ColorAttributeFactory.getColor( "\033[1;95m");// PURPLE
    public static final ColorAttribute CYAN_BOLD_BRIGHT = ColorAttributeFactory.getColor("\033[1;96m"); // CYAN
    public static final ColorAttribute WHITE_BOLD_BRIGHT = ColorAttributeFactory.getColor("\033[1;97m"); // WHITE

    // High Intensity backgrounds
    public static final ColorAttribute BLACK_BACKGROUND_BRIGHT = ColorAttributeFactory.getColor("\033[0;100m");// BLACK
    public static final ColorAttribute RED_BACKGROUND_BRIGHT =ColorAttributeFactory.getColor( "\033[0;101m");// RED
    public static final ColorAttribute GREEN_BACKGROUND_BRIGHT =ColorAttributeFactory.getColor("\033[0;102m");// GREEN
    public static final ColorAttribute YELLOW_BACKGROUND_BRIGHT = ColorAttributeFactory.getColor("\033[0;103m");// YELLOW
    public static final ColorAttribute BLUE_BACKGROUND_BRIGHT = ColorAttributeFactory.getColor("\033[0;104m");// BLUE
    public static final ColorAttribute PURPLE_BACKGROUND_BRIGHT = ColorAttributeFactory.getColor("\033[0;105m"); // PURPLE
    public static final ColorAttribute CYAN_BACKGROUND_BRIGHT = ColorAttributeFactory.getColor("\033[0;106m"); // CYAN
    public static final ColorAttribute WHITE_BACKGROUND_BRIGHT = ColorAttributeFactory.getColor("\033[0;107m"); // WHITE


private static final ConsoleColors instance =new ConsoleColors();

    private ConsoleColors(){
        // private constructor to prevent instantiation from outside the class
    }
    public static ConsoleColors getInstance(){
        return instance;
    }
