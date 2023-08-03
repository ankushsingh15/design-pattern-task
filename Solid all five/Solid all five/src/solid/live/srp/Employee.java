package solid.live.srp;
public class Employee {
    private int empId;
    private double monthlySalary;
    private String name, addressStreet, addressCity, addressCountry;
    private int leavesTaken, yearsInOrg;
    private int[] leavesLeftPreviously;


    public Employee(int empId, double monthlySalary, String name, String addressStreet, String addressCity, String addressCountry, int leavesTaken, int[] leavesLeftPreviously) {
        this.empId = empId;
        this.monthlySalary = monthlySalary;
        this.name = name;
        this.addressStreet = addressStreet;
        this.addressCity = addressCity;
        this.addressCountry = addressCountry;
        this.leavesTaken = leavesTaken;
        this.leavesLeftPreviously = leavesLeftPreviously;
        this.yearsInOrg = leavesLeftPreviously.length;
    }

    public int getEmpId() {
        return empId;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public String getName() {
        return name;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public int getLeavesTaken() {
        return leavesTaken;
    }

    public int[] getLeavesLeftPreviously() {
        return leavesLeftPreviously;
    }

    public int getYearsInOrg() {
        return yearsInOrg;
    }

    public totalLeaveLeftPreviously() {
        int years = 3;
        if (this.getYearsInOrg() < 3) {
            years = this.getYearsInOrg();
        }
        int totalLeaveLeftPrevious = 0;
        for (int i = 0; i < years; i++) {
            totalLeaveLeftPrevious += this.getLeavesLeftPreviously()[this.getYearsInOrg() - i - 1];
        }
        return totalLeaveLeftPrevious;
    }


}

public class EmployeeRenderer {
    public String toHtml(Employee employee) {
        String str = "<div>" +
                "<h1>Employee Info</h1>" +
                "<div id='emp" + employee.getEmpId() + "'>" +
                "<span>" + employee.getName() + "</span>" +
                "<div class='left'>" +
                "<span>Leave Left :</span>" +
                "<span>Annual Salary:</span>" +
                "<span>Manager:</span>" +
                "<span>Reimbursable Leave:</span>" +
                "</div>";
        str += "<div class='right'><span>" + (Employee.TOTAL_LEAVES_ALLOWED - employee.getLeaveTaken()) + "</span>";
        str += "<span>" + Math.round(employee.getMonthlySalary() * 12) + "</span>";
        if (employee.getManager() != null)
            str += "<span>" + employee.getManager() + "</span>";
        else
            str += "<span>None</span>";

        str += "<span>" + employee.totalLeaveLeftPreviously() + "</span>";
        return str + "</div> </div>";
    }
}

