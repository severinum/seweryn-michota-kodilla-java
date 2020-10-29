package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testSaveManyToMany(){
        // given
        // create employees
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
        // create companies
        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");
        // assign employees to companies
        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);
        // assigning companies to employees
        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        // when : saving company entities
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMstersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        // then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMstersId);
        assertNotEquals(0, greyMatterId);

        // clanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMstersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e){
            // do nothing here
        }

    }

    @Test
    void testFindEmployeesBySurname(){
        // given
        Employee employee1 = new Employee("John","Smith");
        Employee employee2 = new Employee("Adam","Smith");
        Employee employee3 = new Employee("Anna","McAllister");

        employeeDao.save(employee1);
        employeeDao.save(employee2);
        employeeDao.save(employee3);

        int id1 = employee1.getId();
        int id2 = employee2.getId();
        int id3 = employee3.getId();

        // when
        List<Employee> smithsList = employeeDao.findEmployeeByLastName("Smith");
        // then
        try {
            assertEquals(2, smithsList.size());
        } finally {
            // cleaning
            employeeDao.deleteById(id1);
            employeeDao.deleteById(id2);
            employeeDao.deleteById(id3);
        }

    }


    @Test
    void testFindCompanyByNamePrefix(){
        // given
        Company company1 = new Company("Metro Solicitors");
        Company company2 = new Company("Oliver Simons Ltd");
        Company company3 = new Company("Olimpic Nutritions Limited");

        companyDao.save(company1);
        companyDao.save(company2);
        companyDao.save(company3);

        int id1 = company1.getId();
        int id2 = company2.getId();
        int id3 = company3.getId();

        // when
        List<Company> oliCompany = companyDao.findCompanyNamesByPrefix("oli");

        // then
        assertEquals(2, oliCompany.size());

        // cleaning
        companyDao.deleteById(id1);
        companyDao.deleteById(id2);
        companyDao.deleteById(id3);

    }

}