public class Plate {
    private int food;
    private String color;

    public Plate(int food, String color) {
        this.food = food;
        this.color=color;
    }

    public void info(){
        System.out.println(String.format("There are %d grams \"Whiskas\" in the %s plate.", food, color));
    }

    public boolean decreaseFood(int portion) {
        if (isPlateEmpty(portion)) {
            food -= portion;
            return true;
        } else {
            System.out.print("There is no enough 'Whiskas' in the plate, because ");
        }
        return false;
    }

    private boolean isPlateEmpty(int portion){
        int remains = food-portion;
        if (remains<0){
            return false;
        }
        return true;
    }
}
