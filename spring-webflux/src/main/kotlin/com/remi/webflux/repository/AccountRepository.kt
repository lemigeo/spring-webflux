package com.remi.webflux.repository

import com.remi.webflux.domain.Account
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository : R2dbcRepository<Account, String> {
}