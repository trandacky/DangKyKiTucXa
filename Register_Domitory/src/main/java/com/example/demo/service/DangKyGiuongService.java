package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.DangKyGiuong;


public interface DangKyGiuongService {
	List<DangKyGiuong> getAll();
	DangKyGiuong setData(DangKyGiuong dangKyGiuong);
	Optional<Object> update(DangKyGiuong dangKyGiuong);
	Optional<DangKyGiuong> getByID(long id);
	Optional<Object> delete(long id);
	List<Object> laySoLuongGiuongDaDangKyCuaPhong(Long id);
	
	Optional<DangKyGiuong> updateTinhTrang(long idgiuong, int tinhtrang);
}
