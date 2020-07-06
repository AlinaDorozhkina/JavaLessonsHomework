public class Dog extends Animal{
    private String name;

    public Dog(String name){
        super (500, 10,0.5f);
        this.name=name;
    }

    @Override
    public void swim(float inputSwimValue){
        System.out.print(String.format("%s swim %.2f metres: ", name, inputSwimValue));
        super.swim(inputSwimValue);
    }
    @Override
    public void run (float inputRunValue){
        System.out.print(String.format("%s runs %.2f metres: ", name, inputRunValue));
        super.run(inputRunValue);
    }
    @Override
    public void jump(float inputJumpValue){
        System.out.print(String.format("%s jumps %.2f metres: ", name, inputJumpValue));
        super.jump(inputJumpValue);
    }
}

/*public class Dog extends Animal{


    public Dog(float maxRunValue, float maxSwimValue, float maxJumpValue) {
        super(maxRunValue, maxSwimValue, maxJumpValue);
    }

}

 */
