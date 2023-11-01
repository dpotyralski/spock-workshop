package pl.dpotyralski.spockintroduction

import pl.dpotyralski.spockintroduction.extensions.local.ExampleFeatureAnnotation
import pl.dpotyralski.spockintroduction.extensions.local.ExampleSpecAnnotation
import spock.lang.Specification

@ExampleSpecAnnotation("Spock")
class _20_LifecycleAnnotationDrivenLocalExtensions extends Specification {

    def "Should see local annotation in action"(String name) {
        expect:
        name == "Spock"
    }

    @ExampleFeatureAnnotation
    def "Should see local annotation in action"(String name) {
        expect:
        name == "Spock enriched"
    }

}
