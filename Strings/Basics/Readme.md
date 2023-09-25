<h2> Basics </h2>

* String is Immutable (Stored in String Pool), String Builder/ String Buffer is Mutable (Stored in Heap).

    * String Builder is Single Threaded.
    * String Buffer is Concurrent / Multi Threaded (Thread safe)

```
String a = "Sample"

String is a class , a is reference Variable "Sample" is String Literal.
```
* Strings are Immutable, that means we can not change string literals or objects, in the below example new Literal/ Object is created and a Points to new one.

    * We can not modify characters inside the strings (Immutable) unlike Arrays. 
    * There are replace functions in String, which internally creates new object but does not modify existing one.

```
String a = "Sample"
a = "Updated"
```

Strings are Stored in String Pool (Memory other than Stack and Heap) to Increase Performance and Security.

```
String a = "Sample"
String b = "Sample"

a==b  --> return true  as They point to Same Literal/Obejct.
```

If We want to create new Objects for the Same Value, Need to Initiate String Class.

```
String s1 = "Sample"
String s2 = "Sample"

s1==s2 --> returns false , since Reference Variables points to Different Objects.

s1.equals(s2) --> returns true , since it compares values
```
<h2> Concatenation Operators </h2>

* Operator Overloading is not supporte in Java (because it results in Poor Code) . 
    * We can Add any data types with String.
    * Exception: only Supported with (+) and Strings.
```
'a' + 'b' --> gives 195 (Since Characters are Added with ASCII Values)
"a" + "b" --> gives ab
"a" + 1 -> a1 (Integer is converted to String using Wrapper class Integer)
```
