/*******************************************************************************
 * Copyright (c) 2020 Eclipse RDF4J contributors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Distribution License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *******************************************************************************/

package org.eclipse.rdf4j.sail.shacl.ast.planNodes;

import java.math.BigDecimal;

import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Value;

/**
 * @author Håvard Ottestad
 */
public class MinExclusiveFilter extends FilterPlanNode {

	private final BigDecimal min;

	public MinExclusiveFilter(PlanNode parent, BigDecimal min) {
		super(parent);
		this.min = min;
	}

	@Override
	boolean checkTuple(ValidationTuple t) {
		Value literal = t.getValue();

		if (literal.isLiteral()) {
			BigDecimal bigDecimal = ((Literal) literal).decimalValue();
			return min.compareTo(bigDecimal) < 0;

		}

		return false;
	}

	@Override
	public String toString() {
		return "MinLengthFilter{" + "min=" + min + '}';
	}
}
