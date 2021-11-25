package johnston.design_pattern.creation.builder;

import johnston.design_pattern.creation.builder.base_entity.Employee;
import johnston.design_pattern.creation.builder.base_entity.Person;

/**
 * Usage demo of builder pattern
 */
public class Main {
  public static void main(String[] args) {
    System.out.println("*** Basic Builder ***");
    System.out.println("Basic builder without optional fields: ");
    Person johnDoe = new BasicPersonBuilder.Builder("John", "Doe").build();
    System.out.println(johnDoe);

    System.out.println("\nBasic builder with all optional fields: ");
    // The order of parameter setters does not matter
    Person tonyStark = new BasicPersonBuilder.Builder("Tony", "Stark")
        .age(40)
        .gender("male")
        .address("10880 Malibu Point")
        .id("Unknown")
        .occupation("CEO")
        .build();
    System.out.println(tonyStark);

    System.out.println("\n\n*** Required Field Builder ***");
    System.out.println("Required field builder without optional fields: ");
    Person janeDoe = RequiredFieldPersonBuilder.StepBuilder
        .begin()
        .firstName("Jane")
        .lastName("Doe")
        .age(18)
        .build();
    System.out.println(janeDoe);

    System.out.println("\nRequired field builder with all optional fields: ");
    Person bruceWayne = RequiredFieldPersonBuilder.StepBuilder
        .begin()
        .firstName("Bruce") // After calling begin(), user has to fill in these three fields
        .lastName("Wayne")  // before moving on other fields
        .age(41)
        .gender("male")
        .id("Dark Knight")
        .address("Gotham Wayne Tower")
        .occupation("Billionaire")
        .build();
    System.out.println(bruceWayne);

    System.out.println("\n\n*** Fluent Employee Builder ***");
    System.out.println("Fluent employee builder without optional fields: ");
    Employee mrX = new FluentEmployeeBuilder("Mr.", "X").begin().build();
    System.out.println(mrX);

    System.out.println("\nFluent employee builder with all optional fields: ");
    // The order of field groups does not matter.
    Employee clarkKent = new FluentEmployeeBuilder("Clark", "Kent").begin()
        .personInfo()
            .age(35).address("Smallville Kanasas").id("abc123").gender("male")
        .employeeInfo()
            .jobTitle("Reporter").worksAt("Daily Planet").dailyWorkingHours(8)
        .benefitsInfo()
            .annualSalary(100000).hasMedicalCovered(true)
        .build();
    System.out.println(clarkKent);

    System.out.println("\n\n*** Recursive Generics Employee Builder ***");
    System.out.println("Recursive Generics employee builder without optional fields: ");
    Employee mrMystery =
        new RecursiveGenericEmployeeBuilder("Mr.", "Mystery").getEmployeeBuilder().build();
    System.out.println(mrMystery);

    System.out.println("\nRecursive Generics employee builder with all optional fields: ");
    Employee peggyCarter = new RecursiveGenericEmployeeBuilder("Peggy", "Carter")
        .getEmployeeBuilder() // Extending Person builder to use all methods of Person builder
            .age(80).id("123abc").address("Washington, D.C").gender("female")
            .occupation("Special agent Director").worksAt("S.H.I.E.L.D").dailyWorkingHours(12)
            .yearlySalary(100000).medicalCovered(true).build();
    System.out.println(peggyCarter);
  }
}
