/*
 *
 * Copyright (c) 2001-2002 RagingCat Project.
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
 
 
 package com.google.code.p.keytooliui.shared.swing.textfield;

/**
    known subclasses:
    . shared:
      . PF10x20
**/


import com.google.code.p.keytooliui.shared.lang.*;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;

abstract public class PFAbs extends JPasswordField
{   
    // --------------------------
    // FINAL STATIC PUBLIC STRING
    
    // !!!!!!!!!!!!!!!!!!!!!!!!
    final static public String f_s_strDocPropKey = PFAbs.f_s_strDocPropKey; 
    
    // ---------------
    // ABSTRACT PUBLIC
    
    abstract public void setDefault();
    abstract public boolean isDefault();
   

    // ------
    // PUBLIC
    
    public boolean init() { return true; }
    
    public void destroy() 
    {
         if (this._docListenerParent != null)
         {
            this.getDocument().addDocumentListener(this._docListenerParent);
            this._docListenerParent = null;
         }
    }
    
    // ---------
    // PROTECTED
    
    protected PFAbs(String strToolTipText, int intColumns, int intH, javax.swing.event.DocumentListener docListenerParent)
    {
        super(intColumns);
        
        this._docListenerParent = docListenerParent;
        
        if (this._docListenerParent != null)
            this.getDocument().addDocumentListener(this._docListenerParent);
        
        if (strToolTipText != null)
            setToolTipText(strToolTipText);
        
        // ----
        Dimension dim = new Dimension(intColumns, intH);
        setPreferredSize(dim);
        setMaximumSize(dim);
        setMinimumSize(dim);
	    
	    setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
	    setEditable(false);
    }
    
    private javax.swing.event.DocumentListener _docListenerParent = null;
}