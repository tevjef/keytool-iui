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
 
 
package com.google.code.p.keytooliui.ktl.swing.menuitem;

/**
    known subclasses:
    . MIToolKstJks
    . MIToolKstJceks
**/


import com.google.code.p.keytooliui.shared.swing.menuitem.*;
import com.google.code.p.keytooliui.shared.lang.*;

import java.awt.event.*;

abstract public class MIToolKstAbs extends MIAbstract
{   
    public boolean init()
    {
        String strMethod = "init()";
        
        if (! super.init())
            return false;
            
        javax.swing.ImageIcon iin = com.google.code.p.keytooliui.ktl.swing.imageicon.S_IINUI.s_get(
            com.google.code.p.keytooliui.ktl.swing.button.BESTool16.f_s_strImage);
            
        if (iin == null)
        {
            MySystem.s_printOutError(this, strMethod, "nil iin");
            return false;
        }
        
        setIcon(iin);
            
        // --
        return true;
    }
    
    // ---------
    // PROTECTED
    
    protected MIToolKstAbs(
        String strTypeKst,
        ActionListener actListenerParent
        )
    {
        super(
            strTypeKst + " " + "keystore" + " " + "...",
            actListenerParent
            );
    }
}