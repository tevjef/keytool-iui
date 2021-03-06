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
 
 
 package com.google.code.p.keytooliui.shared.swing.button;
 
 /**

    
 **/
 
 import com.google.code.p.keytooliui.shared.swing.icon.*;
 
 import javax.swing.*;
 
 import java.awt.*;
 import java.awt.event.*;
 
 final public class RBColor extends JRadioButton
 {
    public boolean init() { return true; }
    
    public void destroy() 
    {
        if (this._itmListenerParent != null)
        {
            removeItemListener(this._itmListenerParent);
            this._itmListenerParent = null;
        }
    }
    
    // ---------
    // PROTECTED
    
    public RBColor(String strText, Color col, ItemListener itmListenerParent)
    {
        super(strText);
        
        this._itmListenerParent = itmListenerParent;
        
        if (this._itmListenerParent != null)
            addItemListener(this._itmListenerParent);
        
        if (col != null)
            setBackground(col);         
    }
    
    private ItemListener _itmListenerParent = null;
 }