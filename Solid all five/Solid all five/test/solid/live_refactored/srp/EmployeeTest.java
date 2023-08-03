package solid_2011.live_refactored.srp;

import org.junit.Test;
import solid_2011.live_refactored.srp.Employee;

import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 19, 2011
 * Time: 2:45:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class EmployeeTest {
    @Test
    public void shouldReturnEmployeeInfo() {
        Employee employee = new Employee(1, 345.123, "Sherlock Holmes", "Baker Street", "London", "UK", 3, new int[]{1, 2, 4,7});
        EmployeeFormatter formatter = new EmployeeFormatter(employee);
        String employeeInfo = formatter.toHtml();
        String expectedEmployeeInfo = "<div><h1>Employee Info</h1><div id='emp1'><span>Sherlock Holmes</span><div class='left'><span>Leave Left :</span><span>Annual Salary:</span><span>Manager:</span><span>Reimbursable Leave:</span></div><div class='right'><span>27</span><span>4141</span><span>None</span><span>13</span></div> </div>";
        assertEquals("Employee info should be equal", expectedEmployeeInfo, employeeInfo);
    }
}
