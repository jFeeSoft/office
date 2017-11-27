package com.jfeesoft.office.view;

import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;

import com.jfeesoft.office.model.GenericEntity;
import com.jfeesoft.office.service.GenericService;
import com.jfeesoft.office.view.utils.Utils;

public abstract class GenericView<T> {

	protected final ResourceBundle messagesBundle;

	@Autowired
	protected LazyDataModel<T> genericLazyModel;

	@SuppressWarnings("rawtypes")
	protected GenericService genericService;

	protected T newEntity;

	@SuppressWarnings("rawtypes")
	public GenericView(GenericService genericService) {
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		this.messagesBundle = application.getResourceBundle(context, "msg");
		this.genericService = genericService;
	}

	@SuppressWarnings("unchecked")
	public void delete(GenericEntity entity) {
		genericService.delete(entity);
		Utils.addDetailMessage(messagesBundle.getString("info.delete"), FacesMessage.SEVERITY_INFO);
	}

	@SuppressWarnings("unchecked")
	public void save() {
		try {
			newEntity = (T) genericService.save(newEntity);
			Utils.addDetailMessage(messagesBundle.getString("info.edit"), FacesMessage.SEVERITY_INFO);
		} catch (Exception e) {
			Utils.addDetailMessage(messagesBundle.getString("message.error.undefinedSaveException"),
					FacesMessage.SEVERITY_ERROR);
		}
	}

	public void edit(T entity) {
		newEntity = entity;
	}

	public abstract void add();

	public LazyDataModel<T> getGenericLazyModel() {
		return genericLazyModel;
	}

	public void setGenericLazyModel(LazyDataModel<T> genericLazyModel) {
		this.genericLazyModel = genericLazyModel;
	}

	public T getNewEntity() {
		return newEntity;
	}

	public void setNewEntity(T newEntity) {
		this.newEntity = newEntity;
	}

}
