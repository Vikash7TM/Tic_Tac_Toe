import java.util.Scanner;

public class Main_V2 {
    public static Scanner scn = new Scanner(System.in);
    final static int xsum=264;
    final static int osum=237;
    static int flag=0;
    static boolean xwon=false;
    static boolean owon=false;
    static boolean eflag=true;

    public static void main(String[] args) {
        char[][] board = new char[4][4];

        for (int c = 3; c >=1; c--) {
            for (int r = 1; r < 4; r++) {
                board[r][c] = '_';
            }
        }
        displayBoard(board);
        char player = 'X';
        while (eflag) {
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
            switch(player){
                case 'X':board[cordR][cordC]='X'; player='O'; break;
                case 'O':board[cordR][cordC]='O'; player='X'; break;
            }

            displayBoard(board);
            eflag=status(board);
        }
    }

    private static void displayBoard(char[][] arr) {
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
    private static boolean existAt(char[][] arr,int cordC,int cordR) {
        if(arr[cordR][cordC]=='_'){
            return false;
        }else return true;
    }
    private static boolean status(char[][] arr){
        char part1=arr[1][3];
        char part2=arr[2][3];
        char part3=arr[3][3];
        char part4=arr[1][2];
        char part5=arr[2][2];
        char part6=arr[3][2];
        char part7=arr[1][1];
        char part8=arr[2][1];
        char part9=arr[3][1];

        int xs=0,os=0;
        for (int c = 3; c >=1; c--) {
            for (int r = 1; r < 4; r++) {
                if(arr[r][c]=='X'){
                    xs++;
                }else if(arr[r][c]=='O'){
                    os++;
                }
            }
        }

        if((part1+part2+part3==xsum)||(part4+part5+part6==xsum)||(part7+part8+part9==xsum)||
                (part1+part4+part7==xsum)||(part2+part5+part8==xsum)||(part3+part6+part9==xsum)||
                (part1+part5+part9==xsum)||(part3+part5+part7==xsum)){
            winner();
            xwon=true;

        }
        if((part1+part2+part3== osum)||(part4+part5+part6== osum)||(part7+part8+part9== osum)||
                (part1+part4+part7== osum)||(part2+part5+part8== osum)||(part3+part6+part9== osum)||
                (part1+part5+part9== osum)||(part3+part5+part7== osum)){
            winner();
            owon=true;
        }
        if(Math.abs(xs-os)>1||flag>1){
            System.out.println("Impossible"); return false;
        }else if(xwon){
            System.out.println("X wins"); return false;
        }else if(owon){
            System.out.println("O wins"); return false;
        }else if (xs+os==9){
            System.out.println("Draw"); return false;
        }
        return true;
    }
    public static void winner(){
        flag++;
    }
}
