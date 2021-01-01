package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.NguoiDung;

@Repository
public interface REPOSITORY_NguoiDung extends JpaRepository< NguoiDung, String>{


	List<NguoiDung> findAllByOrderByTenDangNhapAsc();

	List<NguoiDung> findByTenDangNhapLikeOrHoTenLike(String seachString, String seachString2);

	List<NguoiDung> findByTenDangNhapLike(String id);
	
	
}
