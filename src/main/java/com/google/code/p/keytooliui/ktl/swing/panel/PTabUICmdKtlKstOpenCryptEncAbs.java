package com.google.code.p.keytooliui.ktl.swing.panel;

/*
*/

import javax.swing.event.DocumentEvent;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import com.google.code.p.keytooliui.ktl.util.jarsigner.*;
import com.google.code.p.keytooliui.ktl.io.*;

import com.google.code.p.keytooliui.shared.lang.*;
import com.google.code.p.keytooliui.shared.swing.panel.*;
import com.google.code.p.keytooliui.shared.swing.dialog.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

abstract public class PTabUICmdKtlKstOpenCryptEncAbs extends PTabUICmdKtlKstOpenCryptAbs
{    
    // ---------
    // protected
    
    protected PTabUICmdKtlKstOpenCryptEncAbs(
        Frame frmOwner, 
        String strTitleAppli,
        String strHelpID,
        boolean blnAllowTypeJks,
        boolean blnAllowTypePkcs12
        )
    {
        super(
            strHelpID, 
            frmOwner, 
            strTitleAppli,
            blnAllowTypeJks,
            blnAllowTypePkcs12   
            );
        
        super._pnlSelectFileDataOpen_ = new PSelBtnTfdFileOpenAnyCbx(
            (javax.swing.event.DocumentListener) this,
            frmOwner, 
            strTitleAppli,
            (ItemListener) null,
            "Data file:", // strLabel
            "Ascii",
            "ascii versus binary file format"
            );
        
            super._pnlSelectFileDataSave_ = new PSelBtnTfdFileSaveAny(
            (javax.swing.event.DocumentListener) this,
            frmOwner, 
            strTitleAppli,
            (ItemListener) null,
            "Encrypted Data file:" // strLabel
            );
        
    }

    // -------
    // PRIVATE

}
