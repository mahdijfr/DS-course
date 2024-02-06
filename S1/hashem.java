import java.util.Scanner;

public class hashem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        boolean f =true;
        for (int i = 0; i < string.length()/2 & i<string.length()-1; i++) {
            if(string.charAt(i)!=string.charAt(string.length()-i-1)) {
                f=false;
            }
        }
        if(f){
            System.out.println("Yes");
        }else {
            System.out.println("No");

        }
    }
}
