/**
 * Mogwai ERDesigner. Copyright (C) 2002 The Mogwai Project.
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package de.erdesignerng.visual.editor.info;

import de.erdesignerng.ERDesignerBundle;
import de.erdesignerng.visual.editor.BaseEditor;
import de.erdesignerng.visual.editor.DialogConstants;
import de.mogwai.common.client.looks.UIInitializer;
import de.mogwai.common.client.looks.components.action.DefaultAction;
import org.apache.log4j.Logger;

import java.awt.*;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Editor for exceptions.
 * 
 * @author $Author: mirkosertic $
 * @version $Date: 2008-06-13 16:48:59 $
 */
public class saveModelEditor extends BaseEditor {

	//private static final Logger LOGGER = Logger.getLogger(ExceptionEditor.class);

	private final saveModelEditorView view = new saveModelEditorView();

	private final DefaultAction closeAction = new DefaultAction(e -> commandClose(), this, ERDesignerBundle.CLOSE);

	public saveModelEditor(Component aParent) {
		super(aParent, ERDesignerBundle.SAVEMODEL);

		//LOGGER.error("Exception", aException);

		initialize();

		//StringWriter theWriter = new StringWriter();
		//PrintWriter thePrintWriter = new PrintWriter(theWriter);
		//aException.printStackTrace(thePrintWriter);
		//thePrintWriter.flush();

		view.getinfoText().setText("This icon can easily be saved model to the Model Repository.\nAfter you select this icon The save model to repository dialog will appear. \nYou have the option to create a new entry in the Model Repository, \nOr the option to overwrite an existing entry, and additionally give it a new name. \nAfter you have chosen the option of your choice, and entered the parameters like entry name, \nYou have to click the OK button. \nThen, the current model will be saved to the Model Repository.");
	}

	private void initialize() {

		view.getCloseButton().setAction(closeAction);

		setContentPane(view);
		setResizable(false);
		pack();

		UIInitializer.getInstance().initialize(this);
	}

	@Override
	public void applyValues() throws Exception {
	}

	private void commandClose() {
		setModalResult(DialogConstants.MODAL_RESULT_OK);
	}
}