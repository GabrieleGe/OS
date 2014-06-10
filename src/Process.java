/**
 * Created by sattas on 5/21/14.
 */
public class Process {
    Resource r = new Resource();
    GUI x = GUI.getInstance();


    public void StartStop(){
        x.textfieldStartStop.setText("Working");
        x.textfieldMOSPab.setText("Created");
        x.textfieldSpausdintuvas.setText("Created");
        x.textfieldPranesPrLoader.setText("Created");

        String pState;
        String ownedRestList; //èia turi bût masyas, á kurá sudeda visus ið resources priskirtus  resursus
        String ParentProcess;
        String serviceTime; //èia reikia sugalvot, kiek kartø suksis kiekvienas procesas
    }

    public void Loader(){

        x.textfieldLoader.setText("Working");
        x.textfielduzduotIsoAtmntyje.setText("Created");
        x.textfielduzduotVartAtmntyje.setText("Created");
        x.textfieldPranesPrLoader.setText("Using");

        String pState;
        String ownedRestList; //èia turi bût masyas, á kurá sudeda visus ið resources priskirtus  resursus
        String ParentProcess;
        String serviceTime; //èia reikia sugalvot, kiek kartø suksis kiekvienas procesas
    }

    public void MainProc(){

        x.textfieldMainProc.setText("Working");
        x.textfielduzduotIsoAtmntyje.setText("Using");
        x.textfieldPranesPrLoader.setText("NotCreated");


        String pState;
        String ownedRestList; //èia turi bût masyas, á kurá sudeda visus ið resources priskirtus  resursus
        String ParentProcess;
        String serviceTime; //èia reikia sugalvot, kiek kartø suksis kiekvienas procesas
    }

    public void JobGovernor(){

        x.textfieldJobGovernor.setText("Working");
        x.textfieldEiluteAtmintyje.setText("Created");
        x.textfielduzduotVartAtmntyje.setText("Using"); //cia iskart reikia kurt VM
        x.textfieldpertraukimas.setText("Using");
        x.textfielduzduotIsoAtmntyje.setText("NotCreated");

        String pState;
        String ownedRestList; //èia turi bût masyas, á kurá sudeda visus ið resources priskirtus  resursus
        String ParentProcess;
        String serviceTime; //èia reikia sugalvot, kiek kartø suksis kiekvienas procesas
    }

    public void VirtualMachine(){
        MOSMain m = new MOSMain();
        x.textfieldVirtualMachine.setText("Working");
        x.textfieldPranesApiePertrauk.setText("Created");
        x.textfieldInterrupt.setText("WaitingForProcessor");
        x.textfielduzduotVartAtmntyje.setText("NotCreated"); //cia iskart reikia kurt VM
        x.textfieldpertraukimas.setText("NotCreated");


        String pState;
        String ownedRestList; //èia turi bût masyas, á kurá sudeda visus ið resources priskirtus  resursus
        String ParentProcess;
        String serviceTime; //èia reikia sugalvot, kiek kartø suksis kiekvienas procesas
    }

    public void Interrupt(){
        ChangeStatus();
        x.textfieldInterrupt.setText("Working");
        x.textfieldPranesApiePertrauk.setText("Using");
        x.textfieldpertraukimas.setText("Created");


        String pState;
        String ownedRestList; //èia turi bût masyas, á kurá sudeda visus ið resources priskirtus  resursus
        String ParentProcess;
        String serviceTime; //èia reikia sugalvot, kiek kartø suksis kiekvienas procesas
    }

    public void SendToPrinter(){
        ChangeStatus();
        x.textfieldSendToPrinter.setText("Working");
        x.textfieldSpausdintuvas.setText("Using");
        x.textfieldEiluteAtmintyje.setText("Using");
        x.textfieldPranesApiePertrauk.setText("NotCreated");


        String pState;
        String ownedRestList; //èia turi bût masyas, á kurá sudeda visus ið resources priskirtus  resursus
        String ParentProcess;
        String serviceTime; //èia reikia sugalvot, kiek kartø suksis kiekvienas procesas
    }

    public void ChangeStatus(){
        if (x.textfieldStartStop.getText().equals("Working")){
            x.textfieldStartStop.setText("WaitingForProcessor");

        } else if (x.textfieldLoader.getText().equals("Working")){
            x.textfieldLoader.setText("WaitingForProcessor");

        }else if (x.textfieldMainProc.getText().equals("Working")){
            x.textfieldMainProc.setText("WaitingForProcessor");

        }else if (x.textfieldJobGovernor.getText().equals("Working")){
            x.textfieldJobGovernor.setText("WaitingForProcessor");

        } else if (x.textfieldVirtualMachine.getText().equals("Working")){
            x.textfieldVirtualMachine.setText("WaitingForProcessor");

        } else if (x.textfieldInterrupt.getText().equals("Working")){
            x.textfieldInterrupt.setText("WaitingForProcessor");

        }else if (x.textfieldSendToPrinter.getText().equals("Working")){
            x.textfieldSendToPrinter.setText("WaitingForProcessor");
        }

    }

    public void clearResources(){
        x.textfieldPranesPrLoader.setText("NotCreated");
        x.textfielduzduotIsoAtmntyje.setText("NotCreated");
        x.textfielduzduotVartAtmntyje.setText("NotCreated");
        x.textfieldpertraukimas.setText("NotCreated");
        x.textfieldPranesApiePertrauk.setText("NotCreated");
        x.textfieldSpausdintuvas.setText("NotCreated");
        x.textfieldEiluteAtmintyje.setText("NotCreated");
        x.textfieldMOSPab.setText("NotCreated");
    }
}
