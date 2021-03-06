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
 
 
 package com.google.code.p.keytooliui.shared.swing.menubar;


import com.google.code.p.keytooliui.shared.util.eventlistener.*;
import com.google.code.p.keytooliui.shared.lang.*;
import com.google.code.p.keytooliui.shared.swing.menu.*;

final public class MBEditorDefault extends MBEditorAbstract
{
    // ------
    // PUBLIC

    public boolean doFileNew()
        throws Exception
    {
        String f_strMethod = "doFileNew()";
        
        if (! super._doFileNew_())
        {
            MySystem.s_printOutError(this, f_strMethod, "failed");
            return false;
        }
        
        return true;
    }
    
    public boolean doFileOpen()
        throws Exception
    {
        String f_strMethod = "doFileOpen()";
        
        if (! super._doFileOpen_())
        {
            MySystem.s_printOutError(this, f_strMethod, "failed");
            return false;
        }

        return true;
    }
    
    public MBEditorDefault(
        java.awt.Component cmpFrameOwner,
        String strApplicationTitle,
        java.awt.event.ActionListener actListenerParent,
        MFileAllEditorListener nfeListenerParent)
    {
        super(actListenerParent, nfeListenerParent);
        
        super._nhp_ = new MHelpAboutEditorDefault(cmpFrameOwner, strApplicationTitle);
    }
    
    public boolean init()
    {
        String f_strMethod = "init()";
        
        if (! super._init_())
        {
            MySystem.s_printOutError(this, f_strMethod, "failed");
            return false;
        }
    
        // ending
        return true;
    }
    
    public void destroy()
    {
        super._destroy_();
    }
}