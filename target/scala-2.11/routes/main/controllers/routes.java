
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/dabbu/IdeaProjects/scala-project/conf/routes
// @DATE:Thu Mar 22 18:16:49 IST 2018

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
  }

}
