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

package com.gwtext.client.widgets.tree;

import com.google.gwt.core.client.JavaScriptObject;

public interface TreeSelectionModel {

    JavaScriptObject getJsObj();

    /**
     * Clear all selections.
     */
    void clearSelections();

    /**
     * Returns true if the node is selected.
     *
     * @param treeNode the node to test
     * @return true if selected
     */
    boolean isSelected(TreeNode treeNode);

    /**
     * Select a node.
     * 
     * @param treeNode the tree node to select
     */
    void select(TreeNode treeNode);

    /**
     * Selects the node above the selected node in the tree, intelligently walking the nodes.
     */
    void selectNext();

    /**
     * Selects the node above the selected node in the tree, intelligently walking the nodes.
     */
    void selectPrevious();

    /**
     * Deselect a node.
     *
     * @param treeNode the node to deselect
     */
    void unselect(TreeNode treeNode);
}
