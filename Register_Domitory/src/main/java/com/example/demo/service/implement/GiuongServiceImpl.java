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

	private final REPOSITORY_Giuong giuongRepository;
	
	public GiuongServiceImpl(REPOSITORY_Giuong repository_giuong) {
		super();
		this.giuongRepository = repository_giuong;
	}

	@Override
	public List<Giuong> findAll() {
		// TODO Auto-generated method stub
		return giuongRepository.findAll();
	}

	@Override
	public Giuong saveOne(Giuong giuong) {
		// TODO Auto-generated method stub
		return giuongRepository.save(giuong);
	}

	@Override
	public Optional<Object> updateOne(Giuong giuong) {
		return giuongRepository.findById(giuong.getIdGiuong()).map(giuong2 -> {
			giuong2 = giuong;
			return giuongRepository.save(giuong2);
		});
	}

	@Override
	public Optional<Giuong> findById(long id) {
		// TODO Auto-generated method stub
		return giuongRepository.findById(id);
	}

	@Override
	public Optional<Object> delete(long id) {
		return giuongRepository.findById(id).map(giuong2 -> {
			giuongRepository.delete(giuong2);
			return ResponseEntity.ok().build();
		});
	}

	@Override
	public Optional<Object> updateTinhTrang(long idgiuong, boolean tinhtrang) {
		return giuongRepository.findById(idgiuong).map(giuong2 -> {
			giuong2.setTinhTrangGiuong(tinhtrang);
			return giuongRepository.save(giuong2);
		});
	}
	

}
