public class App {
    static Employee[] employees = new Employee[10];

    public static void main(String[] args) {

// данные для массива
        Employee nicYV = new Employee("Никулин Юрий Владимирович", 1, 140);
        Employee vicGM = new Employee("Вицин Георгий Михайлович", 1, 130);
        Employee morEa = new Employee("Моргунов Евгений Александрович", 1, 120);
        Employee demAS = new Employee("Демьяненко Александр Сергеевич", 2, 100);
        Employee celNI = new Employee("Селезнева Наталья Игоревна", 2, 115);
        Employee varNV = new Employee("Варлей Наталья Владимировна", 2, 105);
        Employee pugMI = new Employee("Пуговкин Михаил Иванович", 3, 80);
        Employee basVP = new Employee("Басов Владимир Павлович", 3, 125);
        Employee greNP = new Employee("Гребешкова Нина Павловна", 4, 90);
        Employee papAD = new Employee("Папанов Анатолий Дмитриевич", 5, 130);

        employees[0] = nicYV;
        employees[1] = vicGM;
        employees[2] = morEa;
        employees[3] = demAS;
        employees[4] = celNI;
        employees[5] = varNV;
        employees[6] = pugMI;
        employees[7] = basVP;
        employees[8] = greNP;
        employees[9] = papAD;

// проверка работы методов
        System.out.println("Полная информация о всех сотрудниках:");
        printAllEmployeesData();
        System.out.println();
        System.out.println("Всего расходы на зарплату в месяц: " + sumSalaryInMonth() + " рублей");
        System.out.println();
        System.out.println("Минимальная зарплата за месяц составила " + minSalaryInMonth() + " рублей");
        System.out.println();
        System.out.println("Максимальная зарплата за месяц составила " + maxSalaryInMonth() + " рублей");
        System.out.println();
        System.out.println("Средняя зарплата за месяц составила " + middleSalaryInMonth() + " рублей");
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


    public static double minSalaryInMonth() {
        double min = employees[0].getSalary();
        for (Employee employee : employees) {
            if (employee.getSalary() < min) {
                min = employee.getSalary();
            }
        }
        return min;
    }


    public static double maxSalaryInMonth() {
        double max = employees[0].getSalary();
        for (Employee employee : employees) {
            if (employee.getSalary() > max) {
                max = employee.getSalary();
            }
        }
        return max;
    }


    public static double middleSalaryInMonth() {
        return sumSalaryInMonth() / employees.length;
    }


    public static void printAllFullNames() {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }


}
