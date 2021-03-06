/*
 * GWT-Ext Widget Library
 * Copyright 2007 - 2008, GWT-Ext LLC., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
 

package com.gwtext.client.widgets.form;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.core.Connection;
import com.gwtext.client.core.JsObject;
import com.gwtext.client.core.UrlParam;
import com.gwtext.client.data.Record;
import com.gwtext.client.util.JavaScriptObjectHelper;
import com.gwtext.client.widgets.form.event.FormListener;

/**
 * Form widget.
 *
 * @author Sanjiv Jivan
 */
public class Form extends JsObject {

    public Form(JavaScriptObject jsObj) {
        super(jsObj);
    }

    protected native JavaScriptObject create(JavaScriptObject config)/*-{
        return new $wnd.Ext.form.BasicForm(config);
    }-*/;

    public static Form instance(JavaScriptObject formJS) {
        return new Form(formJS);
    }

    /**
     * Add a Field to the current open container (e.g. column, fieldset, etc.).
     * 
     * @param field the field to add
     */
    public native void add(Field field) /*-{
       var form = this.@com.gwtext.client.core.JsObject::getJsObj()();
       var fieldJS = field.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
       form.add(fieldJS);
   }-*/;

    /**
     * Copies all properties of the passed config to all fields in this form with the passed object if they don't already exist.
     * 
     * @param fieldConfig the config object
     */
    //TODO
    /*public native void applyIfToFields(FieldConfig fieldConfig) *//*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var configJS = fieldConfig.@com.gwtext.client.core.JsObject::getJsObj()();
        field.applyIfToFields(configJS);
    }-*//*;
*/
    /**
     * Copies all properties of the passed config to all fields in this form with the passed object.
     *
     * @param fieldConfig the config object
     */
    //TODO
/*    public native void applyToFields(FieldConfig fieldConfig) *//*-{
        var field = this.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
        var configJS = fieldConfig.@com.gwtext.client.core.JsObject::getJsObj()();
        field.applyToFields(configJS);
    }-*//*;*/

    /**
     * Clears all invalid messages in this form.
     */
    public native void clearInvalid() /*-{
        var form = this.@com.gwtext.client.core.JsObject::getJsObj()();
        form.clearInvalid();
    }-*/;

    /**
     * Find a {@link Field} in this form by id, dataIndex, name or hiddenName.
     * 
     * @param id the field ID,dataIndex, name or hiddenName to search for
     * @return the field
     */
     public native Field findField(String id)/*-{
        var form = this.@com.gwtext.client.core.JsObject::getJsObj()();
        var fieldJS =  form.findField(id);
        return fieldJS != null ? @com.gwtext.client.widgets.ComponentFactory::getComponent(Lcom/google/gwt/core/client/JavaScriptObject;)(fieldJS) : null;
    }-*/;

    //todo add getValues() that returns Map
    /**
     * Returns the fields in this form as a String
     * 
     * @return form vield values as String
     */
    public native String getValues() /*-{
        var form = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return form.getValues(true);
    }-*/;

    /**
     * Returns true if any fields in this form have changed since their original load.
     *
     * @return true if dirty
     */
    public native boolean isDirty() /*-{
        var form = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return form.isDirty();
    }-*/;

    /**
     * Returns true if client-side validation on the form is successful.
     *
     * @return true if valid
     */
    public native boolean isValid() /*-{
        var form = this.@com.gwtext.client.core.JsObject::getJsObj()();
        return form.isValid();
    }-*/;

    //http://extjs.com/forum/showthread.php?t=4340
    public void load(String url) {
        JavaScriptObject configJS = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(configJS, "url", url);
        load(configJS);
    }

    public void load(String url, UrlParam[] params, Connection.Method method, String waitMsg) {
        JavaScriptObject configJS = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(configJS, "url", url);
        if(params != null && params.length > 0) {
            JavaScriptObject paramObj = UrlParam.getJsObj(params);
            JavaScriptObjectHelper.setAttribute(configJS, "params", paramObj);
        }

        if(method != null) {
            JavaScriptObjectHelper.setAttribute(configJS, "method", method.getMethod());
        }
        if(waitMsg != null) {
            JavaScriptObjectHelper.setAttribute(jsObj, "waitMsg", waitMsg);
        }
        load(configJS);
    }
    
    private native void load(JavaScriptObject configJS) /*-{
		var form = this.@com.gwtext.client.core.JsObject::getJsObj()();
		form.load(configJS);
	}-*/;

    /**
     * Loads a {@link Record} into this form. The name of the Fields in the {@link com.gwtext.client.data.RecordDef}
     * must match the names of the Fields in the From.
     *
     * @param record the Record to load
     */
    public native void loadRecord(Record record) /*-{
		var form = this.@com.gwtext.client.core.JsObject::getJsObj()();
		var recordJS  = record.@com.gwtext.client.core.JsObject::getJsObj()();
		form.loadRecord(recordJS);
	}-*/;

    //markInvalid( )  - no need since can findField by ID and call markInvalid on field itself

    /**
     * Removes a field from the items collection (does NOT remove its markup).
     *
     * @param field the field to remove
     */
    public native void remove(Field field) /*-{
	    var form = this.@com.gwtext.client.core.JsObject::getJsObj()();
		var fieldJS  = field.@com.gwtext.client.widgets.BaseExtWidget::jsObj;
		form.remove(fieldJS);
	}-*/;

    /**
     * Resets this form.
     */
    public native void reset() /*-{
        var form = this.@com.gwtext.client.core.JsObject::getJsObj()();
        form.reset();
    }-*/;

    //setValues  -- no need for now

    /**
     * Shortcut to do a submit action.
     * <br/>
     * <b>Note</b> When calling this method to submit the form and have registered a {@link com.gwtext.client.widgets.form.event.FormListener}
     * to process the return value, the rerun value <b>must</b> conform the to format specified by the {@link com.gwtext.client.widgets.form.FormPanel#setErrorReader(com.gwtext.client.data.Reader)}.
     * The {@link com.gwtext.client.widgets.form.event.FormListener}'s onActionComplete and onActionFailed callbacks are invoked based on what the errorReader
     * translated the return value. The default errorReader is a JSONReader which expects the return value to be in the format
     * <pre>
     * <code>
     * {"success":false,"errors":[{"id":"email","msg":"Already exists"}, {"id":"username","msg":"Already taken"}]}
     * </code></pre>. If your return data format is different, you have two options :
     * <ul>
     * <li>Explicitly specify your own errorReader</li>
     * <li>Do not call this method to submit the form. Instead, call {@link #getValues()} to fetch the form values, and then use GWT's {@link com.google.gwt.http.client.RequestBuilder}
     * or GWT-RPC to submit the form values and you can process the return data yourself in the callback.</li>
     * <ul>
     */
    public native void submit() /*-{
        var form = this.@com.gwtext.client.core.JsObject::getJsObj()();
        form.submit();
    }-*/;

    /**
     * Submit the form.
     * <br/>
     * <b>Note</b> When calling this method to submit the form and have registered a {@link com.gwtext.client.widgets.form.event.FormListener}
     * to process the return value, the rerun value <b>must</b> conform the to format specified by the {@link com.gwtext.client.widgets.form.FormPanel#setErrorReader(com.gwtext.client.data.Reader)}.
     * The {@link com.gwtext.client.widgets.form.event.FormListener}'s onActionComplete and onActionFailed callbacks are invoked based on what the errorReader
     * translated the return value. The default errorReader is a JSONReader which expects the return value to be in the format
     * <pre>
     * <code>
     * {"success":false,"errors":[{"id":"email","msg":"Already exists"}, {"id":"username","msg":"Already taken"}]}
     * </code></pre>. If your return data format is different, you have two options :
     * <ul>
     * <li>Explicitly specify your own errorReader</li>
     * <li>Do not call this method to submit the form. Instead, call {@link #getValues()} to fetch the form values, and then use GWT's {@link com.google.gwt.http.client.RequestBuilder}
     * or GWT-RPC to submit the form values and you can process the return data yourself in the callback.</li>
     * <ul>
     *
     * @param url the url to sumbit to
     */
    public void submit(String url) {
        JavaScriptObject configJS = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(configJS, "url", url);
        submit(configJS);
    }

    /**
     * Subit the form.
     * <br/>
     * <b>Note</b> When calling this method to submit the form and have registered a {@link com.gwtext.client.widgets.form.event.FormListener}
     * to process the return value, the rerun value <b>must</b> conform the to format specified by the {@link com.gwtext.client.widgets.form.FormPanel#setErrorReader(com.gwtext.client.data.Reader)}.
     * The {@link com.gwtext.client.widgets.form.event.FormListener}'s onActionComplete and onActionFailed callbacks are invoked based on what the errorReader
     * translated the return value. The default errorReader is a JSONReader which expects the return value to be in the format
     * <pre>
     * <code>
     * {"success":false,"errors":[{"id":"email","msg":"Already exists"}, {"id":"username","msg":"Already taken"}]}
     * </code></pre>. If your return data format is different, you have two options :
     * <ul>
     * <li>Explicitly specify your own errorReader</li>
     * <li>Do not call this method to submit the form. Instead, call {@link #getValues()} to fetch the form values, and then use GWT's {@link com.google.gwt.http.client.RequestBuilder}
     * or GWT-RPC to submit the form values and you can process the return data yourself in the callback.</li>
     * <ul>
     *
     *
     * @param url the url to submit to
     * @param params additional params to submit
     * @param method the submit method
     * @param waitMsg the wait message
     * @param clientValidation pass true to call form.isValid() prior to posting to validate the form on the client (defaults to false)
     *
     * @see com.gwtext.client.core.Connection#GET
     * @see com.gwtext.client.core.Connection#POST
     */
    public void submit(String url, UrlParam[] params, Connection.Method method, String waitMsg, boolean clientValidation) {
        JavaScriptObject configJS = JavaScriptObjectHelper.createObject();
        JavaScriptObjectHelper.setAttribute(configJS, "url", url);
        if(params != null && params.length > 0) {
            JavaScriptObject paramObj = UrlParam.getJsObj(params);
            JavaScriptObjectHelper.setAttribute(configJS, "params", paramObj);
        }

        if(method != null) {
            JavaScriptObjectHelper.setAttribute(configJS, "method", method.getMethod());
        }
        if(waitMsg != null) {
            JavaScriptObjectHelper.setAttribute(configJS, "waitMsg", waitMsg);
        }
        JavaScriptObjectHelper.setAttribute(configJS, "clientValidation", clientValidation);
        submit(configJS);
    }

    /**
     * Submit the form using the specified configuration.
     *
     * @param configJS form submit config
     */
    private native void submit(JavaScriptObject configJS) /*-{
        var form = this.@com.gwtext.client.core.JsObject::getJsObj()();
		form.submit(configJS);
	}-*/;

    /**
     * Persists the values in this Form into the passed Record object.
     * 
     * @param record the record to edit
     */
    public native void updateRecord(Record record) /*-{
		var form = this.@com.gwtext.client.core.JsObject::getJsObj()();
		var recordJS  = record.@com.gwtext.client.core.JsObject::getJsObj()();
		form.updateRecord(recordJS);
	}-*/;

    /**
     * Add a Form listener.
     *
     * @param listener the form listener
     */
    public native void addListener(FormListener listener) /*-{
        var formJ = this;
        var form = this.@com.gwtext.client.core.JsObject::getJsObj()();

        form.addListener('actioncomplete',
                function(frm, action) {
                    var responseText = '';
                    var status = 200;
                    if(action.response && action.response != null) {
                        responseText = action.response.responseText;
                        status = action.response.status === null || 
                                 action.response.status === undefined ? 
                                 status : action.response.status;

                    }
                    listener.@com.gwtext.client.widgets.form.event.FormListener::onActionComplete(Lcom/gwtext/client/widgets/form/Form;ILjava/lang/String;)(formJ, status, responseText);
                }
        );

        form.addListener('actionfailed',
                function(frm, action) {
                    var responseText = '';
                    var status = 200;
                    if(action.response && action.response != null) {
                        responseText = action.response.responseText ?
                             action.response.responseText:action.response.statusText ;
                        status = action.response.status;
                    }
                    listener.@com.gwtext.client.widgets.form.event.FormListener::onActionFailed(Lcom/gwtext/client/widgets/form/Form;ILjava/lang/String;)(formJ, status, responseText);
                }
        );

        form.addListener('beforeaction',
                function(frm) {
                    return listener.@com.gwtext.client.widgets.form.event.FormListener::doBeforeAction(Lcom/gwtext/client/widgets/form/Form;)(formJ);
                }
        );
    }-*/;
}
