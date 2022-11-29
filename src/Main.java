public class Main {
    public static void main(String[] args) {

        for (int i = 0; i < 100; i++){
            Generator gen = new Generator();
            gen.generateCode();
        }
        for (int i = 33; i < 127; i++){
            char char1 = (char)i;
            System.out.print(char1);
        }

    }
}