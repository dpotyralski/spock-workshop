package pl.dpotyralski.spockintroduction.extensions.local

import org.spockframework.runtime.extension.ExtensionAnnotation
import org.spockframework.runtime.extension.IAnnotationDrivenExtension
import org.spockframework.runtime.extension.IMethodInterceptor
import org.spockframework.runtime.extension.IMethodInvocation
import org.spockframework.runtime.model.FeatureInfo
import org.spockframework.runtime.model.FieldInfo
import org.spockframework.runtime.model.MethodInfo
import org.spockframework.runtime.model.SpecInfo

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

@Retention(value = RetentionPolicy.RUNTIME)
@Target([ElementType.TYPE, ElementType.FIELD, ElementType.METHOD])
@ExtensionAnnotation(value = LifecycleAnnotationExtension.class)
@interface LifecycleAnnotation {}

class LifecycleAnnotationExtension implements IAnnotationDrivenExtension<LifecycleAnnotation> {

    @Override
    void visitSpecAnnotation(LifecycleAnnotation annotation, SpecInfo spec) {
        println "visitSpecAnnotation"
    }

    @Override
    void visitFeatureAnnotation(LifecycleAnnotation annotation, FeatureInfo feature) {
        println "visitFeatureAnnotation - ${feature.getName()}"

        feature.addInterceptor(new PrintingHelperInterceptor(msg: "feature interceptor"))
        feature.addIterationInterceptor(new PrintingHelperInterceptor(msg: "iteration interceptor"))
    }

    @Override
    void visitFixtureAnnotation(LifecycleAnnotation annotation, MethodInfo fixtureMethod) {
        println "visitFixtureAnnotation - ${fixtureMethod.getName()}"

        fixtureMethod.addInterceptor(new PrintingHelperInterceptor(msg: "fixture interceptor"))
    }

    @Override
    void visitFieldAnnotation(LifecycleAnnotation annotation, FieldInfo field) {
        println "visitFieldAnnotation - ${field.getName()}"
    }

    @Override
    void visitSpec(SpecInfo spec) {
        println "visitSpec"

        spec.addInitializerInterceptor(new PrintingHelperInterceptor(msg: "initializer interceptor"))

        spec.addSetupInterceptor(new PrintingHelperInterceptor(msg: "setup interceptor"))
        spec.addCleanupInterceptor(new PrintingHelperInterceptor(msg: "cleanup interceptor"))

        spec.addSetupSpecInterceptor(new PrintingHelperInterceptor(msg: "setup spec interceptor"))
        spec.addCleanupSpecInterceptor(new PrintingHelperInterceptor(msg: "cleanup spec interceptor"))

        spec.addInterceptor(new PrintingHelperInterceptor(msg: "test interceptor"))
    }

    private static class PrintingHelperInterceptor implements IMethodInterceptor {
        String msg

        @Override
        void intercept(IMethodInvocation invocation) throws Throwable {
            println "  Starting ${msg}"
            try {
                invocation.proceed()
            } finally {
                println "  Finish ${msg}"
            }
        }
    }
}
