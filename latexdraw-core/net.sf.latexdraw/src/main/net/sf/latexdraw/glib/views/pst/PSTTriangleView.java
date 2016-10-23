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
import net.sf.latexdraw.glib.models.interfaces.shape.ITriangle;
import net.sf.latexdraw.util.LNumber;
import org.eclipse.jdt.annotation.NonNull;

/**
 * Defines a PSTricks view of the LTriangle model.
 */
class PSTTriangleView extends PSTClassicalView<ITriangle> {
	/**
	 * Creates and initialises a LTriangle PSTricks view.
	 * @param model The model to view.
	 * @throws IllegalArgumentException If the given model is not valid.
	 * @since 3.0
	 */
	protected PSTTriangleView(final @NonNull ITriangle model) {
		super(model);
	}


	@Override
	public String getCode(final IPoint origin, final float ppc) {
		if(!GLibUtilities.isValidPoint(origin) || ppc < 1) return "";

		final IPoint tl = shape.getTopLeftPoint();
		final IPoint br = shape.getBottomRightPoint();
		final double tlx = tl.getX();
		final double brx = br.getX();
		final double bry = br.getY();
		final StringBuilder rot = getRotationHeaderCode(ppc, origin);
		final StringBuilder code = new StringBuilder();

		if(rot != null) code.append(rot);

		code.append("\\pstriangle[");//$NON-NLS-1$
		code.append(getPropertiesCode(ppc)).append(']').append('(');
		code.append(LNumber.getCutNumberFloat(((tlx + brx) / 2. - origin.getX()) / ppc)).append(',');
		code.append(LNumber.getCutNumberFloat((origin.getY() - bry) / ppc)).append(')').append('(');
		code.append(LNumber.getCutNumberFloat((brx - tlx) / ppc)).append(',');
		code.append(LNumber.getCutNumberFloat((bry - tl.getY()) / ppc)).append(')');

		if(rot != null) code.append('}');

		return code.toString();
	}
}

