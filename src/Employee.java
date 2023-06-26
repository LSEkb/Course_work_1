public class Employee {
    private String surname;
    private String name;
    private String patronymic;
    private int department;
    private double salary;
    private final int id;

    private static int idCounter = 1;

    public Employee(String surname, String name, String patronymic, int department, double salary) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.department = department;
        this.salary = salary;
        this.id = idCounter++;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }
    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        int n1 = 1, n2 = 5;
        if (department >= n1 && department <= n2) {
            this.department = department;
        }
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID " + id + " ФИО - " + surname + " " + name + " " + patronymic + ", отдел " + department + ", зарплата " + salary;
    }
}
