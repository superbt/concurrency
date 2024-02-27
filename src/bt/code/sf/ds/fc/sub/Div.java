package bt.code.sf.ds.fc.sub;

import bt.code.sf.ds.fc.Operation;

public class Div extends Operation {
    @Override
    protected double getResule() {
        if (getValue2()==0) throw new RuntimeException("value is zero");
        return getValue1()/getValue2();
    }
}
