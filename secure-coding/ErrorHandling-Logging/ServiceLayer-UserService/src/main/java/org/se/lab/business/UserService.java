package org.se.lab.business;

import java.util.List;

import org.se.lab.data.User;

public interface UserService
{
	void addUser(String firstName, String lastName, String username, String password);

	void removeUser(final String idString);

	List<User> findAllUsers();
}