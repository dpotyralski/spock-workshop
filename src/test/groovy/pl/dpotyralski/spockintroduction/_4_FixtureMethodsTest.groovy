package pl.dpotyralski.spockintroduction


import spock.lang.Specification

class _4_FixtureMethodsTest extends Specification {

    void setupSpec() {
        println "Hello from setupSpec!"
    }

    void setup() {
        println "Hello from setup!"
    }

    void cleanup() {
        println "Hello from cleanup!"
    }

    void cleanupSpec() {
        println "Hello from cleanupSpec!"
    }

    def "should run this dummy test"() {
        expect:
        1 == 1
    }

    def "should run another dummy test"() {
        expect:
        1 == 1
    }

}