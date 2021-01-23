package com.example.demo.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Phong;
import com.example.demo.repository.REPOSITORY_Phong;
import com.example.demo.service.PhongService;

@Service
public class PhongServiceImpl implements PhongService {
	@Autowired
private REPOSITORY_Phong repository_Phong;

	@Override
	public List<Phong> findAll() {
		// TODO Auto-generated method stub
		return repository_Phong.findAllByOrderByIdPhongAsc();
	}

	@Override
	public Phong saveOne(Phong phong) {
		// TODO Auto-generated method stub
		return repository_Phong.save(phong);
	}

	@Override
	public Optional<Object> updateOne(Phong phong) {
		return repository_Phong.findById(phong.getIdPhong()).map(Phong -> {
			Phong.setPhongSo(phong.getPhongSo());
			Phong.setTang(phong.getTang());
			Phong.setTinhTrang(phong.getTinhTrang());
			return repository_Phong.save(Phong);
		});
	}

	@Override
	public Optional<Phong> findById(long id) {
		// TODO Auto-generated method stub
		return repository_Phong.findById(id);
	}

	@Override
	public Optional<Object> deleteById(long id) {
		// TODO Auto-generated method stub
		return repository_Phong.findById(id).map(phong -> {
			repository_Phong.delete(phong);
			return ResponseEntity.ok().build();
		});
	}
}
