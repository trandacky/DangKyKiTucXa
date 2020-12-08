package com.example.demo.entity;


import javax.persistence.*;

import java.io.Serializable;

/**
 * A QuangCao.
 */
@Entity
@Table(name = "quang_cao")
public class QuangCao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "link_hinh_anh")
    private String linkHinhAnh;

    @Column(name = "link_web_can_quang_cao")
    private String linkWebCanQuangCao;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLinkHinhAnh() {
        return linkHinhAnh;
    }

    public QuangCao linkHinhAnh(String linkHinhAnh) {
        this.linkHinhAnh = linkHinhAnh;
        return this;
    }

    public void setLinkHinhAnh(String linkHinhAnh) {
        this.linkHinhAnh = linkHinhAnh;
    }

    public String getLinkWebCanQuangCao() {
        return linkWebCanQuangCao;
    }

    public QuangCao linkWebCanQuangCao(String linkWebCanQuangCao) {
        this.linkWebCanQuangCao = linkWebCanQuangCao;
        return this;
    }

    public void setLinkWebCanQuangCao(String linkWebCanQuangCao) {
        this.linkWebCanQuangCao = linkWebCanQuangCao;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof QuangCao)) {
            return false;
        }
        return id != null && id.equals(((QuangCao) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "QuangCao{" +
            "id=" + getId() +
            ", linkHinhAnh='" + getLinkHinhAnh() + "'" +
            ", linkWebCanQuangCao='" + getLinkWebCanQuangCao() + "'" +
            "}";
    }
}
