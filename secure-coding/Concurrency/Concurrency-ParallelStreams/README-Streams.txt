Java 8 Streams API
-------------------------------------------------------------------------------
Streams are an update to the Java API that lets you manipulate collections of 
data in a declarative way (we express a query rather than code an ad hoc 
implementation for it).

We can think of streams like fancy iterators over a collection of data.

Benefits:

i) Declarative
	The code is written in a declarative way (we specify what we want to achieve)


ii) Composable
	We chain together several building-block operations to express a complicated 
	data processing pipeline (e.g. filter, sort, map, collect) while keeping our
	code readable.
	
ii) Parallelizable
	Because operations such as filter are available as high-level building blocks 
	which don't depend on a specific threading model, their internal implementation
	could be single-threaded or potentially maximize a multi-core architecture 
	transparently.	 

										 
Example: 
	List<String> --->[stream]==>[sorted]==>[filter]==>[limit]==>[collect]---> List<String>

The Stream interface defines many operations which can be classified into two 
categories:

i) Intermediate operations such as filter or sorted return another stream as the 
	return type. This allows the operations to be connected to form a query.
	Intermediate operations don't perform any processing until a terminal operation
	is invoked on the stream pipeline - they are lazy.

ii) Terminal operations produce a result from a stream pipeline. A result is any 
	non-stream value such as a List, an Integer, or even void. 

