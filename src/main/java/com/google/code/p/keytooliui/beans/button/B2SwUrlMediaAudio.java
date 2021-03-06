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

package com.google.code.p.keytooliui.beans.button;

/**
    a button displayed as a label, while clicked: open up a secondary window
    
    "B" for "Button"
    "Sw" for "Secondary Window"
    "Url" for "Uniform Resource Locator"
    "Media" means window displays a page of type "media", JMF's related
    "Audio" format: AIFF, AU, AVI, GSM, MIDI, MP2, MP3, QT, RMF, WAV 

**/


import com.google.code.p.keytooliui.shared.lang.*;
import com.google.code.p.keytooliui.shared.swing.frame.*;

import javax.swing.*;

import java.net.*;

final public class B2SwUrlMediaAudio extends B2SwUrlMediaAbs 
{
    // ------
    // PUBLIC
    
    public B2SwUrlMediaAudio()
    {
        super();
    }
    
    // ---------
    // PROTECTED
    
    protected boolean _createWindow_()
    {
        String strMethod = "_createWindow_()";
        
        URL url = super._getUrl_();
        
        if (url == null)
        {
            MySystem.s_printOutError(this, strMethod, "nil url");
            return false;
        }
        
        JFrame frmOwner = B2SwAbs._s_getFrameOwnerHelpSet_(this);
        
        if (frmOwner == null)
        {
            MySystem.s_printOutError(this, strMethod, "nil frmOwner");
            return false;
        }

        // --
        
        super._frmWindow_ = 
            new FSwUrlMediaAudio(
                (java.awt.Window) frmOwner,
                super.getWindowTitle(), 
                super._getImageIconFrameTarget_(),
                url); 
        
        return true;
    }
}