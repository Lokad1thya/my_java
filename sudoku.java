import java.util.Scanner;

class sudoku{
    public static void main(String args[]){
        display n = new display();
        n.frame();
    }
}
class display{
    int k=1;
    public void frame(){
        String n=".";
        String b="_";
        String c = "|";
        String gap = String.format("%4s",n);
        String gap1 = String.format("%4s",b);
        String gap2 = String.format("%4s",c);
        int array[][]= new int[9][9];
        for(int i=1;i<12;i++){
            for(int j=1;j<12;j++){
                if(j%4==0){
                    System.out.print(gap2);
                }else if(i%4==0){
                    System.out.print(gap1);
                }else{
                    System.out.print(gap);
                }
            }
        System.out.println();
        System.out.println();
        } 
    }
    
}
