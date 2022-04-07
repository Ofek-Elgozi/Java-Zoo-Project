package zoo;

import animals.*;
import food.IEdible;
import mobility.Point;

import java.util.Random;
import java.util.Scanner;
//Ofek Elgozi 318432085
//Elyasaf Sinvani 318551728
//Campus Ashdod

/**
 * A department that implements all the actions in the zoo, including a main executable file (main)
 * @version 1.10 3 April 2022
 * @author Ofek Elgozi
 * @see Animal
 */

public class ZooActions
{
    private static Scanner sc = new Scanner(System.in);

    /**
     * A method that checks the type of object we received if it is an animal type does dawncusting from an object to an animal,
     * and activates whether the "eat" function of the specific animal,
     * if the animal was able to eat returns "true" if not returns "false"
     * @param animal Describing a type of animal
     * @param food that describes the type of food (EFoodType)
     * @return if the animal was able to eat returns "true" if not returns "false"
     */
    public static boolean eat(Object animal, IEdible food)
    {
        if (animal instanceof Animal)
        {
            return ((Animal) animal).eat(food);
        }
        return false;
    }

    /**
     ** A method that checks the type of object we received if it is an animal type does dawncusting from an object to an animal ,
     * If the point we got in the range (X between 0 and 800, Y between 0 and 600), returns "true" otherwise returns "false",
     * and activates whether the "move" function of the specific animal
     * @param animal Describing a type of animal
     * @param point A point-type object that describes a location
     * @return If the point we got in the range (X between 0 and 800, Y between 0 and 600), returns "true" otherwise returns "false"
     */
    public static boolean move(Object animal, Point point)
    {
        if (animal instanceof Animal)
        {
            if (((Animal)animal).move(point) != 0)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Main system execution program
     * @param args Strings of commands
     */
    public static void main(String[] args)
    {

        int size;
        int x;
        int y;
        Animal[] Animals_Array;
        //
        System.out.println("How Many Animals There Are In The Zoo?:");
        size = sc.nextInt();
        while (size < 3) {
            System.out.println("Invalid input, The minimum size is 3.");
            size = sc.nextInt();
        }
        //
        Animals_Array = BuildArrayAnimals(size);
        //
        for (int i = 0; i < size; i++)
        {
            System.out.println("Please Enter Location Of X:");
            x = sc.nextInt();
            System.out.println("Please Enter Location Of Y:");
            y = sc.nextInt();
            while(move(Animals_Array[i], new Point(x,y)) == false)
            {
                System.out.println("Invalid Input, Please Try Again.");
                System.out.println("Please Enter Location Of X:");
                x = sc.nextInt();
                System.out.println("Please Enter Location Of Y:");
                y = sc.nextInt();
            }
        }
        //
        int NewSize = size / 2;
        Random random = new Random();
        for (int i = 0; i < NewSize; i++) {
            int FirstAnimal = random.nextInt(size);
            int SecondAnimal = random.nextInt(size);
            ZooActions.eat(Animals_Array[FirstAnimal], Animals_Array[SecondAnimal]);
        }
        sc.close();
    }

    /**
     * A method that starts an array of the "animal" type,
     * and accepts the size of the array (of an integer type),
     * and in each cell in the array inserts an object that is a type of animal (lion, elephant, bear, etc ...),
     * and returns the array it built
     * @param size An integer that describes the size of the array we want to build
     * @return An array of size (size) of "animal" initialized by the user
     */
    private static Animal[] BuildArrayAnimals(int size)
    {
        int Selection;
        Animal[] Animals_Array = new Animal[size];

        for (int i = 0; i < size; i++) 
        {
            System.out.println("\nAnimal number " + (i + 1));
            System.out.println("Which Animal You Want To Add?:");
            System.out.println("1. Lion");
            System.out.println("2. Bear");
            System.out.println("3. Elephant");
            System.out.println("4. Giraffe");
            System.out.println("5. Turtle");
            System.out.println("6. Exit");
            
            System.out.print("Enter your choice:");
            Selection = sc.nextInt();
            while (Selection <= 0 || Selection > 6)
            {
                System.out.println("Invalid input, please Enter a number between 1-6");
                System.out.print("Enter your choice: ");
                Selection = sc.nextInt();
            }
            if(Selection == 6)
            {
                System.exit(0);
            }
            System.out.println("Please Enter The Name Of The Animal:");
            String name = sc.next();
            switch (Selection) {
                case 1:
                    //Lion
                    Animals_Array[i] = new Lion(name);
                    break;
                case 2:
                    //Bear
                    AddBear(name, Animals_Array, i);
                    break;
                case 3:
                    //Elephant
                    AddElephant(name, Animals_Array, i);
                    break;
                case 4:
                    //Giraffe
                    AddGiraffe(name, Animals_Array, i);
                    break;
                case 5:
                    //Turtle
                    AddTurtle(name, Animals_Array, i);
                    break;
                default:
                    //invalid input
                    break;
            }
        }
        return Animals_Array;
    }

    /**
     * A method that receives as parameters an array of the "animal" type, the name of the animal,
     * and a place in the array (index).
     * It adds to the array where we received as a parameter a new "elephant" object with the name we received as a parameter
     * @param name A string of characters describing the name of the elephant (animal)
     * @param Animals_Array "Animal" array
     * @param i Position of any organ in the "animal" array we received
     */
    private static void AddElephant(String name, Animal[] Animals_Array, int i) {
        int Selection;
        double trunkLength;
        System.out.println("Do you want to choose a specific length for the elephant trunk?:");
        System.out.println("1. YES");
        System.out.println("2. NO");
        do {
            System.out.print("Enter your choice: ");
            Selection = sc.nextInt();
            switch (Selection) {
                case 1:
                    //YES
                    System.out.print("Enter length of the trunk (Number Between 0.5 To 3):");
                    trunkLength = sc.nextDouble();
                    while(trunkLength < 0.5 || trunkLength > 3)
                    {
                        System.out.println("Invalid input, Trunk Length Must Be Between 0.5 To 3:");
                        trunkLength = sc.nextDouble();
                    }
                    Animals_Array[i] = new Elephant(name, trunkLength);
                    break;
                case 2:
                    //NO
                    Animals_Array[i] = new Elephant(name);
                    break;
                default:
                    //invalid input
                    System.out.println("Invalid input, please Enter 1 or 2");
                    break;
            }
        } while (Selection != 1 && Selection != 2);
    }

    /**
     * A method that receives as parameters an array of the "animal" type, the name of the animal,
     * and a place in the array (index).
     * It adds to the array where we received as a parameter a new "Giraffe" object with the name we received as a parameter
     * @param name A string of characters describing the name of the Giraffe (animal)
     * @param Animals_Array "Animal" array
     * @param i Position of any organ in the "animal" array we received
     */
    private static void AddGiraffe(String name, Animal[] Animals_Array, int i) {
        Scanner sc = new Scanner(System.in);
        int Selection;
        double neckLength;
        System.out.println("Do you want to choose a specific length for the giraffe's neck? : ");
        System.out.println("1. YES");
        System.out.println("2. NO");
        do {
            System.out.print("Enter your choice: ");
            Selection = sc.nextInt();
            switch (Selection) {
                case 1:
                    //YES
                    System.out.print("Enter length of the neck (a real number between 1 - 2.5) : ");
                    neckLength = sc.nextDouble();
                    while(neckLength < 1 || neckLength > 2.5)
                    {
                        System.out.println("Invalid input, Neck Length Must Be Between 1 - 2.5:");
                        neckLength = sc.nextDouble();
                    }
                    Animals_Array[i] = new Giraffe(name, neckLength);
                    break;
                case 2:
                    //NO
                    Animals_Array[i] = new Giraffe(name);
                    break;
                default:
                    //invalid input
                    System.out.println("Invalid input, please Enter 1 or 2");
                    break;
            }
        } while (Selection != 1 && Selection != 2);
    }

    /**
     * A method that receives as parameters an array of the "animal" type, the name of the animal,
     * and a place in the array (index).
     * It adds to the array where we received as a parameter a new "Turtle" object with the name we received as a parameter
     * @param name A string of characters describing the name of the Turtle (animal)
     * @param Animals_Array "Animal" array
     * @param i Position of any organ in the "animal" array we received
     */
    private static void AddTurtle(String name, Animal[] Animals_Array, int i) {
        Scanner sc = new Scanner(System.in);
        int Selection;
        int age;
        System.out.println("Do you want to choose a specific age for the Turtle?: ");
        System.out.println("1. YES");
        System.out.println("2. NO");
        do {
            System.out.print("Enter your choice: ");
            Selection = sc.nextInt();
            switch (Selection) {
                case 1:
                    //YES
                    System.out.print("Enter the age (a integer number between 0 - 500) : ");
                    age = sc.nextInt();
                    while(age <= 0 || age > 500)
                    {
                        System.out.println("Invalid input, Age Must Be Between 0 - 500 (Higher Then Zero):");
                        age = sc.nextInt();
                    }
                    Animals_Array[i] = new Turtle(name, age);
                    break;
                case 2:
                    //NO
                    Animals_Array[i] = new Turtle(name);
                    break;
                default:
                    //invalid input
                    System.out.println("Invalid input, please Enter 1 or 2");
                    break;
            }
        } while (Selection != 1 && Selection != 2);
    }

    /**
     * A method that receives as parameters an array of the "animal" type, the name of the animal,
     * and a place in the array (index).
     * It adds to the array where we received as a parameter a new "Bear" object with the name we received as a parameter
     * @param name A string of characters describing the name of the Bear (animal)
     * @param Animals_Array "Animal" array
     * @param i Position of any organ in the "animal" array we received
     */
    private static void AddBear(String name, Animal[] Animals_Array, int i) {
        Scanner sc = new Scanner(System.in);
        int Selection;

        System.out.println("Please select the bear's fur color: ");
        System.out.println("1. White");
        System.out.println("2. Gray");
        System.out.println("3. Black");
        System.out.println("4. Default");

        do {
            System.out.print("Enter your choice: ");
            Selection = sc.nextInt();
            switch (Selection) {
                case 1:
                    //White
                    Animals_Array[i] = new Bear(name, "WHITE");
                    break;
                case 2:
                    //Gray
                    Animals_Array[i] = new Bear(name, "GRAY");
                    break;
                case 3:
                    //Black
                    Animals_Array[i] = new Bear(name, "BLACK");//TODO
                    break;
                case 4:
                    //default
                    Animals_Array[i] = new Bear(name);
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
                    break;
            }
        }
        while (Selection < 1 || Selection > 4);
    }

}
