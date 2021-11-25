package johnston.design_pattern.creation.builder;

import johnston.design_pattern.creation.builder.base_entity.Person;
import johnston.design_pattern.creation.builder.required_field_interface.Age;
import johnston.design_pattern.creation.builder.required_field_interface.FirstName;
import johnston.design_pattern.creation.builder.required_field_interface.LastName;

/**
 * If the number of required field is too many, then putting them into the builder constructor
 * would repeat the scaling problem.
 *
 * This can apply scoped interface in the builder class to guild the user to fill in the required
 * field part by part. Once call begin(), the user has to follow the sequential methods to fill
 * out all required field before calling build(). in The scoped-interface is in package
 * "required_field_interface".
 */
public class RequiredFieldPersonBuilder extends Person {
  public static class StepBuilder implements Age, FirstName, LastName {
    private String firstName;
    private String lastName;
    private int age;
    private String id = null;
    private String address = null;
    private String occupation = null;
    private String gender = null;

    // private Builder constructor
    StepBuilder() {}

    public static FirstName begin() {
      return new StepBuilder();
    }

    @Override
    public LastName firstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    @Override
    public Age lastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    @Override
    public StepBuilder age(int age) {
      this.age =age;
      return this;
    }

    public StepBuilder id(String id) {
      this.id = id;
      return this;
    }

    public StepBuilder address(String address) {
      this.address = address;
      return this;
    }

    public StepBuilder occupation(String occupation) {
      this.occupation = occupation;
      return this;
    }

    public StepBuilder gender(String gender) {
      this.gender = gender;
      return this;
    }

    public RequiredFieldPersonBuilder build() {
      return new RequiredFieldPersonBuilder(this);
    }
  }

  private RequiredFieldPersonBuilder(StepBuilder builder) {
    this.firstName = builder.firstName;
    this.lastName = builder.lastName;
    this.age = builder.age;
    this.id = builder.id;
    this.address = builder.address;
    this.occupation = builder.occupation;
    this.gender = builder.gender;
  }
}
