public class AutoPlate extends Plate {

    // автокормушка для кошек
    private int container;

    public AutoPlate(int food, String color, int container) {
        super(food, color);
        this.container=container;
    }

    public int getContainer() {
        return container;
    }

    private int addFoodFromContainer(int portion) {
        int remains = portion - food;// вычисляем , сколько не хватаем корма в тарелке, чтоб накормить кота
        if ((container > remains)) {
            System.out.println("Autoadding " + remains + " grams \"Whiskas\" from the auto container");
            return remains;
        } else {
            //int remains1 = remains - container;
            if (container>0) {
                System.out.println("Autoadding " + container + " grams \"Whiskas\" from the auto container");
            }
            else {
                System.out.println("Conteiner is empty now");
            }
            return container;

        }
    }

    @Override
    public boolean decreaseFood(int portion) {
        if (isPlateEmpty(portion)){
            food-=portion;
            return true;
        } else {
            int remains =addFoodFromContainer(portion);
            food += remains;
            container -= remains;
            int dif =food - portion;
            if (dif<0) {
                return false;
            } else{
                food-=portion;
                return true;
            }


        }
    }
}
