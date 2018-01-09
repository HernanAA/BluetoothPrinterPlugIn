package com.starmicronics.starprntsdk.localizereceipts;

import com.starmicronics.starioextension.ICommandBuilder;
import com.starmicronics.starioextension.StarIoExt.CharacterCode;

public abstract class ILocalizeReceipts {
    private int mPaperSize;
    private int mLanguage;

    protected String        mLanguageCode;
    private   String        mPaperSizeStr;
    private   String        mScalePaperSizeStr;
    protected CharacterCode mCharacterCode;

    public static ILocalizeReceipts createLocalizeReceipts(int language, int paperSize) {
        ILocalizeReceipts localizeReceipts ;

        localizeReceipts = new SpanishReceiptsImpl();
        localizeReceipts.setPaperSizeStr("2\"");
        localizeReceipts.setScalePaperSizeStr("3\"");   // 3inch -> 2inch
        localizeReceipts.setLanguage(language);
        localizeReceipts.setPaperSize(paperSize);

        return localizeReceipts;
    }

    public void appendTextReceiptData(ICommandBuilder builder, boolean utf8) {
        append2inchTextReceiptData(builder, utf8);
    }

    public void setLanguage(int language) {
        mLanguage = language;
    }

    public void setPaperSize(int paperSize) {
        mPaperSize = paperSize;
    }

    public void setPaperSizeStr(String paperSizeStr){
        mPaperSizeStr = paperSizeStr;
    }


    public void setScalePaperSizeStr(String scalePaperSizeStr){
        mScalePaperSizeStr = scalePaperSizeStr;
    }

    public abstract void append2inchTextReceiptData(ICommandBuilder builder, boolean utf8);

}
