public class Main {

    public static void main(String[] args) {
        createParticularObject();

        createRandomCat();
        createRandomDog();
    }

    public static void createParticularObject() {
        Cat cat1 = new Cat("Barsik");
        cat1.run(150);
        cat1.swim(500);
        cat1.jump(2);
        Dog dog1 = new Dog("Bim");
        dog1.run(1000);
        dog1.swim(10);
        dog1.jump(5);

    }

    public static void createRandomCat() {
        Cat cat2 = new Cat(createRandomValue(1000), createRandomValue(0), createRandomValue(10));
        cat2.setName("RandomCat");
        System.out.println("Random cat move:");
        cat2.run(500);
        cat2.swim(10);
        cat2.jump(8);
    }

    public static void createRandomDog() {
        Dog dog2 = new Dog(createRandomValue(2000), createRandomValue(20), createRandomValue(3));
        dog2.setName("RandomDog");
        System.out.println("Random dog move:");
        dog2.run(1000);
        dog2.swim(15);
        dog2.jump(2);
    }

    public static float createRandomValue(int bound) {

        return (float) (Math.random() * bound);

    }


}
/*public class Main {

    public static void main(String[] args) {
        Cat cat = new Cat(200, 2, 2);
        Dog dog = new Dog(500, 10, 0.5f);

        System.out.println("Cat:");
        cat.run(150);
        cat.jump(1.5f);
        cat.swim(100);


        System.out.println("Dog:");
        dog.run(500);
        dog.jump(1);
        dog.swim(9.5f);

    }

}

 */
