package com.example.studentcheckin;

import java.util.ArrayList;
import java.util.List;

import com.example.mynewapp.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Spinner spinner1, spinner2, spinner3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// Restore any saved state
		super.onCreate(savedInstanceState);

		// Set content view
		setContentView(R.layout.activity_main);

		// Initialize UI elements
		TextView fName = (TextView) findViewById(R.id.resultText);
		TextView lName = (TextView) findViewById(R.id.textView1);
		EditText edit1 = (EditText) findViewById(R.id.editText1);
		EditText edit2 = (EditText) findViewById(R.id.editText2);

		addItemsOnSpinner2();
		addItemsOnSpinner3();
		//addListenerOnButton();
		addListenerOnSpinnerItemSelection();
		// set UI element to action in code
		lName.getText();
		fName.getText();
		// System.out.println("Richa" + s1);

	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// add items into spinner dynamically
	public void addItemsOnSpinner2() {

		spinner2 = (Spinner) findViewById(R.id.spinner2);
		List<String> list = new ArrayList<String>();
		list.add("Freshman");
		list.add("Sophomore");
		list.add("Junior");
		list.add("Senior");
		list.add("Graduate");
		list.add("Other");
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner2.setAdapter(dataAdapter);
	}
	public void addItemsOnSpinner3() {

		spinner3 = (Spinner) findViewById(R.id.spinner3);
		List<String> list = new ArrayList<String>();
		list.add("Meet My Advisor");
		list.add("I-20");
		list.add("OPT");
		list.add("CPT");
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner3.setAdapter(dataAdapter);
	}

	public void addListenerOnSpinnerItemSelection() {
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
	}

}
