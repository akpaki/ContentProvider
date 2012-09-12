package com.ingeniousafrica.android.contact;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.provider.Contacts.PeopleColumns;

import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class Main extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
       //Utilisation du curseur pour demander au Contentresolver de recuperer les gens du telephone
        Cursor lC = getContentResolver().query(People.CONTENT_URI, null, null, null, null);
        startManagingCursor(lC);
        //recuperation de notre ListView
        ListView lList = ((ListView) this.findViewById(R.id.activity_main_listView1));
        //Instancions un simple adapteur qui prend le contexte,le layout integre du systeme android  et le curseur en parametre
        SimpleCursorAdapter lAdapter = new SimpleCursorAdapter(this, 
                android.R.layout.simple_list_item_2,
                lC, 
                
                //Liste des champs a recuperer
                new String[] {People.NAME, People.NUMBER} ,
                
                //La ou on doit mettre les infos recuperer
                new int[] {android.R.id.text1,android.R.id.text2}); 
        
        //Fournissons l adapteur a notre ListView
        lList.setAdapter(lAdapter);
        
    }
}