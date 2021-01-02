package com.example.demo.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Phong;
import com.example.demo.repository.REPOSITORY_Phong;
import com.example.demo.service.SERVICE_Phong;

@Service
public class IMPLEMENT_Service_Phong implements SERVICE_Phong {
	@Autowired
private REPOSITORY_Phong repository_Phong;

	@Override
	public List<Phong> getAll() {
		// TODO Auto-generated method stub
		return repository_Phong.findAllByOrderByIdPhongAsc();
	}

	@Override
	public Phong setData(Phong phong) {
		// TODO Auto-generated method stub
		return repository_Phong.save(phong);
	}

	@Override
	public Optional<Object> update(Phong phong) {
		return repository_Phong.findById(phong.getIdPhong()).map(Phong -> {
			Phong.setPhongSo(phong.getPhongSo());
			Phong.setSoGiuong(phong.getSoGiuong());
			Phong.setSoNguoiDangKy(phong.getSoNguoiDangKy());
			Phong.setTang(phong.getTang());
			Phong.setTinhTrang(phong.getTinhTrang());
			return repository_Phong.save(Phong);
		});
	}

	@Override
	public Optional<Phong> getByID(long id) {
		// TODO Auto-generated method stub
		return repository_Phong.findById(id);
	}

	@Override
	public Optional<Object> delete(long id) {
		// TODO Auto-generated method stub
		return repository_Phong.findById(id).map(phong -> {
			repository_Phong.delete(phong);
			return ResponseEntity.ok().build();
		});
	}
}
