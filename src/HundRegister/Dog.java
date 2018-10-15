/*tola2470, Tobias Larsson*/
package HundRegister;
public class Dog {
    private String name;
    private String breed;
    private int age;
    private int weight;
    private double tailLength=0.0;
    
    public Dog(String name, String breed, int age, int weight){
        
        this.name=name;
        this.breed=breed;
        this.age=age;
        this.weight=weight; 
    }
    public double getTailLength(){
        if (breed.equals("tax")| breed.equals("Tax")){
            tailLength=3.7;
        }else{
            tailLength=((age*weight)/10.0);
        }
        return tailLength;
    }
    public void printDog(){
        System.out.println(name+", "+breed+", "+age+", "+weight);
    }
    public String getName(){
        return name;
    }
    public String getBreed(){
        return breed;
    }
    public int getAge(){
        return age;
    }
    public int getWeight(){
        return weight;
    }
    public void increaseAge(){
    	this.age++;
    }
    public String toString(){
        return "Hunden heter "+name+", är rasen "+breed+", och är "+age+"är gammal, väger "+weight+"kg och har svanslängden "+tailLength;

    }
}
