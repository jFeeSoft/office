package com.jfeesoft.office.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jfeesoft.office.model.Note;
import com.jfeesoft.office.model.SystemUser;
import com.jfeesoft.office.model.Tag;
import com.jfeesoft.office.repository.NoteRepository;
import com.jfeesoft.office.repository.SystemUserRepository;
import com.jfeesoft.office.repository.TagRepository;
import com.jfeesoft.office.service.SystemUserService;

@Component
@Transactional
public class SystemUserServiceImpl extends GenericServiceImpl<SystemUser, Long> implements SystemUserService {

	@Autowired
	private TagRepository tagRepository;

	@Autowired
	private NoteRepository noteRepository;

	@Autowired
	public SystemUserServiceImpl(SystemUserRepository systemUserRepository) {
		super(systemUserRepository);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SystemUser> load(int first, int pageSize, String sortField, Direction sortOrder,
			Map<String, Object> filters) {
		List<SystemUser> users = repository.findRepositorySortFilterPage(first, pageSize, sortField, sortOrder,
				filters);
		for (SystemUser user : users) {
			List<Note> notes = noteRepository.findByRelationAndRelationId("systemUser", user.getId());
			List<Tag> tags = tagRepository.findByRelationAndRelationId("systemUser", user.getId());
			user.setTags(tags);
			user.setNotes(notes);
		}
		return users;
	}
}
