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
    known subclasses:
    . PCpSwRtpVideoOnly
    . PCpSwRtpVideoAudio
**/


import com.google.code.p.keytooliui.shared.swing.toolbar.*;
import com.google.code.p.keytooliui.shared.lang.*;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;


abstract public class PCpSwRtpVideoAbs extends PCpSwRtpAbs
{
    // ------
    // PUBLIC
    
    public void actionPerformed(ActionEvent evtAction)
    {
        String strMethod = "actionPerformed(evtAction)";
        
            
        if (evtAction.getSource() instanceof com.google.code.p.keytooliui.shared.swing.button.BESFullScreen16)
        {
            if (super._pnlPage_ == null)
                return;
                    
            if (! ((PPageSwMediaRtpVideoAbs) super._pnlPage_).setFullScreen(true))
                MySystem.s_printOutExit(this, strMethod, "failed");
            
            return;
        }
        
        if (evtAction.getSource() instanceof com.google.code.p.keytooliui.shared.swing.checkbox.CBIFullWindow16)
        {
            if (super._pnlPage_ == null)
                return;
                
            JCheckBox cbx = (JCheckBox) evtAction.getSource();
                    
            if (! ((PPageSwMediaRtpVideoAbs) super._pnlPage_).setFullWindow(cbx.isSelected()))
                MySystem.s_printOutExit(this, strMethod, "failed");
            
            return;
        }
        
        
            
        super.actionPerformed(evtAction);  
      
    }
    
    // ---------
    // PROTECTED
    
    protected PCpSwRtpVideoAbs(
        String strIPTransmitter,
        int intPortTransmitter,
        int intTTL,
        String strTitleAppli,
        JFrame frmParent,
        ActionListener actListenerParentFrame,
        int intTimeToWait)
    {
        super((Component) frmParent, strTitleAppli, intTimeToWait);
        
        super._tbrToolbar_ = new TBPageSecMediaRtpVideo(
            actListenerParentFrame,
            (ActionListener) this
            );
        
    }
}