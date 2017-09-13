package com.jfeesoft.office.view.utils;

import javax.faces.application.FacesMessage;

import org.omnifaces.util.Messages;

public class Utils
{

  public static void addDetailMessage(String message)
  {
    addDetailMessage(message,null);
  }

  public static void addDetailMessage(String message, FacesMessage.Severity severity)
  {

    FacesMessage facesMessage = Messages.create("").detail(message).get();
    if (severity != null && severity != FacesMessage.SEVERITY_INFO)
    {
      facesMessage.setSeverity(severity);
    }
    else
    {
      Messages.add(null,facesMessage);
    }
  }

}
