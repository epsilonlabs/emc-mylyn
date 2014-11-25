Epsilon-Mylyn Integration
=========

Eclipse plugins that extend Epsilon's Model Connectivity (EMC) layer with support for managing Mylyn task lists using languages of the [Epsilon platform](http://www.eclipse.org/epsilon) to perform activities such as code generation, model validation and model-to-model transformation.

Example
-----------
The following EOL snippet demonstrates iterating through all tasks, categories and queries of a Mylin task list and printing the values of some of their features.

```
for (t in Task.all) {
	t.summary.println();
	t.creationDate.println();
	t.url.println();
	t.a_product.println();
	t.a_bug_severity.println();
}

for (c in Category.all) {
	c.summary.println();
	c.children.println();
}

for (q in Query.all) {
	q.summary.println();
	q.children.collect(b|b.class.name).println();
}
```
