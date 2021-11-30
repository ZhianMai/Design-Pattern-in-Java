# Design Pattern in Java

This repo contains design pattern concept demo in Java.

## Why Design Pattern

In the history of software engineering especially in OOD, people have found many common problems,
such as poor re-usability and flexibility, difficult scaling, etc. Software design pattern is a
general, reusable solution to those commonly occurring problems in software design. Design pattern
is like algorithm, which is independent to programming language. However, some patterns may only apply
to OOD languages, and they may not work in some functional programming languages like Haskell.

## Types of Design Pattern

Design patterns mainly fall into three categories:

- Object Creation;
- Object Builder;
- Object Structure.

## 1. Object Creations

### 1.1 Builder Pattern

#### 1.1.1 Problem: Constructor Parameter Overwhelming :link:[link](src/johnston/design_pattern/creation/builder/ScopedPersonCtor.java)

Suppose the object creation needs <i>n</i> optional parameters, and the user can either input or ignore anyone
of them, then it needs <i>2^n</i> number of constructors. Also, too many variables is error-probing, like
swapping first name and last name by mistake.

Using scoped constructor may reduce the size, but it's still not scalable. Everytime when the class adds one more 
field, someone has to overwrite all constructor.

There is another way to solve this problem: use setter to set fields after creating the object. However, this operation
is inconsistent, so it's not safe in multi-threading environment. Suppose a context switching happens during calling
a bunch of setters, then the object is not yet finishing instantiation.

So <i>builder pattern</i> comes to help.

#### 1.1.2 Basic Builder  :link:[link](src/johnston/design_pattern/creation/builder/BasicPersonBuilder.java)

Basic builder pattern implementations:
- Main class does not have public constructor. This ensures user has to create object using Builder class.
- Builder class can access all fields which are required for main class's object creation.
- The required field can place into the builder class constructor.  
- One field one method in Builder class, and always return <i>this</i>.
- Calling build() can call main class's private constructor to create object.

This Builder pattern is thread-safe in object creation, as long as the builder object is not a shared variable. Builder
pattern is also scalable: if the main class adds one more field, then the builder class just needs to add few lines of 
code.

<b>Usage:</b>
``` java
Person tonyStark = new BasicPersonBuilder.Builder("Tony", "Stark")
        .age(40)
        .gender("male")
        .address("10880 Malibu Point")
        .id("Unknown")
        .occupation("CEO")
        .build();
```


#### 1.1.3 Builder with Many Required Fields  :link:[link](src/johnston/design_pattern/creation/builder/RequiredFieldPersonBuilder.java)

Suppose the main class has many required field, and someone places all required fields into the builder class constructor, then this
will recur the constructor parameter overwhelming problem.

This can apply scoped interface in the builder class to guide the user to fill in the required
fields part by part. Once call begin(), the user has to follow the sequential methods to fill
out all required fields before calling build(). The scoped-interface is in package
"required_field_interface".

<b>Usage:</b>
``` java
Person bruceWayne = RequiredFieldPersonBuilder.StepBuilder
        .begin()
        .firstName("Bruce") // After calling begin(), user has to fill in these three fields
        .lastName("Wayne")  // before moving to other fields
        .age(41)
        .gender("male")
        .id("Dark Knight")
        .address("Gotham Wayne Tower")
        .occupation("Billionaire")
        .build();
    System.out.println(bruceWayne);
```

#### 1.1.4 Builder with Fields Categorized  :link:[link](src/johnston/design_pattern/creation/builder/FluentEmployeeBuilder.java)

If object creation fields has too many, and it can confuse the user, then group those fields into several categories
and guild the user to fill them out category by category.

The Spring MVC and Security use this pattern to guide user filling fields:
``` java
@Override
protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
            .antMatchers("/", "/home").permitAll()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login")
            .permitAll()
            .and()
        .logout()
            .permitAll();
}
```

<b>Usage:</b>
``` java
Employee clarkKent = new FluentEmployeeBuilder("Clark", "Kent").begin()
        .personInfo()
                .age(35).address("Smallville Kanasas").id("abc123").gender("male")
        .employeeInfo()
                .jobTitle("Reporter").worksAt("Daily Planet").dailyWorkingHours(8)
        .benefitsInfo()
                .annualSalary(100000).hasMedicalCovered(true)
        .build();
```

Step 1.1.3 and 1.1.4 can combine to make a builder that each category has some mandatory fields to fill in.

#### 1.1.5 Recursive Generic Builder for Inheritance :link:[link](src/johnston/design_pattern/creation/builder/RecursiveGenericEmployeeBuilder.java)

In general builder class is very big, and it would be great if it supports inheritance. The problem is the super class 
methods return super class instance itself, and the subclass cannot override them to return subclass instance.

So the super class builder can use recursive generic type to support inheritance.

<b>Usage:</b>
``` java
Employee peggyCarter = new RecursiveGenericEmployeeBuilder("Peggy", "Carter")
        .getEmployeeBuilder() // Extending Person builder to use all methods of Person builder
                .age(80).id("123abc").address("Washington, D.C").gender("female")
                .occupation("Special agent Director").worksAt("S.H.I.E.L.D").dailyWorkingHours(12)
                .yearlySalary(100000).medicalCovered(true).build();
```

### 1.2 Factory Pattern

#### 1.2.1 Problem: Object Type Complicated

Suppose many subclasses extending the same super class or implementing same interfaces, and their constructors are
different, then they can confuse the user when creating their instances.

#### 1.2.2 Factory Pattern  :link:[link](src/johnston/design_pattern/creation/factory/factory_pattern)
Factory pattern packs the object creation operations inside the factory class, and provides interfaces for user to
create objects they want. Factory pattern is a very common used pattern in software design, such as JUC Executor and
Hibernate sessionFactory. My project thread-safe hash map also uses this pattern. 

<b>Usage:</b> :link:[link](https://github.com/ZhianMai/Thread-safe-LinkedList-Hashmap)
``` java
// Example of creating hash map object using factory class.
// Hash map for general use (no debugging methods)
private MyHashMap<ClassA, ClassB> hashMap;
private int capacity = 666; // Init hash map capacity
private float loadFactor = 0.4f; // Init hash map load factor for rehashing

// Create a MyHashMap object without thread-safety policy
hashMap = MyHashMapFactory.getMyHashMap(ThreadSafePolicy.NoSync);

// Create a MyHashMap object without thread-safety policy and given capacity and loadFactor
hashMap = MyHashMapFactory.getMyHashMap(ThreadSafePolicy.NoSync, capacity, loadFactor);

// Create a MyHashMap object with thread-safety using synchronized keyword
hashMap = MyHashMapFactory.getMyHashMap(ThreadSafePolicy.SyncKeyword);

// Createa MyHashMap object with thread-safety using ReentrantReadWriteLock
hashMap = MyHashMapFactory.getMyHashMap(ThreadSafePolicy.ReadWriteLock);

// Hash map for debugging (interface MyHashMapTesting)
private MyHashMapTesting<ClassA, ClassB> hashMap;

hashMap = MyHashMapFactory.MyHashMapTesting(ThreadSafePolicy.NoSync);
hashMap = MyHashMapFactory.MyHashMapTesting(ThreadSafePolicy.NoSync, capacity, loadFactor);
// Same usage as the MyHashMap above, but with different method names.
```

#### 1.2.3 Abstract Factory  :link:[link](src/johnston/design_pattern/creation/factory/abstract_factory)
If a group of classes which are very similar, then it can use an abstract factory to create their
objects instead of directly calling the concrete constructors.

This group of classes needs to implement a same interface or inheritance a same super class for
abstract factory to provide a general interface.

<b>Usage:</b>
``` java
Drink coffee = DrinkAbstractFactory.getDrink(DrinkList.COFFEE);
coffee.drink();

Drink tea = DrinkAbstractFactory.getDrink(DrinkList.TEA);
tea.drink();

Drink cocacola = DrinkAbstractFactory.getDrink(DrinkList.COCACOLA);
cocacola.drink();
```

### 1.3 Singleton Pattern
Unlike builder and factory pattern, singleton pattern prevent user from creating multiple objects, and it provides a 
global unique object all the time. It's like a global public variable.

Singleton class can use for global variable, logger, thread pool, config, remote database connection, etc.

Singleton has no scaling or extending ability, so use it with caution.

The general singleton class includes:
- private constructors;
- a global object;
- other strategies to ensure safety.

#### 1.3.1 Basic Singleton with Eager Loading  :link:[link](src/johnston/design_pattern/creation/singleton/BasicEagerIdGenerator.java)
singleton class can init when the class is loading. It's thread-safe.

Problem: if the singleton class instance is never used, then it wastes resources. If multiple singleton classes from
different places init at the same time, then it may create a hot spot, like many servers connecting to database on 
startup.

#### 1.3.2 Not Thread-safe Singleton with Lazy Loading  :link:[link](src/johnston/design_pattern/creation/singleton/UnsafeLazyIdGenerator.java)
Singleton class with lazy init can avoid the problems occurred in eager init. However, this implementation is not thread-safe. See
demo: :link:[link](src/johnston/design_pattern/creation/singleton/test/DataRacingTest.java)

#### 1.3.3 Thread-safe Singleton with Lazy Loading   :link:[link](src/johnston/design_pattern/creation/singleton/SafeLazyIdGenerator.java)
To ensure thread-safe, it needs a synchronized lock and double check to avoid data racing. Missing either of these two 
requirements can compromise the thread-safety.

#### 1.3.4 Thread-safe Inner Class Singleton with Lazy Loading  :link:[link](src/johnston/design_pattern/creation/singleton/InnerStaticSafeIdGenerator.java)
An easier way to implement thread-safe lazy init singleton class is using static inner class.

#### 1.3.5 Malicious Copy on Singleton  :link:[link](src/johnston/design_pattern/creation/singleton/test/MaliciousCopyTest.java)

<b><i>Serializing</i></b>

Using serializing-de-serializing can make a copy of singleton class.

Solution: create method <i>readResolve()</i> to control the object serializing behavior that it returns the original singleton object.
``` java
protected Object readResolve() {
    return Impl.GLOBAL_ID_GENERATOR;
}
```

<b><i>Reflection</i></b>

Use the powerful reflection tool can extract & call private constructors to create another singleton objects.

Solution: the private constructor needs to check the global unique instance is null or not.
``` java
private InnerStaticSafeIdGenerator() {
    /**
     * Adding this check to avoid malicious reflection copying.
     */
    if (Impl.GLOBAL_ID_GENERATOR != null) {
      throw new InstantiationError("Not allowed to created this object again!");
    }
    
    System.out.println("\n***Singleton InnerStaticSafeIdGenerator init finished***\n");
}
```

<b><i>Cloneable</i></b>

If the singleton class implements Cloneable or its super class has implemented Cloneable, then using clone()
may make another copy of it.

Solution: override clone() method in either of two ways:
``` java
@Override
public final Object clone() throws CloneNotSupportedException {
  // throw new CloneNotSupportedException("Not allow to clone this singleton class");
  return getInstance();
}
```

#### 1.3.6 Enum Singleton  :link:[link](src/johnston/design_pattern/creation/singleton/EnumIdGenerator.java)
Use enum to implement singleton class is easy, thread-safe, and lazy loading. However, enum does not support inheritance.

Putting multiple enum elements into an enum type is another design pattern called <i>multiton</i>.

#### 1.3.7 Util Class
A util class (monostate) has static methods only. It's always act as a singleton, no matter how many instances created.
Util classes are very commons, such as java package Collections and Arrays. They are stateless and provide "utilities" methods.
In general, a singleton class is "locally stateful", while a util class is "globally stateless".

### 1.4 ProtoType Pattern
Classes with Prototype pattern allow users to copy/clone their objects. However, the copy is either (partially) deep or
shallow copy should be well considered.

For deep copy, one needs to think about: how "deep" should be this deep copy be? Suppose I need to deep copy an object array,
then I got two options as:

- New an object array, then copy all original object references to the new array;
- New an object array, then for each original object I make a new one and let the new array points to them.

So how "deep" of the deep copy should be? This problem should be well addressed when designing.

## 2. Object Structures

### 2.1 Adapter Pattern

Electrical devices from all over the world have different rated voltage and different plugs, and a plug adapter can fit
them into a specific outlet.