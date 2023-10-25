package pl.dpotyralski.spockintroduction

import org.spockframework.runtime.extension.IMethodInterceptor
import org.spockframework.runtime.extension.IMethodInvocation

class ParamExtension implements IMethodInterceptor {

    def paramValue

    ParamExtension(String paramValue) {
        this.paramValue = paramValue
    }

    void intercept(IMethodInvocation invocation) {
        def method = invocation.method
        def parameterTypes = method.parameterTypes

        // Check if the method has parameters and the first parameter is of the expected type
        if (parameterTypes.length == 1 && parameterTypes[0] == String) {
            // Inject the parameter value
            def args = [paramValue]
            invocation.arguments = args

            // Proceed with the test method execution
            invocation.proceed()
        } else {
            // If the method doesn't have the expected parameter, throw an exception or handle it as needed.
            throw new IllegalArgumentException("Test method '${method.name}' must have a single String parameter.")
        }
    }
}
