package pl.dpotyralski.spockintroduction.extensions.global

import org.spockframework.runtime.extension.IGlobalExtension
import org.spockframework.runtime.model.SpecInfo;

class MyFirstGlobalExtension implements IGlobalExtension {

    @Override
    void start() {
        println "Starting!"
        super.start()
    }

    @Override
    void visitSpec(SpecInfo spec) {
        println "Visiting ${spec.getName()}"
        super.visitSpec(spec)
    }
}
