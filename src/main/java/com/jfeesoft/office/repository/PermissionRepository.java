package com.jfeesoft.office.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.jfeesoft.office.model.Permission;

public interface PermissionRepository extends GenericRepository<Permission, Integer>, PermissionRepositoryCustom {

	@Query(value = "FROM Permission per LEFT JOIN FETCH per.children WHERE per.parent IS NULL ")
	List<Permission> findAllPermission();
}
