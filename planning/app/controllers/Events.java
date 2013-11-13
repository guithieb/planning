package controllers;

import java.util.List;

import models.Event;
import models.Member;
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

	public static void create(long id,Event event,String eventParticipant)
	{
		Member m = Member.findById(id);
		event.member = m;
		event.save();
		
		//Envoi d'email au participant
		
		calendar(m.id);
		
		
		
	}
	
}
