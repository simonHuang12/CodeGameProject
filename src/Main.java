import java.util.Scanner;
public class Main {
    public static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the code cracking game\nCorrect characters will show up in bright green");
        System.out.println("Do you want default length of 8 or a custom length? (1 for default, 2 for custom)");
            String answer = input.nextLine();
            try {
                if (Integer.parseInt(answer) == 1) {
                    Generator gen = new Generator();
                    gen.generateCode();

                    String character; //guessing part
                    while (gen.winCheck()) {
                        System.out.println(gen);
                        character = input.nextLine();
                        if (character.length() != 1){
                            System.out.println(ANSI_RED+"Input can only be a single character"+ANSI_RESET);
                        }else {
                            gen.guessGame(character);
                            if (gen.getCorrect()){
                                System.out.println(ANSI_RED+"Try Again"+ANSI_RESET);
                            }
                        }
                    }
                    System.out.println(gen);
                    System.out.println("You cracked the code!");
                } else if (Integer.parseInt(answer) == 2) {
                    System.out.println("What length should the code be?");
                    int len = input.nextInt();
                    if (len <= 0) {
                        System.out.println(ANSI_RED+"Invalid input"+ANSI_RESET);
                    } else {
                        Generator gen = new Generator(len);
                        gen.generateCode();

                        boolean firstRun = true;
                        String character; //guessing part dupe
                        while (gen.winCheck()) {
                            System.out.println("Input a character");
                            character = input.nextLine();
                            if ((character.length() != 1)&&(!firstRun)){
                                System.out.println(ANSI_RED+"Input can only be a single character"+ANSI_RESET);
                            }else {
                                gen.guessGame(character);
                                if ((gen.getCorrect())&&(!firstRun)){
                                    System.out.println(ANSI_RED+"Try Again"+ANSI_RESET);
                                }
                            }
                            firstRun = false;
                        }
                        System.out.println(gen);
                        System.out.println("You cracked the code!");
                        System.out.println("The code was "+gen.getCode());
                    }
                } else {
                    System.out.println(ANSI_RED+"Invalid input"+ANSI_RESET);
                }
            }catch (NumberFormatException e){
                System.out.println(ANSI_RED+"Invalid input"+ANSI_RESET);
            }

        }
}