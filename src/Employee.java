import java.util.Objects;

public class Employee {
    private String surname;
    private String name;
    private String patronymic;
    private int department;
    private double salary;
    private final int id;

    private static int idCounter = 1;
    static int startDep = 1, finalDep = 5;

    public Employee(String surname, String name, String patronymic, int department, double salary) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.department = department;
        this.salary = salary;
        this.id = idCounter++;
    }

    public Employee(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.id=idCounter;
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
        if (department >= startDep && department <= finalDep) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return (surname == ((Employee) o).getSurname() && name == ((Employee) o).getName() && patronymic == ((Employee) o).getPatronymic());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, patronymic);

    }
}
