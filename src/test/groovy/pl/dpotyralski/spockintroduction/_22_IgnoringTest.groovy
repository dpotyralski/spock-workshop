package pl.dpotyralski.spockintroduction

import spock.lang.*

class _22_IgnoringTest extends Specification {

    @Ignore
    def "should ignore this test"() {
        expect:
        true
    }

    @PendingFeature
    def "test should be run, but due to error result ignored"() {
        expect:
        throw new IllegalStateException("")
    }

    @PendingFeatureIf({ System.getProperty("os.name") == "Mac OS X" })
    def "test should be run on condition, but due to error result ignored"() {
        expect:
        throw new IllegalStateException("")
    }

    @IgnoreIf({ !os.macOs })
    def "run me, but it depends"() {
        expect: true
    }

    @Requires({ jvm.java17 })
    @Requires({ jvm.java8Compatible })
    def "run me, but it depends #2"() {
        expect: true
    }

//    @IgnoreRest
//    def "run me pretty please!"() {
//        expect:
//        true
//    }


}
