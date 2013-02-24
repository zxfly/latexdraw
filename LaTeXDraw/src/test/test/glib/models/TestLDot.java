package test.glib.models;


import net.sf.latexdraw.glib.models.impl.LShapeFactory;
import net.sf.latexdraw.glib.models.interfaces.Dottable;
import net.sf.latexdraw.glib.models.interfaces.DrawingTK;
import net.sf.latexdraw.glib.models.interfaces.ICircle;
import net.sf.latexdraw.glib.models.interfaces.IDot;
import net.sf.latexdraw.glib.models.interfaces.IPositionShape;
import net.sf.latexdraw.glib.models.interfaces.IRectangle;
import net.sf.latexdraw.glib.models.interfaces.IShape;

import org.junit.Before;
import org.junit.Test;

import test.glib.models.interfaces.TestIDot;

public class TestLDot<T extends IDot> extends TestIDot<T> {
	@Override
	@Before
	public void setUp() {
		DrawingTK.setFactory(new LShapeFactory());
		shape  = (T) DrawingTK.getFactory().createDot(DrawingTK.getFactory().createPoint(), false);
		shape2 = (T) DrawingTK.getFactory().createDot(DrawingTK.getFactory().createPoint(), false);
	}


	@Override
	@Test
	public void testIsTypeOf() {
		assertFalse(shape.isTypeOf(null));
		assertFalse(shape.isTypeOf(IRectangle.class));
		assertFalse(shape.isTypeOf(ICircle.class));
		assertTrue(shape.isTypeOf(IShape.class));
		assertTrue(shape.isTypeOf(Dottable.class));
		assertTrue(shape.isTypeOf(IPositionShape.class));
		assertTrue(shape.isTypeOf(IDot.class));
		assertTrue(shape.isTypeOf(shape.getClass()));
	}


	@Test
	public void testConstructor1() {
		IDot dot1 = DrawingTK.getFactory().createDot(DrawingTK.getFactory().createPoint(), false);

		assertTrue(dot1.getRadius()>0);
		assertNotNull(dot1.getDotStyle());
		assertNotNull(dot1.getPosition());
		assertEquals(0., dot1.getPosition().getX());
		assertEquals(0., dot1.getPosition().getY());
	}


	@Test
	public void testConstructor3() {
		IDot dot1 = DrawingTK.getFactory().createDot(null, false);

		assertTrue(dot1.getRadius()>0);
		assertNotNull(dot1.getDotStyle());
		assertNotNull(dot1.getPosition());
		assertEquals(0., dot1.getPosition().getX());
		assertEquals(0., dot1.getPosition().getY());

		dot1 = DrawingTK.getFactory().createDot(DrawingTK.getFactory().createPoint(-1, 2), true);
		assertEquals(-1., dot1.getPosition().getX());
		assertEquals(2., dot1.getPosition().getY());
	}
}