package API;

import java.util.Random;

public class RandomPetName {
    public static  String getPetName(){
        Random random = new Random();
        String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        int upperBound = 26;
        String   petName = alphabet[random.nextInt(upperBound)].toUpperCase();
        for(int i=0; i<6; i++){
            petName+=alphabet[random.nextInt(upperBound)];
        }
        System.out.println(petName);
        return  petName;
    }
}

