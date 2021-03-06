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
 
 
 package com.google.code.p.keytooliui.shared.swing.cellrenderer;

/**

    known subclasses:
    . shared_gen:   CRStringHLocalAnchor
    . shared:       CRStringFileDoc 


    MEMO: cannot derive this class from String as String is final
**/


import javax.swing.*;

import java.awt.*;

abstract public class CRStringAbstract extends Object
{
    // --------------
    // static private
    
    final static private Font _f_s_fnt = new Font("Dialog", Font.PLAIN, 12);
    
    // ------
    // public
    
    public ImageIcon getIcon() { return this._iin_; }   
    public Font getFont() { return this._fnt; }
    public String getName() { return this._str; }
    
    public boolean init() { return true; }
    public void destroy() {}
    
    // ---------
    // protected
    
    protected ImageIcon _iin_ = null;
    
    protected CRStringAbstract(String str)
    {
        this._str = str;
        this._fnt = _f_s_fnt;
    }   
    
    // -------
    // private
    
    private Font _fnt = null;
    private String _str = null;
}