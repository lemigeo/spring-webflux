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
    var name: String? = null
)