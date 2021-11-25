package johnston.design_pattern.creation.builder;

import johnston.design_pattern.creation.builder.base_entity.Person;

/**
 * A basic builder pattern. The Buildr class constructor needs required field, which is first name
 * and last name. Other parameters are optional. If it needs to set the optional parameter, just
 * call its corresponding setter methods.
 *
 * Here the firstName and lastName are required, while other fields are optional.
 */
public class BasicPersonBuilder extends Person {
  public static class Builder {
    private String firstName;
    private String lastName;
    private int age = -1;
    private String id = null;
    private String address = null;
    private String occupation = null;
    private String gender = null;

    // Builder constructor needs required field
    public Builder(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
    }

    public Builder age(int age) {
      this.age = age;
      return this;
    }

    public Builder id(String id) {
      this.id = id;
      return this;
    }

    public Builder address(String address) {
      this.address = address;
      return this;
    }

    public Builder occupation(String occupation) {
      this.occupation = occupation;
      return this;
    }

    public Builder gender(String gender) {
      this.gender = gender;
      return this;
    }

    public BasicPersonBuilder build() {
      return new BasicPersonBuilder(this);
    }
  }

  // private ctor
  private BasicPersonBuilder(Builder builder) {
    this.firstName = builder.firstName;
    this.lastName = builder.lastName;
    this.age = builder.age;
    this.id = builder.id;
    this.address = builder.address;
    this.occupation = builder.occupation;
    this.gender = builder.gender;
  }
}
