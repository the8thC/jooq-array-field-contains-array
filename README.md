# jooq-array-field-contains-array


```kotlin
...
    val EXPECTED_1_V_3_18_14 =
        "\"public\".\"testtable\".\"numbers\" like (('%' || cast(cast(array[array['123456']] as clob array) as varchar)) || '%') escape '!'"
    val EXPECTED_2_V_3_18_14 =
        "\"public\".\"testtable\".\"numbers\" like (('%' || cast(array['123456'] as varchar)) || '%') escape '!'"

    val EXPECTED_1_V_3_14_16 =
        "\"public\".\"testtable\".\"numbers\" @> cast(array[array['123456']] as clob[])"
    val EXPECTED_2_V_3_14_16 =
        "\"public\".\"testtable\".\"numbers\" @> array['123456']"


    fun getConditions(): Pair<Condition, Condition> {
        val numbers = listOf("123456")

        val condition1 = TestTable.TESTTABLE.NUMBERS.contains(
            DSL.cast(DSL.array(numbers.toTypedArray()), TestTable.TESTTABLE.NUMBERS.dataType)
        )
        val condition2 = TestTable.TESTTABLE.NUMBERS.contains(
            numbers.toTypedArray()
        )
        println("$condition1")
        println("$condition2")
        return Pair(condition1, condition2)
    }

    @Test
    fun testCondition_version3_18_14() {
        val (condition1, condition2) = getConditions()

        assert(condition1.toString() == EXPECTED_1_V_3_18_14)
        assert(condition2.toString() == EXPECTED_2_V_3_18_14)
    }

    @Test
    fun testCondition_version3_14_16() {
        val (condition1, condition2) = getConditions()

        assert(condition1.toString() == EXPECTED_1_V_3_14_16)
        assert(condition2.toString() == EXPECTED_2_V_3_14_16)
    }
...
```
