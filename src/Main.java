public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Abramov Evgenii Ivanovich", "director", "director@mail.ru", "+79105555555", 100000.5, 50);
        employees[1] = new Employee("Egorova Lidiia Mikhailovna", "accountant", "account@mail.ru", "+79104444444", 70000.0, 42);
        employees[2] = new Employee("Ivanova Mariia Sergeevna", "administrator", "admin@mail.ru", "+79101111111", 50000.65, 32);
        employees[3] = new Employee("Matrosova Irina Leonidovna", "waiter", "waiter@mail.ru", "+7966666666", 40000.0, 25);
        employees[4] = new Employee("Rusakov Dmitrii Nikolaevich", "chef", "chef@mail.ru", "+7999999999", 90000.8, 41);

        findOlderThan40(employees);
    }

    static void findOlderThan40(Employee[] employees){
        System.out.println("Selection by age (more than 40 years old)");
        for (int i=0;i<employees.length;i++){
            if(employees[i].getAge()>40){
                employees[i].printEmployeeInfo();
            }
        }

    }
}
