package com.jfeesoft.office.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jfeesoft.office.model.SystemUser;

@Repository
public interface SystemUserRepository extends CrudRepository<SystemUser, String> {

	@Query(value = "SELECT user FROM SystemUser user LEFT JOIN FETCH user.roles role "
			+ "LEFT JOIN FETCH role.permissions perm WHERE user.emailAddress = :emailAddress ")
	SystemUser findByEmailAddress(@Param("emailAddress") String email);
}
