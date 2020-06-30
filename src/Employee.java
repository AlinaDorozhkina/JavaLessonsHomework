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
        this.salary=salary;
        this.age=age;
    }
    int getAge (){
        return age;
    }

    void printEmployeeInfo(){
        System.out.println(String.format("Employee's information:\nFullname: %s, position: %s, email: %s, telephone number: %s, salary: %.2f rubles, age: %d years", fullName,position, email,telephoneNumber,salary,age ));

    }
}
