package StatePanels;

import composite.Panels;
import factory.ProductsInterface;

import java.util.ArrayList;

public class Backup {
    private Panels panel;
    ArrayList<Memento> panelSnapshot = new ArrayList<>();

    public Backup(Panels panel){
        this.panel = panel;
    }

    public void takeSnapshot(){
        this.panelSnapshot.add(panel.backup());
    }

    public void restoreSnapshot(int panelId) throws NotExistingSnapshotException {
        if(panelId < 0 || panelId > this.panelSnapshot.size() -1){
            throw new NotExistingSnapshotException();
        }
        System.out.println("Restore the snapshots with ID: {"+ panelId +"}");
        this.panel.restore(this.panelSnapshot.get(panelId));
    }
}
