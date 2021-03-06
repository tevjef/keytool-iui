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
 
package com.google.code.p.keytooliui.shared.io;

/*
    U: unix
    

  launching first web navigator found from the following list:
  . mozilla ( in comments, jan 8, 2002)
  . netscape (hard-coded)
  . konqueror
  . lynx 
  
  
  
  
  !!!!
  http://developer.java.sun.com/developer/bugParade/bugs/4052517.html
  !!!!
  (process) Solaris Runtime.exec won't execute programs belonging to other groups

   On Solaris, <code>Runtime.exec()</code> fails if the primary group id of the
Java process doing the exec, and the group id of the executable being exec'ed,
are not the same. Workaround is to rely only on primary group id based
permissions, and refrain from depending on secondary group ids based
permissions for executables that are being exec'ed with
<code>Runtime.exec()</code>.

Evaluation  Turns out that we make a check against the primary gid (in statExecutable) --
we are trying to pre-empt any exec() failures by doing permissions checks very
early. A hack would be to check for other gid's that the java processes euid
might be in. But a correct fix (as Tom Rodriguez points) out would be to
setup a pipe through which it can be communicated to the java process that the
exec failed -- that way we don't have to do any of the permission checks
statExecutable can go away).  Giving to Tom Rodriguez because he is
very comfortable writing this kind of nasty stuff.


 
    
*/



import com.google.code.p.keytooliui.shared.lang.*;
import com.google.code.p.keytooliui.shared.swing.optionpane.*;

import java.awt.*;

public class _S_ToBrowserUSun_ extends _S_ToBrowserUAbs_
{
    // ---------------------------
    // FINAL STATIC PRIVATE STRING
    
    final static private String _f_s_strClass = "com.google.code.p.keytooliui.shared.io._S_ToBrowserUSun_.";
   
    
    
    // ----------------
    // STATIC PROTECTED
    
    static protected boolean _s_displayURL_(Component cmpFrameOwner, String strTitleAppli, String strUrl)
    {    
        String strMethod = _f_s_strClass + "_s_displayURL_(cmpFrameOwner, strTitleAppli, strUrl)";
        
        // ----------
        // 1) mozilla
        
        /** TEMPO IN COMMENTS jan 8, 2002
        if (_S_ToBrowserUAbs_._s_gotCommand_(_S_ToBrowserNSMozilla_._f_s_strName_))
        {
            MySystem.s_printOutTrace(strMethod, "got:" + _S_ToBrowserNSMozilla_._f_s_strName_);

            if (! _S_ToBrowserNSMozilla_._s_displayURL_(strUrl))
            {
                MySystem.s_printOutError(strMethod, "failed, strUrl=" + strUrl);
                return false;
            }
            
            return true;
        }
        **/

        
        // -----------
        // 2) netscape
        
        if (_S_ToBrowserUAbs_._s_gotCommand_(_S_ToBrowserNSNetscape_._f_s_strName_))
        {
            MySystem.s_printOutTrace(strMethod, "got:" + _S_ToBrowserNSNetscape_._f_s_strName_);
            
            
            String strCmdRemote = _S_ToBrowserNSNetscape_._f_s_strName_ + " -remote openURL(" + strUrl + ")";
            
            MySystem.s_printOutTrace(strMethod, "!!!! TRYING REMOTE: strCmdRemote=" + strCmdRemote);
            
            Process p = null;
            
            try
            {
                p = Runtime.getRuntime().exec(strCmdRemote);
            }
            
            catch(Exception exc)
            {
                exc.printStackTrace();
                MySystem.s_printOutError(strMethod, "exc caught");
                return false;
            }
            
            MySystem.s_printOutTrace(strMethod, ">>>> REMOTE COMMAND SENT, NOW CATCHING RETURNED VALUE");
            
            
            try 
            {

                // waiting for exit returned value 
                // if intExitCode=0, OK, netscape was already opened
                // otherwise start browser up.
                int intExitCode = p.waitFor();
                
                MySystem.s_printOutTrace(strMethod, "intExitCode=" + intExitCode);
                
                
                if(intExitCode != 0) 
                {
                    String strCmdDirect = _S_ToBrowserNSNetscape_._f_s_strName_ + " " + strUrl;
                    MySystem.s_printOutTrace(strMethod, "!!!! TRYING DIRECT: strCmdDirect=" + strCmdDirect);
                    p = Runtime.getRuntime().exec(strCmdDirect);
                }
                
                else
                {
                    MySystem.s_printOutTrace(strMethod, ">>>> REMOTE SHOULD BE OK!");
                }
            }
            
            catch(Exception exc)
            {
                exc.printStackTrace();
                MySystem.s_printOutError(strMethod, "exc caught");
                return false;
            }
            
            return true;
        }
        
        
        // ------------
        // 3) konqueror
        
        if (_S_ToBrowserUAbs_._s_gotCommand_(_S_ToBrowserKonqueror_._f_s_strName_))
        {
            MySystem.s_printOutTrace(strMethod, "got:" + _S_ToBrowserKonqueror_._f_s_strName_);

            if (! _S_ToBrowserKonqueror_._s_displayURL_(strUrl))
            {
                MySystem.s_printOutError(strMethod, "failed");
                return false;
            }
            
            return true;
        }
        
        // -------
        // 4) lynx
        
        if (_S_ToBrowserUAbs_._s_gotCommand_(_S_ToBrowserLynx_._f_s_strNameXterm_))
        {
            MySystem.s_printOutTrace(strMethod, "got:" + _S_ToBrowserLynx_._f_s_strNameXterm_);

            if (_S_ToBrowserUAbs_._s_gotCommand_(_S_ToBrowserLynx_._f_s_strNameLynx_))
            {
                MySystem.s_printOutTrace(strMethod, "got:" + _S_ToBrowserLynx_._f_s_strNameLynx_);

                if (! _S_ToBrowserLynx_._s_displayURL_(strUrl))
                {
                    MySystem.s_printOutError(strMethod, "failed");
                    return false;
                }
                
                return true;
            }
        }
        
            
        String strBody = _S_ToBrowserUAbs_._s_strWarningBody_;
        strBody += "\n";
        //strBody += ". " + _S_ToBrowserNSMozilla_._f_s_strName_ + "\n";
        strBody += ". " + _S_ToBrowserNSNetscape_._f_s_strName_ + "\n";
        strBody += ". " + _S_ToBrowserKonqueror_._f_s_strName_ + "\n";
        strBody += ". " + _S_ToBrowserLynx_._f_s_strNameLynx_ + "\n";
        
        OPAbstract.s_showDialogWarning(cmpFrameOwner, strTitleAppli, strBody);

        // ending
        return true;
    }
    
    // -------
    // PRIVATE
    
	// Preventing to instantiate.
	private _S_ToBrowserUSun_() { }
}