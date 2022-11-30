import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the code cracking game");
        System.out.println("Do you want default length of 8 or a custom length? (1 for default, 2 for custom)");
            String answer = input.nextLine();
            try {
                if (Integer.parseInt(answer) == 1) {
                    Generator gen = new Generator();
                    gen.generateCode();

                    String character = ""; //guessing part
                    while (gen.winCheck()) {
                        System.out.println("Input a character");
                        character = input.nextLine();
                        if (character.length() != 1){
                            System.out.println("Input can only be a single character");
                        }else {
                            gen.guessGame(character);
                        }
                    }
                    System.out.println("You cracked the code!");
                    System.out.println("You took " + gen.getAttempts() + " tries!");
                } else if (Integer.parseInt(answer) == 2) {
                    System.out.println("What length should the code be?");
                    int len = input.nextInt();
                    if (len <= 0) {
                        System.out.println("Invalid input");
                    } else {
                        Generator gen = new Generator(len);
                        gen.generateCode();

                        String character = ""; //guessing part dupe
                        while (gen.winCheck()) {
                            System.out.println("Input a character");
                            character = input.nextLine();
                            if (character.length() != 1){
                                System.out.println("Input can only be a single character");
                            }else {
                                gen.guessGame(character);
                            }
                        }
                        System.out.println("You cracked the code!");
                        System.out.println("You took " + gen.getAttempts() + " tries!");
                    }
                } else {
                    System.out.println("Invalid input");
                }
            }catch (NumberFormatException e){
                System.out.println("Invalid input");
            }

        }
}