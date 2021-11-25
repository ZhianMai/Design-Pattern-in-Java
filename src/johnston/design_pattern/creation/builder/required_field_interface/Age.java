package johnston.design_pattern.creation.builder.required_field_interface;

import johnston.design_pattern.creation.builder.RequiredFieldPersonBuilder;

public interface Age {
  RequiredFieldPersonBuilder.StepBuilder age(int age);
}
