import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


public class TestRecord extends UpdatableRecordImpl<TestRecord> {

    private static final long serialVersionUID = 1L;

    public TestRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    public Integer getId() {
        return (Integer) get(0);
    }


    public TestRecord setNumbers(String[] value) {
        set(1, value);
        return this;
    }

    public String[] getNumbers() {
        return (String[]) get(1);
    }

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    public TestRecord() {
        super(TestTable.TESTTABLE);
    }

    public TestRecord(Integer id, String[] numbers) {
        super(TestTable.TESTTABLE);

        setId(id);
        setNumbers(numbers);
    }
}

