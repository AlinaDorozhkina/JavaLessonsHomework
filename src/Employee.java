public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String telephoneNumber;
    private double salary;
    private int age;

    public Employee(String fullName, String position, String email, String telephoneNumber, double salary, int age){
        this.fullName=fullName;
        this.position=position;
        this.email=email;
        this.telephoneNumber=telephoneNumber;
        this.salary=checkMinSalary(salary);
        this.age=checkAge(age);
    }
    public void setSalary(double salary){
        checkMinSalary(salary);
        this.salary=salary;
    }
    public double getSalary (){
        return salary;
    }

    private double checkMinSalary(double salary){
        if (salary>12130){
            return salary;

        } else {
            System.out.println((String.format("Warning! %s Salary %.2f is less than min. Fix it.", fullName, salary)));

        }
        return 0.00;

    }

    private int checkAge(int age){
        if (age>=18){
            return age;
        } else {
            System.out.println(String.format("Warning! Impossible to hire. %s younger than 18. Check age.",fullName));
        }
        return 0;

    }
    public void setAge(int age){
        checkAge(age);
        this.age=age;

    }

    public int getAge (){
        return age;
    }

    public void printEmployeeInfo(){
        System.out.println(String.format("Employee's information:\nFull Name: %s, position: %s, email: %s, telephone number: %s, salary: %.2f rubles, age: %d years", fullName,position, email,telephoneNumber,salary,age ));

    }
}
