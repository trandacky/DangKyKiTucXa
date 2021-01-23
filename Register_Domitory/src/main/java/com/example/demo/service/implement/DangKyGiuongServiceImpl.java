package com.example.demo.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DangKyGiuong;
import com.example.demo.repository.REPOSITORY_DangKyGiuong;
import com.example.demo.service.DangKyGiuongService;
@Service
public class DangKyGiuongServiceImpl implements DangKyGiuongService {
	private final REPOSITORY_DangKyGiuong repository_DangKyGiuong;

	public DangKyGiuongServiceImpl(REPOSITORY_DangKyGiuong repository_DangKyGiuong) {
		super();
		this.repository_DangKyGiuong = repository_DangKyGiuong;
	}

	@Override
	public List<DangKyGiuong> getAll() {
		// TODO Auto-generated method stub
		return repository_DangKyGiuong.findAll();
	}
	@Override
	public List<Object> laySoLuongGiuongDaDangKyCuaPhong(Long id) {
		// TODO Auto-generated method stub
		return repository_DangKyGiuong.laySoLuongGiuongDaDangKyCuaPhong(id);
	}

	@Override
	public Optional<DangKyGiuong> getByID(long id) {
		// TODO Auto-generated method stub
		return repository_DangKyGiuong.findById(id);
	}

	@Override
	public DangKyGiuong setData(DangKyGiuong dangKyGiuong) {
		// TODO Auto-generated method stub
		return repository_DangKyGiuong.save(dangKyGiuong);
	}

	@Override
	public Optional<Object> update(DangKyGiuong dangKyGiuong) {
		return repository_DangKyGiuong.findById(dangKyGiuong.getIdDangKyGiuong()).map(dangkygiuong -> {
			dangkygiuong = dangKyGiuong;
			return repository_DangKyGiuong.save(dangkygiuong);
		});
	}

	@Override
	public Optional<Object> delete(long id) {
		return repository_DangKyGiuong.findById(id).map(dangkygiuong -> {
			repository_DangKyGiuong.delete(dangkygiuong);
			return ResponseEntity.ok().build();
		});
	}
	@Override
	public Optional<DangKyGiuong> updateTinhTrang(long idgiuong, int tinhtrang) {
		return repository_DangKyGiuong.findById(idgiuong).map(dangkygiuong -> {
			dangkygiuong.setTinhTrangDangKy(tinhtrang);
			return repository_DangKyGiuong.save(dangkygiuong);
		});
	}
	
}
