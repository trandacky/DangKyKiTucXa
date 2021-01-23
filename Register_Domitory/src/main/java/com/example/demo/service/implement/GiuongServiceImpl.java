package com.example.demo.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Giuong;
import com.example.demo.repository.REPOSITORY_Giuong;
import com.example.demo.service.GiuongService;
@Service
public class GiuongServiceImpl implements GiuongService{

	private final REPOSITORY_Giuong repository_giuong;
	
	public GiuongServiceImpl(REPOSITORY_Giuong repository_giuong) {
		super();
		this.repository_giuong = repository_giuong;
	}

	@Override
	public List<Giuong> findAll() {
		// TODO Auto-generated method stub
		return repository_giuong.findAll();
	}

	@Override
	public Giuong saveOne(Giuong giuong) {
		// TODO Auto-generated method stub
		return repository_giuong.save(giuong);
	}

	@Override
	public Optional<Object> updateOne(Giuong giuong) {
		return repository_giuong.findById(giuong.getIdGiuong()).map(giuong2 -> {
			giuong2 = giuong;
			return repository_giuong.save(giuong2);
		});
	}

	@Override
	public Optional<Giuong> findById(long id) {
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

	@Override
	public Optional<Object> updateTinhTrang(long idgiuong, boolean tinhtrang) {
		return repository_giuong.findById(idgiuong).map(giuong2 -> {
			giuong2.setTinhTrangGiuong(tinhtrang);
			return repository_giuong.save(giuong2);
		});
	}
	

}
