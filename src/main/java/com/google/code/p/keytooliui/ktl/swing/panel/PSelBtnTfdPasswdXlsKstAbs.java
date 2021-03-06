/*
 *
 * Copyright (c) 2001-2011 keyTool IUI Project.
 * LGPL License.
 * http://code.google.com/p/keytool-iui/
 *
 * This software is the confidential and proprietary information of RagingCat Project.
 * You shall not disclose such confidential information and shall use it only in
 * accordance with the terms of RagingCat Project's license agreement.
 *
 * THE SOFTWARE IS PROVIDED AND LICENSED "AS IS" WITHOUT WARRANTY OF ANY KIND,
 * EITHER EXPRESS OR IMPLIED, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. 
 *
 * LICENSE FOR THE SOFTWARE DOES NOT INCLUDE ANY CONSIDERATION FOR ASSUMPTION OF RISK
 * BY KEYTOOL IUI PROJECT, AND KEYTOOL IUI PROJECT DISCLAIMS ANY AND ALL LIABILITY FOR INCIDENTAL
 * OR CONSEQUENTIAL DAMAGES ARISING OUT OF THE USE OR OPERATION OF OR INABILITY
 * TO USE THE SOFTWARE, EVEN IF KEYTOOL IUI PROJECT HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES. 
 *
 */
 
 
package com.google.code.p.keytooliui.ktl.swing.panel;

/**
    known subclasses:

    . PSelBtnTfdPasswdXlsKstAny (KeyStore of type [JKS-JCEKS])
    . PSelBtnTfdPasswdXlsKstPkcs12 (KeyStore of type PKCS12)


    a panel that displays, from left to right:
    
    . 1 buttonSelect
    . 1 buttonClearSelection
    . 1 passwordfieldSelection
    

     
**/

import com.google.code.p.keytooliui.shared.swing.panel.*;
import com.google.code.p.keytooliui.shared.swing.dialog.*;
import com.google.code.p.keytooliui.shared.swing.optionpane.*;
import com.google.code.p.keytooliui.shared.lang.*;
import com.google.code.p.keytooliui.shared.swing.button.*;
import com.google.code.p.keytooliui.shared.swing.textfield.*;

import javax.swing.*;

import java.awt.*;

abstract public class PSelBtnTfdPasswdXlsKstAbs extends PSelBtnTfdPasswdXlsAbs
{
    protected PSelBtnTfdPasswdXlsKstAbs(
        String strLabel,
        javax.swing.event.DocumentListener docListenerParent,
        Frame frmParent, 
        String strTitleAppli, 
        Object objDocPropValue,
        int intModePassword)
    {
        super(
            strLabel,
            docListenerParent,
            frmParent, 
            strTitleAppli, 
            objDocPropValue, 
            false, // blnFieldRequired
            intModePassword);
    }
    
    protected PSelBtnTfdPasswdXlsKstAbs(
        javax.swing.event.DocumentListener docListenerParent,
        Frame frmParent, 
        String strTitleAppli, 
        Object objDocPropValue,
        String strLabelPrefix,
        int intModePassword)
    {
        super(
            docListenerParent,
            frmParent, 
            strTitleAppli, 
            objDocPropValue, 
            strLabelPrefix, 
            false, // blnFieldRequired
            intModePassword);
    }
}