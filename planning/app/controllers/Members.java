package controllers;

import models.Member;
import play.mvc.Controller;

public class Members extends Controller {

	public static void save(Member p)
	{
		p.save();
		
	}
	
	 public static void signup()
	    {
	    	render();
	    }
}
