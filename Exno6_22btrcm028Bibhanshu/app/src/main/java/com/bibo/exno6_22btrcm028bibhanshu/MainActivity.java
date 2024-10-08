package com.bibo.exno6_22btrcm028bibhanshu;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends Activity
{
    EditText et1;
    Button b;
    TextView tv;
    NodeList children;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
// TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.editText1);
        b= (Button) findViewById(R.id.button1);
        tv = (TextView) findViewById(R.id.textView3);
        String xml = ParseXMLMethods.getXML();
        Document doc = ParseXMLMethods.XMLfromString(xml);
        children = doc.getElementsByTagName("city");
        b.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
// TODO Auto-generated method stub
                String city = et1.getText().toString();
                for (int i = 0; i < children.getLength(); i++) {
                    Element e = (Element) children.item(i);
                    String id = ParseXMLMethods.getValue(e, "id");
                    String name = ParseXMLMethods.getValue(e,"name");
                    if(name.equals(city))
                    {
                        tv.setText(id+ " Celsius");
                    }
                }
            }
        });
    }
}
