package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import play.db.jpa.Model;

@Entity
public class Member extends Model {

/*	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
    public long id;*/
	
	
	public String firstName;
	public String lastName;
	
	@Column(unique=true)
	public String email;
	public String password;
	
	public Member(String firstName, String lastName,String email,String password){
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;		
	}
	
	//Verifie si un  utilisateur existe
	public static Member connect(String email, String password)
	{
		return find("byEmailAndPassword",email,password).first();
	}
	
	
	
}