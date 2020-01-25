package com.nik;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDAO extends CrudRepository<Person, Long> {

	public List<Person> findByFullNameLike(String name);

	public void delete(Long id);

}