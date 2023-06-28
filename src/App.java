import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook(); // заполняем массив сотрудников с использованием метода Добавить сотрудника;
        // 11 сотрудников для проверки отказа "нет свободных мест"

        employeeBook.addEmployee(new Employee("Никулин", "Юрий", "Михайлович", 1, 140));
        employeeBook.addEmployee(new Employee("Вицин", "Георгий", "Михайлович", 1, 130));
        employeeBook.addEmployee(new Employee("Моргунов", "Евгений", "Александрович", 1, 120));
        employeeBook.addEmployee(new Employee("Демьяненко", "Александр", "Сергеевич", 2, 120));
        employeeBook.addEmployee(new Employee("Селезнева", "Наталья", "Игоревна", 2, 115));
        employeeBook.addEmployee(new Employee("Варлей", "Наталья", "Владимировна", 2, 105));
        employeeBook.addEmployee(new Employee("Пуговкин", "Михаил", "Иванович", 3, 80));
        employeeBook.addEmployee(new Employee("Басов", "Владимир", "Павлович", 3, 80));
        employeeBook.addEmployee(new Employee("Гребешкова", "Нина", "Павловна", 4, 90));
        employeeBook.addEmployee(new Employee("Папанов", "Анатолий", "Дмитриевич", 5, 140));
        employeeBook.addEmployee(new Employee("Мордюкова", "Нонна", "Викторовна", 5, 90));

        employeeBook.deleteEmployee(2); // удаляем сотрудника с id 2, и оставляем в таком состоянии для проверки корректоности работы с неполным списком -
        // ошибки NullPointerException
        System.out.println();
        System.out.println("Печать полного списка сотрудников со всеми данными:");
        employeeBook.printAllEmployeesData();
        System.out.println();

        employeeBook.transferBetweenDepartments("Гребешкова", "Нина", "Павловна", 2);// переводим сотрудника в другой отдел
        employeeBook.changeSalary("Гребешкова", "Нина", "Павловна", 85); // меняем сотруднику зарплату

        System.out.println("Печать списка всех сотрудников со всеми данными по отделам:");
        employeeBook.printByDepartment();
        System.out.println();

        System.out.println("На зарплату всех сотрудников в месяц требуется " + employeeBook.calculateSumSalaryInMonth() + " руб");
        System.out.println();

        System.out.println("Минимальная зарплата у сотрудника(-ов):");
        System.out.println(Arrays.toString(employeeBook.findMinSalaryEmployee()));
        System.out.println();

        System.out.println("Максимальная зарплата у сотрудника(-ов):");
        System.out.println(Arrays.toString(employeeBook.findMaxSalaryEmployee()));
        System.out.println();

        System.out.println("Средняя зарплата сотрудника в месяц: " + employeeBook.middleSalaryInMonth() + " руб");
        System.out.println();

        System.out.println("Список всех сотрудников (только ФИО):");
        employeeBook.printAllFullNames();
        System.out.println();

        double indexPercent = 5; // индексация зарплат для всех сотрудников
        employeeBook.indexSalaryTotal(indexPercent);

        int department = 2;
        System.out.println("Минимальная зарплата у сотрудника(-ов) отдела " + department + " : " + employeeBook.minSalaryEmployeeInDepartment(department));
        System.out.println(); // здесь видна работа метода индексации зарплат по всем сотрудникам

        System.out.println("Максимальная зарплата у сотрудника(-ов) отдела " + department + " : " + employeeBook.maxSalaryEmployeeInDepartment(department));
        System.out.println(); // здесь видна работа метода индексации зарплат по всем сотрудникам

        double percent = 10; // индексация зарплат сотрудников выбранного отдела; для удобства оценки работы оставлен тот же отдел
        employeeBook.IndexSalaryInDepartment(percent, department);

        employeeBook.printAllEmployeesDataInDepartmentWithinDep(2); // виден результат работы индексации по отделу
        System.out.println();

        double num1 = 100;
        System.out.println("Список сотрудников, чья зарплата ниже, чем " + num1 + " : ");
        employeeBook.belowSalaryEmployee(num1);
        System.out.println();

        double num2 = 120;
        System.out.println("Список сотрудников, чья зарплата выше или равна " + num2 + " : ");
        employeeBook.aboveSalaryEmployee(num2);
        System.out.println();
    }
}