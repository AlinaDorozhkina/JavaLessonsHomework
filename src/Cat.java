

public class Cat extends Animal {
    private String name;
    public Cat(String name) {
        super(200, 0, 2);
        this.name=name;
    }

    @Override
    public void swim(float inputSwimValue){
        System.out.println(String.format("%s can't swim", name));
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
