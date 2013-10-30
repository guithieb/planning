package controllers;

import models.Member;

public class Security extends Secure.Security{

	static boolean authenticate (String email, String password)
	{
		return Member.connect(email, password) != null;
	}
}
