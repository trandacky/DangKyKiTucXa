package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.NguoiDung;

@Repository
public interface REPOSITORY_NguoiDung extends JpaRepository< NguoiDung, Long>{
	
	
}
