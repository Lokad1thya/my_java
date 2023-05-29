import java.util.ArrayList;
import java.util.Scanner;

public class Sudoku_Solver {
    public static void main(String args[]){
        int arr[][] = new int[9][9];
        input(arr);
        ArrayList<Integer> valid = new ArrayList<Integer>();
                    for(int i =1;i<=9;i++){
                        valid.add(i);
                    }

        sudokusolver(arr,1,0,0,valid);
        display(arr);
    }
    public static void input(int arr[][]){
        int x=1;
        System.out.println("Please Enter 0 when you are done giving the input: ");
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        if(x==0){
            display(arr);
            return;
        }
        System.out.println("Co-ordinates: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Eleement at ["+a+"]["+b+"]: ");
        int ele = sc.nextInt();
        arr[a][b]=ele;
        input(arr);
    }

    public static void display(int arr[][]){
        int k=1;
        boolean y=true;
        String b="_";
        String c = "|";
        System.out.println();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(j%3==0&&j!=0){
                    System.out.print(c);
                }
                {
                    if(arr[i][j]==0){
                         y=false;
                    }
                    System.out.print(arr[i][j]+" ");               
                }

            }
            System.out.println();
            if(k%3==0){
              for(int l=0;l<11;l++){
                System.out.print(b+" ");
              }
              System.out.println();           
            }
            k++; 
        }
        if(y!=false){
            return;
        }
    }

    public static void sudokusolver(int arr[][],int item,int a,int b,ArrayList<Integer>valid){
        System.out.println();
        if(arr[a][b]==0){

            for(int i=0;i<valid.size();i++){

                if(valid.size()!=0)
                item=valid.get(i);
        
                if(validity(arr, a, b, item)){
                    if(valid.size()!=0){
                        valid.remove(Integer.valueOf(item));
                        sudokusolver(arr, item, a, b, valid);
                    }
                }

            }
            if(valid.size()!=0){
                item=valid.get(0);
                arr[a][b]=item;

                if(valid.size()!=0)
                valid.remove(Integer.valueOf(item));
            }
        }

        if(arr[a][b]!=0){
            if(b<8){
                display(arr);
                ArrayList<Integer> promise = new ArrayList<Integer>();
                for(int i =1;i<=9;i++){
                    promise.add(i);
                }
                sudokusolver(arr, item, a, b+1,promise);
            }else if(a<8){
                display(arr);
                ArrayList<Integer> promise = new ArrayList<Integer>();
                for(int i =1;i<=9;i++){
                    promise.add(i);
                }
                sudokusolver(arr, item, a+1, 0, promise);
            }else{
                display(arr);
                System.exit(0);
            }
        }
        arr[a][b]=0;
        return;
    }

    public static boolean validity(int arr[][],int a,int b,int item){

        for(int i =0;i<arr.length;i++){
                if(arr[i][b]==item){
                    return true;
                }
        }

        for(int j =0;j<arr.length;j++){
            if(arr[a][j]==item){
                return true;
            }
        }
        
        int row=(a/3)*3;
        int col=(b/3)*3;

        for(int i=row;i<(row+3);i++){
            for(int j=col;j<(col+3);j++){
                if(arr[i][j]==item){
                    return true;
                }
            }
        }

        return false;
    }
}
