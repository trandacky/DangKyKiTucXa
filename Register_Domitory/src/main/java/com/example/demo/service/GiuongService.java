package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Giuong;

public interface GiuongService {
	List<Giuong> findAll();
	Giuong saveOne(Giuong giuong);
	Optional<Object> updateOne(Giuong giuong);
	Optional<Giuong> findById(long id);
	Optional<Object> delete(long id);
	Optional<Object> updateTinhTrang(long idgiuong, boolean tinhtrang);
}
