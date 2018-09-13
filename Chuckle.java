import java.util.Random;
import java.util.Scanner;
public class Chuckle {
    public static Random r = new Random();
    public static void main(String[] args) {
        boolean a[] = new boolean[12];
        for (int i = 1; i <12 ; i++) {
            a[i] = false;
        }
        Scanner sc = new Scanner(System.in);                                    //make a new object of scanner class and store it in sc
        int waste = 0;
        boolean flag = true;                                                    //flag to check the condition is true
        while (flag){
            int dice1 = Math.abs((r.nextInt()))%6+1;                            //abs() method taking int as an input
            int dice2 = Math.abs((r.nextInt()))%6+1;                            //abs() method taking int as an input
            System.out.println("Value of Dice1 : " + dice1);
            System.out.println("Value of Dice2 : " + dice2);
            System.out.println("Sum of 2 dices :" + (dice1+dice2));
            System.out.println("\n");
            System.out.println("Choose one:\n1.Roll again\n2.roll both\n3.lock one of the Dices");
            int tmp = sc.nextInt();                                             //sc is the object of scanner class
            if (tmp == 2){
                dice1 = Math.abs((r.nextInt()))%6+1;
                dice2 = Math.abs((r.nextInt()))%6+1;
                System.out.println("Value of Dice 1 : " + dice1);
                System.out.println("Value of Dice 2 : " + dice2);
                System.out.println("Sum of two dices:" + (dice1+dice2));
            }
            else if (tmp == 3){
                System.out.print("Lock one of the Dices: " );
                waste += CheckAndUpdate(a,(dice1+dice2));
                int choice = sc.nextInt();                                      //sc is the object of scanner class
                if (choice == 2){
                    dice1 = Math.abs((r.nextInt()))%6+1;                        //abs() method taking int as an input for dice1
                    System.out.println("dice1 value : " + dice1);               //printing value of dice1
                    System.out.println("dice2 value : " + dice2);               //printing value of dice2
                    System.out.println("sum :" + (dice1+dice2));                //printing sum of both dices
                }
                if (choice == 1){
                    dice2 = Math.abs((r.nextInt()))%6+1;                        //abs() method taking int as an input for dice2
                    System.out.println("dice1 value : " + dice1);               //printing value of dice1
                    System.out.println("dice2 value : " + dice2);               //printing value of dice2
                    System.out.println("sum :" + (dice1+dice2));                //printing sum of both dices
                }
            }
            else{
                System.out.println("Score updated");
            }
            waste += CheckAndUpdate(a,(dice1+dice2));                           //Check and update the value of sum of dices
            if (allUpdated(a)){
                flag = false;
            }
            System.out.println("\n");
        }
        System.out.println("the total number of moves wasted:"+waste);
    }

    private static boolean allUpdated(boolean[] a) {
        for (int i = 1; i <12 ; i++) {
            if (a[i] == false){
                return false;
            }
        }
        return true;

    }

    private static int CheckAndUpdate(boolean[] a, int i) {
        if (a[i-1] == true){
            return 1;
        }
        a[i-1] = true;
        return 0;
    }

}
