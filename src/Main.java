public class Main {
    public static void main(String[] args) {
        System.out.print ("Task 2. ");
        initializeVariables();

        System.out.println ("Task 3. Result: " +calculate(6,4,7,8));

        System.out.println ("Task 4. " + isAmountIncludedInRange(2,7));

        System.out.print ("Task 5. ");
        checkPositiveOrNegative(-5);
        checkPositiveOrNegative(20);

        System.out.println ("Task 6. Is number negative " +isNumberNegative(-5));

        System.out.print("Task 7. ");
        sayHello("Max");

        System.out.print ("Task 8. ");
        checkLeapYear(500);
        checkLeapYear(2020);

    }
    // task2
    public static void initializeVariables (){
        int surfaceArea = 510072000;
        short coreRadius =3485;
        double equatorialCircumference  = 40075.017;
        double meridionalCircumference = 40007.86;
        float surfaceGravity =9.798f;
        byte averageTemperature = 14;
        long earthPopulation=7632819325L;
        char symbolSlash = '/';
        boolean correctInfo = true;

        System.out.println ("Earth Fact Sheet:\n" +
                "Surface area " + surfaceArea + " km2;" +
                "\nCore radius "+coreRadius + " km;"+
                "\nEquatorial/Meridional circumference " + equatorialCircumference+ symbolSlash+meridionalCircumference +" km;"+
                "\nSurface gravity " + surfaceArea + "m/s2;"+
                "\nAverage temperature " + averageTemperature + " degrees;"+
                "\nEarth population "+earthPopulation + " people." +
                "\nIs information correct? " + correctInfo);
    }
    //task 3
    public static float calculate (float a, float b, float c, float d){
        return  a * (b + (c / d));
    }

    //task 4
    public static boolean isAmountIncludedInRange (int a, int b){
        if (a+b>=10 && a+b<=20){
            return true;
        } else {
            return false;
        }
    }
    //task 5
    public static void checkPositiveOrNegative (int number){
        if (number >=0){
            System.out.println ("Number " + number + " is positive");
        } else {
            System.out.println ("Number " + number + " is negative");
        }
    }
    // task 6
    public static boolean isNumberNegative (int number){
        if (number <0){
            return true;
        } else {
            return false;
        }
    }
    // task 7
    public static void sayHello (String name){
        System.out.println ("Hello, " + name + "!");
    }
    //task 8
    public static void checkLeapYear(int year){
        if (year %4 ==0 && year %100!=0 || year %400==0){
            System.out.println (year + " is a leap year.");
        } else {
            System.out.println (year + " is not a leap year");
        }
    }

}


