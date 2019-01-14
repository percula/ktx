package com.perculacreative.ktx

import org.junit.Test

class StringTest {

    @Test
    fun removeSymbols_DoesNotRemovePunctuation() {
        val input = "abcdefghijklmnopqrstuvwxyz1234567890`~!@#$%^&*()_+-=,.|{}[]:; '‘’''?/<>\"\\"
        val output = input.removeSymbols()
        System.out.println(output)

        assert(output == input)
    }

    @Test
    fun removeSymbols_ShouldNotEqual() {
        val input = "㋡㋛☺☹☻〠シッツヅÜ〲〴ϡت⍡⍢⍣⍤⍥⍨⍩ὃὕὣѶӪӫ"
        val output = input.removeSymbols()
        val expected = "����������������������������"
        System.out.println(output)

        assert(input.removeSymbols() == expected)
    }

}
