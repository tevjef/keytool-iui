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
 
 
 package com.google.code.p.keytooliui.shared.swing.menu;

import com.google.code.p.keytooliui.shared.lang.*;

import javax.swing.*;
import javax.swing.text.*;

import java.util.*;

public class METextFontSizeEditorText extends MAbstract
{ 
    
    /** ##############
        STATIC PRIVATE
        ##############
    **/
    
    static private ResourceBundle _s_rbeResources;
    
    final static private String _f_s_strBundleFileShort =
        com.google.code.p.keytooliui.shared.Shared.f_s_strBundleDir +
        ".METextFontSizeEditorText" // class name
        ;
    
    
    final static private String _f_s_strBundleFileLong = _f_s_strBundleFileShort + ".properties";

    static
    {
        final String f_strWhere = "com.google.code.p.keytooliui.shared.swing.menu.METextFontSizeEditorText";
        
        try
        {
            _s_rbeResources = ResourceBundle.getBundle(_f_s_strBundleFileShort,
                Locale.getDefault());
        }
        
        catch (MissingResourceException excMissingResource)
        {
            excMissingResource.printStackTrace();
            MySystem.s_printOutExit(f_strWhere, _f_s_strBundleFileLong + "excMissingResource caught");
        }
    }
    
    // -------------------
    // FINAL STATIC PUBLIC
    
    final static public int F_S_INT_DEFAULT = 12;
    
    /** ######
        PUBLIC
        ######
    **/
    
    public boolean doFileNew()
        throws Exception
    {
        
        this._mim1.setEnabled(true);
        this._mim2.setEnabled(true);
        this._mim3.setEnabled(true);
        this._mim4.setEnabled(true);
        this._mim5.setEnabled(true);
        
        setEnabled(true);
        
        return true;
    }
    
    public boolean doFileOpen()
        throws Exception
    {
        
        this._mim1.setEnabled(true);
        this._mim2.setEnabled(true);
        this._mim3.setEnabled(true);
        this._mim4.setEnabled(true);
        this._mim5.setEnabled(true);
        
        setEnabled(true);
        
        return true;
    }
    
    
    
    // LIFO
    public void destroy()
    {
        
    }
    
  
    
    public boolean init()
    {
        String f_strMethod = "init()";
        // 0) context
        //getAccessibleContext().setAccessibleDescription("Notepad Text Font Size options: select one of several different font families for the notepad");

        if (! _loadResourceBundle())
        {
            MySystem.s_printOutError(this, f_strMethod, "failed");
            return false;
        }

        _addChildren();
        _disableChildrenAtInit();
        return true;
    }
        

        
     
    private JMenuItem _mim1;
    private JMenuItem _mim2;
    private JMenuItem _mim3;
    private JMenuItem _mim4;
    private JMenuItem _mim5;
    
    
    public METextFontSizeEditorText(Hashtable actions)
    {
        super();
       
        _createChildren();
        _createListeners(actions);
    }
	
	private boolean _loadResourceBundle()
	{
        String f_strMethod = "_loadResourceBundle()";
        
         /* MEMO: trim() not necessary
        */
        try
        {   
            String strValue = null;
            
            // TEXTS
	        strValue = _s_rbeResources.getString("text_this");
	        setText(strValue);
	        strValue = _s_rbeResources.getString("text_1");
	        this._mim1.setText(strValue);
	        strValue = _s_rbeResources.getString("text_2");
	        this._mim2.setText(strValue);
	        strValue = _s_rbeResources.getString("text_3");
	        this._mim3.setText(strValue);
	        strValue = _s_rbeResources.getString("text_4");
	        this._mim4.setText(strValue);
	        strValue = _s_rbeResources.getString("text_5");
	        this._mim5.setText(strValue);
	    }
	    
	    catch (MissingResourceException excMissingResource)
	    {
	        excMissingResource.printStackTrace();
	        MySystem.s_printOutError(this, f_strMethod, "excMissingResource caught," + _f_s_strBundleFileLong);
	        return false;
	    }
	  
	    // ending
	    return true;
    }
    
    private void _createChildren()
    {
        this._mim1 = new JMenuItem();
        this._mim2 = new JMenuItem();
        this._mim3 = new JMenuItem();
        this._mim4 = new JMenuItem();
        this._mim5 = new JMenuItem();
    }
    
    private void _createListeners(Hashtable actions)
    {
        Action act = null;
        
        act = _getActionByName(actions, "font-size-10");
        this._mim1.addActionListener(act);
        
        act = _getActionByName(actions, "font-size-12");
        this._mim2.addActionListener(act);
        
        act = _getActionByName(actions, "font-size-18");
        this._mim3.addActionListener(act);
        
        act = _getActionByName(actions, "font-size-36");
        this._mim4.addActionListener(act);
        
        act = _getActionByName(actions, "font-size-48");
        this._mim5.addActionListener(act);
    }
    
    private Action _getActionByName(Hashtable actions, String name)
    {
        return (Action)(actions.get(name));
    }
    
    private void _addChildren()
    { 
        // 4) add buttons
        add(this._mim1);
        add(this._mim2);
        add(this._mim3);
        add(this._mim4);
        add(this._mim5);
    }
    
    private void _disableChildrenAtInit()
    { 
        // 4) add buttons
        this._mim1.setEnabled(false);
        this._mim2.setEnabled(false);
        this._mim3.setEnabled(false);
        this._mim4.setEnabled(false);
        this._mim5.setEnabled(false);
    }
}

