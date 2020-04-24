package com.inihood.draw.android;

import java.util.ArrayList;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends Activity {

	private static final int REQUEST_WRITE_STORAGE_REQUEST_CODE = 0;
	ListView lsvmain;
	ArrayList<List_Item> ListArray = new ArrayList<List_Item>();
	List_Adapter listadapter;
	String[] title,description;
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
 		setContentView(R.layout.activity_main);
		requestAppPermissions();

		title= getResources().getStringArray(R.array.names);
		description= getResources().getStringArray(R.array.descriptions);

		lsvmain=(ListView)findViewById(R.id.listView_main);

		for(int i=0; i<title.length;i++)
		{
			List_Item item=new List_Item(description[i], title[i],Image_Arrays.icons[i]);
			ListArray.add(item);
		}

		listadapter = new List_Adapter(this, R.layout.list_item,ListArray);
		lsvmain.setAdapter(listadapter);

		lsvmain.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
 				//Toast.makeText(getApplicationContext(), ""+position, Toast.LENGTH_SHORT).show();
 				if(position==0)
				{
				Intent intentnew=new Intent(getApplicationContext(),Drawing_Activity.class);
				intentnew.putExtra("Image_Array", "image_car");
				startActivity(intentnew);
				}
				else if(position==1)
				{
				Intent intentnew=new Intent(getApplicationContext(),Drawing_Activity.class);
				intentnew.putExtra("Image_Array", "image_house");
				startActivity(intentnew);
				}
				else if(position==2)
				{
				Intent intentnew=new Intent(getApplicationContext(),Drawing_Activity.class);
				intentnew.putExtra("Image_Array", "image_spider");
				startActivity(intentnew);
				}
				else if(position==3)
				{
				Intent intentnew=new Intent(getApplicationContext(),Drawing_Activity.class);
				intentnew.putExtra("Image_Array", "image_gun");
				startActivity(intentnew);
				}
				else if(position==4)
				{
				Intent intentnew=new Intent(getApplicationContext(),Drawing_Activity.class);
				intentnew.putExtra("Image_Array", "image_boat");
				startActivity(intentnew);
				}
				else if(position==5)
				{
				Intent intentnew=new Intent(getApplicationContext(),Drawing_Activity.class);
				intentnew.putExtra("Image_Array", "image_bird");
				startActivity(intentnew);
				}
				else if(position==6)
				{
				Intent intentnew=new Intent(getApplicationContext(),Drawing_Activity.class);
				intentnew.putExtra("Image_Array", "image_elephant");
				startActivity(intentnew);
				}
				else if(position==7)
				{
				Intent intentnew=new Intent(getApplicationContext(),Drawing_Activity.class);
				intentnew.putExtra("Image_Array", "image_flower");
				startActivity(intentnew);
				}
				else if(position==8)
				{
				Intent intentnew=new Intent(getApplicationContext(),Drawing_Activity.class);
				intentnew.putExtra("Image_Array", "image_frog");
				startActivity(intentnew);
				}
				else if(position==9)
				{
				Intent intentnew=new Intent(getApplicationContext(),Drawing_Activity.class);
				intentnew.putExtra("Image_Array", "image_horse");
				startActivity(intentnew);
				}
				else if(position==10)
				{
				Intent intentnew=new Intent(getApplicationContext(),Drawing_Activity.class);
				intentnew.putExtra("Image_Array", "image_lion");
				startActivity(intentnew);
				}
				else if(position==11)
				{
				Intent intentnew=new Intent(getApplicationContext(),Drawing_Activity.class);
				intentnew.putExtra("Image_Array", "image_mickey_mouse");
				startActivity(intentnew);
				}
				else if(position==12)
				{
				Intent intentnew=new Intent(getApplicationContext(),Drawing_Activity.class);
				intentnew.putExtra("Image_Array", "image_dog");
				startActivity(intentnew);
				}
				else if(position==13)
				{
				Intent intentnew=new Intent(getApplicationContext(),Drawing_Activity.class);
				intentnew.putExtra("Image_Array", "image_turtle");
				startActivity(intentnew);
				}
				else if(position==14)
				{
				Intent intentnew=new Intent(getApplicationContext(),Drawing_Activity.class);
				intentnew.putExtra("Image_Array", "image_princess");
				startActivity(intentnew);
				}

			}
		});
	}

	@Override
	protected void onStart() {
		super.onStart();
		requestAppPermissions();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void requestAppPermissions() {
		if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
			return;
		}

		if (hasReadPermissions() && hasWritePermissions()) {
			return;
		}

		ActivityCompat.requestPermissions(this,
				new String[] {
						Manifest.permission.READ_EXTERNAL_STORAGE,
						Manifest.permission.WRITE_EXTERNAL_STORAGE
				}, REQUEST_WRITE_STORAGE_REQUEST_CODE); // your request code
	}

	private boolean hasReadPermissions() {
		return (ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
	}

	private boolean hasWritePermissions() {
		return (ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
	}
}
 