import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Generator {
    private int length;
    private String code = "";
    private String codeProgress = "";
    private int lettersCorrect = 0;



    public Generator(){ //default values
        length = 8;
    }
    public Generator(int length){ //custom length
        this.length = length;
    }

    public String generate1Char(){ //generates a single character for the code
        int random = (int)(Math.random()*94+33);
        char char1 = (char)random;
        return ""+char1;
    }
    public void generateCode(){ //generates the entire code
        for (int i = 1; i <= length; i++){
            code += generate1Char();
        }
        System.out.println(code);
        for (int i = 0; i < code.length(); i++){
            codeProgress += "?";
        }
    }
    public boolean guessGame(String character){
            for (int i = 0; i < code.length(); i++){
                if (character.equals(code.substring(i, i+1))){
                    filler(character, i);
                    System.out.println(codeProgress);
                    return true;
            }
        }
        return false;
        }
    public void filler(String character, int index){
        codeProgress = codeProgress.substring(0, index)+character+codeProgress.substring(index+1);
        if (index.equals())
        lettersCorrect ++;
    }
}


