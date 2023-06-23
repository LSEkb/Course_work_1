import java.util.Arrays;

public class App {
    static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        // данные для массива
        employees[0] = new Employee("Никулин Юрий Владимирович", 1, 140);
        employees[1] = new Employee("Вицин Георгий Михайлович", 1, 130);
        employees[2] = new Employee("Моргунов Евгений Александрович", 1, 120);
        employees[3] = new Employee("Демьяненко Александр Сергеевич", 2, 100);
        employees[4] = new Employee("Селезнева Наталья Игоревна", 2, 115);
        employees[5] = new Employee("Варлей Наталья Владимировна", 2, 80);
        employees[6] = new Employee("Пуговкин Михаил Иванович", 3, 80);
        employees[7] = new Employee("Басов Владимир Павлович", 3, 125);
        employees[8] = new Employee("Гребешкова Нина Павловна", 4, 90);
        employees[9] = new Employee("Папанов Анатолий Дмитриевич", 5, 140);

        // проверка работы методов

        System.out.println("Полная информация о всех сотрудниках:");
        printAllEmployeesData();
        System.out.println();
        System.out.println("Всего расходы на зарплату в месяц: " + sumSalaryInMonth() + " руб.");
        System.out.println();
        System.out.println("Минимальная зарплата за месяц у сотрудника " + minSalaryEmployee());
        System.out.println();
        System.out.println("Максимальная зарплата за месяц у сотрудника " + maxSalaryEmployee());
        System.out.println();
        System.out.println("Варианты метода с возвратом массива:");
        Employee[] empMin = minSalaryEmployee1();
        for (int i = 0; i < employees.length; i++) {
            if (empMin[i] != null) System.out.println("Минимальная зарплата за месяц у сотрудника " + empMin[i]);
        }
        // Чтобы не печатать пустые ячейки
        System.out.println();
        System.out.println("Максимальная зарплата за месяц у сотрудника: " + Arrays.toString(maxSalaryEmployee1()));
        System.out.println();
        System.out.println("Средняя зарплата за месяц составила " + middleSalaryInMonth() + " руб.");
        System.out.println();
        System.out.println("Список всех сотрудников:");
        printAllFullNames();
    }

    public static void printAllEmployeesData() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static double sumSalaryInMonth() {
        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    public static Employee minSalaryEmployee() {
        double min = employees[0].getSalary();
        Employee employeeMin = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() < min) {
                min = employee.getSalary();
                employeeMin = employee;
            }
        }
        return employeeMin;
    }

    public static Employee maxSalaryEmployee() {
        double max = employees[0].getSalary();
        Employee employeeMax = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() > max) {
                max = employee.getSalary();
                employeeMax = employee;
            }
        }
        return employeeMax;
    }
    // у методов, определяющих сейчас сотрудника с минимальной/максимальной зарплатой, есть существенный
    // недостаток - они возвращают данные одного человека. если у нас несколько человек, то лучше сдеалть
    // возврат из метода массива, далее два варианта, каждый со своими недостатками:
    public static Employee[] minSalaryEmployee1() {
        double min = employees[0].getSalary();
        Employee[] emplMin = new Employee[employees.length];
        for (Employee employee : employees) {
            if (employee.getSalary() <= min) {
                min = employee.getSalary();
            }
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() == min) {
                emplMin[i] = employees[i];
            }
        }
        return emplMin;
    }
    // вариант метода для случаев, когда у нас несколько сотрудников получают минимальную зарплату, печать пустых ячеек убираем в основном коде
    // (более красивый вывод в консоль, но не очень красивый код)

    public static Employee[] maxSalaryEmployee1() {
        double max = employees[0].getSalary();
        Employee[] emplMax = new Employee[employees.length];
        for (Employee employee : employees) {
            if (employee.getSalary() >= max) {
                max = employee.getSalary();
            }
        }
        int k = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() == max) {
                emplMax[i] = employees[i];
                if (emplMax[i] != null) {
                    k++;
                }
            }
        }
        Employee[] emplMaxFinal = new Employee[k];
        int j = 0;
        for (int i = 0; i < emplMax.length; i++) {
            if (emplMax[i] != null) {
                emplMaxFinal[j] = emplMax[i];
                j++;
            }
        }
        return emplMaxFinal;
    }
    // чтобы не писать в коде удаление пустых ячеек перед выводом на печать. но тогда не получится запустить нашими средствами красивый вывод данных

    public static double middleSalaryInMonth() {
        return sumSalaryInMonth() / employees.length;
    }

    public static void printAllFullNames() {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }
}
