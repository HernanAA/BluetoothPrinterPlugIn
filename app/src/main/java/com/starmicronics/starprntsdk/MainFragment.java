package com.starmicronics.starprntsdk;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.starmicronics.starprntsdk.functions.PrinterFunctions;
import com.starmicronics.starprntsdk.localizereceipts.ILocalizeReceipts;
import static com.starmicronics.starioextension.StarIoExt.Emulation;
import android.support.v4.app.Fragment;

public class MainFragment extends Fragment {
    private boolean mIsForeground;

/*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        print();
    }
*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        print();
    }



    private void print() {
        //mProgressDialog.show();

        byte[] commands;

        PrinterSetting setting = new PrinterSetting(getActivity());
        Emulation emulation = setting.getEmulation();

        int language  = PrinterSetting.LANGUAGE_SPANISH;
        int paperSize = PrinterSetting.PAPER_SIZE_TWO_INCH;

        ILocalizeReceipts localizeReceipts = ILocalizeReceipts.createLocalizeReceipts(language, paperSize);
        commands = PrinterFunctions.createTextReceiptData(emulation, localizeReceipts, false);
        Communication.sendCommands(this, commands, setting.getPortName(), setting.getPortSettings(), 10000, getActivity(), mCallback);     // 10000mS!!!
    }
    @Override
    public void onResume() {
        super.onResume();

        mIsForeground = true;
    }

    private final Communication.SendCallback mCallback = new Communication.SendCallback() {
        @Override
        public void onStatus(boolean result, Communication.Result communicateResult) {
            if (!mIsForeground) {
                return;
            }
            String msg;

            switch (communicateResult) {
                case Success:
                    msg = "Success!";
                    break;
                case ErrorOpenPort:
                    msg = "Fail to openPort";
                    break;
                case ErrorBeginCheckedBlock:
                    msg = "Printer is offline (beginCheckedBlock)";
                    break;
                case ErrorEndCheckedBlock:
                    msg = "Printer is offline (endCheckedBlock)";
                    break;
                case ErrorReadPort:
                    msg = "Read port error (readPort)";
                    break;
                case ErrorWritePort:
                    msg = "Write port error (writePort)";
                    break;
                default:
                    msg = "Unknown error";
                    break;
            }


            Log.i("Fin de Impresion: ", msg);
        }
    };


  /*  @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public void onDialogResult(String tag, Intent data) {

    }*/

}
