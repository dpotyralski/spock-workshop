package pl.dpotyralski.spockintroduction.extensions.local

import org.spockframework.runtime.extension.ExtensionAnnotation
import org.spockframework.runtime.extension.IAnnotationDrivenExtension
import org.spockframework.runtime.model.FeatureInfo
import org.spockframework.runtime.model.SpecInfo

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target


@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
@ExtensionAnnotation(value = ExampleSpecAnnotationExtension.class)
@interface ExampleSpecAnnotation {

    String value()

}

class ExampleSpecAnnotationExtension implements IAnnotationDrivenExtension<ExampleSpecAnnotation> {

    @Override
    void visitSpecAnnotation(ExampleSpecAnnotation annotation, SpecInfo spec) {
        spec.getFeatures().forEach { FeatureInfo feature ->
            feature.getFeatureMethod().addInterceptor {
                it.getArguments()[0] = annotation.value()
                it.proceed()
            }
        }
    }

}