package com.google.code.p.keytooliui.ktl.swing.internalframe;

import java.awt.Frame;
import com.google.code.p.keytooliui.ktl.swing.panel.*;


public class IFKstSave extends IFAbs
{
    public IFKstSave(Frame frmParent, String strTitleAppli)
    {
        super();
        
        super._pnl_ = new PTabUICmdKtlKstSave(frmParent, strTitleAppli);
        setTitle(PTabUICmdKtlKstSave.STR_TITLETASK);
    }

}
