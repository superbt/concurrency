package bt.code.sf.ds.fc.sub1;

import bt.code.sf.ds.fc.Operation;
import bt.code.sf.ds.fc.sub.Add;

public class AddFactiory implements  IFactory{
    @Override
    public Operation createOption() {
        return  new Add();
    }
}
