package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Phong;
@Repository
public interface REPOSITORY_Phong extends JpaRepository<Phong, Long>{

	List<Phong> findAllByOrderByIdPhongAsc();

}
