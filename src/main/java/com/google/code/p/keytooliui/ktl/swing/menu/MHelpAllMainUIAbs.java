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
 

 
package com.google.code.p.keytooliui.ktl.swing.menu;

/**
  
    
    contains:
    . 1 menu helpOffline
    . 1 menu helpOnline
    . 1 menu about
    
    children are:
    . created in this class,
    . inited, added, and destroyed in superclass
**/

import com.google.code.p.keytooliui.ktl.swing.menuitem.*;

import com.google.code.p.keytooliui.shared.swing.menu.*;

import com.google.code.p.keytooliui.shared.lang.*;

import java.awt.*;

abstract public class MHelpAllMainUIAbs extends MHelpAllMainAbs
{
    // --------------------
    // FINAL STATIC PRIVATE
    
    final static private String _f_s_strTextHelpOfflineSource = "User's Guide ...";
    
    // ------
    // PUBLIC
    
    public boolean init()
    {
        String strMethod = "init()";
        
        if (! super.init())
            return false;
    
        if (! this._mimLicBc.init())
        {
            MySystem.s_printOutError(this, strMethod, "failed");
            return false;
        }
        
      
        super._matAbout_.insert(this._mimLicBc, 0);
        
        
        // --
        return true;
    }
    
    
    public void destroy()
    {
        super.destroy();
        
        if (this._mimLicBc != null)
        {
            this._mimLicBc.destroy();
            this._mimLicBc = null;
        }
    }
    
    // ---------
    // PROTECTED
    
    protected MHelpAllMainUIAbs(
        Component cmpFrameOwner,
        String strTitleApplication,
        //javax.help.HelpBroker hbrHelpStandard,
        String strLic)
    {
        super();
        
        super._matHelpOffline_ = new MHelpOffline(
            //hbrHelpStandard,
            MHelpAllMainUIAbs._f_s_strTextHelpOfflineSource,
            true // blnDoHelpOnItem
            );
        
        
        this._mimLicBc = new MIHelpLicBc(cmpFrameOwner, strTitleApplication);
        
    }
    
    // -------
    // PRIVATE
    
    private MIHelpLicBc _mimLicBc = null;
}