import java.util.Random;

public class Main {
    public static void main(String[] args) {
        createObject();

        feedCats();
    }

    public static void createObject(){
        Cat cat = new Cat("Nick", 10);
        Cat cat1 = new Cat("Lou", 8);

        Plate plate = new Plate(15, "red");
        plate.info();
        cat.catInfo();
        cat.eat(plate);
        plate.info();
        cat1.catInfo();
        cat1.eat(plate);
        plate.info();
        cat1.catInfo();

    }

    public static void feedCats() {
        Cat[] cats = new Cat[10];
        Plate newPlate = new Plate(50, "blue");
        newPlate.info();
        String[] names =
                {"Murzik", "Murka", "Nia", "Lucky", "Loki", "Archi", "Zefir", "Cocos", "Alf", "Tim", "Kitty", "Sofi", "Agata",};
        for (int i=0; i<cats.length;i++){
            cats[i]=new Cat();
            Random random = new Random();
            String name=choseName(cats, names);
            cats[i].setName(name);
            cats[i].setAppetite(random.nextInt(20)+2);
            cats[i].eat(newPlate);
            newPlate.info();
        }
        printInfo(cats);
        newPlate.info();

    }
// сделаем так, чтобы имена котов не повторялись
    public static String choseName(Cat [] cats, String [] names) {

        int nameIndex=0;

            do {
                Random random = new Random();
                nameIndex = random.nextInt(names.length - 1);
            } while (names[nameIndex] == null);
            String temp=names[nameIndex];
            names[nameIndex] = null;
        return temp;
    }

    public static void printInfo(Cat [] cats){
        for (int i=0; i<cats.length;i++){
            System.out.println(String.format("Cat %s has appetite %d grams, fullness is %s", cats[i].getName(), cats[i].getAppetite(),cats[i].getFullness()));
        }
    }
}
