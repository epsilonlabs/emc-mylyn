/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.mylyn;

import java.util.Collection;

public class PrefixedPropertyFactory {
	
	protected Collection<String> prefixes = null;
	
	public PrefixedPropertyFactory(Collection<String> prefixes) {
		this.prefixes = prefixes;
	}
	
	public PrefixedProperty createProperty(String property) {
		
		for (String prefix : prefixes) {
			if (property.startsWith(prefix + "_")) {
				return new PrefixedProperty(property.substring(0, prefix.length()), property.substring(prefix.length() + 1, property.length()));
			}
		}
		
		return null;
	}
	

	
}
