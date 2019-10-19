import java.security.SecureRandom;
import java.util.Scanner;

public class CAI
{
    public static void main(String[] args)
    {
        var(math(), difficulty());
    }
    public static int math ()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Lets study Math! Choose which type of problems you would like to practice.");
        System.out.println("Type (1) to study addition.");
        System.out.println("Type (2) to study multiplication.");
        System.out.println("Type (3) to study subtraction.");
        System.out.println("Type (4) to study division.");
        System.out.println("Type (5) to study all of these types.");

        int answ = sc.nextInt();
        return answ;
    }
    public static int difficulty ()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("At which difficulty would you like to practice at?");
        System.out.println("Type (1) to only use single digits in your problems.");
        System.out.println("Type (2) to use double and single digit numbers in your problems.");
        System.out.println("Type (3) to use triple, double and single digit numbers in your problems.");
        System.out.println("Type (4) to use quadruple, triple, double and single digit numbers in your problems.");
        int answ = sc.nextInt();
        return answ;
    }
    public static int var(int math, int difficulty)
    {
        SecureRandom rand = new SecureRandom();
        int tally = 0;

        if (difficulty == 1)
        {
            difficulty = 10;
        }
        else if (difficulty == 2)
        {
            difficulty = 100;
        }
        else if (difficulty == 3)
        {
            difficulty = 1000;
        }
        else if (difficulty == 4)
        {
            difficulty = 10000;
        }
        for (int i = 0; i < 10; i++)
        {
            int randOne = rand.nextInt(difficulty);
            int randTwo = rand.nextInt(difficulty);
            randOne += 1;
            randTwo += 1;

            switch (math)
            {
                case 1:
                    tally += addition(randOne, randTwo);
                    break;
                case 2:
                    tally += multiplication(randOne, randTwo);
                    break;
                case 3:
                    tally += subtraction(randOne, randTwo);
                    break;
                case 4:
                    tally += division(randOne, randTwo);
                    break;
                case 5:
                    tally += random(randOne, randTwo);
                    break;
            }
            System.out.println(tally);
        }
        if (tally >= 8)
        {
            System.out.println("Congratulations, you are ready to go to the next level!");
            System.out.println("You got " + tally + " right out of 10 questions!");
        }
        else {
            System.out.println("Please ask your teacher for extra help.");
            System.out.println("You got " + tally + " right out of 10 questions");
        }
        return 0;
    }
    public static int multiplication (int randOne, int randTwo)
    {
        Scanner sc = new Scanner(System.in);
        int correctAnsw = randOne * randTwo;
        System.out.println("What is " + randOne + " times " + randTwo + "?");
        int userAnsw = sc.nextInt();

        if (correctAnsw == userAnsw)
        {
            return 1;
        }
        else {
            return 0;
        }
    }
    public static int addition (int randOne, int randTwo)
    {
        Scanner sc = new Scanner(System.in);
        int correctAnsw = randOne + randTwo;
        System.out.println("What is " + randOne + " plus " + randTwo + "?");
        int userAnsw = sc.nextInt();

        if (correctAnsw == userAnsw)
        {
            return 1;
        }
        else {
            return 0;
        }
    }
    public static int subtraction (int randOne, int randTwo)
    {
        Scanner sc = new Scanner(System.in);
        int correctAnsw = randOne - randTwo;
        System.out.println("What is " + randOne + " minus " + randTwo + "?");
        int userAnsw = sc.nextInt();

        if (correctAnsw == userAnsw)
        {
            return 1;
        }
        else {
            return 0;
        }
    }
    public static int division (int randOneInt, int randTwoInt)
    {
        Scanner sc = new Scanner(System.in);
        double randOne = randOneInt;
        double randTwo = randTwoInt;
        double correctAnsw = randOne / randTwo;
        System.out.println("What is " + randOne + " divided by " + randTwo + "?");
        System.out.println("Round to the second decimal place.");
        double userAnsw = sc.nextDouble();

        if (Math.abs(userAnsw - correctAnsw) < 1e-2)
        {
            return 1;
        }
        else {
            return 0;
        }
    }
    public static int random (int randOne, int randTwo)
    {
        SecureRandom rand = new SecureRandom();
        int math = rand.nextInt(5);
        math += 1;
        int tally = 0;

        switch (math)
        {
            case 1:
                tally += addition(randOne, randTwo);
                break;
            case 2:
                tally += multiplication(randOne, randTwo);
                break;
            case 3:
                tally += subtraction(randOne, randTwo);
                break;
            case 4:
                tally += division(randOne, randTwo);
                break;
        }
        return tally;
    }
}