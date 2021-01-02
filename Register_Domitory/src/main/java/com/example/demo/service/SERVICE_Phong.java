package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.NguoiDung;
import com.example.demo.entity.Phong;

public interface SERVICE_Phong {
	List<Phong> getAll();
	Phong setData(Phong phong);
	Optional<Object> update(Phong phong);
	Optional<Object> delete(long id);
	Optional<Phong> getByID(long id);
}
