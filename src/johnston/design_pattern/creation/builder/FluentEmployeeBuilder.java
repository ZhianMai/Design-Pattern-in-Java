package johnston.design_pattern.creation.builder;

import johnston.design_pattern.creation.builder.base_entity.Employee;

/**
 * If the fields fall into multiple categories, try to guide the user to fill in call categories
 * one by one. It's like the init configuration in Spring Security.
 */
public class FluentEmployeeBuilder  {
  private Employee employee;

  public FluentEmployeeBuilder(String firstName, String lastName) {
    employee = new Employee();
    employee.setFirstName(firstName);
    employee.setLastName(lastName);
  }

  public FluentBuilder begin() {
    return new FluentBuilder();
  }

  public class FluentBuilder{
    private FluentBuilder() {
    }

    public PersonalInfoBuilder personInfo() {
      return new PersonalInfoBuilder();
    }

    public EmployeeInfoBuilder employeeInfo() {
      return new EmployeeInfoBuilder();
    }

    public EmployeeBenefitBuilder benefitsInfo() {
      return new EmployeeBenefitBuilder();
    }

    public Employee build() {
      return employee;
    }

  }

  class PersonalInfoBuilder extends FluentBuilder {
    private PersonalInfoBuilder() {
    }

    public PersonalInfoBuilder age(int age) {
      employee.setAge(age);
      return this;
    }

    public PersonalInfoBuilder id(String id) {
      employee.setId(id);
      return this;
    }

    public PersonalInfoBuilder address(String address) {
      employee.setAddress(address);
      return this;
    }

    public PersonalInfoBuilder gender(String gender) {
      employee.setGender(gender);
      return this;
    }
  }

  class EmployeeInfoBuilder extends FluentBuilder {
    private EmployeeInfoBuilder() {
    }

    public EmployeeInfoBuilder jobTitle(String occupation) {
      employee.setOccupation(occupation);
      return this;
    }

    public EmployeeInfoBuilder worksAt(String companyAddress) {
      employee.setCompanyAddress(companyAddress);
      return this;
    }

    public EmployeeInfoBuilder dailyWorkingHours(int dailyWorkingHours) {
      employee.setDailyWorkingHours(dailyWorkingHours);
      return this;
    }
  }

  class EmployeeBenefitBuilder extends FluentBuilder {
    private EmployeeBenefitBuilder() {
    }

    public EmployeeBenefitBuilder annualSalary(int yearlySalary) {
      employee.setYearlySalary(yearlySalary);
      return this;
    }

    public EmployeeBenefitBuilder hasMedicalCovered(boolean medicalCovered) {
      employee.setMedicalCovered(medicalCovered);
      return this;
    }
  }
}
