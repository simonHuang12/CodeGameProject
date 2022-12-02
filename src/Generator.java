public class Generator {
    private final int length;
    private String code = "";
    private String codeProgress = "";
    private int attempts = 0;
    private boolean correct;
    private char char1;
    private static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN_BRIGHT = "\033[0;92m";


    public Generator(){ //default values
        length = 8;
    }
    public Generator(int length){ //custom length
        this.length = length;
    }

    public String generate1Char(){ //generates a single character for the code
        int random = (int)(Math.random()*94+33);
        char1 = (char)random;
        return ""+char1;
    }
    public void generateCode(){ //generates the entire code
        for (int i = 1; i <= length; i++){
            code += generate1Char();
        }
        for (int i = 0; i < code.length(); i++){
            codeProgress += "?";
        }
    }
    public void guessGame(String character){
        correct = false;
        attempts++;
            for (int i = 0; i < code.length(); i++) {
                if (character.equals(code.substring(i, i + 1))) {
                    filler(character, i);
                    correct = true;
                }
            }
        System.out.println(codeProgress);
        }
    public void filler(String character, int index){
        codeProgress = codeProgress.substring(0, index)+ANSI_GREEN_BRIGHT+character+ANSI_RESET+codeProgress.substring(index+1);
    }
    public boolean winCheck(){
        return !codeProgress.equals(code);
    }
    public int getAttempts(){
        return attempts;
    }
    public boolean getCorrect(){
        return !correct;
    }
    public String toString(){
        return "Input a character";
    }
}


