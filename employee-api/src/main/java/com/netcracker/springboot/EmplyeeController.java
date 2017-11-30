package com.netcracker.springboot;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.prometheus.client.Counter;
import java.util.List;
import io.prometheus.client.Gauge;

/**
 * Created by akba0717 on 10-11-2017.
 */

@RestController
@RequestMapping("/product")
public class EmplyeeController {

    private static final Counter inputGETRequestAll = Counter.build()
            .name("employee_get_all_counter").help("All Employee input messages.").register();

    private static final Counter inputGETRequest = Counter.build()
            .name("employee_get_according_to_id").help("Employee input messages.").register();

    private static final Counter inputPOSTRequest = Counter.build()
            .name("employee_post").help("Employee POST messages.").register();

    private static final Gauge ResponseTime = Gauge.build()
            .name("tfa_bulk_scheduler_input_es_indexes_number").help("TfaBulkShedulerComponent input es indexes.").register();

    @Autowired
    private EmployeeSevice employeeSevice;

    @ApiOperation(value = "View a list of all employees", response = List.class)
    @RequestMapping(value="/employees", method= RequestMethod.GET)
    public List<Employee> getAllEmployees()
    {
     //String inputAllEmployee = inputGETRequestAll.describe().get(0).name;
        inputGETRequestAll.inc();
        ResponseTime.setToCurrentTime();
        ResponseTime.startTimer();
      return employeeSevice.getAllEmployees();
    }

    @ApiOperation(value = "View details of an employee", response = Employee.class)
    @RequestMapping(value="/employees/{empid}", method= RequestMethod.GET)
    public Employee getEmployee(@PathVariable String empid)
    {
        inputGETRequest.inc();
        ResponseTime.setToCurrentTime();
        ResponseTime.startTimer();
        return employeeSevice.getEmployee(empid);
    }

    @ApiOperation(value = "Add an employee to the database", response = String.class)
    @RequestMapping(method = RequestMethod.POST, value = "/employees")
    public String addEmployee(@RequestBody Employee employee)
    {
        inputPOSTRequest.inc();
        ResponseTime.setToCurrentTime();
        ResponseTime.startTimer();
        employeeSevice.addEmployee(employee);
        return "Added Employee";
    }

}
