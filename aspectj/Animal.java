
public class Animal {
    public String name;

    

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    
    public String setName(String name) {
        this.name = name;
        return "Jumbo";
    }

}