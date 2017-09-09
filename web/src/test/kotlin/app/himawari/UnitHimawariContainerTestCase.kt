package app.himawari

import org.dbflute.utflute.spring.ContainerTestCase
import org.junit.After
import org.junit.Before
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext

/**
 * UT基底クラスです。
 * Created by cxpqwvtj on 2017/03/15.
 */
abstract class UnitHimawariContainerTestCase : ContainerTestCase() {
    @Autowired
    lateinit var context: ApplicationContext

    @Before
    fun before() {
        super.setUp()
    }

    @After
    fun after() {
        super.tearDown()
    }

    override fun provideDefaultApplicationContext(): ApplicationContext {
        return context
    }
}