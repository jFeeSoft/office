package com.jfeesoft.office.view;

import javax.annotation.PostConstruct;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("breadCrumbBean")
@Scope("session")
public class BreadCrumbBean {
	private MenuModel model;
	private DefaultMenuItem homeItem;

	@PostConstruct
	public void init() {
		model = new DefaultMenuModel();
		homeItem = new DefaultMenuItem();
		homeItem.setHref("/pages/index.xhtml");
		homeItem.setIcon("ui-icon-home");
		model.addElement(homeItem);
	}

	public void addElement(String name, String href) {
		model.getElements().clear();
		model.addElement(homeItem);
		DefaultMenuItem item = new DefaultMenuItem();
		item.setHref(href);
		item.setValue(name);
		model.addElement(item);
	}

	public void addElementNext(String name, String href) {
		DefaultMenuItem item = new DefaultMenuItem();
		item.setHref(href);
		item.setValue(name);
		model.addElement(item);
	}

	public MenuModel getModel() {
		return model;
	}

	public void setModel(MenuModel model) {
		this.model = model;
	}
}
