package com.jfeesoft.office.view;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
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
import com.jfeesoft.office.view.utils.Utils;

@Component("attachmentView")
@Scope("view")
public class AttachmentView implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<File> attachList;
	private Long idUser;

	private StreamedContent file;
	protected ResourceBundle messagesBundle;

	@Autowired
	private FileService fileService;

	@PostConstruct
	public void init() {
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		this.messagesBundle = application.getResourceBundle(context, "msg");
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
		file = fileService.save(file);
		attachList.add(file);
		Utils.addDetailMessage(messagesBundle.getString("info.upload"), FacesMessage.SEVERITY_INFO);
	}

	public void deleteFile(File attach) {
		fileService.delete(attach);
		attachList.remove(attach);
		Utils.addDetailMessage(messagesBundle.getString("info.delete"), FacesMessage.SEVERITY_INFO);
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
