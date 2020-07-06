

public abstract class Animal {
    protected float runValue;
    protected float swimValue;
    protected float jumpValue;



    public Animal (float runValue, float swimValue, float jumpValue){
        this.runValue=runValue;
        this.swimValue=swimValue;
        this.jumpValue=jumpValue;
    }

    protected void run (float inputRunValue) {
        boolean result;
        if (inputRunValue <= runValue&& inputRunValue>0) {
            result =true;
        } else{
            result=false;
        }
        System.out.println(result);

    }
    protected void swim (float inputSwimValue){
        boolean result;
        if (inputSwimValue <= swimValue&&inputSwimValue>0) {
            result =true;
        } else{
            result=false;
        }
        System.out.println(result);
    }
    protected void jump (float inputJumpValue){
        boolean result;
        if (inputJumpValue <= jumpValue&&inputJumpValue>0) {
            result =true;
        } else{
            result=false;
        }
        System.out.println(result);
    }
    private void move(){

    }

}
