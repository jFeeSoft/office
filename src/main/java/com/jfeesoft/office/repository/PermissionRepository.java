package com.jfeesoft.office.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;

import com.jfeesoft.office.model.Permission;

@SuppressWarnings("rawtypes")
public interface PermissionRepository extends GenericRepository<Permission, Integer>, PermissionRepositoryCustom {

	@Query(value = "FROM Permission per LEFT JOIN FETCH per.children WHERE per.parent IS NULL ")
	Set<Permission> findAllRootPermission();

	@Query(value = "FROM Permission per ORDER BY per.name ASC")
	List<Permission> findAllPermission();

}
