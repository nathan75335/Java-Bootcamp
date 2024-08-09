import java.util.*;
public class Main {
    public static void main(String[] args) {
        /*
            Projet 3 : Calculateur d'IMC
            Objectif du Projet
            Développer un calculateur d'IMC qui calcule l'indice de masse corporelle et fournit une
            et interpreter les resultats.
         */
        while(true){

            boolean isValid = true;
            float weight = 0;
            float height = 0;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter you weight in kg:");
            String weightInputText = scanner.nextLine();
            System.out.println("Enter you height in meter:");
            String heightTextInputText = scanner.nextLine();

            try{
                weight = Float.parseFloat(weightInputText);
            }catch (NumberFormatException e){
                System.out.println("Invalid weight input");
                isValid = false;
            }

            try{
                height = Float.parseFloat(heightTextInputText);
            }catch (NumberFormatException e){
                System.out.println("Invalid height input");
                isValid = false;
            }

            if(weight > 1000 && weight < 0){
                System.out.println("You are lying!! you can not have a weight greater than 1000 kg!!!!");
                isValid = false;
            }else if(height > 4 && height < 0){
                System.out.println("You are lying!! you can not have a height greater than 4 meter!!!!");
                isValid = false;
            }

            if(!isValid){
                continue;
            }

            float imc = calculateImc(weight, height);
            System.out.println("Your imc is: " + getResultInterpretation(imc));
        }
    }

    public static float calculateImc(float weight, float height){
        return weight / (height * height);
    }

    public static String getResultInterpretation(float imc){
        String result = "";

        if(imc < 18.5){
            result = "Insufficient Weight";
        }else if(imc >= 18.5 && imc < 25){
            result  = "Normal weight";
        }else if(imc >= 25 && imc < 27){
            result = "Overweight grade I";
        }else if(imc >= 27 && imc < 30){
            result = "Overweight grade II (pre-obesity)";
        }else if(imc >= 30 && imc < 35){
            result = "Type I obesity";
        }else if(imc >= 35 && imc < 40){
            result = "Type II obesity";
        }else if(imc >= 40 && imc < 50){
            result = "Type III obesity (morbid)";
        }else if(imc >= 50) {
            result = "Type III obesity";
        }

        return result;
    }

}