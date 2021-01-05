package com.example.demo.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Giuong;
import com.example.demo.repository.REPOSITORY_Giuong;
import com.example.demo.service.SERVICE_Giuong;
@Service
public class IMPLEMENT_Service_Giuong implements SERVICE_Giuong{

	private final REPOSITORY_Giuong repository_giuong;
	
	public IMPLEMENT_Service_Giuong(REPOSITORY_Giuong repository_giuong) {
		super();
		this.repository_giuong = repository_giuong;
	}

	@Override
	public List<Giuong> getAll() {
		// TODO Auto-generated method stub
		return repository_giuong.findAll();
	}

	@Override
	public Giuong setData(Giuong giuong) {
		// TODO Auto-generated method stub
		return repository_giuong.save(giuong);
	}

	@Override
	public Optional<Object> update(Giuong giuong) {
		return repository_giuong.findById(giuong.getIdGiuong()).map(giuong2 -> {
			giuong2 = giuong;
			return repository_giuong.save(giuong2);
		});
	}

	@Override
	public Optional<Giuong> getByID(long id) {
		// TODO Auto-generated method stub
		return repository_giuong.findById(id);
	}

	@Override
	public Optional<Object> delete(long id) {
		return repository_giuong.findById(id).map(giuong2 -> {
			repository_giuong.delete(giuong2);
			return ResponseEntity.ok().build();
		});
	}

}
