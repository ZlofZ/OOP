package HundRegister;
import java.util.Scanner;
import java.util.ArrayList;
//tola2470, Tobias Larsson
public class Dogregistry{
    private Scanner keyboard = new Scanner(System.in);
    private ArrayList<Dog> dogList = new ArrayList<>();
    public String readText(String initText){
        System.out.print(initText);
        return keyboard.nextLine();
    }
    public int readNumber(String initText){
        System.out.print(initText);
        int tal = keyboard.nextInt();
        keyboard.nextLine();
        return tal;
    }
    public double readDouble(String initText){
        System.out.print(initText);
        double tal = keyboard.nextDouble();
        keyboard.nextLine();
        return tal;
    }
    /*----------------------------------------------------------------------------------*/
    private void preRegDogs(){
        for(int i=0; i<10; i++){
            String namn="namn";
            String Breed="Breed";
            int age=2;
            int Weight=2;
            namn=namn+i;
            Breed=Breed+i;
            age=age+i;
            Weight=Weight+i;
            dogList.add(new Dog(namn, Breed, age, Weight));
        }
        dogList.add(new Dog("fff","Tax",4,5));
    }
    /*----------------------------------------------------------------------------------*/
    private void drawMenu(){
        System.out.println("---------Start!--------");
        System.out.println("kommandon");
        System.out.println("1. Registrera");
        System.out.println("2. öka ålder");
        System.out.println("3. Lista");
        System.out.println("4. Ta bort");
        System.out.println("5. Avsluta");
    }
    private void registerNewDog(){
        String DogName = readText("Vad är hundens namn? ");
        String DogBreed = readText("Vad är "+DogName+" för ras? ").toLowerCase();
        Integer DogAge = readNumber("Hur gammal är "+DogName+"? ");
        Integer DogWeight = readNumber("Hur mycket väger "+DogName+"? ");
        dogList.add(new Dog(DogName,DogBreed,DogAge,DogWeight));
    }
    private void increaseDogAge(){
        boolean existsInList=false;
        String nameOfDog = readText("Vilket namn har hunden som ska bli äldre? ");
        for (Dog p: dogList){
            if (p.getName().equals(nameOfDog)){
                existsInList=true;
                p.increaseAge();
                System.out.println("hunden ör ett är äldre nu.");
                break;
            }
        }
        if(existsInList==false){
            System.out.println("Hund med det namnet fanns ej i registret.");
        }
    }
    private void listaDogar(){
       double kortastTailLength = readDouble("Hur kort för svansen vara? ");
       DogPrint(kortastTailLength);
    }
    private void taBortDog(){
        boolean removed=false;
        String nameOfDog = readText("Vilket namn har hunden som ska tas bort? ");
        for (Dog p: dogList){
            if (p.getName().equals(nameOfDog)){
                removed=true;
                dogList.remove(p);
                System.out.println("hunden togs bort.");
                break;
            }
        }
        if(removed==false){
            System.out.println("hunden fanns inte.");
        }
    }
    private void DogPrint(double svL){
        for(Dog p: dogList){
            if(p.getTailLength()>=svL){
                System.out.println(p.getName()+" "+p.getBreed()+" "+p.getAge()+"är "+p.getWeight()+"kg svans: "+p.getTailLength());
            }
        }
    }
    private void initiera(){
        System.out.println("Welcome!");
        preRegDogs();
    }
    private void runProgram(){
        drawMenu();
        while(true){
            String kommando = readText("Vilket kommando ska köras?: ").toLowerCase();
            switch (kommando){
                case "registrera":
                case "r":
                    registerNewDog();
                    break;
                case "öka":
                case "ölder":
                case "öka ålder":
                case "ö":
                	increaseDogAge();
                	break;
                case "lista":
                case "l":
                    listaDogar();
                    break;
                case "ta bort":
                case "t":
                    taBortDog();
                    break;
                case "avsluta":
                case "a":
                	avsluta();
                    return;
            }
        }
    }
    private void avsluta(){
        System.out.println("Hejdå!");
        System.exit(0);
    }
    public static void main(String[] args){
        Dogregistry program;
        program = new Dogregistry();
        program.initiera();
        program.runProgram();
        program.avsluta();
    }
}