package spock.bug

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(Dummy)
class DummySpec extends Specification {

    void testSomething( ) {
        given:
        def mock = Mock( Dummy )

        when:
        mock.foobar()

        then:
        1 * mock.foobar()
    }
}
