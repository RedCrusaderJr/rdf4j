/*******************************************************************************
 * .Copyright (c) 2020 Eclipse RDF4J contributors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Distribution License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *******************************************************************************/

package org.eclipse.rdf4j.sail.shacl.ast.planNodes;

import org.eclipse.rdf4j.model.Literal;

/**
 * @author Håvard Ottestad
 */
public class MinCountFilter extends FilterPlanNode {

	private final long minCount;

	public MinCountFilter(PlanNode parent, long minCount) {
		super(parent);
		this.minCount = minCount;
	}

	@Override
	boolean checkTuple(ValidationTuple t) {
		Literal literal = (Literal) t.getValue();
		return literal.longValue() >= minCount;
	}

	@Override
	public String toString() {
		return "MinCountFilter{" + "minCount=" + minCount + '}';
	}
}
