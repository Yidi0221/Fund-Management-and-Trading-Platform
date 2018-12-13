/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.PlatformTradeRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author yangyun
 */
public class PlatformTradeOrganization extends Organization {
    public PlatformTradeOrganization() {
        super(OrganizationType.PlatformTrade.getValue(), OrganizationType.PlatformTrade);
        
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new PlatformTradeRole());
        return roles;
    }
}