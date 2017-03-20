package app.himawari

import org.dbflute.utflute.spring.ContainerTestCase
import org.junit.After
import org.junit.Before

/**
 * UT基底クラスです。
 * Created by cxpqwvtj on 2017/03/15.
 */
abstract class UnitHimawariContainerTestCase : ContainerTestCase() {
    @Before
    fun before() {
        super.setUp()
    }

    @After
    fun after() {
        super.tearDown()
    }
}