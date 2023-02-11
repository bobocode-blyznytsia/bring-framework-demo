package com.bobocode.bring.demo.raw;

import com.bringframework.BringApplication;
import com.bringframework.context.ApplicationContext;
import lombok.extern.slf4j.Slf4j;

/**
 * Entry point to work with Bring Application.
 */
@Slf4j
public class DemoApplication {

  //TODO Remove. Added for demonstration purpose
  public static void main(String[] args) {
    BringApplication bringApplication = new BringApplication("com.bobocode.bring.demo");
    bringApplication.run();
    ApplicationContext applicationContext1 = bringApplication.getApplicationContext();

    System.out.println(String.format("%1$20s%2$30s", "BeanName", "SimpleBeanClass"));
    System.out.println("==================================================");
    applicationContext1.getAllBeans().entrySet().forEach(entry -> System.out.println(
        String.format("%1$20s%2$30s", entry.getKey(), entry.getValue().getClass().getSimpleName())));

    System.out.println();
    System.out.println("==================================================");
    ComponentClass2 bean = applicationContext1.getBean(ComponentClass2.class);
    bean.someMethod();

    System.out.println();
    System.out.println("==================================================");
    SomeClass2 someClass2 = applicationContext1.getBean(SomeClass2.class);
    someClass2.someMethod();

    System.out.println();
    System.out.println("==================================================");
    ComponentSomeClass componentSomeClass = applicationContext1.getBean(ComponentSomeClass.class);
    componentSomeClass.someMethod();
  }

}
