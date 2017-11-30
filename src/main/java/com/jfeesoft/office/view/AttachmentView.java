package com.jfeesoft.office.view;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.jfeesoft.office.model.File;
import com.jfeesoft.office.service.FileService;

@Component("attachmentView")
@Scope("view")
public class AttachmentView implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<File> attachList;
	private Long idUser;

	private StreamedContent file;

	@Autowired
	private FileService fileService;

	@PostConstruct
	public void init() {
		attachList = Lists.newArrayList();
		if (idUser != null) {
			attachList = fileService.findByUserId(idUser);
		}
	}

	public void saveAttach(Long userId) {
		idUser = userId;
		List<File> files = fileService.findByUserId(userId);
		attachList.clear();
		attachList.addAll(files);
	}

	public void handleFileUpload(FileUploadEvent event) {
		File file = new File();
		file.setFileName(event.getFile().getFileName());
		file.setContent(event.getFile().getContents());
		file.setContentType(event.getFile().getContentType());
		file.setUserId(idUser);
		fileService.save(file);
		FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void deleteFile(File attach) {
		fileService.delete(attach);
	}

	public void download(File attach) {
		ByteArrayInputStream bis = new ByteArrayInputStream(attach.getContent());
		file = new DefaultStreamedContent(bis, attach.getContentType(), attach.getFileName());
	}

	public List<File> getAttachList() {
		return attachList;
	}

	public void setAttachList(List<File> attachList) {
		this.attachList = attachList;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
		if (idUser != null) {
			attachList = fileService.findByUserId(idUser);
		}
	}

	public StreamedContent getFile() {
		return file;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}

}
