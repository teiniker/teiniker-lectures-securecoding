# Regular Expressions 

Regular expressions (regex) are a powerful tool used in programming for **pattern matching 
within strings**. They provide a concise and flexible means to **search**, **replace**,
**extract**, and **manipulate** strings based on specific patterns. 

Regular expressions are extremely versatile and are implemented in various programming 
languages and tools. 
They are invaluable for tasks like **data validation**, **parsing**, and **text processing**. 

Here's a breakdown of their key concepts:

* **Basic Syntax**:
    * **Literals**: Plain text characters like `a`, `1`, or `?` are matched directly.
    * **Wildcards**: The dot `.` matches any single character (except newline).
    * **Character Classes**: Square brackets `[ ]` match any one of the characters inside 
        them. For example, `[abc]` matches either a, b, or c.

* **Special Characters**:
    * **Backslashes** `\` are used to escape special characters, turning them into 
        literals, or to signify special sequences.
    * **Anchors**: Symbols like `^` and `$` are used to match the start and end of a 
        string, respectively.

* **Quantifiers**:
    * `*` (zero or more), `+` (one or more), `?` (zero or one), `{n}, {n,}, {n,m}` specify 
        how many times a preceding element should be matched.

* **Groups and Ranges**:
    * **Parentheses** `( )` are used to group parts of the pattern together, allowing us 
        to apply quantifiers to entire groups and to capture the matched content for later use.
    * **Ranges**: Inside character classes, the hyphen `-` is used to specify a range of 
        characters (e.g., `[a-z]` for any lowercase letter).
    * **Alternation**: The pipe `|` acts as a logical OR. It matches the pattern either to 
        the left or the right of it.

* **Escaped Characters**:
    * Sequences like `\d` (digit), `\w` (word character), `\s` (whitespace), and their 
        uppercase counterparts `\D`, `\W`, `\S` (the negation of the lowercase versions) 
        are shorthand for common character classes.



_Example:_ Validate a username: 
```
    ^[a-zA-Z_-]+$
```    
This regular expression is designed to match strings that contain only certain
characters, specifically letters (both uppercase and lowercase), underscores, 
and hyphens: 
* `^`: This is an anchor that matches the beginning of the string. It ensures that 
	the pattern must start at the very start of the string.

* `[a-zA-Z_-]`: This is a character class with several ranges and characters:
	* `a-z`: This matches any lowercase letter from `a` to `z`.
	* `A-Z`: This matches any uppercase letter from `A` to `Z`.
	* `_`: This matches the underscore character.
	* `-`: This matches the hyphen character.
	The character class `[a-zA-Z_-]` will match any single character that is a 
		lowercase letter, an uppercase letter, an underscore, or a hyphen.

* `+`: This is a quantifier that matches one or more of the preceding element, 
	which in this case is the character class `[a-zA-Z_-]`. 
	This means the regex will match strings that consist of one or more of 
	the characters in the set: letters (either case), underscores, and hyphens.

* `$`: This is another anchor that matches the end of the string. 
	It ensures that the pattern must end at the very end of the string.

Examples of strings that would match this regex include `hello`, `Data-Science`, 
and `user_name`. However, it would not match `user123` (because of the digits) 
or `hello world` (because of the space).



_Example:_ Validate a hexadecimal number: 
```
    ^0[xX][a-fA-F0-9]+$ 
```
This regular expression is designed to match strings that represent hexadecimal numbers 
in a specific format:
* `^`: This is an anchor that matches the **beginning of the string**. It ensures that 
    the pattern must start at the very start of the string.
* `0`: This matches the literal character `0`. This part of the pattern specifies 
	that the string must start with `0`.
* `[xX]`: This is a character class that matches a single character that is either 
	`x` or `X`. This part is used to denote the start of a hexadecimal number, 
	typically written as `0x` or `0X`.
* [a-fA-F0-9]: This is another character class. It matches any single hexadecimal 
	digit. The range `a-f` matches any lowercase letter from `a` to `f`, `A-F` matches any 
	uppercase letter from `A` to `F`, and `0-9` matches any digit from `0` to `9`. 
	Hexadecimal numbers consist of these characters because they represent values 
	from `0` to `15` in a single digit (`0-9` for decimal values `0-9`, and `a-f` for decimal 
	values `10-15`).
* `+`: This is a quantifier that matches one or more of the preceding element. 
	In this case, it applies to the character class `[a-fA-F0-9]`, meaning that the 
	regex will match strings that have one or more hexadecimal digits following 
	the `0x` or `0X`.
* `$`: This is another anchor that matches the end of the string. It ensures that 
	the pattern must finish at the very end of the string.

Put together, this regular expression will match strings that start with `0x` or `0X`, 
followed by one or more hexadecimal digits, and nothing else. 

For example, it will match `0x1F4`, `0Xa9`, and `0xABC123`, but it will not match `00x1F4`, 
`0xG4` (since `G` is not a valid hexadecimal digit), or `0x1F4G`.

This regex is typically used to validate strings to ensure they are properly 
formatted hexadecimal numbers.


_Example:_ Validate an email address
```
^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$
```
This regular expression is commonly used for validating email addresses. 

Let's break it down:

* `^`: This symbol anchors the start of the string, ensuring that the pattern 
    matches from the beginning of the string.

* `[a-z0-9._%+-]+`: This part matches one or more `+` of the characters 
    inside the brackets.
	* `a-z` matches any lowercase letter.
	* `0-9` matches any digit.
	* `._%+-` matches a dot, underscore, percent, plus, or hyphen character.
	This part of the expression is designed to match the user name part of an email address.

* `@`: This matches the `@` symbol, which is a standard part of every email address.

* `[a-z0-9.-]+`: This matches one or more characters that are either lowercase 
    letters, digits, a dot, or a hyphen.
    This part is designed to match the domain name of the email address.
* `\.`: This matches a literal dot. In regular expressions, a dot is a special character 
    that matches almost any character; the backslash `\` is used to escape the special 
    character, turning it into a normal dot.

* `[a-z]{2,4}`: This matches between `2` and `4` lowercase letters.
	It's designed to match top-level domain names (like `.com`, `.org`, `.info`, etc.).

* `$`: This anchors the end of the string, ensuring that the pattern matches up to 
    the end of the string.

For example, it would match `user.name@example.com` and `contact123@service.co.uk`, 
but it would not match `user@domain` (because there's no top-level domain) or 
`user@domain.a12` (because the top-level domain can't contain digits).

It's important to note that while this regex is a good basic pattern for validating 
the structure of an email address, it's not foolproof. There are many valid email 
formats and newer top-level domains that are longer than four characters, which this 
regex would not match. Additionally, it does not match uppercase letters, which are 
technically valid in email addresses (although their handling depends on the email 
provider).

## References

* Jeffrey E. F. Friedl. **Mastering Regular Expressions**. O’REILLY, 3rd Edition, 2006



*Egon Teiniker, 2023, GPL v3.0* 