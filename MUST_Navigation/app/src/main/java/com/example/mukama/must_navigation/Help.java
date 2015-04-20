package com.example.mukama.must_navigation;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

/**
 * Created by Collins Mann on 4/20/2015.
 */
public class Help extends Activity {

    TextView header,help_info, copyryt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);

        header = (TextView)findViewById(R.id.heading);
        help_info = (TextView)findViewById(R.id.helpContent);
        copyryt = (TextView)findViewById(R.id.c_rights);

        header.setText(Html.fromHtml("<b><u> How to use this app </u></b>"));
        help_info.setText(Html.fromHtml("" +
                "Welome to Must Navigation application," +
                "this informations helps you on how to use " +
                "the developed application." +
                "<p>" +
                "The application has 9 icons on the first " +
                "screen when it is launched." +
                "</p>"));

        copyryt.setText(Html.fromHtml("" +
                "<i>" +
                "This app has been designed by <br />" +
                "<b>" +
                R.string.developers +
                "</b><br />" +
                "Under the supervision of" +
                "<b>Bamutura</b>" +
                "</i>" +
                ""));
    }
}
