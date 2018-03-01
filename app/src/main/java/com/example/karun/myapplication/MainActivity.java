package com.example.karun.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TextWatcher {

    private ContactsAdapter contactsAdapter;
    private ArrayList<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
    }

    private void setupViews(){
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));



        contacts=new ArrayList<>();

        Contact contact=new Contact();
        contact.setFirstName("Karun");
        contact.setLastName("Kumar");
        contacts.add(contact);

        contact=new Contact();
        contact.setFirstName("Saman");
        contact.setLastName("PourAskari");
        contacts.add(contact);

        contact=new Contact();
        contact.setFirstName("Saeed");
        contact.setLastName("Shokat");
        contacts.add(contact);

        contact=new Contact();
        contact.setFirstName("Maryam");
        contact.setLastName("HamidNezhad");
        contacts.add(contact);

        contact=new Contact();
        contact.setFirstName("Sara");
        contact.setLastName("Ahmadi");
        contacts.add(contact);

        contact=new Contact();
        contact.setFirstName("Fateme");
        contact.setLastName("Eshraghi");
        contacts.add(contact);

        contact=new Contact();
        contact.setFirstName("Pouya");
        contact.setLastName("Ahmadi");
        contacts.add(contact);








        contactsAdapter=new ContactsAdapter(this,contacts);
        recyclerView.setAdapter(contactsAdapter);

        EditText editText=(EditText)findViewById(R.id.editText_main_search);
        editText.addTextChangedListener(this);
    }




    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        contactsAdapter.filter(charSequence.toString());
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

}
