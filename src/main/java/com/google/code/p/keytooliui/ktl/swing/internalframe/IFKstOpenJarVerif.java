package com.google.code.p.keytooliui.ktl.swing.internalframe;

import java.awt.Frame;
import com.google.code.p.keytooliui.ktl.swing.panel.*;


public class IFKstOpenJarVerif extends IFAbs
{
    public IFKstOpenJarVerif(Frame frmParent, String strTitleAppli)
    {
        super();
        
        super._pnl_ = new PTabUICmdJsrVerify(frmParent, strTitleAppli);
        setTitle(PTabUICmdJsrVerify.STR_TITLETASK);
    }

}
