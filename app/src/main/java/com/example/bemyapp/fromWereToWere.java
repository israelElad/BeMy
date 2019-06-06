package com.example.bemyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

public class fromWereToWere extends AppCompatActivity {
    private AppCompatAutoCompleteTextView autoTextView;
    private static final String[] COUNTRIES = new String[]{
            "Lod","Tel Aviv","Jerusalem","Kfar Saba","Or Yehuda","Azor","Bat Yam","Ramat Gan","Holon","Ashdod","Beersheba","Yehud","Rishon LeZion","Hazav","Ness Ziona","Eilat","Rehovot","Herzliya","Nahariya","Haifa","Shave Ziyyon","Ramat HaSharon","Ramat Poleg","Kadima","Karmi'el","Pardesiyya","Netanya","Gan Yavne","Petah Tikwah","Ashqelon","Savyon","Naham","Mazkeret Batya","`Arugot","Ofaqim","Shetulim","Hadera","Qiryat Bialik","Tel Mond","Hod HaSharon","Qiryat Yam","Shelomi","Binyamina","Liman","`Alma","Ramla","Nazareth","Et Taiyiba","Rinnatya","Yavne","Acre","Nazerat `Illit","Baraq","Even Yehuda","Nesher","Pardes Hanna Karkur","Netivot","Tirat Karmel","Or `Aqiva","Kefar Yona","Bet Oren","Haluz","Biriyya","Gan Hayyim","Qiryat Tiv`on","Qiryat Gat","Be'er Toviyya","`En Ayyala","Misgav Regional Council","Safed","Gedera","Dimona","Bet Shemesh","`En HaShelosha","Herut","Mazor","Shamir","Ra'anana","Bat Hadar","Rosh Ha'Ayin","Zoran","Tirat Yehuda","Bareqet","Elyakhin","Hadid","Hadar Ramatayim","Modiin","Hazor Ashdod","Kefar Daniyyel","Newe Efrayim","Talme Menashe","Kefar Netter","Mazliah","Moran","Shoval","Ramat Aviv","Afiqim","Ramat Dawid","Sde Warburg","Magen","Karkur","Qiryat Ata","Maghar","Bet Alfa","Timrat","Elyaqim","Bet Dagan","Ginnosar","Qiryat Mal'akhi","Hadar `Am","maalot Tarshiha","Ahituv","Qiryat Motzkin","Migdal","Bat Hefer","Ben Shemen-Kefar Hano`ar","Emunim","Tiberias","Mikhmoret","Hever","Ramat Yishay","Sderot","Gimzo","Mesillat Ziyyon","Pasuta","Bet She'an","Newe Yamin","Nordiyya","HaKarmel","Gibbeton","Qiryat Ono","Sarid","Nir Zevi","Ramat Ef`al","Bene Ziyyon","Hurfeish","Shefayim","Dabburiya","Rishpon","Mizpe Netofa","Sde Boker","Yaqum","Bahan","Jaffa","Allonim","`Evron","Hazor HaGelilit","Ramot Naftali","Giv`at Hayyim","Urim","Sedot Yam","`Aseret","Nirim","`Amir","Ganne Tiqwa","Ma`agan Mikha'el","Qiryat Hayyim","Kefar Witqin"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_were_to_were);

        autoTextView = (AppCompatAutoCompleteTextView) findViewById(R.id.location);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, COUNTRIES);
        autoTextView.setThreshold(1); //will start working from first character
        autoTextView.setAdapter(adapter);
    }

    public void Click(View view)
    {
        String beMyWhat=getIntent().getStringExtra("BeMy");
        AppCompatAutoCompleteTextView appCompatAutoCompleteTextView = (AppCompatAutoCompleteTextView) findViewById(R.id.location);
        String location =  appCompatAutoCompleteTextView.getText().toString();
        Intent intent = new Intent(fromWereToWere.this, search.class);
        intent.putExtra("BeMy",beMyWhat);
        intent.putExtra("location",location);
        startActivity(intent);
    }
}
