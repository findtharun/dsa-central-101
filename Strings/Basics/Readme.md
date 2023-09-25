<h2> Basics </h2>

```
String a = "Sample"

String is a class , a is reference Variable "Sample" is String Literal.
```
Strings are Immutable, that means we can not change string literals or objects, in the below example new Literal/ Object is created and a Points to new one.

We can not modify characters inside the strings (Immutable) unlike Arrays.

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