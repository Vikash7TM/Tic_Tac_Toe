import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.lang.Math;
public class Main {
    public final static Scanner scn = new Scanner(System.in);
    final static int xsum=264;
    final static int osum=237;
    static int flag=0;
    static boolean xwon=false;
    static boolean owon=false;

    public static void main(String[] args) {
        String txt = scn.nextLine();

        char part1=txt.charAt(0);
        char part2=txt.charAt(1);
        char part3=txt.charAt(2);
        char part4=txt.charAt(3);
        char part5=txt.charAt(4);
        char part6=txt.charAt(5);
        char part7=txt.charAt(6);
        char part8=txt.charAt(7);
        char part9=txt.charAt(8);

        List<String> rows = new ArrayList<>();

        rows.add(part1+" "+part2+" "+part3);
        rows.add(part4+" "+part5+" "+part6);
        rows.add(part7+" "+part8+" "+part9);

        System.out.println("---------");
        for(String row : rows){
            System.out.print("| ");
            System.out.print(row);
            System.out.println(" |");
        }
        System.out.println("---------");
        int i = 0;
        int xs=0,os=0;
        while(i<txt.length()){
            if(txt.charAt(i)=='X') {
                xs++;
            }else if(txt.charAt(i)=='O'){
                os++;
            }
            i++;
        }


        if((part1+part2+part3== xsum)||(part4+part5+part6== xsum)||(part7+part8+part9== xsum)||
                (part1+part4+part7== xsum)||(part2+part5+part8== xsum)||(part3+part6+part9== xsum)||
                (part1+part5+part9== xsum)||(part3+part5+part7== xsum)){
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
            System.out.println("Impossible");
        }else if(xwon){
            System.out.println("X wins");
        }else if(owon){
            System.out.println("O wins");
        }else if (xs+os==9){
            System.out.println("Draw");
        }else {
            System.out.println("Game not finished");
        }





    }
    public static void winner(){
        flag++;
    }
}