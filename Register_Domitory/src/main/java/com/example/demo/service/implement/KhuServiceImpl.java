package com.example.demo.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Khu;
import com.example.demo.repository.REPOSITORY_Khu;
import com.example.demo.service.KhuService;
@Service
public class KhuServiceImpl implements KhuService {
	private final REPOSITORY_Khu khuRepository;

	public KhuServiceImpl(REPOSITORY_Khu repository_Khu) {
		super();
		this.khuRepository = repository_Khu;
	}

	@Override
	public List<Khu> findAll() {
		// TODO Auto-generated method stub
		return khuRepository.findAllByOrderByIdKhuAsc();
	}

	@Override
	public Optional<Khu> findById(long id) {
		// TODO Auto-generated method stub
		return khuRepository.findById(id);
	}

	@Override
	public Khu saveOne(Khu khu) {
		// TODO Auto-generated method stub
		return khuRepository.save(khu);
	}

	@Override
	public Optional<Object> updateOne(Khu khu) {
		return khuRepository.findById(khu.getIdKhu()).map(khu2 -> {
			khu2 = khu;
			return khuRepository.save(khu2);
		});
	}

	@Override
	public Optional<Object> deleteOneById(long id) {
		return khuRepository.findById(id).map(khu2 -> {
			khuRepository.delete(khu2);
			return ResponseEntity.ok().build();
		});
	}

}
