import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Generator gen = new Generator();
        gen.generateCode();
        String character = "";
        while (!gen.guessGame(character)) {
            System.out.println("Input a character");
            character = input.nextLine();
            gen.guessGame(character);
        }


    }
}