package com.fernando

import io.micronaut.core.annotation.Introspected
import io.micronaut.core.annotation.Nullable

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Introspected
class Subscriber {
    @NotNull
    @NotBlank
    String email
    @Nullable
    String name

    Subscriber(@NotNull String email,@Nullable String name) {
        this.email = email
        this.name = name
    }
}
