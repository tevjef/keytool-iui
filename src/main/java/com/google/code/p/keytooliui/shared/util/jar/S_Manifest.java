/*
 *
 * Copyright (c) 2001-2007 RagingCat Project.
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

package com.google.code.p.keytooliui.shared.util.jar;

/**
    
**/

import com.google.code.p.keytooliui.shared.lang.*;
import com.google.code.p.keytooliui.shared.swing.optionpane.*;

import java.util.jar.*;
import java.io.*;
import java.awt.*;

final public class S_Manifest
{
    // -------------------
    // FINAL STATIC PUBLIC
    
    final static public String f_s_strDirParentManifest = "META-INF";
    final static public String f_s_strPathRelManifest = S_Manifest.f_s_strDirParentManifest + "/MANIFEST.MF";
    
    final static public String f_s_strKeySpecVend = "Specification-Vendor";
    final static public String f_s_strKeySpecVers = "Specification-Version";
    final static public String f_s_strKeyImplVend = "Implementation-Vendor";
    final static public String f_s_strKeyImplVers = "Implementation-Version";
    final static public String f_s_strKeyImplVendId = "Implementation-Vendor-Id";
    
    
    // --------------------
    // FINAL STATIC PRIVATE
    
    final static private String _f_s_strClass = "com.google.code.p.keytooliui.share.util.jar.S_Manifest.";
  
    final static private String _f_s_strManifVersion = "1.0";

    final static private String[] _f_s_strsDefaultEntryManifVersion = 
    { 
        Attributes.Name.MANIFEST_VERSION.toString(), 
        S_Manifest._f_s_strManifVersion
    };
    
    final static private String[] _f_s_strsDefaultEntryManifCreator = 
    { 
        // ----
        // arg #0
        "Created-By", 
        
        // ----
        // arg #1
        System.getProperty("java.version") + 
        " (" + 
        System.getProperty("java.vendor") + 
        ")"
    };
    
    // -------------
    // STATIC PUBLIC
    
    /* transform manifest in an array of byte
        if any code error, exit
        else if any error, show dialog, then return nil
    */
    static public byte[] s_toByteArray(
        Manifest man,
        Frame frmOwner,
        String strTitleAppli
        ) 
    {
        String strMethod = _f_s_strClass + "s_toByteArray(man, frmOwner, strTitleAppli)";
        
        if (man == null)
        {
            MySystem.s_printOutExit(strMethod, "nil man");
        }
        
        ByteArrayOutputStream baoBuffer = new ByteArrayOutputStream();
        
        try
        {
            man.write(baoBuffer);
            baoBuffer.flush();
            baoBuffer.close();
        }
        
        catch(IOException excIO)
        {
            excIO.printStackTrace();
            MySystem.s_printOutExit(strMethod, "excIO caught");
            
            String strBody = "Got IO exception"; 
            
            OPAbstract.s_showDialogError(frmOwner, strTitleAppli, strBody);
            
            return null;
        }
        
        return baoBuffer.toByteArray();
    }
    
    static public Manifest s_create(
        String strSpecVend,
        String strSpecVers,
        String strImplVend,
        String strImplVers,
        String strImplVendId
        
        )
    {
        // create the manifest object
        Manifest man = S_Manifest.s_create();
        
        Attributes attAttributes = man.getMainAttributes();
            
        if (strSpecVend != null)
            attAttributes.putValue(
                S_Manifest.f_s_strKeySpecVend, 
                strSpecVend);
                
        if (strSpecVers != null)
            attAttributes.putValue(
                S_Manifest.f_s_strKeySpecVers, 
                strSpecVers);
                
        if (strImplVend != null)
            attAttributes.putValue(
                S_Manifest.f_s_strKeyImplVend, 
                strImplVend);
                
        if (strImplVers != null)
            attAttributes.putValue(
                S_Manifest.f_s_strKeyImplVers, 
                strImplVers);
                
        if (strImplVendId != null)
            attAttributes.putValue(
                S_Manifest.f_s_strKeyImplVendId, 
                strImplVendId); 
               
            
        return man;
    }
    
    static public Manifest s_create()
    {
        // create the manifest object
        Manifest man = new Manifest();
        
        S_Manifest.s_fill(man);
            
        return man;
    }
    
    static public void s_fill(Manifest man)
    {
        String strMethod = _f_s_strClass + "s_fill(man)";
        
        if (man == null)
        {
            MySystem.s_printOutExit(strMethod, "nil man");
        }
        
        Attributes attAttributes = man.getMainAttributes();
            
        attAttributes.putValue(
            S_Manifest._f_s_strsDefaultEntryManifVersion[0], 
            S_Manifest._f_s_strsDefaultEntryManifVersion[1]);
                
        attAttributes.putValue(
            S_Manifest._f_s_strsDefaultEntryManifCreator[0], 
            S_Manifest._f_s_strsDefaultEntryManifCreator[1]);
    }
}