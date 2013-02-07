package test.glib.views.java2D;

import net.sf.latexdraw.glib.models.interfaces.DrawingTK;
import net.sf.latexdraw.glib.models.interfaces.IDot;
import net.sf.latexdraw.glib.models.interfaces.IDot.DotStyle;
import net.sf.latexdraw.glib.views.Java2D.interfaces.View2DTK;

import org.junit.Before;

public class TestLDotView extends TestLShapeView {
	@Before
	@Override
	public void setUp() {
		super.setUp();
		view = View2DTK.getFactory().createView(DrawingTK.getFactory().createDot(DrawingTK.getFactory().createPoint(), false));
	}


	private IDot getDotShape() {
		return (IDot) view.getShape();
	}

	private void setDot(final double x, final double y, final DotStyle style, final double size) {
		IDot dot = getDotShape();
		dot.setPosition(x, y);
		dot.setDotStyle(style);
		dot.setRadius(size);
		view.update();
	}

	@Override
	public void testContains1() {
		setDot(100, 200, DotStyle.DOT, 10);
		assertTrue(view.contains(100, 200));
		assertFalse(view.contains(0, 0));
	}

	public void testContainsASTERISK() {
		setDot(100, 200, DotStyle.ASTERISK, 10);
		assertTrue(view.contains(100, 200));
		assertFalse(view.contains(0, 0));
	}

	public void testContainsBAR() {
		setDot(100, 200, DotStyle.BAR, 10);
		assertTrue(view.contains(100, 200));
		assertFalse(view.contains(0, 0));
	}

	public void testContainsOPLUS() {
		setDot(100, 200, DotStyle.OPLUS, 10);
		assertTrue(view.contains(100, 200));
		assertFalse(view.contains(0, 0));
	}

	public void testContainsOTIMES() {
		setDot(100, 200, DotStyle.OTIMES, 10);
		assertTrue(view.contains(100, 200));
		assertFalse(view.contains(0, 0));
	}

	public void testContainsPLUS() {
		setDot(100, 200, DotStyle.PLUS, 10);
		assertTrue(view.contains(100, 200));
		assertFalse(view.contains(0, 0));
	}

	public void testContainsX() {
		setDot(100, 200, DotStyle.X, 10);
		assertTrue(view.contains(100, 200));
		assertFalse(view.contains(0, 0));
	}

	public void testContainsFDIAMOND() {
		setDot(100, 200, DotStyle.FDIAMOND, 10);
		assertTrue(view.contains(100, 200));
		assertFalse(view.contains(0, 0));
	}

	public void testContainsFTRIANGLE() {
		setDot(100, 200, DotStyle.FTRIANGLE, 10);
		assertTrue(view.contains(100, 200));
		assertFalse(view.contains(0, 0));
	}

	public void testContainsFPENTAGON() {
		setDot(100, 200, DotStyle.FPENTAGON, 10);
		assertTrue(view.contains(100, 200));
		assertFalse(view.contains(0, 0));
	}

	public void testContainsDIAMOND() {
		setDot(100, 200, DotStyle.DIAMOND, 10);
		assertTrue(view.contains(100, 200));
		assertFalse(view.contains(0, 0));
	}

	public void testContainsO() {
		setDot(100, 200, DotStyle.O, 10);
		assertTrue(view.contains(100, 200));
		assertFalse(view.contains(0, 0));
	}

	public void testContainsTRIANGLE() {
		setDot(100, 200, DotStyle.TRIANGLE, 10);
		assertTrue(view.contains(100, 200));
		assertFalse(view.contains(0, 0));
	}

	public void testContainsPENTAGON() {
		setDot(100, 200, DotStyle.PENTAGON, 10);
		assertTrue(view.contains(100, 200));
		assertFalse(view.contains(0, 0));
	}

	public void testContainsSQUARE() {
		setDot(100, 200, DotStyle.SQUARE, 10);
		assertTrue(view.contains(100, 200));
		assertFalse(view.contains(0, 0));
	}

	@Override
	public void testContains2() {
		setDot(100, 200, DotStyle.FSQUARE, 10);
		assertTrue(view.contains(100, 200));
		assertFalse(view.contains(0, 0));
	}

	@Override
	public void testUpdateDblePathOutside() {
		//TODO
	}

	@Override
	public void testUpdateDblePathInside() {
		//TODO
	}

	@Override
	public void testUpdateDblePathMiddle() {
		//TODO
	}

	@Override
	public void testUpdateGeneralPathInside() {
		//TODO
	}

	@Override
	public void testUpdateGeneralPathMiddle() {
		//TODO
	}

	@Override
	public void testUpdateGeneralPathOutside() {
		//TODO
	}

	@Override
	public void testIntersects() {
		//TODO
	}

}
