package com.example.wael.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;
import it.neokree.materialnavigationdrawer.elements.MaterialAccount;
import it.neokree.materialnavigationdrawer.elements.MaterialSection;
import it.neokree.materialnavigationdrawer.elements.listeners.MaterialAccountListener;
import it.neokree.materialnavigationdrawer.elements.listeners.MaterialSectionListener;

/**
 * Created by Wael on 05/08/2015.
 */
public class MyNavigationDrawer extends MaterialNavigationDrawer {
    @Override
    public void init(Bundle bundle) {
        this.disableLearningPattern();
        setBackPattern(MaterialNavigationDrawer.BACKPATTERN_BACK_TO_FIRST);
        this.addSubheader("Sections :");
        MaterialSection section3 = newSection("Section 3", new section3Fragment());

        MaterialSection section1 = newSection("Section 1", new Intent(this, section1.class));

        MaterialSection section2 = newSection("Section 2", new Intent(this, section2.class));


        this.addDivisor();
        MaterialAccount account = new MaterialAccount(this.getResources(),"Ouni Wael","waelounie@gmail.com",R.drawable.ic_arrow_drop_down_white_24dp, R.drawable.abc_btn_default_mtrl_shape);
        this.addAccount(account);
        this.addSubheader("Guide :");
        MaterialSection help = newSection("Help", new Intent(this, help.class));

        addSection(section3);
        addSection(section1);
        addSection(section2);
        addBottomSection(help);

        section1.setSectionColor(Color.red(55), 55);
        section2.setSectionColor(Color.blue(55), 15);
        section3.setSectionColor(Color.green(15), 25);
        help.setSectionColor(Color.GRAY, 15);
        int number = 4;
        section1.setNotifications(number);
        section2.setNotifications(2);

        final int notifications = section1.getNotifications();

        this.setAccountListener(new MaterialAccountListener() {
            @Override
            public void onAccountOpening(MaterialAccount materialAccount) {
                Toast.makeText(getApplicationContext(), "You can't change  this account "+ notifications,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onChangeAccount(MaterialAccount materialAccount) {

            }
        });


        section1.setOnClickListener(new MaterialSectionListener() {
            @Override
            public void onClick(MaterialSection materialSection) {
                Toast.makeText(getApplicationContext(), "looooooooooooool " +notifications , Toast.LENGTH_LONG).show();
            }
        });
    }
}
