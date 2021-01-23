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
	private final REPOSITORY_Khu repository_Khu;

	public KhuServiceImpl(REPOSITORY_Khu repository_Khu) {
		super();
		this.repository_Khu = repository_Khu;
	}

	@Override
	public List<Khu> findAll() {
		// TODO Auto-generated method stub
		return repository_Khu.findAllByOrderByIdKhuAsc();
	}

	@Override
	public Optional<Khu> findById(long id) {
		// TODO Auto-generated method stub
		return repository_Khu.findById(id);
	}

	@Override
	public Khu saveOne(Khu khu) {
		// TODO Auto-generated method stub
		return repository_Khu.save(khu);
	}

	@Override
	public Optional<Object> updateOne(Khu khu) {
		return repository_Khu.findById(khu.getIdKhu()).map(khu2 -> {
			khu2 = khu;
			return repository_Khu.save(khu2);
		});
	}

	@Override
	public Optional<Object> deleteOneById(long id) {
		return repository_Khu.findById(id).map(khu2 -> {
			repository_Khu.delete(khu2);
			return ResponseEntity.ok().build();
		});
	}

}
