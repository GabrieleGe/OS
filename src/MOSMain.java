import java.util.Arrays;
import java.util.Comparator;

public class MOSMain {

    GUI x = GUI.getInstance();
    InputData in = new InputData();
    public static boolean oneLoader = false;
    public static boolean oneMainProc = false;

    public void planner() {
        int i = 59;
        int nr = 0;
        int[] copy = new int[12];
        int[] placeInMem = new int[12];
        while (!x.data[i][1].equals("0")) {
            copy[nr] = Integer.valueOf(x.data[i][1]);
            i++;
            nr++;
        }
        ArrayIndexComparator comparator = new ArrayIndexComparator(copy, nr);
        Integer[] indexes = comparator.createIndexArray();
        Arrays.sort(indexes, comparator);
        for(int idx=0; idx < nr; idx++) {
            placeInMem[idx] = in.memarray[indexes[idx]];
        }

    }




    public static void bubble_srt( int a[], int n ){
        int i, j,t=0;
        for(i = 0; i < n; i++){
            for(j = 1; j < (n-i); j++){
                if(a[j-1] > a[j]){
                    t = a[j-1];
                    a[j-1]=a[j];
                    a[j]=t;
                }
            }
        }
    }


    public static void s( int a[], int n ){
        int i, j,t=0;
        for(i = 0; i < n; i++){
            for(j = 1; j < (n-i); j++){
                if(a[j-1] > a[j]){
                    t = a[j-1];
                    a[j-1]=a[j];
                    a[j]=t;
                }
            }
        }
    }

    public void planner2() {
        Process p = new Process();
        String JG = "";
        if (x.textfieldPranesPrLoader.getText().equals("Created") && oneLoader == false) {
            x.textfieldStartStop.setText("WaitingForProcessor");
            oneLoader = true;
            p.Loader();
        } else if ((x.textfielduzduotIsoAtmntyje.getText().equals("Created")) && oneMainProc == false){
            x.textfieldLoader.setText("WaitingForProcessor");
            x.textfieldPranesPrLoader.setText("Created");
            oneMainProc = true;
            p.MainProc();
        } else if ((x.textfieldMainProc.getText().equals("Working"))) {
            x.textfieldMainProc.setText("WaitingForProcessor");

            p.JobGovernor();
            x.textfielduzduotIsoAtmntyje.setText("Created");
        }else if ((x.textfielduzduotIsoAtmntyje.getText().equals("Created"))) {
            x.textfieldJobGovernor.setText("WaitingForProcessor");
            x.textfielduzduotVartAtmntyje.setText("Created"); //cia iskart reikia kurt VM
            x.textfieldpertraukimas.setText("Created");
            x.textfieldSendToPrinter.setText("WaitingForProcessor");
            p.VirtualMachine();
            x.virtualMachineProc = true;
        }else if ((x.textfieldPranesApiePertrauk.getText().equals("Created"))&&x.textfieldMODE.getText().equals("S")) {
            x.textfieldVirtualMachine.setText("WaitingForProcessor");
            p.Interrupt();
        }else if ((x.textfieldEiluteAtmintyje.getText().equals("Created"))&&(x.textfieldSpausdintuvas.getText().equals("Created"))) {
            x.textfieldInterrupt.setText("WaitingForProcessor");
            x.textfieldPranesApiePertrauk.setText("Created");
            p.SendToPrinter();

        }


    }


}