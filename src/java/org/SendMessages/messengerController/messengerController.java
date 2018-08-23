/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.SendMessages.messengerController;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIInput;
import javax.faces.component.UIPanel;
import javax.faces.context.FacesContext;
import org.SendMessages.messenger.messenger;

@ManagedBean(name = "messengerController")
/**
 *
 * @author bhavana
 */
public class messengerController {
   private messenger converter = new messenger();
   private UIPanel resultPanel;
   private UIInput URLInput;

   public messenger getConverter() {
      return converter;
   }

   public void setConverter(messenger converter) {
      this.converter = converter;
   }

   public UIPanel getResultPanel() {
      return resultPanel;
   }

   public void setResultPanel(UIPanel resultPanel) {
      this.resultPanel = resultPanel;
   }

   public UIInput getStringInput() {
      return URLInput;
   }

   public void setStringInput(UIInput URLInput) {
      this.URLInput = URLInput;
   }

   public String sendMessage() {
      FacesContext ctx = FacesContext.getCurrentInstance();
      try {
         converter.sendMessage();
         resultPanel.setRendered(true);
         ctx.addMessage(null, new
               FacesMessage(FacesMessage.SEVERITY_INFO,
            "Sent Message Successfully", null));
      } catch (Exception ex) {
         resultPanel.setRendered(false);
         ctx.addMessage(null, new
               FacesMessage(FacesMessage.SEVERITY_ERROR,
            ex.getMessage(), null));
      }
      return null;
   }
   
   
    public String clear() {
      FacesContext ctx = FacesContext.getCurrentInstance();
      try {
         converter.clear();
         resultPanel.setRendered(false);
         ctx.addMessage(null, new
               FacesMessage(FacesMessage.SEVERITY_INFO,
            "Results Cleared", null));
      } catch (Exception ex) {
         resultPanel.setRendered(false);
         ctx.addMessage(null, new
               FacesMessage(FacesMessage.SEVERITY_ERROR,
            ex.getMessage(), null));
         }
         return null;
   }
    
}
