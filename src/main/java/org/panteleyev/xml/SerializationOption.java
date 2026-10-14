// Copyright © 2026 Petr Panteleyev
// SPDX-License-Identifier: BSD-2-Clause
package org.panteleyev.xml;

import java.time.LocalDate;

/// Serialization options.
public enum SerializationOption {
    /// Exports [LocalDate] as [`epoch day`][LocalDate#toEpochDay()], otherwise as ISO\_DATE.
    LOCAL_DATE_AS_EPOCH_DAY
}
