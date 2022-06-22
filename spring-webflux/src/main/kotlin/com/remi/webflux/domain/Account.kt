package com.remi.webflux.domain

import org.springframework.data.domain.Persistable
import javax.persistence.*

@Entity
@Table(name = "account")
class Account (
    @Id
    @org.springframework.data.annotation.Id
    @Column(name = "id")
    private var id: String? = null,

    @Column(name = "name")
    var name: String? = null,

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq", insertable=false)
    var seq: Long? = null
): Persistable<String> {

    override fun getId(): String? {
        return this.id
    }

    fun setId(value: String?) {
        this.id = value
    }

    override fun isNew(): Boolean {
        return this.seq === null
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Account

        if (id != other.id) return false
        if (name != other.name) return false
        if (seq != other.seq) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "Account(id=$id, name=$name, seq=$seq)"
    }
}