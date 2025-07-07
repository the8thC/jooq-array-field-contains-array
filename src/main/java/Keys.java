import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;

public class Keys {
    public static final UniqueKey<TestRecord> TESTTABLE_PKEY = Internal.createUniqueKey(TestTable.TESTTABLE, DSL.name("campcontact_pkey"), new TableField[]{TestTable.TESTTABLE.ID}, true);
}
