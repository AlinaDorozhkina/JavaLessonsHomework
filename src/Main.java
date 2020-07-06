public class Main {

    public static void main(String[] args) {
        Cat cat1 = new Cat("Barsik");
        cat1.run(150);
        cat1.swim(500);
        cat1.jump(2);
        Dog dog1 = new Dog("Bim");
        dog1.run(1000);
        dog1.swim(10);
        dog1.jump(5);

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
