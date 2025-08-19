package com.badaklng.lib;

import com.badaklng.lib.model.request.util.Parameter;
import com.badaklng.lib.model.request.util.TemplateParameter;
import com.badaklng.lib.model.response.APIResponse;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//        }

//        Qontak qontak = new Qontak();
//        TemplateParameter nama = new TemplateParameter("1", "name", "Dzulfikar");
//        TemplateParameter hari = new TemplateParameter("2", "hari", "Sabtu");
//        TemplateParameter tanggal = new TemplateParameter("3", "tanggal", "23/Aug/2025");
//        TemplateParameter jam = new TemplateParameter("4", "jam", "11.50 AM");
//        Parameter parameter = new Parameter.Builder().addParameter(nama).build();
//
//        try {
//            String test = qontak.sendWhatsappMsgOutboundDirect("628115521745", "Dzulfikar Luthfi", Qontak.TEMPLATE_TEST, Qontak.CHANNEL_ID_TEST, nama, hari, tanggal, jam);
//            System.out.println(test);
////            APIResponse response = qontak.sendWhatsappMsgOutboundDirect("6281219450611", "Dzulfikar Luthfi", Qontak.TEMPLATE_TEST, Qontak.CHANNEL_ID_TEST, nama, hari, tanggal, jam);
////            System.out.print("Response Status : " + response.getStatus());
////            System.out.print(" -> Log ID : " + response.getData().getId());
//        } catch (Exception e) {
//            System.out.println("Error : " + e.getMessage());
//        }

    }
}