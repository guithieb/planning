package controllers;

import java.util.List;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import models.Event;
import models.Member;
import play.libs.Mail;
import play.mvc.Controller;

public class Events extends Controller{
	
	
	//Action for the calendar page
		public static void calendar(Long id)
		{
			
			Member member = Member.findById(id);
			List <Events> listEvents = Event.find("member_id",member.id).fetch();
			render(member,listEvents);
		}
		
		public static void search(String lnameSearch,String fnameSearch)
		{
			
			List <Member> members = Member.find("firstName=? and lastName=?", fnameSearch,lnameSearch).fetch();
			Member m = members.get(0);
			List <Event> events = Event.find("member_id",members.get(0).id).fetch();
			render(events,m);
			
		}
		
		
	
	public static void save(Event event)
	{
		
		event.save();
		render();
	}
	
	public static void add(long id)
	{
		Member member = Member.findById(id);
		render(member);
	}

	public static void create(long id,Event event,String eventParticipant) throws EmailException
	{
		Member m = Member.findById(id);
		event.member = m;
		event.save();
		
		List <Member> participant = Member.find("email",eventParticipant).fetch();
		
		//Envoi d'email au participant
		SimpleEmail email = new SimpleEmail();
		email.setFrom("planning@ece.fr");
		email.addTo(eventParticipant);
		email.setSubject(participant.get(0).firstName + participant.get(0).lastName + " vous avez un nouveau rendez-vous");
		email.setMsg(eventParticipant + " vous propose un rendez-vous");
		Mail.send(email);
		
		//Renvoi à la page calendar
		calendar(m.id);
		
		
		
	}
	
}
