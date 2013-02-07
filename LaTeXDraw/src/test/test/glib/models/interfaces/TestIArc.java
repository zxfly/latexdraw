package test.glib.models.interfaces;

import net.sf.latexdraw.glib.models.interfaces.IArc.ArcStyle;
import net.sf.latexdraw.glib.models.interfaces.IArc;

import org.junit.Test;

public abstract class TestIArc<T extends IArc> extends TestIEllipse<T> {
	@Test
	public void testGetStartPoint() {
		shape.setRx(1);
		shape.setPosition(-1, -1);

		shape.setAngleStart(0);
		assertEquals(1, shape.getStartPoint().getX());
		assertEquals(0, shape.getStartPoint().getY());

		shape.setAngleStart(Math.PI/2.);
		assertEquals(0, shape.getStartPoint().getX());
		assertEquals(1, shape.getStartPoint().getY());

		shape.setAngleStart(Math.PI);
		assertEquals(-1, shape.getStartPoint().getX());
		assertEquals(0, shape.getStartPoint().getY());

		shape.setAngleStart(1.5*Math.PI);
		assertEquals(0, shape.getStartPoint().getX());
		assertEquals(-1, shape.getStartPoint().getY());

		shape.setAngleStart(2.*Math.PI);
		assertEquals(1, shape.getStartPoint().getX());
		assertEquals(0, shape.getStartPoint().getY());

		shape.setAngleStart(-2.*Math.PI);
		assertEquals(1, shape.getStartPoint().getX());
		assertEquals(0, shape.getStartPoint().getY());

		shape.setAngleStart(-Math.PI/2.);
		assertEquals(0, shape.getStartPoint().getX());
		assertEquals(-1, shape.getStartPoint().getY());

		shape.setAngleStart(-Math.PI);
		assertEquals(-1, shape.getStartPoint().getX());
		assertEquals(0, shape.getStartPoint().getY());
	}


	@Test
	public void testGetEndPoint() {
		//TODO
	}


	@Test
	public void testSetGetStyle() {
		shape.setArcStyle(ArcStyle.CHORD);
		assertEquals(ArcStyle.CHORD, shape.getArcStyle());

		shape.setArcStyle(ArcStyle.ARC);
		assertEquals(ArcStyle.ARC, shape.getArcStyle());

		shape.setArcStyle(ArcStyle.WEDGE);
		assertEquals(ArcStyle.WEDGE, shape.getArcStyle());

		shape.setArcStyle(null);
		assertEquals(ArcStyle.WEDGE, shape.getArcStyle());
	}


	@Test
	public void testSetGetAngleStart() {
		shape.setAngleStart(Math.PI);
		assertEquals(Math.PI, shape.getAngleStart());

		shape.setAngleStart(0.);
		assertEquals(0., shape.getAngleStart());

		shape.setAngleStart(2.*Math.PI);
		assertEquals(2.*Math.PI, shape.getAngleStart());

		shape.setAngleStart(4.*Math.PI);
		assertEquals(4.*Math.PI, shape.getAngleStart());

		shape.setAngleStart(-2.*Math.PI);
		assertEquals(-2.*Math.PI, shape.getAngleStart());

		shape.setAngleStart(-4.*Math.PI);
		assertEquals(-4.*Math.PI, shape.getAngleStart());

		shape.setAngleStart(Double.NaN);
		assertEquals(-4.*Math.PI, shape.getAngleStart());

		shape.setAngleStart(Double.NEGATIVE_INFINITY);
		assertEquals(-4.*Math.PI, shape.getAngleStart());

		shape.setAngleStart(Double.POSITIVE_INFINITY);
		assertEquals(-4.*Math.PI, shape.getAngleStart());
	}


	@Test
	public void testSetGetAngleEnd() {
		shape.setAngleEnd(Math.PI);
		assertEquals(Math.PI, shape.getAngleEnd());

		shape.setAngleEnd(0.);
		assertEquals(0., shape.getAngleEnd());

		shape.setAngleEnd(2.*Math.PI);
		assertEquals(2.*Math.PI, shape.getAngleEnd());

		shape.setAngleEnd(4.*Math.PI);
		assertEquals(4.*Math.PI, shape.getAngleEnd());

		shape.setAngleEnd(-2.*Math.PI);
		assertEquals(-2.*Math.PI, shape.getAngleEnd());

		shape.setAngleEnd(-4.*Math.PI);
		assertEquals(-4.*Math.PI, shape.getAngleEnd());

		shape.setAngleEnd(Double.NaN);
		assertEquals(-4.*Math.PI, shape.getAngleEnd());

		shape.setAngleEnd(Double.NEGATIVE_INFINITY);
		assertEquals(-4.*Math.PI, shape.getAngleEnd());

		shape.setAngleEnd(Double.POSITIVE_INFINITY);
		assertEquals(-4.*Math.PI, shape.getAngleEnd());
	}


	@Override
	@Test
	public void testCopy() {
		super.testCopy();

		shape2.setAngleEnd(-4.*Math.PI);
		shape2.setAngleStart(-2.*Math.PI);
		shape2.setArcStyle(ArcStyle.WEDGE);

		shape.copy(shape2);

		assertEquals(-4.*Math.PI, shape.getAngleEnd());
		assertEquals(-2.*Math.PI, shape.getAngleStart());
		assertEquals(ArcStyle.WEDGE, shape.getArcStyle());
	}

	@Override
	@Test
	public void testIsParametersEquals() {
		shape2.setAngleEnd(-4.*Math.PI);
		shape2.setAngleStart(-2.*Math.PI);
		shape2.setArcStyle(ArcStyle.WEDGE);

		shape.setAngleEnd(-4.*Math.PI);
		shape.setAngleStart(-2.*Math.PI);
		shape.setArcStyle(ArcStyle.WEDGE);

		assertTrue(shape.isParametersEquals(shape2, false));

		shape.setAngleEnd(1.);
		assertFalse(shape.isParametersEquals(shape2, false));

		shape.setAngleEnd(-4.*Math.PI);
		shape.setAngleStart(1.);
		assertFalse(shape.isParametersEquals(shape2, false));

		shape.setAngleStart(-2.*Math.PI);
		shape.setArcStyle(ArcStyle.ARC);
		assertFalse(shape.isParametersEquals(shape2, false));
	}
}
