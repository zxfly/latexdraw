package test.svg;

import java.text.ParseException;

import junit.framework.TestCase;

import net.sf.latexdraw.parsers.svg.parsers.SVGPathParser;
import net.sf.latexdraw.parsers.svg.path.SVGPathHandler;
import net.sf.latexdraw.parsers.svg.path.SVGPathSeg;
import net.sf.latexdraw.parsers.svg.path.SVGPathSegLinetoVertical;
import net.sf.latexdraw.parsers.svg.path.SVGPathSegMoveto;
import net.sf.latexdraw.parsers.svg.path.SVGPathSeg.PathSeg;

import org.junit.Test;

public class TestSVGPathSegLinetoVertical extends TestCase implements SVGPathHandler {
	protected final SVGPathSegLinetoVertical seg = new SVGPathSegLinetoVertical(-1, false);
	protected int cpt = 0;

	@Test
	public void testGetters() {
		assertEquals(seg.getY(), -1.);
		assertFalse(seg.isRelative());
		assertEquals(seg.getType(), PathSeg.LINETO_VERTICAL_ABS);
	}


	@Test
	public void testToString() throws ParseException {
		SVGPathSegMoveto m = new SVGPathSegMoveto(0, 0, false);
		SVGPathParser parser = new SVGPathParser(m.toString() + " " + seg.toString(), this);

		parser.parse();
	}


	@Override
	public void onPathSeg(SVGPathSeg pathSeg) {
		if((pathSeg instanceof SVGPathSegMoveto) && cpt==0) {
			cpt++;
			return ;
		}

		assertTrue(pathSeg instanceof SVGPathSegLinetoVertical);

		SVGPathSegLinetoVertical seg2 = (SVGPathSegLinetoVertical)pathSeg;

		assertEquals(seg.getY(), seg2.getY());
		assertEquals(seg.isRelative(), seg2.isRelative());
	}
}
