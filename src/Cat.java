public class Cat {
    private String name;
    private int appetite;
    private boolean fullness = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;

    }

    public Cat() {

    }

    public boolean getFullness() {
        return fullness;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }


    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        System.out.println(String.format("%s wants to have %d grams", name, appetite));
        if (p.decreaseFood(appetite)) {
            System.out.println(String.format("%s eats %d grams", name, appetite));
            fullness = true;
        }
    }

    public void catInfo() {
        System.out.println(String.format("%s well-fed is %b", name, fullness));
    }

}
