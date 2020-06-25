import java.util.Scanner;
/*the board coordinates are as follows bottom left cell has coordinates(1,1) and top right has(3,3)
 * (1,3)(2,3)(3,3)
 * (1,2)(2,2)(3,2)
 * (1,1)(2,1)(3,1)
 * */

public class Main_V1 {
    public final static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        String txt = scn.nextLine();
        String[][] board = new String[4][4];
        int i=0;
        while(i<txt.length()) {
            for (int c = 3; c >=1; c--) {
                for (int r = 1; r < 4; r++) {
                    board[r][c] = Character.toString(txt.charAt(i));
                    i++;
                }
            }
        }
        displayBoard(board);
        int cordR=0,cordC=0;
        while (true) {
            System.out.print("Enter the coordinates: ");
            String[] coord = scn.nextLine().split(" ");

            try {
                cordR=Integer.parseInt(coord[0]);
                cordC=Integer.parseInt(coord[1]);
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!"); continue;
            }
            if((cordR>=4||cordR<=0)||(cordC>=4||cordC<=0)){
                System.out.println("Coordinates should be from 1 to 3!"); continue;
            }
            if(existAt(board,cordC,cordR)){
                System.out.println("This cell is occupied! Choose another one!"); continue;
            }
            break;
        }
        board[cordR][cordC]="X";
        displayBoard(board);
    }

    private static void displayBoard(String[][] arr) {
        System.out.println("---------");
        for (int c = 3; c >=1; c--) {
            System.out.print("| ");
            for (int r = 1; r < 4; r++) {
                System.out.print(arr[r][c]+" ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
    private static boolean existAt(String[][] arr,int cordC,int cordR) {
        if(arr[cordR][cordC].equals("_")){
            return false;
        }else return true;
    }
}
