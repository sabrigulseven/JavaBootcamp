package com.godoro.composition.manager;

import java.sql.ResultSet;

import com.godoro.composition.entity.Department;

public class DepartmentManager extends BaseManager<Department> {

    protected Department parse(ResultSet resultSet) throws Exception {

        long departmentId = resultSet.getLong("departmentId");
        String departmentName = resultSet.getString("departmentName");
        Department department = new Department(departmentId, departmentName);
        return department;
    }
}
