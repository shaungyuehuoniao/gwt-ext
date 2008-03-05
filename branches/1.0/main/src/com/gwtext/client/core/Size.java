/*
 * GwtExt - Gwt Ext Integration library.
 *
 * Copyright (c) 2007, Sanjiv Jivan
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */

package com.gwtext.client.core;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtext.client.util.JavaScriptObjectHelper;

/**
 * This class represents the size of an element.
 *
 * @see ExtElement#getSize()
 */
public class Size {

    private float height;
    private float width;

    public Size() {
    }

    /**
     * Create a new instance.
     *
     * @param width element width
     * @param height element height
     */
    public Size(int width, int height) {
        this.width = width;
        this.height = height;
    }

    private static Size instance(JavaScriptObject jsObj) {
        return new Size(
                JavaScriptObjectHelper.getAttributeAsInt(jsObj, "width"),
                JavaScriptObjectHelper.getAttributeAsInt(jsObj, "height")
        );
    }

    /**
     * @return the height
     */
    public float getHeight() {
        return height;
    }

    /**
     * @param height the height
     */
    public void setHeight(float height) {
        this.height = height;
    }

    /**
     * @return the width
     */
    public float getWidth() {
        return width;
    }

    /**
     * @param width the width
     */
    public void setWidth(float width) {
        this.width = width;
    }
}