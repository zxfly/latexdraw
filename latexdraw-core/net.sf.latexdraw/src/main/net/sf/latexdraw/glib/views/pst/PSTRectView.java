/*
 * This file is part of LaTeXDraw.
 * Copyright (c) 2005-2015 Arnaud BLOUIN
 * LaTeXDraw is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later version.
 * LaTeXDraw is distributed without any warranty; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */
package net.sf.latexdraw.glib.views.pst;

import net.sf.latexdraw.glib.models.GLibUtilities;
import net.sf.latexdraw.glib.models.interfaces.shape.IPoint;
import net.sf.latexdraw.glib.models.interfaces.shape.IRectangle;
import net.sf.latexdraw.util.LNumber;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Defines a PSTricks view of the LRect model.
 */
class PSTRectView extends PSTClassicalView<IRectangle> {
	/**
	 * Creates and initialises a LRect PSTricks view.
	 * @param model The model to view.
	 * @throws IllegalArgumentException If the given model is not valid.
	 * @since 3.0
	 */
	protected PSTRectView(final @NonNull IRectangle model) {
		super(model);
	}


	@Override
	public String getCode(final IPoint position, final float ppc) {
		if(!GLibUtilities.isValidPoint(position) || ppc < 1) return "";

		final StringBuilder params = getPropertiesCode(ppc);
		final IPoint tl = shape.getTopLeftPoint();
		final IPoint br = shape.getBottomRightPoint();
		final double x1 = tl.getX() - position.getX();
		final double x2 = br.getX() - position.getX();
		final double y1 = position.getY() - tl.getY();
		final double y2 = position.getY() - br.getY();
		final StringBuilder code = new StringBuilder();

		if(shape.isRoundCorner()) params.append(", framearc=").append(LNumber.getCutNumberFloat(shape.getLineArc())); //$NON-NLS-1$

		final StringBuilder rotation = getRotationHeaderCode(ppc, position);

		if(rotation != null) code.append(rotation);

		code.append("\\psframe[");    //$NON-NLS-1$
		code.append(params);
		code.append(']').append('(');
		code.append(LNumber.getCutNumberFloat(x2 / ppc)).append(',');
		code.append(LNumber.getCutNumberFloat(y1 / ppc)).append(')').append('(');
		code.append(LNumber.getCutNumberFloat(x1 / ppc)).append(',');
		code.append(LNumber.getCutNumberFloat(y2 / ppc)).append(')');

		if(rotation != null) code.append('}');

		return code.toString();
	}
}
