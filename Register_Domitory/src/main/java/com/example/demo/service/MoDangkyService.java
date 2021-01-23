package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.MoDangKy;

public interface MoDangkyService {
	List<MoDangKy> getAll();
	MoDangKy setData(MoDangKy modangky);
	Optional<Object> update(MoDangKy modangky);
	Optional<MoDangKy> getByID(long id);
	Optional<Object> delete(long id);
}
