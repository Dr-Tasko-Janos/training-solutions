package statements;

public class StatementMain {

    public static void main(String[] args) {

        int x = 5 + 6;
        int y = 11 - x;
        int z = 8;

        boolean b = true;  //to avoid might haven't been initialized error message.
        if(x > y){
            b = true;
        }

        boolean c;
        if(b == true || z > 5){
            c = true;
        }

        z++;

    }
}
