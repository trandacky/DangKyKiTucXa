package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A Giuong.
 */
@Entity
@Table(name = "giuong")
public class Giuong{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_giuong")
    private Long idGiuong;

    @Column(name = "vi_tri_giuong")
    private String viTriGiuong;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "idGiuong")
    private List<DangKyGiuong> dangKyGiuongs = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "idPhong", nullable = false)
    private Phong idPhong;

	public Long getIdGiuong() {
		return idGiuong;
	}

	public void setIdGiuong(Long idGiuong) {
		this.idGiuong = idGiuong;
	}

	public String getViTriGiuong() {
		return viTriGiuong;
	}

	public void setViTriGiuong(String viTriGiuong) {
		this.viTriGiuong = viTriGiuong;
	}

	public List<DangKyGiuong> getDangKyGiuongs() {
		return dangKyGiuongs;
	}

	public void setDangKyGiuongs(List<DangKyGiuong> dangKyGiuongs) {
		this.dangKyGiuongs = dangKyGiuongs;
	}

	public Phong getIdPhong() {
		return idPhong;
	}

	public void setIdPhong(Phong idPhong) {
		this.idPhong = idPhong;
	}
	
}
