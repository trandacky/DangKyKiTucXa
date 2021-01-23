package com.example.demo.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MoDangKy;
import com.example.demo.repository.REPOSITORY_MoDangKy;
import com.example.demo.service.MoDangkyService;

@Service
public class MoDangKyServiceImpl implements MoDangkyService{
	
	@Autowired
	private REPOSITORY_MoDangKy moDangKyRepository;
	
	@Override
	public List<MoDangKy> getAll() {
		// TODO Auto-generated method stub
		return moDangKyRepository.findAll();
	}

	@Override
	public MoDangKy setData(MoDangKy modangky) {
		// TODO Auto-generated method stub
		return moDangKyRepository.save(modangky);
	}

	@Override
	public Optional<Object> update(MoDangKy modangky) {
		return moDangKyRepository.findById(modangky.getIdMoDangKy()).map(dangky -> {
			dangky = modangky;
			return moDangKyRepository.save(dangky);
		});
	}

	@Override
	public Optional<MoDangKy> getByID(long id) {
		return moDangKyRepository.findById(id);
	}

	@Override
	public Optional<Object> delete(long id) {
		return moDangKyRepository.findById(id).map(dangky -> {
			moDangKyRepository.delete(dangky);
			return ResponseEntity.ok().build();
		});
	}
	
}
