package controllers;

import models.Member;
import play.mvc.Before;
import play.mvc.Controller;

public class Members extends Controller {

	
	
	//Save the information of the account created
	public static void save(Member member)
	{
		member.save();
		profile(member.id);
	}
	
	//Action to create an account if you don't have one
	 public static void signup()
	    {
	    	render();
	    	
	    }
	 
	 //Action for the calendar page
	 public static void calendar()
	 {
		 render();
	 }
	 
	 public static void profile(Long id)
	 {
		 Member member = Member.findById(id);
		 render(member);
	 }
	  
	  public static void getPicture(long id) {
	       Member m = Member.findById(id);
	       response.setContentTypeIfNotSet(m.picture.type());
	       renderBinary(m.picture.get());
	        
	    }
}
