spock-bug
=========

Minimal project reproducing a spock bug in grails interactive mode

To reproduce bug:

* Checout this project: `git clone git://github.com/salvadordiaz/spock-bug.git spock-bug` 
* cd into the newly created directory : `cd spock-bug`
* launch grails interactive mode: `grails`
* once in grails interactive mode, run `test-app unit: Dummy`, the test will pass
* run the `test-app unit: Dummy` a second time in the same interactive session, you will see end up with the following console output:

```bash
DEV1:spock-bug salvador$ grails
Listening for transport dt_socket at address: 5005
| Enter a script name to run. Use TAB for completion: 
grails> test-app unit: Dummy
| Completed 1 spock test, 0 failed in 1597ms
| Tests PASSED - view reports in /Users/salvador/workspace/spock-bug/target/test-reports
grails> test-app unit: Dummy
| Running 1 spock test... 1 of 1
| Failure:  testSomething(spock.bug.DummySpec)
|  org.spockframework.mock.CannotCreateMockException: Cannot create mock for class spock.bug.Dummynull
	at org.spockframework.mock.runtime.MockInstantiator.instantiate(MockInstantiator.java:38)
	at org.spockframework.mock.runtime.ProxyBasedMockFactory$CglibMockFactory.createMock(ProxyBasedMockFactory.java:92)
	at org.spockframework.mock.runtime.ProxyBasedMockFactory.create(ProxyBasedMockFactory.java:49)
	at org.spockframework.mock.runtime.JavaMockFactory.create(JavaMockFactory.java:51)
	at org.spockframework.mock.runtime.CompositeMockFactory.create(CompositeMockFactory.java:44)
	at org.spockframework.lang.SpecInternals.createMock(SpecInternals.java:47)
	at org.spockframework.lang.SpecInternals.createMockImpl(SpecInternals.java:282)
	at org.spockframework.lang.SpecInternals.MockImpl(SpecInternals.java:99)
	at com.springsource.loaded.ri.ReflectiveInterceptor.jlrMethodInvoke(ReflectiveInterceptor.java:1231)
	at spock.bug.DummySpec.testSomething(DummySpec.groovy:11)
Caused by: java.lang.ClassCastException
	at java.lang.Class.cast(Class.java:2990)
	at org.spockframework.mock.runtime.MockInstantiator$ObjenesisInstantiator.instantiate(MockInstantiator.java:45)
	at org.spockframework.mock.runtime.MockInstantiator.instantiate(MockInstantiator.java:31)
	... 9 more
| Completed 1 spock test, 1 failed in 223ms
| Tests FAILED  - view reports in /Users/salvador/workspace/spock-bug/target/test-reports
grails> 
```