package com.google.code.p.keytooliui.ktl.swing.internalframe;

import java.awt.Frame;
import com.google.code.p.keytooliui.ktl.swing.panel.*;


public class IFKstOpenCrtImpTcr extends IFAbs
{
    public IFKstOpenCrtImpTcr(Frame frmParent, String strTitleAppli)
    {
        super();
        
        super._pnl_ = new PTabUICmdKtlKstOpenCrtImpTcr(frmParent, strTitleAppli);
        setTitle(PTabUICmdKtlKstOpenCrtImpTcr.STR_TITLETASK);
    }

}

