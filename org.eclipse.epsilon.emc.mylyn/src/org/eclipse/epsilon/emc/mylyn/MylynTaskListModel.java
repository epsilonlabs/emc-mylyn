package org.eclipse.epsilon.emc.mylyn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.models.java.JavaModel;
import org.eclipse.mylyn.internal.tasks.core.AbstractTask;
import org.eclipse.mylyn.internal.tasks.core.AbstractTaskCategory;
import org.eclipse.mylyn.internal.tasks.core.RepositoryQuery;
import org.eclipse.mylyn.internal.tasks.core.TaskList;
import org.eclipse.mylyn.internal.tasks.ui.TasksUiPlugin;

public class MylynTaskListModel extends JavaModel {
	
	protected HashMap<String, Class> classAliases = new HashMap<String, Class>();
	protected MylynTaskListPropertyGetter propertyGetter = new MylynTaskListPropertyGetter();
	
	public MylynTaskListModel() {
		super(Arrays.asList(), Arrays.asList(
				AbstractTask.class, 
				AbstractTaskCategory.class, 
				RepositoryQuery.class));
		
		ArrayList<Object> contents = new ArrayList<Object>();
		TaskList taskList = TasksUiPlugin.getTaskList();
		contents.addAll(taskList.getAllTasks());
		contents.addAll(taskList.getCategories());
		contents.addAll(taskList.getQueries());
		objects = contents;
		
		classAliases.put("Task", AbstractTask.class);
		classAliases.put("Category", AbstractTaskCategory.class);
		classAliases.put("Query", RepositoryQuery.class);
	}
	
	@Override
	public Class<?> classForName(String name) {
		Class clazz = classAliases.get(name);
		if (clazz != null) return clazz;
		return super.classForName(name);
	}
	
	@Override
	public IPropertyGetter getPropertyGetter() {
		return propertyGetter;
	}
	
}
