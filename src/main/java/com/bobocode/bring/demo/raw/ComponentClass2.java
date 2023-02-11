package com.bobocode.bring.demo.raw;

import com.bringframework.annotation.Autowired;
import com.bringframework.annotation.Component;

//TODO Remove. Added for demonstration purpose
@Component
public class ComponentClass2 {


  @Autowired
  private ComponentClass componentClass;


  public void someMethod() {
    componentClass.someMethod();
  }
}
