public class Plate {
    protected int food;
    protected String color;

    public Plate(int food, String color) {
        this.food = food;
        this.color = color;
    }

    public void info() {
        System.out.println(String.format("There are %d grams \"Whiskas\" in the %s plate.", food, color));
    }

    public boolean decreaseFood(int portion) {
        if (isPlateEmpty(portion)) {
            food -= portion;
            return true;
        } else {
            addSomeFood(portion);
            food -= portion;
            return true;
        }


    }

    protected boolean isPlateEmpty(int n) {
        int remains = food - n;
        if (remains < 0) {
            return false;
        }
        return true;
    }

    protected void addSomeFood(int portion) {
        int remains = portion - food;
        food += remains;
        System.out.println("add " + remains + " grams to the plate");

    }
}
