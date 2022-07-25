package rw.wallet.e.model;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import rw.wallet.e.controller.GenericDao;
import rw.wallet.e.domain.Account;
import rw.wallet.e.domain.User;

/**
 *
 * @author nicole
 */
@SessionScoped
@ManagedBean(name = "ewallet")
public class Ewallet {

    public Ewallet() {
    }
    
    private Account account = new Account();
    private User user = new User();
    private GenericDao genericDao = new GenericDao();

    public GenericDao getGenericDao() {
        return genericDao;
    }

    public void setGenericDao(GenericDao genericDao) {
        this.genericDao = genericDao;
    }
    
    public Account getAccount() {
        return account;
    }

    public User getUser() {
        return user;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public String goToUserInfo(){
        return "accountDetails";
    }

    public String goToLogin(){
        return "login";
    }
    
    public String goToCreateAccount(){
        return "create-account";
    }
    
    public String goToIndex(){
        return "index";
    }
    
    public String goToNext(){
        return "steptwo";
    }

    public String goToPrevious(){
        return "create-account";
    }
    
//    public String goToSuccess(){
//        return "success";
//    }
    
    public String createAccount(){
        FacesMessage saveMessage;
        try {
            genericDao.createAccount(account);
            saveMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,"Account successfuly created!","Make sure all required Infomation is provided.");
            FacesContext.getCurrentInstance().addMessage("success-message", saveMessage);
            return "accountDetails";
           
        } catch (Exception e) {
            saveMessage = new FacesMessage(FacesMessage.SEVERITY_FATAL,"Failed to create Account! | "+e.getMessage()+"","Make sure all required Infomation is provided.");
            FacesContext.getCurrentInstance().addMessage("error-message", saveMessage);
            return "create-account";        
        }
    }
    
    /*LOGIN*/
    public String login(){
        try {
            if (true) {
                
                return "accountDetails";   
            } else {
                FacesMessage loginMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR ,"Incorrect nationalId or password","Try again");
                FacesContext.getCurrentInstance().addMessage("error-message", loginMessage);
                return "login";   
            }
        } catch (Exception e) {
            FacesMessage loginMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR ,"Incorrect username or password","Try again");
            FacesContext.getCurrentInstance().addMessage("error-message", loginMessage);
            return "login";
        }
    }
    
    
}
