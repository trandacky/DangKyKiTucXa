package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.DangKyGiuong;

@Repository
public interface RESPOSITORY_DangKyGiuong extends JpaRepository<DangKyGiuong,Long>{

}
