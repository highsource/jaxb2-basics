# JAXB3 Basics

JAXB3 Basics is an [open source](https://github.com/highsource/jaxb2-basics/blob/master/LICENSE) project
which provides useful plugins and tools for [JAXB 3.x reference implementation](https://jakarta.ee/specifications/xml-binding/3.0/).

# Documentation

Please refer to the [wiki](https://github.com/highsource/jaxb2-basics/wiki) for documentation.

JAXB3 Basics can only be used with JAXB/XJC 3.0 and higher. JAXB/XJC versions 2.x and earlier are no longer supported.

JAXB3 Basics can only be used with Java 1.8 and above.

## Using JAXB3 Basics

* [Using JAXB3 Basics Plugins](https://github.com/highsource/jaxb2-basics/wiki/Using-JAXB2-Basics-Plugins)

## JAXB3 Basics Plugins
* [SimpleEquals Plugin](https://github.com/highsource/jaxb2-basics/wiki/JAXB2-SimpleEquals-Plugin) - generates runtime-free reflection-free `equals(...)` methods.
* [SimpleHashCode Plugin](https://github.com/highsource/jaxb2-basics/wiki/JAXB2-SimpleHashCode-Plugin) - generates runtime-free reflection-free `hashCode()` methods.
* Equals Plugin - generates reflection-free strategic `equals(...)` method.
* HashCode Plugin - generates reflection-free strategic `hashCode()` method.
* ToString Plugin - generates reflection-free strategic `toString()` methods.
* Copyable Plugin - generates reflection-free strategic `copy(...)` deep copying.
* Mergeable Plugin - generates reflection-free strategic `merge(...)` methods to merge data from two source objects into the given object.
* Inheritance Plugin - makes schema-derived classes extend certain class or implement certain interfaces.
* Wildcard Plugin - allows you to specify the wildcard mode for the wildcard properties.
* AutoInheritance Plugin - makes classes derived from global elements or complex types extend or implement certain classes or interfaces automatically.
* [Setters Plugin](https://github.com/highsource/jaxb2-basics/wiki/JAXB2-Setters-Plugin) - generates setters for collections.
* [Simplify Plugin](https://github.com/highsource/jaxb2-basics/wiki/JAXB2-Simplify-Plugin) - simplifies weird properties like `aOrBOrC`.
* [EnumValue Plugin](https://github.com/highsource/jaxb2-basics/wiki/JAXB2-EnumValue-Plugin) - makes all the generated enums implement the `EnumValue<T>` interface.
* JAXBIndex Plugin - generated `jaxb.index` files listing schema-derived classes.
* Fluent-Api Plugin - generates a fluent api in addition to the default (JavaBean) setter methods
* Value-Constructor Plugin - generates two constructors for each generated class, one of which is a default constructor, the other takes an argument for each field in the class and initialises the field with the  argument value
* [FixJAXB1058 Plugin](https://github.com/highsource/jaxb2-basics/wiki/JAXB2-FixJAXB1058-Plugin) - fixes [JAXB-1058](https://java.net/jira/browse/JAXB-1058).

## Credits ##

* Many thanks to **James Annesley** for his ideas and help with the [SimpleEquals Plugin](https://github.com/highsource/jaxb2-basics/wiki/JAXB2-SimpleEquals-Plugin) and the [SimpleHashCode Plugin](https://github.com/highsource/jaxb2-basics/wiki/JAXB2-SimpleHashCode-Plugin).
