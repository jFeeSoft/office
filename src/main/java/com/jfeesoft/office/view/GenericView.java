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

import lombok.Getter;
import lombok.Setter;

public abstract class GenericView<T> {

	protected final ResourceBundle messagesBundle;

	@Autowired
	@Getter
	@Setter
	protected LazyDataModel<T> genericLazyModel;

	protected GenericService genericSerivice;

	@Getter
	@Setter
	protected T newEntity;

	public GenericView(GenericService genericService) {
		FacesContext context = FacesContext.getCurrentInstance();
		Application application = context.getApplication();
		this.messagesBundle = application.getResourceBundle(context, "msg");
		this.genericSerivice = genericService;
	}

	public void delete(GenericEntity entity) {
		genericSerivice.delete(entity);
		Utils.addDetailMessage(messagesBundle.getString("info.delete"), FacesMessage.SEVERITY_INFO);
	}

	public void save() {
		newEntity = (T) genericSerivice.save(newEntity);
		Utils.addDetailMessage(messagesBundle.getString("info.edit"), FacesMessage.SEVERITY_INFO);
	}

	public void edit(T entity) {
		newEntity = entity;
	}

	public abstract void add();

}
