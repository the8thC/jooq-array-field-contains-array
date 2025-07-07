import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import java.util.Arrays;
import java.util.List;

public class TestTable extends TableImpl<TestRecord> {

    public static final TestTable TESTTABLE = new TestTable();

    public final TableField<TestRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    public final TableField<TestRecord, String[]> NUMBERS = createField(DSL.name("numbers"), SQLDataType.CLOB.getArrayDataType(), this, "");

    private TestTable(Name alias, Table<TestRecord> aliased) {
        this(alias, aliased, null);
    }

    private TestTable(Name alias, Table<TestRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public TestTable(String alias) {
        this(DSL.name(alias), TESTTABLE);
    }

    public TestTable(Name alias) {
        this(alias, TESTTABLE);
    }

    public TestTable() {
        this(DSL.name("testtable"), null);
    }

    public <O extends Record> TestTable(Table<O> child, ForeignKey<O, TestRecord> key) {
        super(child, key, TESTTABLE);
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<TestRecord, Integer> getIdentity() {
        return (Identity<TestRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<TestRecord> getPrimaryKey() {
        return Keys.TESTTABLE_PKEY;
    }

    @Override
    public List<UniqueKey<TestRecord>> getKeys() {
        return Arrays.<UniqueKey<TestRecord>>asList(Keys.TESTTABLE_PKEY);
    }

    @Override
    public TestTable as(String alias) {
        return new TestTable(DSL.name(alias), this);
    }

    @Override
    public TestTable as(Name alias) {
        return new TestTable(alias, this);
    }

    @Override
    public TestTable rename(String name) {
        return new TestTable(DSL.name(name), null);
    }

    @Override
    public TestTable rename(Name name) {
        return new TestTable(name, null);
    }
}
