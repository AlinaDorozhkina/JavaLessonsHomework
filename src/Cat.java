public class Cat extends Animal {
    private String name;


    public Cat(String name) {
        super(200.0f, 0.0f, 2.0f);
        this.name = name;
    }

    public Cat(float runValue, float swimValue, float jumpValue) {
        super(runValue, swimValue, jumpValue);
    }


    @Override
    public void swim(float inputSwimValue) {
        System.out.println(String.format("%s can't swim", name));
    }

    @Override
    public void run(float inputRunValue) {
        System.out.print(String.format("%s runs %.2f metres: ", name, inputRunValue));
        super.run(inputRunValue);
    }

    @Override
    public void jump(float inputJumpValue) {
        System.out.print(String.format("%s jumps %.2f metres: ", name, inputJumpValue));
        super.jump(inputJumpValue);
    }

    public void setName(String name) {
        this.name = name;
    }
}
/*public class Cat extends Animal {


    public Cat(float maxRunValue, float maxSwimValue, float maxJumpValue) {
        super(maxRunValue, maxSwimValue, maxJumpValue);
    }

    @Override
    public void swim(float inputSwimValue){
        System.out.println("Cats can't swim");
    }
}

 */
