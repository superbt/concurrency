package bt.code.sf.ds.fc.sub;

import bt.code.sf.ds.fc.Operation;

public class Subm extends Operation {
    @Override
    protected double getResule() {
        return  getValue1() -getValue2();
    }
}
