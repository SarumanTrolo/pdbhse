package com.example.aimanjamil.pdbhse;
import android.app.DatePickerDialog;
import android.app.FragmentManager;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import org.w3c.dom.Text;

import java.io.BufferedWriter;
import java.io.File;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FragmentManager fragmentManager = getFragmentManager();
//    RelativeLayout rl = (RelativeLayout)findViewById(R.id.content_frame);

///////////////////////////////////////////////////MANIPULATOR////////////////////////////////////////////////////////////////////////////
    //CONTENT FRAME MANIPULATOR
    public static int t=0;public static int TAB;public void lolo() {TAB = this.getResources().getIdentifier("tab"+t, "layout", this.getPackageName());}
    //IMAGEVIEW MANIPULATOR
    public static int i=0;public static String TABLE;public void table() {TABLE="https://pdb-hse.000webhostapp.com/t"+i+".png";}
    //TEXTVIEW MANIPULATOR
    public static String TITLE="";String statitle[] = {"Summary", "Fatality", "Loss Time Injury", "Total Recordable Case", "Loss of Primary Containment", "Fire", "Product Contamination", "Crime", "Transport Accident", "Terminal Incident", "Commuting Incident", "High Potential Near Miss"};
    public static String[] e;public static String[] s;
    ///////////////////////////////////////////////////MANIPULATOR////////////////////////////////////////////////////////////////////////////

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        rl.setBackgroundResource(R.drawable.pp);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        getSupportActionBar().setTitle("Performance Statistics");
        t=4;lolo();fragmentManager.beginTransaction().replace(R.id.content_frame, new vTab()).commit();//MANUAL JUMP*******************************MANUAL JUMP******
        /////////////////BSObservationCard DatePicker
        // initiate the date picker and a button

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

///////////////////////////////////////////////////////////////FRAGMENT SWITCHER//////////////////////////////////////////////////////////////////
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++Drawer Navigation+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {int id = item.getItemId();
//        rl.setBackgroundColor(Color.WHITE);
    if (id == R.id.nav_first_layout) {getSupportActionBar().setTitle("Performance Statistics");
        t=1;lolo();fragmentManager.beginTransaction().replace(R.id.content_frame, new vTab()).commit();}

    else if (id == R.id.nav_second_layout) {getSupportActionBar().setTitle("Asset");
        t=2;lolo();fragmentManager.beginTransaction().replace(R.id.content_frame, new vTab()).commit();}

    else if (id == R.id.nav_third_layout) {getSupportActionBar().setTitle("Inspection & Audit");
        t=3;lolo();fragmentManager.beginTransaction().replace(R.id.content_frame, new vTab()).commit();}

    else if (id == R.id.nav_fourth_layout_layout) {getSupportActionBar().setTitle("Behavioral Safety");
        t=4;lolo();fragmentManager.beginTransaction().replace(R.id.content_frame, new vTab()).commit();}

    else if (id == R.id.nav_share) {getSupportActionBar().setTitle("Incoming");}

    else if (id == R.id.nav_send) {getSupportActionBar().setTitle("Incoming2");}

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);drawer.closeDrawer(GravityCompat.START);return true;}

    //++++++++++++++++++++++++++++++++++++++++++++++++++++++Activity onClick Navigation+++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public void aleft(View v) {if (i==101){t=1;i=103;}else if(t==1){t=11;i=113;}else{}
    i=i-1;lolo();table();fragmentManager.beginTransaction().replace(R.id.content_frame, new vTab()).commit();TITLE=statitle[i-101];}
    public void aright(View v) {if (i==112){t=1;i=111;}else if(t==1){t=11;i=100;}else{}
    i=i+1;lolo();table();fragmentManager.beginTransaction().replace(R.id.content_frame, new vTab()).commit();TITLE=statitle[i-101];}
    public void tab101(View v) {t=11;lolo();i=101;table();fragmentManager.beginTransaction().replace(R.id.content_frame, new vTab()).commit();TITLE=statitle[0];}
    public void tab102(View v) {t=11;lolo();i=102;table();fragmentManager.beginTransaction().replace(R.id.content_frame, new vTab()).commit();TITLE=statitle[1];}
    public void tab103(View v) {t=11;lolo();i=103;table();fragmentManager.beginTransaction().replace(R.id.content_frame, new vTab()).commit();TITLE=statitle[2];}
    public void tab104(View v) {t=11;lolo();i=104;table();fragmentManager.beginTransaction().replace(R.id.content_frame, new vTab()).commit();TITLE=statitle[3];}
    public void tab105(View v) {t=11;lolo();i=105;table();fragmentManager.beginTransaction().replace(R.id.content_frame, new vTab()).commit();TITLE=statitle[4];}
    public void tab106(View v) {t=11;lolo();i=106;table();fragmentManager.beginTransaction().replace(R.id.content_frame, new vTab()).commit();TITLE=statitle[5];}
    public void tab107(View v) {t=11;lolo();i=107;table();fragmentManager.beginTransaction().replace(R.id.content_frame, new vTab()).commit();TITLE=statitle[6];}
    public void tab108(View v) {t=11;lolo();i=108;table();fragmentManager.beginTransaction().replace(R.id.content_frame, new vTab()).commit();TITLE=statitle[7];}
    public void tab109(View v) {t=11;lolo();i=109;table();fragmentManager.beginTransaction().replace(R.id.content_frame, new vTab()).commit();TITLE=statitle[8];}
    public void tab110(View v) {t=11;lolo();i=110;table();fragmentManager.beginTransaction().replace(R.id.content_frame, new vTab()).commit();TITLE=statitle[9];}
    public void tab111(View v) {t=11;lolo();i=111;table();fragmentManager.beginTransaction().replace(R.id.content_frame, new vTab()).commit();TITLE=statitle[10];}
    public void tab112(View v) {t=11;lolo();i=112;table();fragmentManager.beginTransaction().replace(R.id.content_frame, new vTab()).commit();TITLE=statitle[11];}
    public void tab41(View v) {t=41;lolo();i=41;table();fragmentManager.beginTransaction().replace(R.id.content_frame, new vTab()).commit();TITLE="Observer Particulars";
    getSupportActionBar().setTitle("BS Observation Card");
        }
///////////////////////////////////////////////////////////////FRAGMENT SWITCHER//////////////////////////////////////////////////////////////////




    //++++++++++++++++++++++++++++++++++++++++++++++++++++++Scroll To The Beningging+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void scrr(View v) {
        ScrollView scroll = (ScrollView) findViewById(R.id.scr);
        scroll.scrollTo(0, 0);
        scroll.pageScroll(View.FOCUS_UP);
        scroll.smoothScrollTo(0,0);
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++

    //++++++++++++++++++++++++++++++++++++++++++++++++++++++Double click to exit+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++

    //++++++++++++++++++++++++++++++++++++++++++++++++++++++BS Observation Card METHODS+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void submitForm(View view)
    {
        int inputValidate=0;

        //FOR ALL EDITTEXT
        e = new String[16];for(int i = 1; i < e.length; i++){
        int res = this.getResources().getIdentifier("editTextName"+i, "id", this.getPackageName());
        final EditText edit = (EditText) findViewById(res);
        e[i]=edit.getText().toString();
        //set background to red if blank input
//        if ((i>13 || i<8) && e[i].equalsIgnoreCase("")){inputValidate=1;edit.setBackgroundColor(Color.RED);}
        View.OnTouchListener Spinner_OnTouch = new View.OnTouchListener() {
        //set background back to normal when clicked
            public boolean onTouch(View v, MotionEvent event) {//setbackground programmatically cannot be used with andoid:background even including color/selectedorfocusedMUST USE onTouch
                if (event.getAction() == MotionEvent.ACTION_UP) {edit.setBackgroundDrawable(null);}
                return false;}};
        edit.setOnTouchListener(Spinner_OnTouch);
        //*setbackground programmatically cannot be used with andoid:background even including color/selectedorfocusedMUST USE onTouch
    }
        //FOR ALL SPINNER
        s = new String[34];for(int i = 1; i < s.length; i++){
        int res = this.getResources().getIdentifier("spinnerFeedbackType"+i, "id", this.getPackageName());
        final Spinner spin = (Spinner) findViewById(res);
        s[i]=spin.getSelectedItem().toString();
//        if (s[i].equalsIgnoreCase("Select")){inputValidate=1;spin.setBackgroundColor(Color.RED);}
        View.OnTouchListener Spinner_OnTouch = new View.OnTouchListener() {
            //set background back to normal when clicked
            public boolean onTouch(View v, MotionEvent event) {//setbackground programmatically cannot be used with andoid:background even including color/selectedorfocusedMUST USE onTouch
                if (event.getAction() == MotionEvent.ACTION_UP) {spin.setBackgroundDrawable(null);}
                return false;}};
        spin.setOnTouchListener(Spinner_OnTouch);
        //*setbackground programmatically cannot be used with andoid:background even including color/selectedorfocusedMUST USE onTouch
    }

        if (inputValidate==1){Toast.makeText(this, "Form not complete", Toast.LENGTH_SHORT).show();}
        else {
//            String data="0"+"UTF-8"+"="+"0"+"UTF-8";
//            for(int i = 1; i < MainActivity.e.length; i++){
//                data=data+"&"+String.valueOf(i)+"UTF-8"+"="+MainActivity.e[i]+"UTF-8";
//            }
//            for(int i = 1; i < MainActivity.s.length; i++){
//                data=data+"&"+String.valueOf(i+15)+"UTF-8"+"="+MainActivity.s[i]+"UTF-8";
//            }
//            Toast.makeText(this, data, Toast.LENGTH_LONG).show();
        BackgroundTask backgroundTask=new BackgroundTask(this);
        backgroundTask.execute("bssubmitForm");
        t=4;lolo();fragmentManager.beginTransaction().replace(R.id.content_frame, new vTab()).commit();
        }
    }
    //EDITEXT DATEPICKER
    public void datePicker(View view) {
        final EditText date = (EditText) findViewById(R.id.editTextName3);
        // calender class's instance and get current date , month and year from calender
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR); // current year
        int month = c.get(Calendar.MONTH); // current month
        int day = c.get(Calendar.DAY_OF_MONTH); // current day
        // date picker dialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // set day of month , month and year value in the edit text
                date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);}}, year, month, day);
        datePickerDialog.show();}
    //EDITEXT TIMEPICKER
    public void timePicker(View view) {
        final EditText time = (EditText) findViewById(R.id.editTextName4);
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                String am_pm = "";if (selectedHour>12){selectedHour=selectedHour-12;am_pm = "PM";}else {am_pm = "AM";}
                time.setText( "" + selectedHour + ":" + selectedMinute + am_pm);}}, hour, minute, false);
        timePickerDialog.show();}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++

//++++++++++++++++++++++++++++++++++++++++++++++++++++++Clear cache onDestroy+++++++++++++++++++++++++++++++++++++++++++++++++++++++++







}