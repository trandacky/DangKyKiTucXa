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
private REPOSITORY_Phong phongRepository;

	@Override
	public List<Phong> findAll() {
		// TODO Auto-generated method stub
		return phongRepository.findAllByOrderByIdPhongAsc();
	}

	@Override
	public Phong saveOne(Phong phong) {
		// TODO Auto-generated method stub
		return phongRepository.save(phong);
	}

	@Override
	public Optional<Object> updateOne(Phong phong) {
		return phongRepository.findById(phong.getIdPhong()).map(Phong -> {
			Phong.setPhongSo(phong.getPhongSo());
			Phong.setTang(phong.getTang());
			Phong.setTinhTrang(phong.getTinhTrang());
			return phongRepository.save(Phong);
		});
	}

	@Override
	public Optional<Phong> findById(long id) {
		// TODO Auto-generated method stub
		return phongRepository.findById(id);
	}

	@Override
	public Optional<Object> deleteById(long id) {
		// TODO Auto-generated method stub
		return phongRepository.findById(id).map(phong -> {
			phongRepository.delete(phong);
			return ResponseEntity.ok().build();
		});
	}
}
