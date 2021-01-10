package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Giuong;
import com.example.demo.entity.NguoiDung;

public interface SERVICE_Giuong {
	List<Giuong> getAll();
	Giuong setData(Giuong giuong);
	Optional<Object> update(Giuong giuong);
	Optional<Giuong> getByID(long id);
	Optional<Object> delete(long id);
	Optional<Object> updateTinhTrang(long idgiuong, boolean tinhtrang);
}
