/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorabh86.bean;

/**
 *
 * @author Sorabh86 <ssorabh.ssharma@gmail.com>
 */
public class User {
    
    private String id;
    private String customerId;
    private String password;

    public User(String id, String customerId, String password) {
        this.id = id;
        this.customerId = customerId;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
