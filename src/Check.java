import java.util.Scanner;

import javax.swing.*;

/**
 * Created by sattas on 3/29/14.
 */
public class Check {

    public Check(String command,String operand,int place) {
        GUI x = GUI.getInstance();
        boolean isValidCommand = true;

        if(command.equals("MVR1")){
            //nukelia reikðmë operand á registrà r1
            x.textfieldR1.setText(operand);


        } else if(command.equals("MVR2")) {
            //nukelia reikðmë operand á registrà r2
            x.textfieldR2.setText(operand);


        } else if(command.equals("LR1")) {
            //nukelia reiksme R1 á atminties vietà operand
            int blockNr = Integer.valueOf(operand) / 16;
            int wordNr = Integer.valueOf(operand) % 16;
            int memory = 0;
            if ("V".equals(x.textfieldMODE.getText())){
                //memory = Integer.valueOf(x.data[Integer.valueOf(x.textfieldPLR.getText())][1]) + blockNr*16 + wordNr;
                memory = place + blockNr*16 + wordNr;	//reiksmes tame paciame procese
            } else if ("S".equals(x.textfieldMODE.getText())){
                memory = Integer.valueOf(operand);
            }
            x.data[Integer.valueOf(memory)][1] = x.textfieldR1.getText();


        } else if(command.equals("LR2")) {
            //nukelia reiksmæ R2 á atminteis vietà operand
            int blockNr = Integer.valueOf(operand) / 16;
            int wordNr = Integer.valueOf(operand) % 16;
            int memory = 0;
            if ("V".equals(x.textfieldMODE.getText())){
                //memory = Integer.valueOf(x.data[Integer.valueOf(x.textfieldPLR.getText())][1]) + blockNr*16 + wordNr;
                memory = place + blockNr*16 + wordNr;	//reiksmes tame paciame procese
            } else if ("S".equals(x.textfieldMODE.getText())){
                memory = Integer.valueOf(operand);
            }
            x.data[Integer.valueOf(memory)][1] = x.textfieldR2.getText();



        } else if(command.equals("AD1")) {
            //prie R1 registro prideda atminties vietoje operand esanèià reikðmæ
            int blockNr = Integer.valueOf(operand) / 16;
            int wordNr = Integer.valueOf(operand) % 16;
            int memory = 0;
            if ("V".equals(x.textfieldMODE.getText())){
                //memory = Integer.valueOf(x.data[Integer.valueOf(x.textfieldPLR.getText())][1]) + blockNr*16 + wordNr;
                memory = place + blockNr*16 + wordNr;	//reiksmes tame paciame procese
            } else if ("S".equals(x.textfieldMODE.getText())){
                memory = Integer.valueOf(operand);
            }
            int sum = Integer.valueOf(x.data[Integer.valueOf(memory)][1]) + Integer.valueOf(x.textfieldR1.getText());
            x.textfieldR1.setText(String.valueOf(sum));


        } else if(command.equals("AD2")) {
            //prie R2 registro prideda atminties vietoje operand esanèià reikðmæ
            int blockNr = Integer.valueOf(operand) / 16;
            int wordNr = Integer.valueOf(operand) % 16;
            int memory = 0;
            if ("V".equals(x.textfieldMODE.getText())){
                //memory = Integer.valueOf(x.data[Integer.valueOf(x.textfieldPLR.getText())][1]) + blockNr*16 + wordNr;
                memory = place + blockNr*16 + wordNr;	//reiksmes tame paciame procese
            } else if ("S".equals(x.textfieldMODE.getText())){
                memory = Integer.valueOf(operand);
            }
            int sum = Integer.valueOf(x.data[Integer.valueOf(memory)][1]) + Integer.valueOf(x.textfieldR2.getText());
            x.textfieldR2.setText(String.valueOf(sum));

        } else if(command.equals("SB1")) {
            //ið registro R1 reikðmës atima atminties vietoje operand esanèià reikðmæ
            int blockNr = Integer.valueOf(operand) / 16;
            int wordNr = Integer.valueOf(operand) % 16;
            int memory = 0;
            if ("V".equals(x.textfieldMODE.getText())){
                //memory = Integer.valueOf(x.data[Integer.valueOf(x.textfieldPLR.getText())][1]) + blockNr*16 + wordNr;
                memory = place + blockNr*16 + wordNr;	//reiksmes tame paciame procese
            } else if ("S".equals(x.textfieldMODE.getText())){
                memory = Integer.valueOf(operand);
            }
            int sub = Integer.valueOf(x.textfieldR1.getText()) -Integer.valueOf(x.data[Integer.valueOf(memory)][1]) ;
            x.textfieldR1.setText(String.valueOf(sub));

        } else if(command.equals("SB2")) {
            //ið registro R1 reikðmës atima atminties vietoje operand esanèià reikðmæ

            int blockNr = Integer.valueOf(operand) / 16;
            int wordNr = Integer.valueOf(operand) % 16;
            int memory = 0;
            if ("V".equals(x.textfieldMODE.getText())){
                //memory = Integer.valueOf(x.data[Integer.valueOf(x.textfieldPLR.getText())][1]) + blockNr*16 + wordNr;
                memory = place + blockNr*16 + wordNr;	//reiksmes tame paciame procese
            } else if ("S".equals(x.textfieldMODE.getText())){
                memory = Integer.valueOf(operand);
            }
            int sub = Integer.valueOf(x.textfieldR2.getText()) -Integer.valueOf(x.data[Integer.valueOf(memory)][1]) ;
            x.textfieldR2.setText(String.valueOf(sub));

        } else if(command.equals("CMPR1")) {
            //Jei R1 =yra lygus operand atminties vietoj esanèiai vietai tai registrui C priskiriama reikðmë T, kitu atveju C:= F
            int blockNr = Integer.valueOf(operand) / 16;
            int wordNr = Integer.valueOf(operand) % 16;
            int memory = 0;
            if ("V".equals(x.textfieldMODE.getText())){
                memory = Integer.valueOf(x.data[Integer.valueOf(x.textfieldPLR.getText())][1]) + blockNr*16 + wordNr;
            } else if ("S".equals(x.textfieldMODE.getText())){
                memory = Integer.valueOf(operand);
            }
            if (Integer.valueOf(x.textfieldR1.getText()).equals(Integer.valueOf(x.data[Integer.valueOf(memory)][1]))) {
                x.textfieldC.setText("T");
            }else {
                x.textfieldC.setText("F");
            }

        } else if(command.equals("exit")) {

            x.textfieldMODE.setText("V");
            x.setRegister();


        } else if(command.equals("CMPR2")) {
            //Jei R2 = [x*16 + y], tai registrui C priskiriama reikðmë T, kitu atveju C:= F
            int blockNr = Integer.valueOf(operand) / 16;
            int wordNr = Integer.valueOf(operand) % 16;
            int memory = 0;
            if ("V".equals(x.textfieldMODE.getText())){
                memory = Integer.valueOf(x.data[Integer.valueOf(x.textfieldPLR.getText())][1]) + blockNr*16 + wordNr;
            } else if ("S".equals(x.textfieldMODE.getText())){
                memory = Integer.valueOf(operand);
            }
            if (Integer.valueOf(x.textfieldR2.getText()).equals(Integer.valueOf(x.data[Integer.valueOf(memory)][1]))) {
                x.textfieldC.setText("T");
            }else {
                x.textfieldC.setText("F");
            }

        } else if(command.equals("BT")) {
            // Jei registro C reikðmë lygi T, tai registrui IC priskiriama reikðmë operand.
            int blockNr = Integer.valueOf(operand) / 16;
            int wordNr = Integer.valueOf(operand) % 16;
            int memory = 0;
            if ("V".equals(x.textfieldMODE.getText())){
                memory = Integer.valueOf(x.data[Integer.valueOf(x.textfieldPLR.getText())][1]) + blockNr*16 + wordNr;
            } else if ("S".equals(x.textfieldMODE.getText())){
                memory = Integer.valueOf(operand);
            }
            if (x.textfieldC.getText().equals("T")) {
                x.textfieldIC.setText(String.valueOf(memory));
            }


        } else if(command.equals("JP")) {
            //perduoda valdymà á atminties adresà operand
            int blockNr = Integer.valueOf(operand) / 16;
            int wordNr = Integer.valueOf(operand) % 16;
            int memory = 0;
            if ("V".equals(x.textfieldMODE.getText())){
                memory = Integer.valueOf(x.data[Integer.valueOf(x.textfieldPLR.getText())][1]) + blockNr*16 + wordNr;
            } else if ("S".equals(x.textfieldMODE.getText())){
                memory = Integer.valueOf(operand);
            }
            x.textfieldIC.setText(String.valueOf(memory));

        } else if(command.equals("GET")) {

            //GET [<addr>]
            //nuskaito R1 skaièiø þodþiø is ivedimo ir padeda i tam tikra vieta
            int blockNr = Integer.valueOf(operand) / 16;
            int wordNr = Integer.valueOf(operand) % 16;
            int memory = 0;
            if ("V".equals(x.textfieldMODE.getText())){
                memory = Integer.valueOf(x.data[Integer.valueOf(x.textfieldPLR.getText())][1]) + blockNr*16 + wordNr;
            } else if ("S".equals(x.textfieldMODE.getText())){
                memory = Integer.valueOf(operand);
            }
            int size = Integer.valueOf(x.textfieldR1.getText());
            int t = memory;							//Vieta atmintyje
            for (int i = Integer.valueOf(memory); i<(t+size); i++){
                //read();
            }
        } else if(command.equals("SHOW")) {
            //nuskaito tam tikra skaiciu zodziu is atminties ir isveda á ekranà
            int blockNr = Integer.valueOf(operand) / 16;
            int wordNr = Integer.valueOf(operand) % 16;
            int memory = 0;
            if ("V".equals(x.textfieldMODE.getText())){
                memory =Integer.valueOf(x.data[Integer.valueOf(x.textfieldPLR.getText())][1]) + blockNr*16 + wordNr;
            } else if ("S".equals(x.textfieldMODE.getText())){
                memory = Integer.valueOf(operand);
            }
            int size = Integer.valueOf(x.textfieldR1.getText());
            int t = memory;
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = memory; i<(t+size); i++){
                stringBuilder.append(x.data[i][1]);
                System.out.println(stringBuilder);
            }
            x.output.setText(String.valueOf(stringBuilder));
        } else if(command.equals("HALT")) {
            //iðjungiam programà
            GUI.endProc = true;
            GUI.newProc = true;
            GUI.printer = true;

        } else {
            //x.textfieldPI.setText("1");
        }
    }
}