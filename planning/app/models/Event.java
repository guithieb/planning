package models;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.joda.time.DateTime;

import play.db.jpa.Model;

@Entity
public class Event extends Model {

	public String eventName;
	public String eventPlace;
	
	@Temporal(TemporalType.DATE)
	public Date eventDate;

	@ManyToOne
	public Member member;
	
	
	
	public Event(Member m, String eName, String ePlace,Date eDate)
	{
		this.member = m;
		this.eventName = eName;
		this.eventPlace = ePlace;
		this.eventDate = new Date();
		
	}
	
}
