/*******************************************************************************
 * Copyright (c) 2009, 2024 Mountainminds GmbH & Co. KG and Contributors
 * This program and the accompanying materials are made available under
 * the terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Evgeny Mandrikov - initial API and implementation
 *
 *******************************************************************************/
package org.jacoco.core.test.validation.kotlin.targets

/**
 * Test target for functions with default arguments.
 */
object KotlinDefaultArgumentsTarget {

    private fun f(a: String = "a", b: String = "b") { // assertFullyCovered(0, 0)
    }

    private fun longParameter(x: Long = 0) { // assertFullyCovered()
    }

    private fun branch(a: Boolean, b: String = if (a) "a" else "b") { // assertFullyCovered(0, 2)
    }

    open class Open {
        open fun f(a: String = "a") { // assertFullyCovered()
        }
    }

    class SimpleConstructor(name: String = "foo") // assertFullyCovered()

    class Constructor() {
        constructor(a: Boolean, b: String = if (a) "a" else "b") : this() // assertFullyCovered(0, 2)
    }

    class MoreThan32Parameters( // assertFullyCovered()
        p1: String, // assertEmpty()
        p2: String, // assertEmpty()
        p3: String, // assertEmpty()
        p4: String, // assertEmpty()
        p5: String, // assertEmpty()
        p6: String, // assertEmpty()
        p7: String, // assertEmpty()
        p8: String, // assertEmpty()
        p9: String, // assertEmpty()
        p10: String, // assertEmpty()
        p11: String, // assertEmpty()
        p12: String, // assertEmpty()
        p13: String, // assertEmpty()
        p14: String, // assertEmpty()
        p15: String, // assertEmpty()
        p16: String, // assertEmpty()
        p17: String, // assertEmpty()
        p18: String, // assertEmpty()
        p19: String, // assertEmpty()
        p20: String, // assertEmpty()
        p21: String, // assertEmpty()
        p22: String, // assertEmpty()
        p23: String, // assertEmpty()
        p24: String, // assertEmpty()
        p25: String, // assertEmpty()
        p26: String, // assertEmpty()
        p27: String, // assertEmpty()
        p28: String, // assertEmpty()
        p29: String, // assertEmpty()
        p30: String, // assertEmpty()
        p31: String, // assertEmpty()
        p32: String = "", // assertFullyCovered()
        p33: String, // assertEmpty()
    ) // assertFullyCovered()

    fun functionWithSoManyParams( // assertFullyCovered()
        x00: Int, x01: Int, x02: Int, x03: Int, x04: Int, x05: Int, x06: Int, x07: Int, x08: Int, x09: Int, // assertEmpty()
        x10: Int, x11: Int, x12: Int, x13: Int, x14: Int, x15: Int, x16: Int, x17: Int, x18: Int, x19: Int, // assertEmpty()
        x20: Int, x21: Int, x22: Int, x23: Int, x24: Int, x25: Int, x26: Int, x27: Int, x28: Int, x29: Int, // assertEmpty()
        x30: Int, x31: Int, // assertEmpty()
        a: Long = 1 // assertFullyCovered()
    ) { // assertEmpty()
    } // assertFullyCovered()

    class OverloadExample1 @JvmOverloads constructor(name: String = "foo") // assertFullyCovered()
    class OverloadExample2 @JvmOverloads constructor(name: String = "foo") // assertFullyCovered()
    class OverloadExample3 @JvmOverloads constructor(name: String = "foo") // assertFullyCovered()

    @JvmStatic
    fun main(args: Array<String>) {
        f(a = "a")
        f(b = "b")
        /* next invocation doesn't use synthetic method: */
        f("a", "b")

        longParameter()
        longParameter(1)

        branch(false)
        branch(true)

        Open().f()

        SimpleConstructor("x")

        Constructor(false)
        Constructor(true)

        MoreThan32Parameters(
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
            "31", p33 = ""
        )

        functionWithSoManyParams(
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0
        )

        OverloadExample1()
        OverloadExample1("boo")

        OverloadExample2()

        OverloadExample3("boo")
    }

}
