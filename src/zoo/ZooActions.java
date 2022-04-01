package zoo;

import animals.*;
import food.IEdible;
import mobility.Point;

import java.util.Random;
import java.util.Scanner;

public class ZooActions {
    private static final int MIN_NUM_OF_ANIMALS = 3;
    private static Scanner sc = new Scanner(System.in);

    public static boolean eat(Object animal, IEdible food) {
        if(animal instanceof  Animal) {
            return ((Animal) animal).eat(food);
        }
        return false;
    }

    public static boolean move(Object animal, Point point) {
        boolean isSuccess = false;
        if (((Animal)animal).move(point) != 0) {
            isSuccess = true;
        }
        return isSuccess;
    }

    public static void main(String[] args) {

        int size ;
        Animal[] animalsArr;
        Point location = new Point(5, 10);

            System.out.println("Please enter the number of animals in the zoo (At least 3 animals): ");
            size = sc.nextInt();
            while (size < 3) {
                System.out.println("Invalid input, The minimum size is 3 ");
                size = sc.nextInt();
            }

        animalsArr = createAnimalsArr(size);

        for(int i =0 ; i < size ; i++)
        {
            move(animalsArr[i],location);
        }

        int raffle = size/2;
        Random random = new Random();
        for (int i = 0; i < raffle; i++){
            int first = random.nextInt(size);
            int second = random.nextInt(size);
            ZooActions.eat(animalsArr[first], animalsArr[second]);
        }
        sc.close();
    }
    private static Animal[] createAnimalsArr(int size) {
        int userSelection ;
        Animal[] animalsArr = new Animal[size];

        for (int i = 0; i < size; i++) {
            System.out.println("\nAnimal number " + (i + 1) );
            System.out.println("Select the animal you want to add: " );
            System.out.println("1. Lion");
            System.out.println("2. Bear");
            System.out.println("3. Elephant");
            System.out.println("4. Giraffe");
            System.out.println("5. Turtle");
            System.out.println("6. Exit");


                System.out.print("Enter your choice: ");
                userSelection = sc.nextInt();
             while (userSelection <= 0 || userSelection > 6) {
                 System.out.println("Invalid input, please Enter a number between 1-6");
                 System.out.print("Enter your choice: ");
                 userSelection = sc.nextInt();
             }


            System.out.println("Please enter the animal's name: ");
            String name = sc.next();
                switch (userSelection) {
                    case 1:
                        //Lion
                        animalsArr[i] = new Lion(name);
                        break;
                    case 2:
                        //Bear
                        createBear(name,animalsArr,i);
                        break;
                    case 3:
                        //Elephant
                        createElephant(name,animalsArr,i);
                        break;
                    case 4:
                        //Giraffe
                        createGiraffe(name,animalsArr,i);
                        break;
                    case 5:
                        //Turtle
                        createTurtle(name,animalsArr,i);
                        break;
                    case 6:
                        // Terminate JVM
                        System.exit(0);
                        break;
                    default:
                        //invalid input
                        break;
                }
            }
        return animalsArr;
    }

    private static void createElephant(String name, Animal[] animalsArr, int i)
    {
        int userSelection;
        double trunkLength;
        System.out.println("Do you want to choose a specific length for the elephant trunk?: ");
        System.out.println("1. YES");
        System.out.println("2. NO");
        do {
            System.out.print("Enter your choice: ");
            userSelection = sc.nextInt();
            switch (userSelection) {
                case 1:
                    //YES
                    System.out.print("Enter length of the trunk (a real number between 0.5 - 3) : ");
                    trunkLength = sc.nextDouble();
                    animalsArr[i] = new Elephant(name,trunkLength);
                    break;
                case 2:
                    //NO
                    animalsArr[i] = new Elephant(name);
                    break;
                default:
                    //invalid input
                    System.out.println("Invalid input, please Enter 1 or 2");
                    break;
            }
        } while (userSelection != 1 && userSelection != 2);
    }

    private static void createGiraffe(String name, Animal[] animalsArr, int i)
    {
        Scanner sc = new Scanner(System.in);
        int userSelection;
        double neckLength;
        System.out.println("Do you want to choose a specific length for the giraffe's neck? : ");
        System.out.println("1. YES");
        System.out.println("2. NO");
        do {
            System.out.print("Enter your choice: ");
            userSelection = sc.nextInt();
            switch (userSelection) {
                case 1:
                    //YES
                    System.out.print("Enter length of the neck (a real number between 1 - 2.5) : ");
                    neckLength = sc.nextDouble();//TODO check if we need to validate this input
                    animalsArr[i] = new Giraffe(name,neckLength);
                    break;
                case 2:
                    //NO
                    animalsArr[i] = new Giraffe(name);
                    break;
                default:
                    //invalid input
                    System.out.println("Invalid input, please Enter 1 or 2");
                    break;
            }
        } while (userSelection != 1 && userSelection != 2);
    }

    private static void createTurtle(String name, Animal[] animalsArr, int i) {
        Scanner sc = new Scanner(System.in);
        int userSelection;
        int age;
        System.out.println("Do you want to choose a specific age for the Turtle?: ");
        System.out.println("1. YES");
        System.out.println("2. NO");
        do {
            System.out.print("Enter your choice: ");
            userSelection = sc.nextInt();
            switch (userSelection) {
                case 1:
                    //YES
                    System.out.print("Enter the age (a integer number between 0 - 500) : ");
                    age = sc.nextInt();//TODO check if we need to validate this input
                    animalsArr[i] = new Turtle(name,age);
                    break;
                case 2:
                    //NO
                    animalsArr[i] = new Turtle(name);
                    break;
                default:
                    //invalid input
                    System.out.println("Invalid input, please Enter 1 or 2");
                    break;
            }
        } while (userSelection != 1 && userSelection != 2);
    }


    private static void createBear(String name, Animal[] animalsArr, int i) {
        Scanner sc = new Scanner(System.in);
        int userSelection;

        System.out.println("Please select the bear's fur color: ");
        System.out.println("1. White");
        System.out.println("2. Gray");
        System.out.println("3. Black");
        System.out.println("4. default");

        do {
            System.out.print("Enter your choice: ");
            userSelection = sc.nextInt();
            switch (userSelection) {
                case 1:
                    //White
                    animalsArr[i] = new Bear(name,"WHITE");
                    break;
                case 2:
                    //Gray
                    animalsArr[i] = new Bear(name,"GRAY");
                    break;
                case 3:
                    //Black
                    animalsArr[i] = new Bear(name,"GRAY");
                    break;
                case 4:
                    //default
                    animalsArr[i] = new Bear(name);
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
                    break;
            }
        }
        while(userSelection < 1 || userSelection > 4 );
    }

}
