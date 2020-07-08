public class Cat {
    private String name;
    private int appetite;
    private boolean  fullness=false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;

    }
    public Cat(){

    }

    public boolean getFullness(){
        return fullness;
    }

    public void eat(Plate p) {
        if (p.decreaseFood(appetite)) {
            System.out.println(name+" eats "+appetite + " grams");
            fullness =true;
        } else {
            System.out.println(name +" wants to eat " + appetite + " grams");
            fullness=false;
        }
    }
    public void catInfo(){
        System.out.println(name+" well-fed " + fullness);
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

}
