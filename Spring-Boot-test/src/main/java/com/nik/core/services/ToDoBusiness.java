package com.nik.core.services;

import java.util.List;

public class ToDoBusiness {
	public ToDoService doService;

	public ToDoBusiness(ToDoService doService) {
		this.doService = doService;
	}

	public void deleteTodosNotRelatedToHibernate(String user) {

		List<String> Combinedlist = doService.getTodos(user);

		for (String todos : Combinedlist) {
			if (!todos.contains("Hibernate")) {
				doService.deleteTodos(todos);
			}
		}
	}
}
