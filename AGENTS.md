# AGENTS.md

## Project: java-xml

Java XML — a lightweight library providing convenience wrappers for the Java XML Stream API (JSR-173 / StAX).

## Repository Structure

```
src/main/java/org/panteleyev/xml/
├── Converter.java                     # Type conversion utilities (String ↔ Java types)
├── SerializationOption.java           # Serialization options enum
├── StartElementWrapper.java           # Wrapper for javax.xml.stream.events.StartElement
├── XMLEventReaderWrapper.java         # Wrapper for javax.xml.stream.XMLEventReader
├── XMLEventWrapper.java               # Wrapper for javax.xml.stream.events.XMLEvent
├── XMLStreamWriterWrapper.java        # Wrapper for javax.xml.stream.XMLStreamWriter
├── XMLException.java                  # Base exception for XML operations
├── XMLReaderException.java            # Exception for reader errors
└── XMLWriterException.java            # Exception for writer errors

src/test/java/org/panteleyev/xml/
├── ConverterTest.java                 # Tests for type conversion
└── XMLStreamWriterWrapperTest.java    # Tests for XML writer wrapper
```

## Dependencies

| Category | Dependency                    | Version |
|----------|-------------------------------|---------|
| Build    | Maven                         | —       |
| Compiler | Java                          | 25      |
| Test     | JUnit Jupiter (junit-jupiter) | 6.1.3   |
| Coverage | JaCoCo                        | 0.8.13  |

No runtime dependencies outside the JDK — this library relies solely on `javax.xml.stream` (StAX) from the JDK.

## Build Commands

```bash
# Compile
mvn compile

# Run tests
mvn test

# Full package (with coverage report)
mvn package

# Generate Javadoc
mvn javadoc:javadoc

# Clean build
mvn clean package
```

## Publishing

Three Maven profiles are available:

| Profile   | Purpose                                       |
|-----------|-----------------------------------------------|
| `release` | GPG-sign artifacts for release                |
| `central` | Publish to Maven Central via Sonatype         |
| `private` | Deploy to private server (`MAVEN_DEPLOY_URL`) |

## Coding Conventions

- **License header**: Every source file must include `Copyright © <year> Petr Panteleyev` and `SPDX-License-Identifier: BSD-2-Clause`.
- **Documentation**: Use `///` style (from JEP 468).
- **Package-private visibility**: `Converter` is package-private; only wrapper classes are public.
- **Exception wrapping**: All checked `XMLStreamException` instances are wrapped in runtime exceptions (`XMLReaderException`, `XMLWriterException`).
- **Fluent API**: Writer methods return `this` for method chaining.
- **Optional returns**: Reader methods return `Optional<T>` rather than throwing on missing data.
- **No third-party runtime deps**: The library should remain dependency-free at runtime.
