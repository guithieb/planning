package controllers;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import models.Member;
import play.libs.Mail;
import play.mvc.Before;
import play.mvc.Controller;

public class Members extends Controller {



	//Save the information of the account created
	public static void save(Member member) throws EmailException
	{
		member.save();
		
		SimpleEmail email = new SimpleEmail();
		email.setFrom("planning@ece.fr");
		email.addTo(member.email);
		email.setSubject("Création de votre compte sur Planning");
		email.setMsg(member.firstName + member.lastName + " Création de votre compte. Votre login est : " + member.email + " et votre mot de passe est: " + member.password + " .Rendez-vous sur localhost:8087");
		Mail.send(email);
		
		//profile(member.id);
		Application.index();
	}

	//Action to create an account if you don't have one
	public static void signup()
	{
		render();

	}

	
	//Consult the profile page
	public static void profile(Long id)
	{
		Member member = Member.findById(id);
		render(member);
	}

	//Send the picture of a specific member to the view "profile"
	public static void getPicture(long id) {
		Member m = Member.findById(id);
		response.setContentTypeIfNotSet(m.picture.type());
		renderBinary(m.picture.get());
	}
	
	public static void edit(long id)
	{
		Member member = Member.findById(id);
		member.save();
		profile(member.id);
		
	}
	
	public static void complete(Long id)
	{
		Member member = Member.findById(id);
		render(member);
	}
}
