package com.starmicronics.starprntsdk.localizereceipts;

import com.starmicronics.starioextension.ICommandBuilder;
import com.starmicronics.starioextension.ICommandBuilder.CodePageType;
import com.starmicronics.starioextension.ICommandBuilder.InternationalType;
import com.starmicronics.starioextension.ICommandBuilder.AlignmentPosition;
import com.starmicronics.starioextension.StarIoExt.CharacterCode;
import com.starmicronics.starprntsdk.Util;


import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.text.SimpleDateFormat;


public class SpanishReceiptsImpl extends ILocalizeReceipts {

    public SpanishReceiptsImpl() {
        mLanguageCode = "Es";

        mCharacterCode = CharacterCode.Standard;
    }

    @Override
    public void append2inchTextReceiptData(ICommandBuilder builder, boolean utf8) {
        Charset encoding;

        SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
        SimpleDateFormat ftt = new SimpleDateFormat ("HH:mm");
/*
        String date = ft.format(dateInfraction);
        String time = ftt.format(dateInfraction);
        String plate = args.getString(2);
        String address = args.getString(3);
        String inspector_name = args.getString(4);
        String inspector_dni = args.getString(5);
        String notificationDate = args.getString(6);
        String id = args.getString(7); // ACTA
        String dueDate = args.getString(7);

        String brand = args.getString(9);
		String color = args.getString(10);
		String vehicle_type = args.getString(11);
		String ticket_category_code = args.getString(12);
		String ticket_category_desc = args.getString(13);
		String measure_taken = args.getString(14);
		String notification_type = args.getString(15);

*/

        String date = "12/12/2017";
        String time = "11:25";
        String plate = "AAA345";
        String address = "Gral Manuel Belgrano 100";
        String inspector_name = "Inspector Nousar";
        String inspector_dni = "36100000";
        String notificationDate = "12/12/2017";
        String id = "12345"; // ACTA
        String dueDate =  "12/12/2017";

        String brand = "brand";
        String color = "color";
        String vehicle_type = "Tipo Vehiculo";
        String ticket_category_code = "code";
        String ticket_category_desc = "Description";
        String measure_taken = "measure taken";
        String notification_type = "notification type";



        if (utf8) {
            encoding = Charset.forName("UTF-8");

            builder.appendCodePage(CodePageType.UTF8);
        }
        else {
            try {
                encoding = Charset.forName("Windows-1252");

                builder.appendCodePage(CodePageType.CP1252);
            }
            catch (UnsupportedCharsetException e) {
                encoding = Charset.forName("UTF-8");

                builder.appendCodePage(CodePageType.UTF8);
            }
        }

        builder.appendInternational(InternationalType.Spain);

        builder.appendCharacterSpace(0);

        builder.appendAlignment(AlignmentPosition.Center);

        builder.appendMultiple(("MUNICIPALIDAD DE SAN LORENZO\n").getBytes(encoding), 1, 1);

       builder.append((
               "________________________________\n" +
                "SLPARKING\n" +
                        "\n" +
                       "Horario de atención \n" +
                        "Lunes a Viernes de 0 hs a 0 hs\n" +
                       "________________________________\n" ).getBytes(encoding));

        builder.appendAlignment(AlignmentPosition.Right);
        builder.append(
                ("ACTA N° " + id + " \n").getBytes(encoding));

        builder.appendAlignment(AlignmentPosition.Left);
        builder.append(
                ("San Lorenzo,         " + date + "\n" +
                "Dirección: " + address + "\n" +
                "Hora:                      " + time + "\n" +
                "________________________________\n" ).getBytes(encoding));

        builder.appendAlignment(AlignmentPosition.Center);
        builder.append(
                (" DATOS DEL VEHICULO\n" +
                        "\n" ).getBytes(encoding));

        builder.appendAlignment(AlignmentPosition.Left);
        builder.append(
                ("Placa:                " + Util.rightJustify(plate, 10)+ "\n" +
                "Marca:                " + Util.rightJustify(brand, 10) + "\n" +
                "Color:                " + Util.rightJustify(color, 10) + "\n" +
                "Tipo de vehículo: " + Util.rightJustify(vehicle_type, 14) + "\n" +
                "________________________________\n" ).getBytes(encoding));

        builder.appendAlignment(AlignmentPosition.Center);
        builder.append(
                (" DATOS DEL PRESUNTO INFRACTOR\n" +
                "\n" +
                "................................\n" +
                "Nombres\n" +
                "\n" +
                "................................\n" +
                "Apellidos\n" +
                "\n" +
                "................................\n" +
                "Documento de identidad\n" +
                "\n" +
                "................................\n" +
                "Licencia\n" +
                "\n" +
                "................................\n" +
                "Municipio\n" +
                "\n" +
                "________________________________\n" +
                "DATOS CEDULA" +
                "\n"+
                "................................\n" +
                "Nombres\n" +
                "\n" +
                "................................\n" +
                "Apellidos\n" +
                "\n" +
                "................................\n" +
                "Documento de identidad\n" +
                "\n" +
                "________________________________\n" +
                "DESCRIPCIÓN INFRACCIÓN" +
                "\n" +
                "").getBytes(encoding));

        builder.appendAlignment(AlignmentPosition.Left);
        builder.append(
            ("Código infracción: " + Util.rightJustify(ticket_category_code, 13)+ "\n" +
            "Descripción: " + ticket_category_desc + "\n" +
            "________________________________\n" +
            "").getBytes(encoding));

        builder.appendAlignment(AlignmentPosition.Center);
        builder.append(
                (" MEDIDAS ADOPTADAS\n" +
                        "\n" +
                        measure_taken +  "\n" +
                        "________________________________\n" +
                        "DATOS INSPECTOR\n" +
                        "\n" +
                        "Interviniente: " + Util.rightJustify(inspector_name, 17) + "\n" +
                        "Documento de Identidad: " + Util.rightJustify(inspector_dni, 8)+ "\n" +
                        "________________________________\n" +
                        "NOTIFICACIÓN\n" +
                        "\n" +
                        notification_type + "\n" +
                        "________________________________\n" +
                        "TESTIGO\n" +
                        "\n" +
                        "................................\n" +
                        "Nombres\n" +
                        "\n" +
                        "................................\n" +
                        "Apellidos\n" +
                        "\n" +
                        "................................\n" +
                        "Documento de identidad\n" +
                        "\n" +
                        "________________________________\n" +
                        "FIRMAS" +
                        "\n" +
                        "Testigo: .......................\n" +
                        "\n" +
                        "Inspector: .......................\n" +
                        "________________________________\n" +
                        "OBSERVACIONES\n" +
                        "\n" +
                        "................................\n" +
                        "\n" +
                        "................................\n" +
                        "\n" +
                        "................................\n" +
                        "Queda Ud. debidamente\n"+
                        "notificado que: En el plazo de 5\n"+
                        "días habiles deberá presentarse\n"+
                        "en la Municipalidad de\n"+
                        "San Lorenzo a dar cumplimiento a\n"+
                        "la Ley Nacional  5016/14 y la \n"+
                        "Ordenanza Municipal N° 1532/2017\n"+
                        "").getBytes(encoding));


    }
}
