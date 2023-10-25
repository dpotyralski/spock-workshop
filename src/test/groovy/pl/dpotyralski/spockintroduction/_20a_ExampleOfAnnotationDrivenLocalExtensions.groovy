package pl.dpotyralski.spockintroduction

import pl.dpotyralski.spockintroduction.extensions.local.LifecycleAnnotation
import spock.lang.Specification

@LifecycleAnnotation
class _20a_ExampleOfAnnotationDrivenLocalExtensions extends Specification {

    @LifecycleAnnotation
    String exampleField = "Hello from Lifecycle example"

    @LifecycleAnnotation
    void setupSpec() {
        println "setupSpec"
    }

    @LifecycleAnnotation
    void cleanupSpec() {
        println "cleanupSpec"
    }

    @LifecycleAnnotation
    void setup() {
        println "setup"
    }

    @LifecycleAnnotation
    void cleanup() {
        println "cleanup"
    }

    @LifecycleAnnotation
    def "Example#1 lifecycle annotated feature"() {
        given:
        println "given from example#1"

        when:
        println "when from example#1"

        then:
        println "then from example#1"
    }

    @LifecycleAnnotation
    def "Example#2 lifecycle annotated feature"() {
        given:
        println "given from example#2"

        when:
        println "when from example#2"

        then:
        println "then from example#2"
    }

}
