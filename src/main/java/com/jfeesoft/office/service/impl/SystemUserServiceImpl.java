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
import com.jfeesoft.office.repository.FileRepository;
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
	private SystemUserRepository userRepository;

	@Autowired
	private FileRepository fileRepository;

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
			Long file = fileRepository.countByUserId(user.getId());
			user.setTags(tags);
			user.setNotes(notes);
			user.setAttachCount(file);
		}
		return users;
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void removeTag(SystemUser user) {
		List<Tag> tags = tagRepository.findByRelationAndRelationId("systemUser", user.getId());
		if (user.getTags() == null) {
			for (Tag tag : tags) {
				tagRepository.delete(tag);
			}
		} else {
			for (Tag tag : tags) {
				if (!user.getTags().contains(tag.getTagText())) {
					tagRepository.delete(tag);
				}
			}
		}
	}

	@Override
	public void addTag(SystemUser user) {
		Object obj = user.getTags().get(user.getTags().size() - 1);
		Tag tag = new Tag("systemUser", user.getId(), obj.toString());
		tagRepository.save(tag);
	}

	@Override
	public void saveNotes(SystemUser user) {
		noteRepository.deleteByRelationAndRelationId("systemUser", user.getId());
		noteRepository.save(user.getNotes());

	}

	@Override
	public boolean existEmail(String emial) {
		return userRepository.existEmail(emial) > 0;
	}

}
