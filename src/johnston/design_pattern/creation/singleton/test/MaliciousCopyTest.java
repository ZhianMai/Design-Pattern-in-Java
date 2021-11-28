package johnston.design_pattern.creation.singleton.test;

import johnston.design_pattern.creation.singleton.InnerStaticSafeIdGenerator;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MaliciousCopyTest {
  public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
    useSeralize();
    useReflection();
  }

  private static void useSeralize() {
    System.out.println("***Serialization copy singleton demo***");
    InnerStaticSafeIdGenerator idGenerator = InnerStaticSafeIdGenerator.getInstance();

    // Write object to file
    String fileName = "SingletonCopy.txt";
    FileOutputStream fileOut = null;
    try {
      fileOut = new FileOutputStream(fileName);
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(idGenerator);
      out.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return;
    } catch (IOException e) {
      e.printStackTrace();
      return;
    }

    // Read object from  file
    FileInputStream fileIn = null;
    InnerStaticSafeIdGenerator badCopyIdGenerator;
    try {
      fileIn = new FileInputStream(fileName);
      ObjectInputStream in = new ObjectInputStream(fileIn);
      badCopyIdGenerator = (InnerStaticSafeIdGenerator)in.readObject();
      in.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return;
    } catch (IOException e) {
      e.printStackTrace();
      return;
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      return;
    }

    // System.out.println(idGenerator == badCopyIdGenerator); // false

    for (int i = 0; i < 5; i++) {
      System.out.println("Original id generator gave: " + idGenerator.getId());
      System.out.println("Bad copy id generator gave: " + badCopyIdGenerator.getId() + "\n");
    }
  }

  private static void useReflection() {
    System.out.println("***Reflection copy singleton demo***");
    InnerStaticSafeIdGenerator idGenerator = InnerStaticSafeIdGenerator.getInstance();
    InnerStaticSafeIdGenerator badCopyIdGenerator;

    Class<InnerStaticSafeIdGenerator> singletonClazz = InnerStaticSafeIdGenerator.class;
    Constructor<InnerStaticSafeIdGenerator> privateCtor = null;
    try {
      privateCtor = singletonClazz.getDeclaredConstructor();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
      return;
    }
    privateCtor.setAccessible(true);

    try {
      badCopyIdGenerator = privateCtor.newInstance();
    } catch (InstantiationException e) {
      e.printStackTrace();
      return;
    } catch (IllegalAccessException e) {
      e.printStackTrace();
      return;
    } catch (InvocationTargetException e) {
      e.printStackTrace();
      return;
    }

    for (int i = 0; i < 5; i++) {
      System.out.println("Original id generator gave: " + idGenerator.getId());
      System.out.println("Bad copy id generator gave: " + badCopyIdGenerator.getId() + "\n");
    }
  }
}
