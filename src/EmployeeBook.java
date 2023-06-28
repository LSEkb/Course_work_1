public class EmployeeBook {
    private Employee[] employees = new Employee[10];

    public void addEmployee(Employee employee) {
        boolean isAddedEmpl = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                isAddedEmpl = true;
                break;
            }
        }
        if (!isAddedEmpl) {
            System.out.println("Нет вакантных мест");
        }
    }

    public void deleteEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                employees[i] = null;
            }
        }
    }

    public void transferBetweenDepartments(String surname, String name, String patronymic, int department) {
        Employee employeeForSearch = new Employee(surname, name, patronymic);
        for (Employee employee : employees) {
            if (employee!=null&& employee.equals(employeeForSearch)) {
                employee.setDepartment(department);
            }
        }
    }


        public void changeSalary (String surname, String name, String patronymic,double salary){
            for (Employee employee : employees) {
                if (employee != null) {
                    boolean isThisPerson = employee.getSurname().equals(surname) && employee.getName().equals(name) && employee.getPatronymic().equals(patronymic);
                    if (isThisPerson) {
                        employee.setSalary(salary);
                    }
                }
            }
        }

        public void printByDepartment () {
            for (int i = Employee.startDep; i < Employee.finalDep; i++) {
                if (fillArrayEmployeeOfDepartment(i).length != 0) {
                    System.out.println("Сотрудники отдела " + i + ":");
                    printEmployeesWithinNull(fillArrayEmployeeOfDepartment(i));
                } else {
                    System.out.println("В отделе " + i + " нет сотрудников");
                }
            }
        }

        public void printAllEmployeesData () {
            for (Employee employee : employees) {
                if (employee != null) {
                    System.out.println(employee);
//            если вдруг зачем-то надо отображение вакантных мест:
//            }else{
//                System.out.println(" вакантно ");
                }
            }
        }

        public double calculateSumSalaryInMonth () {
            double sum = 0;
            for (Employee employee : employees) {
                if (employee != null) {
                    sum += employee.getSalary();
                }
            }
            return sum;
        }

        public Employee[] findMinSalaryEmployee () {
            double min = employees[0].getSalary();
            Employee[] employeeMin = new Employee[employees.length];
            for (Employee employee : employees) {
                if (employee != null && employee.getSalary() < min) {
                    min = employee.getSalary();
                }
            }
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] != null && employees[i].getSalary() == min) {
                    employeeMin[i] = employees[i];
                }
            }
            return employeeMin;
        }

        public Employee[] findMaxSalaryEmployee () {
            double max = employees[0].getSalary();
            Employee[] emplMax = new Employee[employees.length];
            for (Employee employee : employees) {
                if (employee != null && employee.getSalary() > max) {
                    max = employee.getSalary();
                }
            }
            int k = 0;
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] != null && employees[i].getSalary() == max) {
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

        public double middleSalaryInMonth () {
            return calculateSumSalaryInMonth() / employees.length;
        }

        public void printAllFullNames () {
            for (Employee employee : employees) {
                if (employee != null) {
                    System.out.println(employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic());
                }
            }
        }

        public void indexSalaryTotal ( double percent){
            for (Employee employee : employees) {
                if (employee != null) {
                    double salary = employee.getSalary() * (100 + percent) / 100;
                    employee.setSalary(salary);
                }
            }
        }

        public Employee minSalaryEmployeeInDepartment ( int department){
            // использована упрощенная модель для одного сотрудника и внутренний метод, формирующий массив сотрудников отдела
            Employee[] employeesOfDep = fillArrayEmployeeOfDepartment(department);
            Employee employeeMinInDep = employeesOfDep[0];
            for (int i = 0; i < employeesOfDep.length; i++) {
                if (employeesOfDep[i].getSalary() < employeeMinInDep.getSalary()) {
                    employeeMinInDep = employeesOfDep[i];
                }
            }
            return employeeMinInDep;
        }

        public Employee maxSalaryEmployeeInDepartment ( int department){
            // использована упрощенная модель для одного сотрудника
            Employee employeeMaxInDep = null;
            for (Employee employee : employees) {
                if (employee != null && employee.getDepartment() == department) {
                    if (employeeMaxInDep == null) {
                        employeeMaxInDep = employee;
                    } else if (employee.getSalary() >= employeeMaxInDep.getSalary()) {
                        employeeMaxInDep = employee;
                    }
                }
            }
            return employeeMaxInDep;
        }

        public void IndexSalaryInDepartment ( double percent, int department){
            for (Employee employee : employees) {
                if (employee != null && employee.getDepartment() == department) {
                    double salary = employee.getSalary() * (100 + percent) / 100;
                    employee.setSalary(salary);
                }
            }
        }

        public void printAllEmployeesDataInDepartmentWithinDep ( int department){
            System.out.println("Список сотрудников отдела " + department + ":");
            printEmployeesWithinNull(fillArrayEmployeeOfDepartment(department));
        }

        public void belowSalaryEmployee ( double num){
            for (Employee employee : employees) {
                if (employee != null && employee.getSalary() < num) {
                    printEmployeeDataWithinDepartment(employee);
                }
            }
        }

        public void aboveSalaryEmployee ( double num){
            for (Employee employee : employees) {
                if (employee != null && employee.getSalary() >= num) {
                    printEmployeeDataWithinDepartment(employee);
                }
            }
        }

        // внутренние вспомогательные методы, работающие для обслуживания основных методов EmployeeBook
        private Employee[] fillArrayEmployeeOfDepartment ( int department){
            Employee[] employeesOfDepartment = new Employee[employees.length];
            int counter = 0;
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] != null && employees[i].getDepartment() == department) {
                    employeesOfDepartment[i] = employees[i];
                    counter++;
                }
            }
            Employee[] emplDepFinal = new Employee[counter];
            int j = 0;
            for (int i = 0; i < employeesOfDepartment.length; i++) {
                if (employeesOfDepartment[i] != null) {
                    emplDepFinal[j] = employeesOfDepartment[i];
                    j++;
                }
            }
            return emplDepFinal;
        }

        private static void printEmployeeDataWithinDepartment (Employee employee){
            System.out.println("ФИО - " + employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic() +
                    ", зарплата " + employee.getSalary() + ", ID " + employee.getId());
        }

        private static void printEmployeesWithinNull (Employee[]empl){
            for (Employee employee : empl) {
                if (employee != null) System.out.println(employee);
            }
        }
    }
