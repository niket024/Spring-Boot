package com.nik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements ApplicationRunner {

	private PersonDAO personDAO;

	//private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	public DataInit(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		long count = personDAO.count();

		if (count == 0) {
			Person p1 = new Person();
			p1.setFullName("John");
			//Date d1 = df.parse("1980-12-20");
			p1.setDateOfBirth("1980-12-20");
			
			Person p2 = new Person();
			p2.setFullName("Smith");
			//Date d2 = df.parse("1985-11-11");
			p2.setDateOfBirth("1985-11-11");

			personDAO.save(p1);
			personDAO.save(p2);
		}

	}

}