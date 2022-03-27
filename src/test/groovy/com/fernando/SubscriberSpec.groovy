package com.fernando

import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

import javax.validation.Validator

@MicronautTest(startApplication = false)
class SubscriberSpec extends Specification {

    @Inject
    Validator validator


    void "no constraint violatinos for valid subscriber"() {
       given:
           Subscriber subscriber = new Subscriber('tcook@apple.com', null)
        expect:
            validator.validate(subscriber).isEmpty()
    }






}
