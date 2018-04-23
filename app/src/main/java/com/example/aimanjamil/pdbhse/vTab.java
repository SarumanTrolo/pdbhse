package com.example.aimanjamil.pdbhse;
import android.graphics.Color;
import android.util.Log;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.signature.StringSignature;

import org.w3c.dom.Text;

public class vTab extends Fragment {View myView;
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
    myView = inflater.inflate(MainActivity.TAB, container, false);

    if (MainActivity.t==1||MainActivity.t==4||MainActivity.t==2){}else if (MainActivity.t==444){

    }else if (MainActivity.t==3){
        ListView simpleList;
        String countryList[] = {"India", "China", "australia", "Portugle", "America", "NewZealand", "dasd", "China", "australia", "Portugle", "America", "NewZealand", "China", "australia", "Portugle", "America", "NewZealand"};
        String countryList1[] = {"ongoing1", "ongoing2", "ongoing3", "ongoing4"};
        String countryList2[] = {"completed1", "completed2", "completed3", "completed4"};
        TabHost host = (TabHost) myView.findViewById(R.id.activity_friends_tab);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Tab");
        spec.setContent(R.id.tab1);
        spec.setIndicator("NEW");
        host.addTab(spec);
        simpleList = (ListView)myView.findViewById(R.id.simpleListView);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), R.layout.activity_listview, R.id.txtv, countryList);
        simpleList.setAdapter(arrayAdapter);
        simpleList = (ListView)myView.findViewById(R.id.simpleListView1);
        ArrayAdapter arrayAdapter1 = new ArrayAdapter(getActivity(), R.layout.activity_listview, R.id.txtv, countryList1);
        simpleList.setAdapter(arrayAdapter1);
        simpleList = (ListView)myView.findViewById(R.id.simpleListView2);
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(getActivity(), R.layout.activity_listview, R.id.txtv, countryList2);
        simpleList.setAdapter(arrayAdapter2);
        //Tab 2
        spec = host.newTabSpec("Tab");
        spec.setContent(R.id.tab2);
        spec.setIndicator("IN PROGRESS");
        host.addTab(spec);
        //Tab 3
        spec = host.newTabSpec("Tab");
        spec.setContent(R.id.tab3);
        spec.setIndicator("COMPLETED");
        host.addTab(spec);

    }else{
        TextView textView = (TextView)myView.findViewById(R.id.textView);textView.setText(MainActivity.TITLE);
        final ProgressBar progressBar = (ProgressBar) myView.findViewById(R.id.progressBar);
        Glide.with(getActivity().getApplicationContext()).load(MainActivity.TABLE).override(1080, Target.SIZE_ORIGINAL)//MAXIMUM 1080x15000
        .listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {progressBar.setVisibility(View.GONE);return false;}
            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {progressBar.setVisibility(View.GONE);return false;}})
                //.signature DISABLE IMAGE CACHE, IMAGE WILL RELOAD EACH TIME TAKING UP SPACE AND QUOTA, DISABLE TO SAVE SPACE & QUOTA USER MUST MANUALLY CLEAR APP  CACHE
                //.signature(new StringSignature(String.valueOf(System.currentTimeMillis())))
                .into((ImageView) myView.findViewById(R.id.imageView));





//            int inputValidate=0;
//            String[] e = new String[17];for(int i = 2; i < e.length; i++){
//                int res = this.getResources().getIdentifier("editTextName"+i, "id", getActivity().getApplicationContext().getPackageName());
//                EditText edit = (EditText) myView.findViewById(res);
//            Toast.makeText(getActivity().getApplicationContext(), "dasd"+edit, Toast.LENGTH_SHORT).show();}
//            e[i]=edit.getText().toString();
//                if (edit.isFocused()==true){edit.setBackgroundColor(Color.RED);}


//        if (e[2].equalsIgnoreCase("Contractor")){
//            TextView from = (TextView) myView.findViewById(R.id.comp);
//            from.setText("Company:");
//        }

//            String[] s = new String[34];for(int i = 1; i < s.length; i++){
//                int res = this.getResources().getIdentifier("spinnerFeedbackType"+i, "id", getActivity().getApplicationContext().getPackageName());
//                Spinner spin = (Spinner) myView.findViewById(res);
//            s[i]=spin.getSelectedItem().toString();
//            if (spin.isFocused()==true){spin.setBackgroundColor(Color.RED);}





    //Toast.makeText(getActivity().getApplicationContext(), "dasd"+MainActivity.t+MainActivity.i+MainActivity.TABLE, Toast.LENGTH_SHORT).show();
    }
    return myView;}}





//HOWTOLOG String iii=String.valueOf(backgroundTask);Log.d("somethingtofilter", iii);
//TAB1
//    public void ClickC(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        ImageButton mButton = getView().findViewById(R.id.imageButton1);
//        mButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                myFancyMethod(v);
//            }
//        });
//    }

//    ImageButton playPause=(ImageButton)getView().findViewById(R.id.imageButton1);
//    playPause.setOnClickListener(new View.OnClickListener(){
//        public void onClick(View v) {
//            Intent intent=new Intent(MainActivity.this,target.class);
//            startActivity(intent);
//        }
//    }
//    public void sendMessage(View view)
//    {
//        playPause =
//        startActivity(new Intent(Tab1.this.getActivity(), Tab4.class));
//    }
//Declare it here if you wanna use it in all other places in the class or outside of your class

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        playPause = (ImageButton)getView().findViewById(R.id.imageButton1);
//
//        playPause.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View view) {
//                startActivity(new Intent(, Tab3.class));
//            }
//        });
//    }
//TAB3
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }