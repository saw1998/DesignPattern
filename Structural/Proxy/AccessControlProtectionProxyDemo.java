
/*
 * Imagine an Employee Data Access System where only admins can view salaries.
 */

/*
 * subject interface
 */

interface Employee{
    void showDetails();
    void showSalary();
}

/*
 * Real Subject
 */
class RealEmployee implements Employee{
    private String name;
    private double salary;

    public RealEmployee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void showDetails(){
        System.out.println("Employee name : " + name);
    }

    @Override
    public void showSalary(){
        System.out.println("Salary : $" + salary);
    }
}

/*
 * Proxy (Access control)
 */

class EmployeeProxy implements Employee{
    private RealEmployee realEmployee;
    private String role;

    public EmployeeProxy(String name, double salary, String role){
        this.realEmployee = new RealEmployee(name, salary);
        this.role = role;
    }

    @Override
    public void showDetails(){
        realEmployee.showDetails();
    }
    @Override
    public void showSalary(){
        if("Admin".equalsIgnoreCase(role)){
            realEmployee.showSalary();
        } else {
            System.out.println("Access Denied: Only admin can view salary");
        }
    }
}

/*
 * client
 */

public class AccessControlProtectionProxyDemo {
    public static void main(String[] args){
        Employee emp1 = new EmployeeProxy("John doe",500,"user");
        Employee emp2 = new EmployeeProxy("John smith",500,"admin");

        System.out.println("User trying to view: ");
        emp1.showDetails();
        emp1.showSalary();

        System.out.println("Admin trying to view: ");
        emp2.showDetails();
        emp2.showSalary();

    }
}
