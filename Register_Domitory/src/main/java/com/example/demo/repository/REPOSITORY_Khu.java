package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Khu;

@Repository
public interface REPOSITORY_Khu extends JpaRepository< Khu, Long>{

	List<Khu> findAllByOrderByIdKhuAsc();
	
	
}
