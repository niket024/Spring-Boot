package com.nik;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImp implements UserService {
	@Autowired
	UserDao userDao;

	public List<User> getUser() {
		return userDao.getUser();
	}

	public User findById(int id) {
		return userDao.findById(id);
	}

	public List<User> findByName(String name) {
		return userDao.findByName(name);
	}

	public void createUser(User user) {
		userDao.addUser(user);
	}

	public void deleteUserById(int id) {
		userDao.delete(id);
	}

	public User updatePartially(User user, int id) {
		userDao.updateCountry(user, id);
		return userDao.findById(id);
	}

	public User update(User user, int id) {
		return userDao.update(user, id);
	}

}
