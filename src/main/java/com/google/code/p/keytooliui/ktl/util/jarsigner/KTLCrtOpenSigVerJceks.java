package com.google.code.p.keytooliui.ktl.util.jarsigner;

/**
    "Crt" for "Certificate"
    "Sig" for "Signature"
    

**/

import com.google.code.p.keytooliui.ktl.swing.dialog.*;

import com.google.code.p.keytooliui.shared.lang.*;
import com.google.code.p.keytooliui.shared.swing.optionpane.*;
import com.google.code.p.keytooliui.shared.util.jarsigner.*;


// ----
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

// --
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
// ----

import java.awt.*;
import java.io.*;
import java.util.*;

final public class KTLCrtOpenSigVerJceks extends KTLCrtOpenSigVerANAbs
{
    // ------
    // PUBLIC

    public KTLCrtOpenSigVerJceks(
        Frame frmOwner, 
        String strTitleAppli,
        
        // input
        String strPathAbsOpenKst, // existing keystore of type Jceks 
        char[] chrsPasswdOpenKst,
        String strPathAbsFileOpenData,
        
        String strPathAbsFileOpenSig, // digital signature
        String strFormatFileSig 
        )
    {
        super(
            frmOwner, 
            strTitleAppli,
        
            // input
            strPathAbsOpenKst, // existing keystore of type Jceks 
            chrsPasswdOpenKst,
            strPathAbsFileOpenData,
        
            strPathAbsFileOpenSig, // digital signature
            strFormatFileSig,
            KTLAbs.f_s_strProviderKstJceks
            ); 
    }
    
    
    // ---------
    // protected
    
    protected KeyStore _getKeystoreOpen_(File fleOpen)
    {
        return UtilKstJceks.s_getKeystoreOpen(
            super._frmOwner_, 
            super._strTitleAppli_,
            fleOpen,
            super._chrsPasswdKst_);
    }
}
