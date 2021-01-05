package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.DangKyGiuong;

@Repository
public interface REPOSITORY_DangKyGiuong extends JpaRepository<DangKyGiuong, Long> {

	@Modifying
	@Query("select a from DangKyGiuong a inner join Giuong a2 on a.idGiuong = a2.idGiuong "
			+ "inner join Phong a3 on a2.idPhong = a3.idPhong "
			+ "where a.tinhTrangDangKy = 1 and a3.idPhong =:id ")
	List<Object> laySoLuongGiuongDaDangKyCuaPhong(@Param(value = "id") long id);
}
