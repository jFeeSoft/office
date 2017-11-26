package com.jfeesoft.office.service;

import com.jfeesoft.office.model.SystemUser;

public interface SystemUserService extends GenericService<SystemUser, Long> {

	void removeTag(SystemUser user);

	void addTag(SystemUser user);

	void saveNotes(SystemUser user);

	boolean existEmail(String emial);
}
