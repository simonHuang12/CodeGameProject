/**
 * Generator class creates an object to create a code to be cracked using random characters of the keyboard.
 */
public class Generator {
    private final int length;
    private String code = "";
    private String codeProgress = "";
    private int attempts = 0;
    private boolean correct;

    /**
     * Constructor for the Generator class. Default constructor w/ no parameters.
     * Sets code length to a default of 8.
     */
    public Generator(){ //default values
        length = 8;
    }

    /**
     * Constructor for the Generator class. Sets code length to a user specified number.
     * @param length represents the user inputted length.
     */
    public Generator(int length){
        this.length = length;
    }

    /**
     * Generates a single character for the code using ASCII values from 33 to 127 (all keyboard characters).
     * @return a single character as a string
     */
    public String generate1Char(){
        int random = (int)(Math.random()*94+33);
        char char1 = (char)random;
        return ""+char1;
    }

    /**
     * Generates a code of the specified length by running generateCode() for length times.
     * Also generates a progress indicator of "?" with the specified length.
     */
    public void generateCode(){
        for (int i = 1; i <= length; i++){
            code += generate1Char();
        }
        for (int i = 0; i < code.length(); i++){
            codeProgress += "?";
        }
    }

    /**
     * Checks if input character matches any character in the code, then
     * replaces the index of the matching character in codeProgress with the specified character.
     * @param character represents the user inputted character to be checked.
     */
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

    /**
     * Replaces the index of a matching character in codeProgress with the user inputted character
     * @param character represents the user inputted character.
     * @param index represents the matching index to be replaced.
     */
    public void filler(String character, int index){
        codeProgress = codeProgress.substring(0, index)+character+codeProgress.substring(index+1);
    }

    /**
     * Checks if codeProgress matches code.
     * @return true if matches, otherwise false.
     */
    public boolean winCheck(){
        return !codeProgress.equals(code);
    }

    /**
     * Returns if guessGame() had any matching characters in code.
     * @return true if there was no matching, otherwise false.
     */
    public boolean getCorrect(){
        return !correct;
    }

    /**
     * Returns the code generated
     * @return the code
     */
    public String getCode(){return code;}

    /**
     * toString() method of generator.
     * @return a string consisting of the length of the code and current number of attempts.
     */
    public String toString(){
        return "Code length: "+length+"\nAttempts: "+attempts;
    }
}


