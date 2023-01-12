# Data Validation

The public **API of a sub-system** can be considered to be a **trust boundary**. 
Data that crosses a trust boundary should be validated unless the code that produces this data provides guarantees of validity.
Sub-systems must ensure that data received across a trust boundary is appropriate and not malicious.

* [**Data Representation**](https://github.com/teiniker/teiniker-lectures-securecoding/tree/master/secure-coding/DataValidation/Representation)\
  Data which are stored and processed must use the right data types in a secure way.

* [**Input Validation**](https://github.com/teiniker/teiniker-lectures-securecoding/tree/master/secure-coding/DataValidation/InputValidation)\
  Data must be checked for validity at the trust boundary.

* [**Output Encoding**](https://github.com/teiniker/teiniker-lectures-securecoding/tree/master/secure-coding/DataValidation/OutputEncoding)\
  Data that leave the subsystem must be encoded appropriate so that they cannot cause any damage in another sub-system.

*Egon Teiniker, 2016-2023, GPL v3.0*
