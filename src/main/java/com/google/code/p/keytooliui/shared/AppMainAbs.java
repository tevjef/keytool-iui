package com.google.code.p.keytooliui.shared;

/**
    "AppMain" means "Main Application", "Main" stands for appli containing a separated (JavaHelp-based) help

    known subclasses:
    . RCReader
    . AppMainBuildAbs ==> XLBuilder & TPBuilder
    . AppMainUIAbs
    
    contains:
    . 1 frame
    
**/

import com.google.code.p.keytooliui.shared.lang.thread.*;
import com.google.code.p.keytooliui.shared.lang.*;
import com.google.code.p.keytooliui.shared.swing.frame.*;
import com.google.code.p.keytooliui.shared.util.changer.*;
import com.google.code.p.keytooliui.shared.io.*;

import java.util.*;
import java.awt.event.*;
import java.io.*;

abstract public class AppMainAbs extends AppAbs implements
    WindowListener,
    ActionListener,
    ItemListener
{
    // -------------------
    // FINAL STATIC PUBLIC
    
    final static public String f_s_strNameDirLibraries = "lib";
 
    // --------------------
    // FINAL STATIC PRIVATE
    
    final static private String _f_s_strClass = "com.google.code.p.keytooliui.shared.AppMainAbs.";
    
    
    
    final static public String f_s_strKWLibHelp = "h"; // used in ModMainAbs.java (NetBeans IDE module)
    
    final static public String f_s_strKWLibHelpStandard = "s"; // used in ModMainAbs.java (NetBeans IDE module)
    
    final static private String _f_s_strKWLibHelpStarted = "r";
    final static private String _f_s_strKWLibHelpExpert = "e";
    final static private String _f_s_strKWLibHelpForward = "f";
    
    
    // ------
    // STATIC
    
    /**
        check for existing classes
    **/
    static
    {
        try
        {
            //  should be located in "jh[javahelp-version]jh.jar"
            Class.forName("javax.help.HelpSet");
	    }
	    
	    catch(ClassNotFoundException excClassNotFound)
	    {
	        excClassNotFound.printStackTrace();
	        MySystem.s_printOutExit(_f_s_strClass + "static", "excClassNotFound caught");
	    }
    }
    
    
    // -------------
    // STATIC PUBLIC
    
    /*
        EG: UIKeytool:
        strAppliLibNameShort = "xls"
        shound return:
              "rc[version]xls_hs"
    */
    static public String s_getNameLibHelpStandardShort(String strAppliLibNameShort)
    {        
        String str = _s_getNameLibHelpPrefix(strAppliLibNameShort);   
        str += AppMainAbs.f_s_strKWLibHelpStandard; // help type
        return str;
    }
 
    
    /*
        EG: UIKeytool:
        strAppliLibNameShort = "xls"
        shound return:
              "rc[version]xls_hr"
              
    */
    static public String s_getNameLibHelpStartedShort(String strAppliLibNameShort)
    {
        String str = _s_getNameLibHelpPrefix(strAppliLibNameShort);   
        str += AppMainAbs._f_s_strKWLibHelpStarted; // help type
        return str;
    }
    
    // ----------------
    // STATIC PROTECTED
    
    
    
    
    /*
        EG: UIKeytool:
        strAppliLibNameShort = "xls"
        shound return:
              "rc[version]xls_hx"
    */
    static protected String _s_getNameLibHelpExpertShort_(String strAppliLibNameShort)
    {
        String str = _s_getNameLibHelpPrefix(strAppliLibNameShort);   
        str += AppMainAbs._f_s_strKWLibHelpExpert; // help type
        return str;
    }
    
    /*
        EG: UIKeytool:
        strAppliLibNameShort = "xls"
        shound return:
              "rc[version]xls_hf"
    */
    static protected String _s_getNameLibHelpForwardShort_(String strAppliLibNameShort)
    {
        String str = _s_getNameLibHelpPrefix(strAppliLibNameShort);   
        str += AppMainAbs._f_s_strKWLibHelpForward; // help type
        return str;
    }
    
    // --------------
    // STATIC PRIVATE
    
    // dialog exit
    static private String _s_strDlgExitTitle = null;
    static private String _s_strDlgExitBody = null;
    
    //static private int _s_intThreadExitNowID = MyThreadAbs.f_s_intIdMin - 1; // = "0"
    
    
    /*
        EG: RCReader:
        strAppliLibNameShort = "rcr"
        shound return:
              "rc[version]rcr_h
    */
    static protected String _s_getNameLibHelpPrefix(String strAppliLibNameShort)
    {
        String strMethod = "_s_getNameLibHelpPrefix(strAppliLibNameShort)";
        
        if (strAppliLibNameShort == null)
            MySystem.s_printOutExit(strMethod, "nil strAppliLibNameShort");
            
        strAppliLibNameShort = strAppliLibNameShort.trim();
        
        if (strAppliLibNameShort.length() != 3)
            MySystem.s_printOutExit(strMethod, "strAppliLibNameShort.length() != 3, strAppliLibNameShort.length()=" + strAppliLibNameShort.length());
  
  
        return Shared.s_getNameShortLibClass(strAppliLibNameShort) +
            Shared.f_s_strLibSeparator +
            AppMainAbs.f_s_strKWLibHelp;
            
        /*return 
            Shared._f_s_strPackLibNameXP_ + // package name
            Shared.f_s_strPackLibVersionXP + // package version
          
            AppMainAbs.f_s_strKWLibHelp +
            Shared.f_s_strLibSeparator +
            strAppliLibNameShort; // library short name*/
    
    }
    
    
    // ------------------
    // STATIC NOT INITIALIZER ==> coz internationalized values not assigned while forcing other language
    // eg: java [appli] -lang fr
    // ==> displays english "exitDialog" texts under english system keyboard
    
    static private void _s_getDialogProps()
    {
        String strMethod = _f_s_strClass + "_s_getDialogProps()";
        
        final String _f_s_strBundleFileShort =
            Shared.f_s_strBundleDir +
            ".AppMainAbs" // class name
        ;
        
        try
        {
            ResourceBundle rbeResources = ResourceBundle.getBundle(_f_s_strBundleFileShort,
               Locale.getDefault());

            _s_strDlgExitTitle = rbeResources.getString("dialogExitTitle");
            _s_strDlgExitBody = rbeResources.getString("dialogExitBody");    
        }
        
        catch (MissingResourceException excMissingResource)
        {
            excMissingResource.printStackTrace();
            MySystem.s_printOutExit(strMethod, "excMissingResource caught");
        }

   
    } 
    
    
     // ---------------
    // ABSTRACT PUBLIC
    
    abstract protected boolean _exitNow_();
    
    // ------
    // PUBLIC
    
    public boolean start()
    {
        String strMethod = "start()";
        
        if (this._blnAppliDirCanWrite_)
        {
            /*if (this._luaLastUserPreferences == null)
            {
                MySystem.s_printOutError(this, strMethod, "nil this._luaLastUserPreferences"); 
                return false;
            }*/
            
            if (this._luaLastUserPreferences != null)
                if (! this._luaLastUserPreferences.assign())
                {
                    MySystem.s_printOutError(this, strMethod, "failed"); 
                    return false;
                }
        }
        
        // ending
        return true;
    }
    
    public boolean init()
    {
        String strMethod = "init()";
        
        if (this._blnAppliDirCanWrite_)
        {
            if (this._luaLastUserPreferences == null)
            {
                MySystem.s_printOutError(this, strMethod, "nil this._luaLastUserPreferences");
                return false;
            }
            
            if (! this._luaLastUserPreferences.init())
            {
                MySystem.s_printOutError(this, strMethod, "failed, don't care");
                //this._luaLastUserPreferences = null;
                return false;
            }
            
            if (this._luaLastUserProjects_ != null)
            {
                if (! this._luaLastUserProjects_.init())
                {
                    MySystem.s_printOutError(this, strMethod, "failed");
                    return false;
                }
            }
        }
        
        if (this._fmaFrame_ == null)
        {
            MySystem.s_printOutError(this, strMethod, "nil this._fmaFrame_");
            return false;
        }
        
        if (! this._fmaFrame_.init())
        {
            MySystem.s_printOutError(this, strMethod, "failed");
            return false;
        }
        
        if (this._cltChangerLocToolbar_ == null)
        {
            MySystem.s_printOutError(this, strMethod, "nil this._cltChangerLocToolbar_");
            return false;
        }
        
        if (! this._cltChangerLocToolbar_.init()) // changer main toolbar orientation
        {
            MySystem.s_printOutError(this, strMethod, "failed");
            return false;
        }
        
        // test
        // TEST
        _delayDoHelpBroker(this._strAppliPackNameShort);
        
        // ------
        // ending
        return true;
    }
    
    public void destroy()
    {
        //String strMethod = "destroy()";
        //MySystem.s_printOutWarning(this, strMethod, "TEMPO IN COMMENTS");
        
        
        if (this._luaLastUserPreferences != null)
        {
            this._luaLastUserPreferences.destroy();
            this._luaLastUserPreferences = null;
        }
        
        if (this._luaLastUserProjects_ != null)
        {
            this._luaLastUserProjects_.destroy();
            this._luaLastUserProjects_ = null;
        }
        
        if (this._fmaFrame_ != null)
        {
            this._fmaFrame_.destroy();
            //this._fmaFrame_.dispose();
            this._fmaFrame_ = null;
        }
        
        if (this._cltChangerLocToolbar_ != null)
        {
            this._cltChangerLocToolbar_.destroy();
            this._cltChangerLocToolbar_ = null;
        }
        
        if (this._vecMyHelpBroker != null)
        {
            for (int i=0; i<this._vecMyHelpBroker.size(); i++)
            {
                com.google.code.p.keytooliui.shared.help.MyHelpBroker mhbCur =
                        (com.google.code.p.keytooliui.shared.help.MyHelpBroker) this._vecMyHelpBroker.elementAt(i);
                
                if (mhbCur != null)
                {
                    mhbCur.destroy();
                    mhbCur = null;
                }
            }
            
            this._vecMyHelpBroker.clear();
            this._vecMyHelpBroker = null;
        }
        
        
        if (this._blnAllowedCleanUpAllManagerMedia)
            com.google.code.p.keytooliui.javax.media.MyManager.s_cleanUpAll();
    }
    
    public void itemStateChanged(ItemEvent evtItem) 
    {
        String strMethod = "itemStateChanged(evtItem)";
        
        try
        {
        
            if (evtItem.getStateChange() == ItemEvent.DESELECTED)
                return;
            
            
            if (! (evtItem.getSource() instanceof com.google.code.p.keytooliui.shared.swing.menuitem.RBMIAlignAbstract))
                MySystem.s_printOutExit(this, strMethod, "wrong instance");
                
            com.google.code.p.keytooliui.shared.swing.menuitem.RBMIAlignAbstract rbmSource =
                (com.google.code.p.keytooliui.shared.swing.menuitem.RBMIAlignAbstract) evtItem.getSource();
                    
            // ------------
            // MAIN TOOLBAR
            
            if (rbmSource instanceof com.google.code.p.keytooliui.shared.swing.menuitem.RBMIAlignTopToolMain)
            {
	            if (! this._cltChangerLocToolbar_.setTop())
	                MySystem.s_printOutExit(this, strMethod, "failed");
    	            
	            return;
            }
            
            if (rbmSource instanceof com.google.code.p.keytooliui.shared.swing.menuitem.RBMIAlignBottomToolMain)
            {
	            if (! this._cltChangerLocToolbar_.setBottom())
	                MySystem.s_printOutExit(this, strMethod, "failed");
    	            
	            return;
            }
                
            if (rbmSource instanceof com.google.code.p.keytooliui.shared.swing.menuitem.RBMIAlignLeftToolMain)
            {
	            if (! this._cltChangerLocToolbar_.setLeft())
	                MySystem.s_printOutExit(this, strMethod, "failed");
            
                return;
            }
            
            if (rbmSource instanceof com.google.code.p.keytooliui.shared.swing.menuitem.RBMIAlignRightToolMain)
            {
	            if (! this._cltChangerLocToolbar_.setRight())
	                MySystem.s_printOutExit(this, strMethod, "failed");
            
                return;
            }
            
            // ---
            // BUG    
            MySystem.s_printOutExit(this, strMethod, "unknown rbmSource, rbmSource.getText()=" + rbmSource.getText());
            
        }
    
        catch(Exception exc)
        {
            if (this._blnExitNow_)
            {
                MySystem.s_printOutTrace(this, strMethod, "exc caught, this._blnExitNow_, ignoring");
                return;
            }
            
            exc.printStackTrace();
            MySystem.s_printOutExit(this, strMethod, "exc caught");
        }
    }
    
    public void actionPerformed(ActionEvent evtAction)
    {
        String strMethod = "actionPerformed(evtAction)";
        
        if (evtAction.getSource() instanceof com.google.code.p.keytooliui.shared.swing.menuitem.MIFileExit)
        {
            if (! _exitConfirmed())
                return;
                
            //MySystem.s_printOutTrace(this, strMethod, "exit confirmed");
            _exitNow();
        
            return;
        }
        
        if (evtAction.getSource() instanceof com.google.code.p.keytooliui.shared.swing.button.BESExit24)
        {
            if (! _exitConfirmed())
                return;
                
            //MySystem.s_printOutTrace(this, strMethod, "exit confirmed");
        
            _exitNow();
        
            return;
        }
        
        // --
        MySystem.s_printOutExit(this, strMethod, "uncaught source,\nevtAction.getSource().getClass().toString()=" + evtAction.getSource().getClass().toString());
    }
    
    public void windowDeactivated(WindowEvent evt){}
    public void windowDeiconified(WindowEvent evt){}
    public void windowOpened(WindowEvent evt){}
    public void windowIconified(WindowEvent evt){}
    public void windowActivated(WindowEvent evt){}
    public void windowClosed(WindowEvent evt){}
    
    public void windowClosing(WindowEvent evtWindow)
    {
        String strMethod = "windowClosing(evtWindow)";
        
        if (! _exitConfirmed())
            return;
            
        //MySystem.s_printOutTrace(this, strMethod, "exit confirmed");
        
        _exitNow();  
    }
    
    
    // ---------
    // PROTECTED
    
    private String _strAppliPackNameShort;
    
    protected String _strTitleAppli_ = null; // "[application]";
    
    protected AppMainAbs(
        boolean blnAllowedCleanUpAllManagerMedia,
        boolean blnParentDirReadOnlyAllowed,
        String strTitleAppli,
        String strAppliPackNameShort, // eg: rcr, xlb, tpb, ktl, jst
        boolean blnShowDialogExitConfirm,
        boolean blnIsHelpGettingStarted,
        boolean blnSetLAFSwing, // used to fix up JH's toolbar buttons
        boolean blnInternAllowed // custom help
        )
    {
        super();
        
        String strMethod = "AppMainAbs(...)";
        
        this._blnAllowedCleanUpAllManagerMedia = blnAllowedCleanUpAllManagerMedia;
        this._blnParentDirReadOnlyAllowed = blnParentDirReadOnlyAllowed;
        this._strTitleAppli_ = strTitleAppli;
        this._strAppliPackNameShort = strAppliPackNameShort;
        this._blnShowDialogExitConfirm = blnShowDialogExitConfirm;
        this._blnSetLAFSwing = blnSetLAFSwing;
        this._blnInternAllowed = blnInternAllowed;
        // --  
        
        this._vecMyHelpBroker = new Vector<javax.help.HelpBroker>();
        
        
        /* _TEMPO_
        this._hbrHelpStandard_ = this._doHelpBroker_(AppMainAbs.s_getNameLibHelpStandardShort(strAppliPackNameShort));

        if (this._hbrHelpStandard_ == null)
            MySystem.s_printOutExit(this, strMethod, "nil this._hbrHelpStandard_");
            
         */
        
        
        
        
         
        if (blnIsHelpGettingStarted)
        {
            this._hbrHelpStarted_ = this._doHelpBroker_(s_getNameLibHelpStartedShort(strAppliPackNameShort));
        
            if (this._hbrHelpStarted_ == null)
                MySystem.s_printOutExit(this, strMethod, "nil this._hbrHelpStarted_");
        }
        
        
        
        
        // ---
        File fle = S_FileSys.s_getPathAbsParentAppli(this._blnParentDirReadOnlyAllowed);
        
        if (fle == null)
        {
            MySystem.s_printOutExit(this, strMethod, "nil fle");
        }
        
        //TEMPO used to simulate a write-protected parent appli (eg: CD-Read only)
        
        // --
        //MySystem.s_printOutWarning(this, strMethod, "TEMPO CODE");
        //this._blnAppliDirCanWrite_ = false;
        // --
        
        // ORI
        
        // --
        this._blnAppliDirCanWrite_ = fle.canWrite();
        // --
        
        if (! this._blnParentDirReadOnlyAllowed)
        {
            if (! this._blnAppliDirCanWrite_)
                MySystem.s_printOutExit(this, strMethod, 
                "! this._blnParentDirReadOnlyAllowed && ! this._blnAppliDirCanWrite_");
        }
    }
    
    
    // test
    
    private void _delayDoHelpBroker(final String strAppliPackNameShort)
    {
        final String strMethod = "_delayDoHelpBroker(strAppliPackNameShort)";
        
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
            javax.help.HelpBroker hbrHelpStandard = _doHelpBroker_(
                AppMainAbs.s_getNameLibHelpStandardShort(strAppliPackNameShort));
          
            if (hbrHelpStandard == null)
            {
                MySystem.s_printOutExit(this, strMethod, "nil hbrHelpStandard");
            }
            
            else
            {
                _fmaFrame_.setEnabledHelpKey(hbrHelpStandard); // F1 key
                _fmaFrame_.setEnabledHelpSourceAndTrack(hbrHelpStandard); // menuBar's menuItem & toolbar's iconButtons
            
                _fmaFrame_.setContextualHelpID(); // assign String IDs association JComponents/JavaHelp'strack 
            
               if (! com.google.code.p.keytooliui.shared.help.MyCSH.s_checkAndDumpCmp2ID())
                {
                    MySystem.s_printOutExit(this, strMethod, "failed");

                }
            
            }
        }
      });
    }
    
    
       // !! tempo
    // TEMPO
    protected boolean _blnExitNow_ = false;
    
    
    
    protected boolean _blnAppliDirCanWrite_ = false; // !!!!!!!!!
    
    //protected javax.help.HelpBroker _hbrHelpStandard_ = null;
    protected javax.help.HelpBroker _hbrHelpStarted_ = null;
    protected FMainAbs _fmaFrame_ = null;
    protected ChgLocAbstract _cltChangerLocToolbar_ = null; // main
    
    protected LastUserAbstract _luaLastUserProjects_ = null;
    
    /**
        a new document/project has been opened, updating JavaHelp's JHEditorPane's StyleSheet
        vector should contain at least one element: helpStandard
    **/
    protected boolean _updateJavaHelpStyleSheets_()
    {
        String strMethod = "_updateJavaHelpStyleSheets_()";
        
        if (this._vecMyHelpBroker == null)
        {
            MySystem.s_printOutError(this, strMethod, "nil this._vecMyHelpBroker");
            return false;
        }
        
        for (int i=0; i<this._vecMyHelpBroker.size(); i++)
        {
            com.google.code.p.keytooliui.shared.help.MyHelpBroker mhbCur = null;
            
            try
            {
                mhbCur = (com.google.code.p.keytooliui.shared.help.MyHelpBroker) this._vecMyHelpBroker.elementAt(i);
            }
            
            catch(ClassCastException excClassCast)
            {
                excClassCast.printStackTrace();
                MySystem.s_printOutError(this, strMethod, "excClassCast caught");
                return false;
            }
            
            if (! mhbCur.assignStyleSheet())
            {
                MySystem.s_printOutError(this, strMethod, "failed");
                return false;
            }
        }
        
        // ending
        return true;
    }
    
    protected boolean _createLastUserPreferences_(
        String strDirSubAppli, 
        String strVersionAppli,
        Vector<UserChoice> vecUserChoice)
    {
        String strMethod = "_createLastUserPreferences_(strDirSubAppli, strVersionAppli, vecUserChoice)";
        
        if (! this._blnAppliDirCanWrite_)
            return true;

        if (strDirSubAppli==null)
        {
            MySystem.s_printOutExit(this, strMethod, "nil strDirSubAppli");
            return false;
        }
        
        if (vecUserChoice==null)
        {
            MySystem.s_printOutExit(this, strMethod, "nil vecUserChoice");
            return false;
        }
        
        // ----
        
        File fle = S_FileSys.s_getPathAbsParentAppli(this._blnParentDirReadOnlyAllowed);
        
        if (fle == null)
        {
            MySystem.s_printOutError(this, strMethod, "nil fle");
            return false;
        }
        
        // --
        
        if (this._cltChangerLocToolbar_ == null)
        {
            MySystem.s_printOutExit(this, strMethod, "nil this._cltChangerLocToolbar_");
            return false;
        }
        
        vecUserChoice.addElement(this._cltChangerLocToolbar_);
        
        // --
        this._luaLastUserPreferences = new LastUserPref(
	        fle.getAbsolutePath(), strDirSubAppli, strVersionAppli, vecUserChoice);
	        
	    return true;
    }
    
    protected boolean _createLastUserProjects_(
        String strDirSubAppli, 
        String strVersionAppli,
        Vector<UserChoice> vecUserChoice)
    {
        String strMethod = "_createLastUserProjects_(strDirSubAppli, strVersionAppli, vecUserChoice)";
        
        if (! this._blnAppliDirCanWrite_)
            return true;
        
        if (strDirSubAppli==null)
        {
            MySystem.s_printOutExit(this, strMethod, "nil strDirSubAppli");
            return false;
        }
        
        if (vecUserChoice==null)
        {
            MySystem.s_printOutExit(this, strMethod, "nil vecUserChoice");
            return false;
        }
        
        // --

        File fle = S_FileSys.s_getPathAbsParentAppli(this._blnParentDirReadOnlyAllowed);
        
        if (fle == null)
        {
            MySystem.s_printOutError(this, strMethod, "nil fle");
            return false;
        }
        
        // --
        this._luaLastUserProjects_ = new LastUserProj(
	        fle.getAbsolutePath(), strDirSubAppli, strVersionAppli, vecUserChoice);
	        
	    return true;
    }
    
    
    protected void _exitNormally_()
    {
        final String strMethod = "_exitNormally_()";
        //com.google.code.p.keytooliui.shared.lang.thread.MyThreadAbs.s_dumpThreadsActive();
        //System.out.println("\n\n>> " + this._strTitleAppli_ + " successfully exited");
        
        // -- begin test
        
        /*Thread thrCur = Thread.currentThread();
        System.out.println("thrCur.getName()=" + thrCur.getName());
        
        ThreadGroup tgp = thrCur.getThreadGroup();
        
        if (tgp == null)
            System.out.println("nil tgp");
        else
        {
            System.out.println("! nil tgp, tgp.activeCount()=" + tgp.activeCount());
            System.out.println("tgp.getName()=" + tgp.getName());
            tgp.list();
        }*/
        
        // -- end test
        
        //System.exit(0); // memo: convention, "0"=normal termination
        
        //if (this._blnAllowedCleanUpAllManagerMedia)
          //  com.google.code.p.keytooliui.javax.media.MyManager.s_cleanUpAll();
        
        /*javax.swing.SwingUtilities.invokeLater(new Runnable()
	    {
	        public void run()
	        {*/
	            MySystem.s_printOutTrace(this, strMethod, "exit normally");
	            System.exit(0);
	        /*}
	    }); */
    }
    
    protected boolean _packAndShow_()
    {        
        String strMethod = "_packAndShow_()";
        
        if (this._fmaFrame_ == null)
        {
            MySystem.s_printOutError(this, strMethod, "nil this._fmaFrame_");
            return false;
        }

        /**
            
            dev.: if excArrayIndexOutOfBounds caught, delete all classes, then recompile
            ==> bug fixed
        **/
        try
        {
            this._fmaFrame_.pack();
        }
        
        catch(ArrayIndexOutOfBoundsException excArrayIndexOutOfBounds)
        {
            excArrayIndexOutOfBounds.printStackTrace();
            MySystem.s_printOutError(this, strMethod, "excArrayIndexOutOfBounds caught");
            return false;
        }
        
        this._fmaFrame_.setVisible(true);
        
        // ending
        return true;
    }
    
    protected javax.help.HelpBroker _doHelpBroker_(String strNameDirHS)
    {
        String strMethod = "_doHelpBroker_(strNameDirHS)";
        
        
        
        if (strNameDirHS == null)
        {
            MySystem.s_printOutError(this, strMethod, "nil strNameDirHS");
            return null;
        }
        
        
        
        
        String strPathRelativeDirHS = new String(
            // not working once jarred!
            //AppMainAbs.f_s_strNameDirLibraries + "/" +  
            strNameDirHS);
            
        // beg modif for internationalization dec 24, 05
        
        if (this._blnInternAllowed)
        {
            
            Locale loc = Locale.getDefault(); 
            String strLocLang = loc.getLanguage();
            
            if (strLocLang == null)
            {
                MySystem.s_printOutError(this, strMethod, "nil strLocLang");
	            return null;
            }
                
            // for now, just handling FR, with keytool IUI
            String[] strsSupported = { "fr" };
                
            for (int i=0; i<strsSupported.length; i++)
            {
                if (strLocLang.toLowerCase().compareTo(strsSupported[i]) == 0)
                strPathRelativeDirHS += "_" + strsSupported[i];
                break;
            }
   
            
        }
        
        // end modif for internationalization
        
        String strHelpsetPathRelativeShort = 
            strPathRelativeDirHS + 
            "/" + 
            FileJar.f_s_strPathRelShortDocJhrHelpset;
        
        //  TEST
        //MySystem.s_printOutFlagDev(this, strMethod, "TESTING FOR NETBEANS MODULE");
        //if (AppMainAbs.s_isDeployedWithNbm())
          //  strHelpsetPathRelativeShort = "/" + strHelpsetPathRelativeShort;
       // NOT WORKING!
        
        
        // ---
        com.google.code.p.keytooliui.shared.help.MyHelpSet hst = null;
        
        try
        {
	        ClassLoader clr = this.getClass().getClassLoader();
	        //java.net.URL url = com.google.code.p.keytooliui.shared.help.MyHelpSet.findHelpSet(clr, strHelpsetPathRelativeShort);
                java.net.URL url = javax.help.HelpSet.findHelpSet(clr, strHelpsetPathRelativeShort);
                
                if (url == null)
                {
                    MySystem.s_printOutError(this, strMethod, "nil url, strHelpsetPathRelativeShort=" + strHelpsetPathRelativeShort);
	            return null;
                }
                
	        hst = new com.google.code.p.keytooliui.shared.help.MyHelpSet(clr, url);
                
                if (hst == null)
                {
                    MySystem.s_printOutError(this, strMethod, "nil hst, strHelpsetPathRelativeShort=" + strHelpsetPathRelativeShort);
                    MySystem.s_printOutError(this, strMethod, "... nil hst, url.toString()=" + url.toString());
                    
                    return null;
                }
	    }
	    
	    catch (Exception exc)
	    {
	        exc.printStackTrace();
	        MySystem.s_printOutError(this, strMethod, "exc caught, strHelpsetPathRelativeShort=" + strHelpsetPathRelativeShort);
	        return null;
	    }
	    
	    catch (ExceptionInInitializerError errExceptionInInitializer)
	    {
	        errExceptionInInitializer.getException().printStackTrace();
	        MySystem.s_printOutError(this, strMethod, "errExceptionInInitializer caught, strHelpsetPathRelativeShort=" + strHelpsetPathRelativeShort);
	        return null;
	    }
        
        
            

	    // MODIF COZ BUG WITH STYLESHEETS AND JAVAHELP
	    /*javax.help.HelpBroker hbr = hst.createHelpBroker();
        if (hbr == null)
        {
            MySystem.s_printOutError(this, strMethod, "nil hbr, strHelpsetPathRelativeShort=" + strHelpsetPathRelativeShort);
	        return null;
        }*/
        
        //return hbr;
        
        
        javax.help.HelpBroker hbrMine = new com.google.code.p.keytooliui.shared.help.MyHelpBroker(
            hst,
            this._blnSetLAFSwing
            );
        
        if (! ((com.google.code.p.keytooliui.shared.help.MyHelpBroker) hbrMine).init())
        {
            MySystem.s_printOutError(this, strMethod, "failed, strHelpsetPathRelativeShort=" + strHelpsetPathRelativeShort);
	    return null;
        }
        
        this._vecMyHelpBroker.addElement(hbrMine);
        
        strPathRelativeDirHS = null; // dec 30, 05
        return hbrMine;
    }
    
    
    // -------
    // PRIVATE
    
    private boolean _blnInternAllowed = false;
    private boolean _blnSetLAFSwing;
    private boolean _blnAllowedCleanUpAllManagerMedia = false;
    
    private boolean _blnShowDialogExitConfirm = false;
    private boolean _blnParentDirReadOnlyAllowed = false;
    
    private LastUserAbstract _luaLastUserPreferences = null;
    
    
    
    // used to fix up troubleshooting in JavaHelp/JHEditorPane/StyleSheet: if new RCR document opened, RCR Doc's StyleSheet
    // assigned in JHEditorPane's StyleSheet
    private Vector<javax.help.HelpBroker> _vecMyHelpBroker = null; 
    

    
    private boolean _exitConfirmed()
    {   
        String strMethod = "_exitConfirmed()";
      
        
        
        /* eg, appli is RCReader:
          . bundled as an help in another appli
          . in preview mode
        */
        // TEMPO IN COMMENTS
        //MySystem.s_printOutTrace(this, strMethod, "!!!!!!!!!!! dev info:tempo in comments");
        //if (true) return true;
        
        
        if (! this._blnShowDialogExitConfirm) 
            return true;
        
        com.google.code.p.keytooliui.shared.awt.MyToolkit.s_beep();
        
        if (_s_strDlgExitTitle == null)
            _s_getDialogProps();
        
        String strTitle = _s_strDlgExitTitle;
        
        if (this._strTitleAppli_ != null)
            strTitle = this._strTitleAppli_ + " - " + _s_strDlgExitTitle;
        
        return com.google.code.p.keytooliui.shared.swing.optionpane.OPAbstract.s_showConfirmDialog(
            this._fmaFrame_,
            strTitle,
            _s_strDlgExitBody);
    }
    
    
    private void _exitNow()
    {
        String strMethod = "_exitNow()";
        
        if (! _exitNow_())
		{
		    System.out.println(strMethod + ", failed, forcing an exit");
            System.exit(1);
        }
        
        
        /** IN COMMENTS: exit in a new thread, coz sometimes hanging up!
        
        // MEMO: regular thread, should not be interrupted
        Thread appThread = new Thread() 
        {
            public void run() 
            {
                String strMethod2 = strMethod + "." + "run()";
                    
		        if (! _exitNow_())
		        {
		            System.out.println(strMethod2 + ", failed, forcing an exit");
                    System.exit(1);
                }
            }
        };
        
        _s_intThreadExitNowID ++;
        
        if (_s_intThreadExitNowID > MyThreadAbs.f_s_intIdMax)
        {
            MySystem.s_printOutTrace(this, strMethod, "_s_intThreadExitNowID > MyThreadAbs.f_s_intIdMax, resetting");
            _s_intThreadExitNowID = MyThreadAbs.f_s_intIdMin;
        }
    
        
        //    important:
        //    1) thread name should be different from all MyThread[x] names
        //    2) thread priority should be MIN_PRIORITY
        
        appThread.setName(
            MyThreadAbs.f_s_strSeparatorWord + MyThreadAbs.f_s_strSeparatorWord +
            "com" +
            MyThreadAbs.f_s_strSeparatorWord + MyThreadAbs.f_s_strSeparatorWord +
            "rcreader" +
            MyThreadAbs.f_s_strSeparatorWord + MyThreadAbs.f_s_strSeparatorWord +
            "AppMainAbs" +
            MyThreadAbs.f_s_strSeparatorWord + MyThreadAbs.f_s_strSeparatorWord +
            "_exitNow" +
            "-" + _s_intThreadExitNowID +
            MyThreadAbs.f_s_strSeparatorWord + MyThreadAbs.f_s_strSeparatorWord
            );
        
        
        appThread.setPriority(Thread.MIN_PRIORITY);
        appThread.start();
        
        
        **/
    }
}