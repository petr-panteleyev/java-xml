# Java XML

[![License](https://www.panteleyev.org/badges/license-bsd-2.svg)](LICENSE)
[![JDK](https://www.panteleyev.org/badges/java-25.svg)](https://jdk.java.net/archive/)

XML wrappers, helpers, and fluent APIs built on top of the Java XML Stream API (StAX / JSR-173).

## Overview

`java-xml` provides convenient, fluent wrappers around the standard StAX APIs (`XMLStreamReader`, `XMLEventReader`, `XMLStreamWriter`) to simplify XML reading and writing. It eliminates boilerplate while remaining a thin layer over the JDK — there are **no third-party runtime dependencies**.

## Features

- **`XMLStreamWriterWrapper`** — Fluent API for writing XML elements, attributes, and text with automatic type-to-string conversion.
- **`XMLEventReaderWrapper`** — Streamlined reading of XML events with typed element-value extraction.
- **`XMLEventWrapper`** — Pattern-matching helpers for `XMLEvent` instances.
- **`StartElementWrapper`** — Convenient attribute access with typed getters and default values.

## Artifact

```xml
<dependency>
    <groupId>org.panteleyev</groupId>
    <artifactId>org-panteleyev-xml</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Usage

### Writing XML

```java
import org.panteleyev.xml.XMLStreamWriterWrapper;
import javax.xml.namespace.QName;
import java.time.LocalDate;
import java.util.Map;

try (var out = new ByteArrayOutputStream();
     var writer = XMLStreamWriterWrapper.newInstance(out)) {

    writer.document(new QName("root"), () -> {
        writer.textElement(new QName("name"), "John Doe");
        writer.element(new QName("user"), () -> {
            writer.attribute(new QName("id"), 42);
            writer.attribute(new QName("created"), LocalDate.of(2024, 12, 13));
            writer.textElement(new QName("email"), "john@example.com");
        });
    });
}
```

### Reading XML

```java
import org.panteleyev.xml.XMLEventReaderWrapper;
import javax.xml.namespace.QName;

try (var reader = XMLEventReaderWrapper.newInstance(inputStream)) {
    while (reader.hasNext()) {
        var event = reader.nextEvent();
        event.ifStartElement(new QName("user"), wrapper -> {
            int id = wrapper.getAttributeValue(new QName("id"), 0);
            String name = wrapper.getAttributeValue(new QName("name"), String.class).orElse("");
            System.out.println("User: " + name + " (id=" + id + ")");
        });
    }
}
```

## API Documentation

* [API Documentation](https://www.panteleyev.org/javadoc/java-xml/)

## References

* [Java XML Stream API (StAX) — JSR-173](https://docs.oracle.com/en/java/javase/25/docs/api/java.xml/javax/xml/stream/package-summary.html)
