package controllers;

import play.*;
import play.mvc.*;

import java.sql.SQLException;
import java.util.*;

import org.hibernate.annotations.Check;

import models.*;

@With(Secure.class)
public class Application extends Controller {

	
    public static void index() {
      	
    	render();
    		
    }
    
   

}