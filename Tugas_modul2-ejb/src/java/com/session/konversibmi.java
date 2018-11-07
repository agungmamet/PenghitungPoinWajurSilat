/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.session;

import java.text.DecimalFormat;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author user
 */
@Stateless
@LocalBean
public class konversibmi {

    String result;
    DecimalFormat a = new DecimalFormat("0.0");
    
    public String silat(double param1, double param2, double param3) {
        return result = a.format((param1*1)+(param2*2)+(param3*3));
    }
    
}
