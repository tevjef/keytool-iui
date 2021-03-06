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
 
 
package com.google.code.p.keytooliui.shared.swing.panel;

/**

    contains a status bar

    known subclasses:
    . PBarContainerSecRtp

**/

import com.google.code.p.keytooliui.shared.lang.*;

import javax.swing.*;

import java.awt.*;

public class PBarContainerSec extends PBarContainerAbstract 
{ 
    // ------
    // PUBLIC
 
    public void setStatusText(String str)
    {
        if (this._pnlStatus != null)
            this._pnlStatus.setStatus(str);
    }
    

    
    public PBarContainerSec()
    {        
        super();
        
        this._pnlStatus = new PBarStatus(PBarContainerAbstract._f_s_intH_);
    }
    
    public boolean init()
    {
        String strMethod = "init()";
        
        if (this._pnlStatus == null)
        {
            MySystem.s_printOutError(this, strMethod, "nil this._pnlStatus");
            return false;
        }
        
        if (! this._pnlStatus.init())
        {
            MySystem.s_printOutError(this, strMethod, "failed");
            return false;
        }
       
        setLayout(new BorderLayout());
        
        this.add(this._pnlStatus, BorderLayout.CENTER);
        
        
        // --
        this.setMinimumSize(new Dimension(this.getMinimumSize().width, PBarContainerAbstract._f_s_intH_));
        
 
        // --
        
        this.setPreferredSize(getMinimumSize());
        
        
        // ending
        return true;
    }
    
    public void destroy()
    {    
        if (this._pnlStatus != null)
        {
            this._pnlStatus.destroy();
            this._pnlStatus = null;
        }
    }
    
    // -------
    // PRIVATE
    
    private PBarStatus _pnlStatus = null;
}