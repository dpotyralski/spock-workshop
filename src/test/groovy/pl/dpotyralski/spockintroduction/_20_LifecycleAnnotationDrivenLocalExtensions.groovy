package pl.dpotyralski.spockintroduction

import pl.dpotyralski.spockintroduction.extensions.local.ExampleSpecAnnotation
import spock.lang.Ignore
import spock.lang.Specification

@ExampleSpecAnnotation("Spock")
class _20_LifecycleAnnotationDrivenLocalExtensions extends Specification {

    def "Should see local annotation in action"(String name) {
        expect:
        name == "Spock"
    }

    @Ignore
    // TODO create me please! @ExampleFeatureAnnotation
    def "Should see local annotation in action"(String name) {
        expect:
        name == "Spock enriched"
    }

}
