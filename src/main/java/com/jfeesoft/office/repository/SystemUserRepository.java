package com.jfeesoft.office.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jfeesoft.office.model.SystemUser;

public interface SystemUserRepository
		extends GenericRepository<SystemUser, Integer>, SystemUserRepositoryCustom<SystemUser> {

	@Query(value = "SELECT user FROM SystemUser user LEFT JOIN FETCH user.roles role "
			+ "LEFT JOIN FETCH role.permissions perm WHERE user.emailAddress = :emailAddress ")
	SystemUser findByEmailAddress(@Param("emailAddress") String email);

	@Query(value = "SELECT count(*) FROM SystemUser user WHERE user.emailAddress = :emailAddress")
	Integer existEmail(@Param("emailAddress") String email);
}
