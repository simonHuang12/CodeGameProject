public class Generator {
    private int length;
    private String code;

    public Generator(){ //default values
        length = 8;
        code = "";
    }
    public Generator(int length){ //custom length
        this.length = length;
        code = "";
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
    }
}
