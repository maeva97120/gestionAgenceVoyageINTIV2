package com.inti.dao.interfaces;

import java.util.List;

public interface IManagerDAO<T> {
	void create(T obj);

	void update(T obj);

	void delete(Long id);

	T getById(Long id);

	List<T> getAll();
}
