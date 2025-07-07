import org.jooq.impl.DSL

fun main() {

    val numbers = listOf("123456")

    val containsCondition = TestTable.TESTTABLE.NUMBERS.contains(
        DSL.cast(DSL.array(numbers.toTypedArray()), TestTable.TESTTABLE.NUMBERS.dataType)
    )

    println("$containsCondition")
}