package net.sf.latexdraw.data;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.sf.latexdraw.models.ShapeFactory;
import net.sf.latexdraw.models.interfaces.shape.ICircle;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

public class CircleSupplier extends ParameterSupplier {
	public static ICircle createCircle() {
		return ShapeFactory.INST.createCircle(ShapeFactory.INST.createPoint(51d, 73d), 200d);
	}

	@Override
	public List<PotentialAssignment> getValueSources(final ParameterSignature sig) {
		return Stream.of(ShapeFactory.INST.createCircle()).map(r -> PotentialAssignment.forValue("", r)).collect(Collectors.toList());
	}
}
