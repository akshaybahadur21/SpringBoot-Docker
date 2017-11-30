package com.netcracker.springboot;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by akba0717 on 10-11-2017.
 */
public interface EmployeeRepository extends CrudRepository<Employee, String> {
}
