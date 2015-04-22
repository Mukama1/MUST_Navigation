package com.example.mukama.must_navigation;

import java.util.ArrayList;


import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


public class MainMenu extends Activity implements AdapterView.OnItemClickListener {
	GridView gridView;
	ArrayList<Item> gridArray = new ArrayList<Item>();
	 CustomGridViewAdapter customGridAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_must);
		
		//set grid view item
		Bitmap officeIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.office_icon);
		Bitmap lectureRmIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.lecture_rm2);
        Bitmap DptIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.departments);
        Bitmap hostelIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.hostel);
        Bitmap rubbishIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.rubbish_pits);
        Bitmap toiletIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.toilet);
        Bitmap canteenIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.canteen);
        Bitmap churchIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.churches);
        Bitmap helpIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.help);
        Bitmap othersIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.others);
		
		gridArray.add(new Item(officeIcon,"Offices"));
		gridArray.add(new Item(DptIcon,"Dep't"));
		gridArray.add(new Item(hostelIcon,"Hostels"));
		gridArray.add(new Item(lectureRmIcon,"Lecture Rms"));
		gridArray.add(new Item(rubbishIcon,"Rubbish pits"));
		gridArray.add(new Item(toiletIcon,"Toilets"));
		gridArray.add(new Item(canteenIcon,"Canteens"));
		gridArray.add(new Item(churchIcon,"Church"));
		gridArray.add(new Item(othersIcon,"Others"));
		gridArray.add(new Item(helpIcon,"Help"));
		
		
		gridView = (GridView) findViewById(R.id.gridView1);
		customGridAdapter = new CustomGridViewAdapter(this, R.layout.row_grid, gridArray);
		gridView.setAdapter(customGridAdapter);
       gridView.setOnItemClickListener(this);
	}

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=null;
        switch(position){

        case 0:
            intent=new Intent(getApplicationContext(),MapsActivity.class);
            intent.putExtra("List_Name","Offices");
            startActivity(intent);
        break;

        case 1:
            intent=new Intent(getApplicationContext(),MapsActivity.class);
            intent.putExtra("List_Name","Faculties");
            startActivity(intent);
        break;

        case 2:
            intent=new Intent(getApplicationContext(),MapsActivity.class);
            intent.putExtra("List_Name","Hostels");
            startActivity(intent);

        break;
        case 3:
            intent=new Intent(getApplicationContext(),MapsActivity.class);
            intent.putExtra("List_Name","Lectures");
            startActivity(intent);

            break;

        case 4:
            intent=new Intent(getApplicationContext(),MapsActivity.class);
            intent.putExtra("List_Name","Rubbish");
            startActivity(intent);
            break;

        case 5:
            intent=new Intent(getApplicationContext(),MapsActivity.class);
            intent.putExtra("List_Name","Toilets");
            startActivity(intent);
            break;

        case 6:
            intent=new Intent(getApplicationContext(),MapsActivity.class);
            intent.putExtra("List_Name","MUST Canteens");
            startActivity(intent);
            break;

        case 7:
            intent=new Intent(getApplicationContext(),MapsActivity.class);
            intent.putExtra("List_Name","Churches");
            startActivity(intent);
            break;

        case 8:
            intent=new Intent(getApplicationContext(),MapsActivity.class);
            intent.putExtra("List_Name","Others");
            startActivity(intent);
            break;

        case 9:
            intent=new Intent(getApplicationContext(),Help.class);
            startActivity(intent);
            break;
        }
    }
}
