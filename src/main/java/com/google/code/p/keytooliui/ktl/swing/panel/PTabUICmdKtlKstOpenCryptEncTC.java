package com.google.code.p.keytooliui.ktl.swing.panel;

/*
*/

import com.google.code.p.keytooliui.ktl.util.jarsigner.*;
import com.google.code.p.keytooliui.ktl.io.*;

import com.google.code.p.keytooliui.shared.lang.*;
import com.google.code.p.keytooliui.shared.swing.panel.*;
import com.google.code.p.keytooliui.shared.swing.dialog.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

final public class PTabUICmdKtlKstOpenCryptEncTC extends PTabUICmdKtlKstOpenCryptEncAbs
{
    // ---------------------------
    // final static private String
    
    final static public String STR_TITLETASK = "Encrypt data file with RSA trusted certificate entry";
    
    // ---------------------
    // STATIC PRIVATE STRING
    
    static private String _s_strHelpID = null;
    
    //static private String _s_strDlgInfoActionBodyBeg = null;
    //static private String _s_strDlgInfoActionBodyCrypt = null;
    //static private String _s_strDlgInfoActionBodyQuery = null;
    
    // ------------------
    // STATIC INITIALIZER
    
    static
    {
        /*String strWhere = "com.google.code.p.keytooliui.ktl.swing.panel.PTabUICmdKtlKstOpenCryptEncTC";
        
        String strBundleFileShort =
            com.google.code.p.keytooliui.ktl.AppMainUIAbs.f_s_strBundleDir +
            ".PTabUICmdKtlKstOpenCryptEncTC" // class name
            ;
        
        String strBundleFileLong = strBundleFileShort + ".properties";
        
        try
        {
            java.util.ResourceBundle rbeResources = java.util.ResourceBundle.getBundle(strBundleFileShort, 
                java.util.Locale.getDefault());
              */
            _s_strHelpID = "_encrypt_file_tce_rsa_"; // TEMPO rbeResources.getString("helpID");
            //_s_strDlgInfoActionBodyBeg = "dlgInfoActionBodyBeg"; // TEMPO rbeResources.getString("dlgInfoActionBodyBeg");
            //_s_strDlgInfoActionBodyCrypt = "dlgInfoActionBodyCrypt"; // TEMPO rbeResources.getString("dlgInfoActionBodyCrypt");
            //_s_strDlgInfoActionBodyQuery = "dlgInfoActionBodyQuery"; // TEMPO rbeResources.getString("dlgInfoActionBodyQuery");
        /*}
        
        catch (java.util.MissingResourceException excMissingResource)
        {
            excMissingResource.printStackTrace();
            MySystem.s_printOutExit(strWhere, "excMissingResource caught, " + strBundleFileLong + " not found");
        }*/
    }
    
    // ------
    // PUBLIC
    
    public void actionPerformed(ActionEvent evtAction)
    {
        String strMethod = "actionPerformed(evtAction)";
        
        String strFormatKst = ((PSelBtnTfdFileOpenKst) super._pnlSelectFileKst_).getSelectedFormatFile();
        
        if (strFormatKst == null)
            MySystem.s_printOutExit(this, strMethod, "nil strFormatKst");
        
        
        char[] chrsPasswdKst = null;
        
        if (super._strPasswdKst_ != null)
            chrsPasswdKst = super._strPasswdKst_.toCharArray();
        else
            chrsPasswdKst = "".toCharArray();
        
        String strInstanceCipherAlgo = (String) ((PSelCmbAbs) this._pnlSelectCipherAlgo).getSelectedItemCmb();

        
        KTLTcrOpenEncRsaAbs ktl = null;
        
        
        if (strFormatKst.toLowerCase().compareTo(
            UtilKstJks.f_s_strKeystoreType.toLowerCase()) == 0)
        {
            ktl = new KTLTcrOpenEncRsaJks(
                super._frmOwner_, 
                super._strTitleAppli_,
                
                // input
                super._strPathAbsKst_, 
                chrsPasswdKst,
                super._strPathAbsFileDataOpen_,
                
                // I/O
                super._strPathAbsFileDataSave_, // mandatory
                
                // re-input
                strInstanceCipherAlgo
            );
        }
        
        else if (strFormatKst.toLowerCase().compareTo(
            UtilKstJceks.f_s_strKeystoreType.toLowerCase()) == 0)
        {
            ktl = new KTLTcrOpenEncRsaJceks(
                super._frmOwner_, 
                super._strTitleAppli_,
                
                // input
                super._strPathAbsKst_, 
                chrsPasswdKst,
                super._strPathAbsFileDataOpen_,
                
                // I/O
                super._strPathAbsFileDataSave_, // mandatory
                
                // re-input
                strInstanceCipherAlgo
            );
        }
        
        else if (strFormatKst.toLowerCase().compareTo(
            UtilKstPkcs12.f_s_strKeystoreType.toLowerCase()) == 0)
        {
            ktl = new KTLTcrOpenEncRsaPkcs12(
                super._frmOwner_, 
                super._strTitleAppli_,
                
                // input
                super._strPathAbsKst_, 
                chrsPasswdKst,
                super._strPathAbsFileDataOpen_,
                
                // I/O
                super._strPathAbsFileDataSave_, // mandatory
                
                // re-input
                strInstanceCipherAlgo
            );
        }
        
        else if (strFormatKst.toLowerCase().compareTo(
            UtilKstBks.f_s_strKeystoreType.toLowerCase()) == 0)
        {
            ktl = new KTLTcrOpenEncRsaBks(
                super._frmOwner_, 
                super._strTitleAppli_,
                
                // input
                super._strPathAbsKst_, 
                chrsPasswdKst,
                super._strPathAbsFileDataOpen_,
                
                // I/O
                super._strPathAbsFileDataSave_, // mandatory
                
                // re-input
                strInstanceCipherAlgo
            );
        }
        
        else if (strFormatKst.toLowerCase().compareTo(
            UtilKstUber.f_s_strKeystoreType.toLowerCase()) == 0)
        {
            ktl = new KTLTcrOpenEncRsaUber(
                super._frmOwner_, 
                super._strTitleAppli_,
                
                // input
                super._strPathAbsKst_, 
                chrsPasswdKst,
                super._strPathAbsFileDataOpen_,
                
                // I/O
                super._strPathAbsFileDataSave_, // mandatory
                
                // re-input
                strInstanceCipherAlgo
            );
        }
        
       
        else
        {
            MySystem.s_printOutExit(this, strMethod, "uncaught value, strFormatKst=" + strFormatKst);
        }
        
        // --
        
        if (ktl.doJob())
        {
            MySystem.s_printOutTrace(this, strMethod, "OK!");     
         
            if (((PSelBtnTfdFileOpenAnyCbx) super._pnlSelectFileDataOpen_).isSelectedCheckbox())
                super._queryPreviewResults_();
        }
        
        else
            MySystem.s_printOutTrace(this, strMethod, "either aborted by user or failed");
        
       
    }
    
    public void destroy()
    {
        super.destroy();
        
        if (this._pnlSelectCipherAlgo != null)
        {
            this._pnlSelectCipherAlgo.destroy();
            this._pnlSelectCipherAlgo = null;
        }
    }
    
    public boolean init()
    {
        String strMethod = "init()";
        
        
        
        
        if (this._pnlSelectCipherAlgo == null)
        {
            MySystem.s_printOutError(this, strMethod, "nil this._pnlSelectCipherAlgo");
            return false;
        }
        
        if (! this._pnlSelectCipherAlgo.init())
        {
            MySystem.s_printOutError(this, strMethod, "failed");
            return false;
        }
        
        
        if (! super.init())
        {
            MySystem.s_printOutError(this, strMethod, "failed");
            return false;
        }
        
        
        
        // alignment
        
        /*java.util.Vector<PSelAbs> vecPanel = new java.util.Vector<PSelAbs>();
        
        
        Component[] cmps = null;
        
        try
        {
            cmps = super._pnlInput_.getComponents();
            
            for (int i=0; i<cmps.length; i++)
            {
                PSelAbs pnlCur = (PSelAbs) cmps[i];
                vecPanel.add(pnlCur);
            }
            
             cmps = super._pnlOutput_.getComponents();
            
            for (int i=0; i<cmps.length; i++)
            {
                PSelAbs pnlCur = (PSelAbs) cmps[i];
                vecPanel.add(pnlCur);
            }
        
        }
        
        catch(ClassCastException excClassCast)
        {
            excClassCast.printStackTrace();
            MySystem.s_printOutError(this, strMethod, "excClassCast caught, DEV ERROR");
            return false;
        }
        
        if (! PSelAbs.s_alignLabels(vecPanel))
        {
            MySystem.s_printOutError(this, strMethod, "failed");
            return false;
        }*/
        
        
        
        // ---
        return true;
    }
    
    public PTabUICmdKtlKstOpenCryptEncTC(Frame frmOwner, String strTitleAppli)
    {
        super(
            frmOwner, 
            strTitleAppli,
            PTabUICmdKtlKstOpenCryptEncTC._s_strHelpID,
            true, // blnAllowTypeJks,
            true  // blnAllowTypePkcs12 
            );
        
        this._pnlSelectCipherAlgo = new PSelCmbStrCipherRsaAlgoAll();
    }
    
    // ---------
    // protected
    
    // overrides superclass 's method
    protected void _fillInPanelInput_()
    {        
        GridBagConstraints gbc = super._fillInPanelKst_(super._pnlInput_);
        
        gbc.gridy ++;
        super._pnlInput_.add(this._pnlSelectCipherAlgo, gbc);
        
        gbc.gridy ++;
        super._pnlInput_.add(this._pnlSelectFileDataOpen_, gbc);
    }

    // -------
    // PRIVATE
    
    private PSelCmbStrCipherRsaAlgoAll _pnlSelectCipherAlgo = null;
}
