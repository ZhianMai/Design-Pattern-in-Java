package johnston.design_pattern.creation.builder;

import johnston.design_pattern.creation.builder.base_entity.Employee;

/**
 * Sometimes Builder class can apply inheritance to avoid duplicated code, but the super class
 * Builder methods return itself, which seems conflict to the subclass type. It can use recursive
 * generic to solve this problems.
 *
 * Here the EmployeeBuilder extends PersonBuilder, and all methods in PersonBuilder work in
 * EmployeeBuilder, too.
 */
class RecursiveGenericEmployeeBuilder {
  private Employee employee = new Employee();

  public RecursiveGenericEmployeeBuilder(String firstName, String lastName) {
    employee.setFirstName(firstName);
    employee.setLastName(lastName);
  }

  public EmployeeBuilder getEmployeeBuilder() {
    return new EmployeeBuilder();
  }

  // Recursive Generic
  class PersonBuilder<SELF extends PersonBuilder<SELF>> {
    public SELF age(int age) {
      employee.setAge(age);
      return self();
    }

    public SELF id(String id) {
      employee.setId(id);
      return self();
    }

    public SELF address(String address) {
      employee.setAddress(address);
      return self();
    }

    public SELF occupation(String occupation) {
      employee.setOccupation(occupation);
      return self();
    }

    public SELF gender(String gender) {
      employee.setGender(gender);
      return self();
    }

    protected SELF self() {
      return (SELF) this;
    }

    public Employee build() {
      return employee;
    }
  }

  class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {
    public EmployeeBuilder worksAt(String companyAddress) {
      employee.setCompanyAddress(companyAddress);
      return self();
    }

    public EmployeeBuilder dailyWorkingHours(int dailyWorkingHours) {
      employee.setDailyWorkingHours(dailyWorkingHours);
      return self();
    }

    public EmployeeBuilder yearlySalary(int yearlySalary) {
      employee.setYearlySalary(yearlySalary);
      return self();
    }

    public EmployeeBuilder medicalCovered(boolean medicalCovered) {
      employee.setMedicalCovered(medicalCovered);
      return self();
    }

    @Override
    protected EmployeeBuilder self() {
      return this;
    }
  }
}
