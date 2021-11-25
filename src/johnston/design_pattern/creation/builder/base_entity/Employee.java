package johnston.design_pattern.creation.builder.base_entity;

/**
 * Simple employee class as a person
 */
public class Employee extends Person{

  protected String companyAddress;
  protected int dailyWorkingHours;
  protected int yearlySalary;
  protected boolean medicalCovered;

  public String getCompanyAddress() {
    return companyAddress;
  }

  public void setCompanyAddress(String companyAddress) {
    this.companyAddress = companyAddress;
  }

  public int getDailyWorkingHours() {
    return dailyWorkingHours;
  }

  public void setDailyWorkingHours(int dailyWorkingHours) {
    this.dailyWorkingHours = dailyWorkingHours;
  }

  public int getYearlySalary() {
    return yearlySalary;
  }

  public void setYearlySalary(int yearlySalary) {
    this.yearlySalary = yearlySalary;
  }

  public boolean isMedicalCovered() {
    return medicalCovered;
  }

  public void setMedicalCovered(boolean medicalCovered) {
    this.medicalCovered = medicalCovered;
  }

  @Override
  public String toString() {
    return "Employee{" +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", age=" + age +
        ", id='" + id + '\'' +
        ", address='" + address + '\'' +
        ", occupation='" + occupation + '\'' +
        ", gender='" + gender + '\'' +
        "companyAddress='" + companyAddress + '\'' +
        ", dailyWorkingHours=" + dailyWorkingHours +
        ", yearlySalary=" + yearlySalary +
        ", medicalCovered=" + medicalCovered +
        '}';
  }
}
