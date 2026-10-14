// Copyright © 2026 Petr Panteleyev
// SPDX-License-Identifier: BSD-2-Clause
package org.panteleyev.xml;

/// Wrapper for XML writer exceptions.
public class XMLWriterException extends XMLException {
    /// Creates a new XMLWriterException instance with the cause.
    ///
    /// @param cause the cause
    public XMLWriterException(Throwable cause) {
        super(cause);
    }
}
