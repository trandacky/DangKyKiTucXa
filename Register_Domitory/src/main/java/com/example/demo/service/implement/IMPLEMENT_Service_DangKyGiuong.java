package com.example.demo.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DangKyGiuong;
import com.example.demo.repository.REPOSITORY_DangKyGiuong;
import com.example.demo.service.SERVICE_DangKyGiuong;
@Service
public class IMPLEMENT_Service_DangKyGiuong implements SERVICE_DangKyGiuong {
	private final REPOSITORY_DangKyGiuong repository_DangKyGiuong;

	public IMPLEMENT_Service_DangKyGiuong(REPOSITORY_DangKyGiuong repository_DangKyGiuong) {
		super();
		this.repository_DangKyGiuong = repository_DangKyGiuong;
	}

	@Override
	public List<DangKyGiuong> getAll() {
		// TODO Auto-generated method stub
		return repository_DangKyGiuong.findAll();
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
		return repository_DangKyGiuong.findById(dangKyGiuong.getIdDK()).map(dangkygiuong -> {
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

}
