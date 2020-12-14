package com.dfg.citysymbolsapplications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listView);

        ArrayList<String> landmark=new ArrayList<>();

        landmark.add("Gobekli Tepe/TURKEY");
        landmark.add("Hagia Sophia/TURKEY");
        landmark.add("Pisa/ITALY");
        landmark.add("Eiffel/FRANCE");
        landmark.add("Colesseo/ITALY");
        landmark.add("London Bridge/UK");

        ArrayList<String> country=new ArrayList<>();
        country.add("Situated on a hilltop some 30 miles from the Turkish-Syrian border, Göbekli Tepe (a Turkish name meaning “potbelly hill”) consists of several dozen T-shaped pillars carved from limestone and arranged in circular enclosures reminiscent of England’s Stonehenge. The largest of the monoliths stand over 16 feet tall, and most are adorned with carvings of frightening creatures such as snakes, spiders, lions and scorpions. Archaeologists believe that Neolithic hunter-gatherers erected the monument in two phases between the 10th and 9th millennia B.C. The result was humanity’s earliest known construction project—an architectural wonder built by a people who had yet to discover pottery or metal tools.");
        country.add("The Hagia Sophia is an enormous architectural marvel in Istanbul, Turkey, that was originally built as a Christian basilica nearly 1,500 years ago. Much like the Eiffel Tower in Paris or the Parthenon in Athens, the Hagia Sophia is a long-enduring symbol of the cosmopolitan city. However, as notable as the structure is itself, its role in the history of Istanbul—and, for that matter, the world—is also significant and touches upon matters related to international politics, religion, art and architecture.");
        country.add("Pick any day in the Piazza del Duomo in the Italian city of Pisa, and you will undoubtedly spot a bunch of tourists posing for the same photo: hands outstretched towards the cathedral’s conspicuously tilting bell tower, as if they are supporting it with their sheer strength. The so-called Leaning Tower of Pisa is one of the most famous buildings in the world, although maybe not for the reasons its original architects would have wanted.");
        country.add("When Gustave Eiffel’s company built Paris’ most recognizable monument for the 1889 World’s Fair, many regarded the massive iron structure with skepticism. Today, the Eiffel Tower, which continues to serve an important role in television and radio broadcasts, is considered an architectural wonder and attracts more visitors than any other paid tourist");
        country.add("Located just east of the Roman Forum, the massive stone amphitheater known as the Colosseum was commissioned around A.D. 70-72 by Emperor Vespasian of the Flavian dynasty as a gift to the Roman people. In A.D. 80, Vespasian’s son Titus opened the Colosseum–officially known as the Flavian Amphitheater–with 100 days of games, including gladiatorial combats and wild animal fights. After four centuries of active use, the magnificent arena fell into neglect, and up until the 18th century it was used as a source of building materials. Though two-thirds of the original Colosseum has been destroyed over time, the amphitheater remains a popular tourist destination, as well as an iconic symbol of Rome and its long, tumultuous history.");
        country.add("In the early 1960s, officials in England made a troubling discovery: London Bridge was falling down. The 1,000-foot span had stood for over 130 years and survived strafing during World War II’s London Blitz, but it was unequipped for modern traffic and was slowly sinking into the River Thames at a rate of one inch every eight years. Renovations were deemed impractical, so the City of London resolved to build a wider, more car-friendly replacement. The 19th century granite bridge seemed destined for the junkyard, but a city councilor named Ivan Luckin convinced his colleagues that it might be possible to sell it in the United States. In 1968, he crossed the pond to market the monument to prospective buyers.");

        Bitmap gobekliTepe= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.gobeklitepe);
        Bitmap hagiaSophia= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.hagiasophia);
        Bitmap pisa= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.pisa);
        Bitmap eiffel= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.eiffel);
        Bitmap colesseo= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.colesseo);
        Bitmap londonBridge= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.londonbridge);

        ArrayList<Bitmap> landmarkImages=new ArrayList<>();

        landmarkImages.add(gobekliTepe);
        landmarkImages.add(hagiaSophia);
        landmarkImages.add(pisa);
        landmarkImages.add(eiffel);
        landmarkImages.add(colesseo);
        landmarkImages.add(londonBridge);

        ArrayAdapter arrayAdapter=new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,landmark);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),detailActivity.class);
                intent.putExtra("name",landmark.get(position));
                intent.putExtra("country",country.get(position));

                Singleton singleton=Singleton.getInstance();
                singleton.setChosenImage(landmarkImages.get(position));
                startActivity(intent);
            }
        });



    }
}