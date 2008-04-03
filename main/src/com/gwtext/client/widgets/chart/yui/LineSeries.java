/*
 * GWT-Ext Widget Library
 * Copyright(c) 2007-2008, GWT-Ext.
 * licensing@gwt-ext.com
 * 
 * http://www.gwt-ext.com/license
 */
package com.gwtext.client.widgets.chart.yui;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * LineSeries class for the YUI Charts widget.
 */
public class LineSeries extends JsObject {

    public LineSeries() {
        jsObj = create();
    }

    protected native JavaScriptObject create() /*-{
        return new $wnd.YAHOO.widget.LineSeries();
    }-*/;

}