package com.perculacreative.ktx

import com.haystax.constellation.utils.MapUtils

import junit.framework.Assert
import junit.framework.TestCase

import org.junit.Before
import org.junit.Test

import java.io.IOException
import java.util.HashMap
import java.util.HashSet

/**
 * Tests for Strings
 */
class StringTest : TestCase() {

    @Test
    fun testInvalidKeyForGetValueForKeyPath() {

        // Asserts an invalid key returns null
        val testKey = "a"
        val act = MapUtils.getValueForKeyPath(testKey, mock)

        Assert.assertNull(act)
    }

}
