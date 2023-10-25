package pl.dpotyralski.spockintroduction.extensions.local

import org.spockframework.runtime.extension.ExtensionAnnotation
import org.spockframework.runtime.extension.IAnnotationDrivenExtension
import org.spockframework.runtime.extension.IMethodInterceptor
import org.spockframework.runtime.extension.IMethodInvocation
import org.spockframework.runtime.model.FeatureInfo

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
@ExtensionAnnotation(value = ExampleFeatureAnnotationExtension.class)
@interface ExampleFeatureAnnotation {}

class ExampleFeatureAnnotationExtension implements IAnnotationDrivenExtension<ExampleFeatureAnnotation> {

    @Override
    void visitFeatureAnnotation(ExampleFeatureAnnotation annotation, FeatureInfo feature) {
        feature.getFeatureMethod().addInterceptor(new MethodArgumentEnrichedInterceptor())
    }
}

class MethodArgumentEnrichedInterceptor implements IMethodInterceptor {
    @Override
    void intercept(IMethodInvocation invocation) throws Throwable {
        invocation.getArguments()[0] = invocation.getArguments()[0] + " enriched"
        invocation.proceed()
    }
}
