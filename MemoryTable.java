import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

/**
 * Created by sattas on 3/27/14.
 */
public class MemoryTable {


    public class memoryTable extends JFrame {
        private JPanel table;
        private JTable memory;
        private JScrollPane scrollPane;

        public memoryTable() {
            table = new JPanel();
            table.setLayout(new BorderLayout());
            getContentPane().add(table);

            //------lentelės stulpelių vardai

            String columnsNames[] = {"nr","in"};

            String data[][] = new String[0][];

            for(int i=0; i < 100;i++) {
                data[i][0] = String.valueOf(i);
                for (int j= 0; j <= 1; j++) {

                }
            }

            memory = new JTable(data, columnsNames);
            TableModel model = memory.getModel();
            memory.setRowSorter(new TableRowSorter(model));
            scrollPane = new JScrollPane(memory);
            table.add(scrollPane, BorderLayout.CENTER);

        }

    }
}