package com.nik;

import java.util.List;

public interface UserDao {
	public void addUser(User user);

	public List<User> getUser();

	public User findById(int id);

	public User update(User user, int id);

	public User updateCountry(User user, int id);

	public void delete(int id);

	public List<User> findByName(String name);
}