package pl.dpotyralski.spockintroduction


import spock.lang.Specification
import spock.util.concurrent.PollingConditions

class _28_PoolingConditionsSpec extends Specification {

    def "should pooling conditions"() {
        given:
        PollingConditions pollingConditions = new PollingConditions(timeout: 5)
        String response = ''

        when:
        new Thread(new Runnable() {
            @Override
            void run() {
                Thread.sleep(2000)
                response = 'OK!'
            }
        }).start()

        then:
        pollingConditions.within(20) { }
    }


}
