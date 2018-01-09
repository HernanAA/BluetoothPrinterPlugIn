package com.starmicronics.starprntsdk.functions;

import com.starmicronics.starioextension.ICommandBuilder;
import com.starmicronics.starioextension.StarIoExt;
import com.starmicronics.starprntsdk.localizereceipts.ILocalizeReceipts;

import static com.starmicronics.starioextension.StarIoExt.Emulation;
import static com.starmicronics.starioextension.ICommandBuilder.CutPaperAction;

public class PrinterFunctions {

    public static byte[] createTextReceiptData(Emulation emulation, ILocalizeReceipts localizeReceipts, boolean utf8) {
        ICommandBuilder builder = StarIoExt.createCommandBuilder(emulation);

        builder.beginDocument();

        localizeReceipts.appendTextReceiptData(builder, utf8);

        builder.appendCutPaper(CutPaperAction.PartialCutWithFeed);

        builder.endDocument();

        return builder.getCommands();
    }
}
