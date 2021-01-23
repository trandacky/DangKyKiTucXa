package com.example.demo.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.NguoiDung;
import com.example.demo.repository.REPOSITORY_NguoiDung;
import com.example.demo.service.SERVICE_NguoiDung;
@Service
public class IMPLEMENT_Service_NguoiDung implements SERVICE_NguoiDung {
	private final REPOSITORY_NguoiDung repository_NguoiDung;

	public IMPLEMENT_Service_NguoiDung(REPOSITORY_NguoiDung repository_NguoiDung) {
		super();
		this.repository_NguoiDung = repository_NguoiDung;
	}

	@Override
	public List<NguoiDung> findAll() {
		// TODO Auto-generated method stub
		return repository_NguoiDung.findAllByOrderByTenDangNhapAsc();
	}

	@Override
	public List<NguoiDung> findById(String id) {
		// TODO Auto-generated method stub
		return repository_NguoiDung.findByTenDangNhapLike(id);
	}

	@Override
	public NguoiDung saveOne(NguoiDung nguoiDung) {
		// TODO Auto-generated method stub
		return repository_NguoiDung.save(nguoiDung);
	}

	@Override
	public Optional<Object> updateOne(NguoiDung nguoiDung) {
		return repository_NguoiDung.findById(nguoiDung.getTenDangNhap()).map(nguoidung -> {
			nguoidung = nguoiDung;
			return repository_NguoiDung.save(nguoidung);
		});
	}

	@Override
	public Optional<Object> deleteById(String id) {
		return repository_NguoiDung.findById(id).map(nguoidung -> {
			repository_NguoiDung.delete(nguoidung);
			return ResponseEntity.ok().build();
		});
	}

	@Override
	public List<NguoiDung> seach(String seachString) {
		seachString= "%"+seachString+"%";
		return repository_NguoiDung.findByTenDangNhapLikeOrHoTenLike(seachString, seachString);
	}

}
