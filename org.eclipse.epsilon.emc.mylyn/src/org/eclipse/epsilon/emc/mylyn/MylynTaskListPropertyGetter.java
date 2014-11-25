package org.eclipse.epsilon.emc.mylyn;

import java.util.Arrays;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.java.JavaPropertyGetter;
import org.eclipse.mylyn.internal.tasks.core.AbstractTask;

public class MylynTaskListPropertyGetter extends JavaPropertyGetter {

	protected PrefixedPropertyFactory factory = 
			new PrefixedPropertyFactory(Arrays.asList("a"));
	
	@Override
	public Object invoke(Object object, String property)
			throws EolRuntimeException {
		
		if (object instanceof AbstractTask) {
			PrefixedProperty p = factory.createProperty(property);
			if (p != null) {
				return ((AbstractTask) object).getAttribute(p.getName());
			}
		}
		
		return super.invoke(object, property);
	}
	
}
