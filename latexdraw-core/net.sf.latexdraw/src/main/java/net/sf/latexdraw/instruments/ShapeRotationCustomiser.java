/*
 * This file is part of LaTeXDraw.
 * Copyright (c) 2005-2018 Arnaud BLOUIN
 * LaTeXDraw is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later version.
 * LaTeXDraw is distributed without any warranty; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */
package net.sf.latexdraw.instruments;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.BiConsumer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.layout.Pane;
import net.sf.latexdraw.commands.shape.RotateShapes;
import net.sf.latexdraw.models.interfaces.shape.IGroup;

/**
 * This instrument modifies the rotation angle of selected shapes.
 * @author Arnaud BLOUIN
 */
public class ShapeRotationCustomiser extends ShapePropertyCustomiser implements Initializable {
	/** The rotation button to perform 90 degree rotation. */
	@FXML private Button rotate90Button;
	/** The rotation button to perform 180 degree rotation. */
	@FXML private Button rotate180Button;
	/** The rotation button to perform 270 degree rotation. */
	@FXML private Button rotate270Button;
	/** The field that modifies the rotation angle. */
	@FXML private Spinner<Double> rotationField;
	@FXML private Pane mainPane;

	/**
	 * Creates the instrument.
	 */
	public ShapeRotationCustomiser() {
		super();
	}

	@Override
	protected void setWidgetsVisible(final boolean visible) {
		mainPane.setVisible(visible);
	}

	@Override
	public void initialize(final URL location, final ResourceBundle resources) {
		mainPane.managedProperty().bind(mainPane.visibleProperty());
	}

	@Override
	protected void update(final IGroup shape) {
		if(!hand.isActivated() || shape.isEmpty()) {
			setActivated(false);
		}else {
			rotationField.getValueFactory().setValue(Math.toDegrees(shape.getRotationAngle()));
			setActivated(true);
		}
	}

	@Override
	protected void configureBindings() {
		final BiConsumer<Double, RotateShapes> init = (angle, c) -> {
			c.setGravityCentre(pencil.canvas.getDrawing().getSelection().getGravityCentre());
			c.setRotationAngle(angle);
			c.setShape(pencil.canvas.getDrawing().getSelection().duplicateDeep(false));
		};

		spinnerBinder(RotateShapes::new).on(rotationField).exec().
			first(c -> init.accept(Math.toRadians(rotationField.getValue()) - pencil.canvas.getDrawing().getSelection().getRotationAngle(), c)).
			then(c -> c.setRotationAngle(Math.toRadians(rotationField.getValue()) - pencil.canvas.getDrawing().getSelection().getRotationAngle())).
			bind();

		buttonBinder(RotateShapes::new).on(rotate90Button).first(c -> init.accept(Math.PI / 2d, c)).bind();
		buttonBinder(RotateShapes::new).on(rotate180Button).first(c -> init.accept(Math.PI, c)).bind();
		buttonBinder(RotateShapes::new).on(rotate270Button).first(c -> init.accept(-Math.PI / 2d, c)).bind();
	}
}
