package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.entity.MoDangKy;

@Repository
public interface REPOSITORY_MoDangKy extends JpaRepository<MoDangKy, Long> {
}
