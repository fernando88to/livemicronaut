package com.fernando

import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification
import spock.lang.Unroll

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

    @Unroll("Susbcriber email with value #email is not valid")
    void "subscriber::email is required"(String email) {
        given:
            Subscriber subscriber = new Subscriber(email, null)
        expect:
            !validator.validate(subscriber).isEmpty()
        where:
         email << [null, ""]
    }

    @Unroll("Susbcriber email with value #email is not valid")
    void "subscriber::email be an email addres"(String email) {
        given:
            Subscriber subscriber = new Subscriber('tkook', null)
        expect:
            !validator.validate(subscriber).isEmpty()
        where:
            email << [null, ""]
    }






}
