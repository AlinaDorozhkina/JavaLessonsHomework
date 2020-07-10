import java.util.Random;

public class Main {
    public static void main(String[] args) {
        createPets();

        createCatsShelter();
    }

    public static void createPets() {
        System.out.println("Let's feed out pets!");
        Cat cat = new Cat("Nick", 10);
        Cat cat1 = new Cat("Lou", 8);

        Plate plate = new Plate(15, "red");
        plate.info();
        cat.catInfo();
        cat.eat(plate);
        cat.catInfo();
        plate.info();
        cat1.catInfo();
        cat1.eat(plate);
        cat1.catInfo();
        plate.info();

    }

    public static void createCatsShelter() {
        System.out.println("\nNow let's go to the cat's shelter and feed cats!");

        AutoPlate autoPlate = new AutoPlate(10, "yellow ", 100);
        autoPlate.info();

        Cat[] cats = new Cat[10];
        String[] names =
                {"Murzik", "Murka", "Nia", "Lucky", "Loki", "Archi", "Zefir", "Cocos", "Alf", "Tim", "Kitty", "Sofi", "Agata", "Kitty", "Grace", "Margo", "Alex"};
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat();
            Random random = new Random();
            String name = chooseName(cats, names);
            cats[i].setName(name);
            cats[i].setAppetite(random.nextInt(20) + 5);
            cats[i].eat(autoPlate);
            autoPlate.info();

        }
        printInfo(cats);
        autoPlate.info();
        System.out.println(autoPlate.getContainer() + " in the container");

    }


    // сделаем так, чтобы имена котов не повторялись
    public static String chooseName(Cat[] cats, String[] names) {

        int nameIndex;

        do {
            Random random = new Random();
            nameIndex = random.nextInt(names.length - 1);
        } while (names[nameIndex] == null);
        String temp = names[nameIndex];
        names[nameIndex] = null;
        return temp;
    }

    public static void printInfo(Cat[] cats) {
        for (Cat cat : cats) {
            System.out.println(String.format("Cat %s has appetite %d grams, fullness is %s", cat.getName(), cat.getAppetite(), cat.getFullness()));
        }
    }
}
