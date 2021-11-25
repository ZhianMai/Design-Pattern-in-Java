package johnston.design_pattern.creation.builder;

import johnston.design_pattern.creation.builder.base_entity.Person;

/**
 * Multiple scoped constructors may help object creation with multiple fields, but it does not
 * scale well. How if the constructors need 10 more parameters? And how about user switch the
 * first name and last name by mistake?
 */
public class ScopedPersonCtor extends Person {
  public ScopedPersonCtor(String firstName, String lastName) {
    this(firstName, lastName, -1);
  }

  public ScopedPersonCtor(String firstName, String lastName, int age) {
    this(firstName, lastName, age, null);
  }

  public ScopedPersonCtor(String firstName, String lastName, int age, String id) {
    this(firstName, lastName, age, id, null);
  }

  public ScopedPersonCtor(String firstName, String lastName, int age, String id, String address) {
    this(firstName, lastName, age, id, address, null);
  }

  public ScopedPersonCtor(String firstName, String lastName, int age, String id, String address, String occupation) {
    this(firstName, lastName, age, id, address, occupation, null);
  }

  public ScopedPersonCtor(String firstName, String lastName, int age, String id,
                          String address, String occupation, String gender) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.id = id;
    this.address = address;
    this.occupation = occupation;
    this.gender = gender;
  }
}
