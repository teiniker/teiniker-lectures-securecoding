# Value Object 

A **Value Object** is a small simple object, like money or a date range, whose equality is not based on identity.

A value object bases its notation of **equality on field values** within the class.
For example, two date objects may be the same if their day, month, and year values are the same.

For value objects to work properly they sould be **immutable** - once created none of their fields can be changed.

In the context of **input validation**, we can use value objects to validate data and encapsulate it securely. If it is possible to create a value object, it contains a valid value that can no longer be changed.

_Example:_ Value Object and Input Validation
```Java
public final class EMail	
{
	public EMail(String address)
	{
		if(address == null)
			throw new IllegalArgumentException("Address is null!");
		
		String s = Normalizer.normalize(address, Form.NFKC);
		Matcher m = ADDRESS_PATTERN.matcher(s);
		if(!m.matches())
			throw new IllegalArgumentException("Invalid address!");
			
		this.address = address;
	}
	
	private final String address;
	private final static Pattern ADDRESS_PATTERN = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");
	public String getAddress()
	{
		return address;
	}

    // ...
```


## References

* Martin Fowler. **Patterns of Enterprise Application Architecture**. Addison-Wesley, 2003
* [Value Object](https://martinfowler.com/eaaCatalog/valueObject.html)

*Egon Teiniker, 2020 - 2022, GPL v3.0* 