package com.google.code.p.keytooliui.ktl.swing.dialog;

/**
    "Kpr" means "KeyPair"
**/


import com.google.code.p.keytooliui.ktl.swing.panel.*;

import com.google.code.p.keytooliui.shared.lang.*;
import com.google.code.p.keytooliui.shared.swing.optionpane.*;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.util.*;

final public class DTblEntryKprOpenPkcs12Any extends DTblEntryKprOpenPkcs12Abs 
{
    // --------------------
    // FINAL STATIC PRIVATE
    
    final static private String _f_s_strTitleThis = 
        "select any keypair entry in ";
    
    // ------
    // PUBLIC
    
 

    
    public DTblEntryKprOpenPkcs12Any(
        Component cmpFrameOwner, 
        String strTitleAppli,
        java.security.KeyStore kseLoaded
        )
    {
        super(
            cmpFrameOwner, 
            strTitleAppli,
            DTblEntryKprOpenPkcs12Any._f_s_strTitleThis,
            kseLoaded
            ); 
                        
    }
    
    
    
}