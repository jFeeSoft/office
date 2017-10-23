package com.jfeesoft.office.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;

import com.jfeesoft.office.model.SystemUser;
import com.jfeesoft.office.repository.PermissionRepositoryCustom;

public class SystemUserRepositoryImpl extends GenericRepositoryImpl<SystemUser>
		implements PermissionRepositoryCustom<SystemUser> {

	public SystemUserRepositoryImpl() {
		super("systemUser", SystemUser.class);
	}

	/*
	 * private void createQuery(Criteria criteria) {
	 * criteria.setFetchMode("smsUzytkownik", FetchMode.JOIN);
	 * criteria.setFetchMode("smsStatus", FetchMode.JOIN);
	 * criteria.setFetchMode("smsUzytkownik.puUzytkownik", FetchMode.JOIN);
	 * criteria.createAlias("smsUzytkownik.puUzytkownik", "puUzytkownik");
	 * criteria.createAlias("smsStatus", "smsStatus");
	 * criteria.createAlias("smsUzytkownik", "smsUzytkownik");
	 * criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY); }
	 */

	@Override
	void createQuery(Criteria criteria) {
		criteria.setFetchMode("roles", FetchMode.JOIN);
		// criteria.setFetchMode("position", FetchMode.JOIN);
		// criteria.setFetchMode("organizationalUnit", FetchMode.JOIN);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
	}

}
