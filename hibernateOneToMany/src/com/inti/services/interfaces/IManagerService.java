package com.inti.services.interfaces;

import java.util.List;

public interface IManagerService<T> {
	void create(T obj);

	void update(T obj);

	void delete(Long id);

	T getById(Long id);

	List<T> getAll();
}
