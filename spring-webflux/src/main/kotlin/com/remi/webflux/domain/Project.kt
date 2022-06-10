package com.remi.webflux.domain

import javax.persistence.*

@Entity
@Table(name = "project")
class Project (
    @Id
    @org.springframework.data.annotation.Id
    @Column(name = "id")
    var id: String? = null,

    @Column(name = "name")
    var name: String? = null,

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
    var seq: Long? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Project

        if (id != other.id) return false
        if (name != other.name) return false
        if (seq != other.seq) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "Project(id=$id, name=$name, seq=$seq)"
    }
}