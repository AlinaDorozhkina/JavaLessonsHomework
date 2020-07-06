public abstract class Animal {
    protected float runValue;
    protected float swimValue;
    protected float jumpValue;


    public Animal(float runValue, float swimValue, float jumpValue) {
        this.runValue = runValue;
        this.swimValue = swimValue;
        this.jumpValue = jumpValue;
    }

    public void run(float inputRunValue) {
        boolean result;
        if (inputRunValue <= runValue && inputRunValue > 0) {
            result = true;
        } else {
            result = false;
        }
        System.out.println(result);

    }

    public void swim(float inputSwimValue) {
        boolean result;
        if (inputSwimValue <= swimValue && inputSwimValue > 0) {
            result = true;
        } else {
            result = false;
        }
        System.out.println(result);
    }

    public void jump(float inputJumpValue) {
        boolean result;
        if (inputJumpValue <= jumpValue && inputJumpValue > 0) {
            result = true;
        } else {
            result = false;
        }
        System.out.println(result);
    }
}

/*public abstract class Animal {
    protected float maxRunValue;
    protected float maxSwimValue;
    protected float maxJumpValue;


    public Animal(float maxRunValue, float maxSwimValue, float maxJumpValue) {
        this.maxRunValue = maxRunValue;
        this.maxSwimValue = maxSwimValue;
        this.maxJumpValue = maxJumpValue;
    }

    protected void run(float distance) {
        System.out.println("Run: " + distance + " metres: " + isItPossibleToDo(distance, maxRunValue));

    }

    protected void swim(float distance) {
        System.out.println("Swim: " + distance + " metres: " + isItPossibleToDo(distance, maxSwimValue));
    }

    protected void jump(float altitude) {
        System.out.println("Jump: " + altitude + " metres: " + isItPossibleToDo(altitude, maxJumpValue));
    }


    private static boolean isItPossibleToDo(float inputValue, float maxValue) {
        if (inputValue <= maxValue && inputValue>0) {
            return true;
        }
        return false;

    }
}

 */
