import java.util.*;

public class Main {
    public static void main(String[] args) {
        //1. Creez un programme qui trouve le minimum et le maximum d'un tableau d'entiers.
        Scanner scanner = new Scanner(System.in);
        int[] numbers;
        int size;

        System.out.println("Enter the size of the array");
        size = scanner.nextInt();
        numbers = new int[size];

        //Remplissage du tableau
        for(int i = 0; i < size; i++){
            System.out.println("Enter the element of the table "+ (i+1));
            numbers[i] = scanner.nextInt();

        }

        int minimum = numbers[0];
        int maximum = numbers[0];
        //Trouver le minimum dans le tableau
        for (int i = 1; i < size; i++){
            if(numbers[i] < minimum){
                minimum = numbers[i];
            }else if(numbers[i] > maximum){
                maximum = numbers[i];
            }

        }

        System.out.println("The minimum of the array is "+ minimum + " and the maximum is "+ maximum);

        //2. Créez un programme pour calculer l’aire d’un rectangle donné sa longueur et sa largeur.

        int width, height;

        System.out.println("Enter the height of the rectange");
        height = scanner.nextInt();
        System.out.println("Enter the width of the rectange");
        width = scanner.nextInt();

        System.out.println("The air of the rectangle is "+ width * height);
        
        verifyNumber(5);

    }

    //3. Écrivez une fonction pour vérifier si un nombre est positif, négatif ou nul.

    public static void verifyNumber(int number){
        if(number < 0){
            System.out.println("The number is negative");
        }else if (number > 0){
            System.out.println("The number is positive");
        }else {
            System.out.println("The number is equal to zero");
        }

    }
}