// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 2012/1/1611:20:03
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) ansi 
// Source File Name:   StreamResultX.java

package com.sunspoter.lib.web.struts2.dispatcher;

import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.dispatcher.StreamResult;

import com.opensymphony.xwork2.ActionInvocation;

public class StreamResultX extends StreamResult {

	public StreamResultX() {
	}

	protected void doExecute(String finalLocation, ActionInvocation invocation)
        throws Exception
    {
        OutputStream oOutput;
        resolveParamsFromStack(invocation.getStack(), invocation);
        oOutput = null;
        byte oBuff[];
        if(inputStream == null)
            inputStream = (InputStream)invocation.getStack().findValue(conditionalParse(inputName, invocation));
        if(inputStream == null)
        {
            String msg = (new StringBuilder("StreamResultX : Can not find a java.io.InputStream with the name [")).append(inputName).append("] in the invocation stack. ").append("Check the <param name=\"inputName\"> tag specified for this action.").toString();
            LOG.error(msg, new String[0]);
            throw new IllegalArgumentException(msg);
        }
        HttpServletResponse oResponse = (HttpServletResponse)invocation.getInvocationContext().get("com.opensymphony.xwork2.dispatcher.HttpServletResponse");
        if(contentCharSet != null && !contentCharSet.equals(""))
            oResponse.setContentType((new StringBuilder(String.valueOf(conditionalParse(contentType, invocation)))).append(";charset=").append(contentCharSet).toString());
        else
            oResponse.setContentType(conditionalParse(contentType, invocation));
        if(contentLength != null)
        {
            String _contentLength = conditionalParse(contentLength, invocation);
            int _contentLengthAsInt = -1;
            try
            {
                _contentLengthAsInt = Integer.parseInt(_contentLength);
                if(_contentLengthAsInt >= 0)
                    oResponse.setContentLength(_contentLengthAsInt);
            }
            catch(NumberFormatException e)
            {
                LOG.warn((new StringBuilder("StreamResultX warn : failed to recongnize ")).append(_contentLength).append(" as a number, contentLength header will not be set").toString(), e, new String[0]);
            }
        }
        if(contentDisposition != null)
            oResponse.addHeader("Content-Disposition", conditionalParse(contentDisposition, invocation));
        if(!allowCaching)
        {
            oResponse.addHeader("Pragma", "no-cache");
            oResponse.addHeader("Cache-Control", "no-cache");
        }
        oOutput = oResponse.getOutputStream();
        if(LOG.isDebugEnabled())
            LOG.debug((new StringBuilder("StreamResultX : Streaming result [")).append(inputName).append("] type=[").append(contentType).append("] length=[").append(contentLength).append("] content-disposition=[").append(contentDisposition).append("] charset=[").append(contentCharSet).append("]").toString(), new String[0]);
        oBuff = new byte[bufferSize];
        try
        {
            LOG.debug("StreamResultX : Streaming to output buffer +++ START +++", new String[0]);
            int iSize;
            while(-1 != (iSize = inputStream.read(oBuff))) 
                oOutput.write(oBuff, 0, iSize);
            LOG.debug("StreamResultX : Streaming to output buffer +++ END +++", new String[0]);
            oOutput.flush();
            //break MISSING_BLOCK_LABEL_598;
        }
        catch(Exception e)
        {
            LOG.warn("StreamResultX Warn : socket write error", new String[0]);
            if(oOutput != null)
                try
                {
                    oOutput.close();
                }
                catch(Exception e1)
                {
                    oOutput = null;
                }
        }
        if(inputStream != null)
            inputStream.close();
        
        if(oOutput != null)
            oOutput.close();
       // break MISSING_BLOCK_LABEL_650;
        Exception exception;
        //exception;
        if(inputStream != null)
            inputStream.close();
        if(oOutput != null)
            oOutput.close();
        //throw exception;
        if(inputStream != null)
            inputStream.close();
        if(oOutput != null)
            oOutput.close();
       /* break MISSING_BLOCK_LABEL_650;
        Exception exception1;*/
        //exception1;
        if(inputStream != null)
            inputStream.close();
        if(oOutput != null)
            oOutput.close();
        //throw exception1;
        if(inputStream != null)
            inputStream.close();
        if(oOutput != null)
            oOutput.close();
        return;
    }

	private static final long serialVersionUID = 0x8d2849730406e908L;
}