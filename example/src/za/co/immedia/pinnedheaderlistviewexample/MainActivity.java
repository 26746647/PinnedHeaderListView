package za.co.immedia.pinnedheaderlistviewexample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import za.co.immedia.pinnedheaderlistview.PinnedHeaderListView;
import za.co.immedia.pinnedheaderlistview.PinnedHeaderListView.OnItemClickListener;

public class MainActivity extends Activity {
	
	//分组标题list
	private ArrayList stringtitle=new ArrayList<String>();
	//所有数据的list
	private ArrayList stringitem = new ArrayList<String>();
	//每个分组的count总数   key为 分组标题  value为该分组的总数
	private HashMap titleitemcount = new HashMap<String, Integer>();
	// 分组所在索引位置     key为 分组标题  value该分组的起始位置  在adapter中+上位置信息即可获取item对象
	private HashMap titleitemposition = new HashMap<String, Integer>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        
        
        PinnedHeaderListView listView = (PinnedHeaderListView) findViewById(R.id.pinnedListView);
        LayoutInflater inflator = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        LinearLayout header1 = (LinearLayout) inflator.inflate(R.layout.list_item, null);
//        ((TextView) header1.findViewById(R.id.textItem)).setText("HEADER 1");
//        LinearLayout header2 = (LinearLayout) inflator.inflate(R.layout.list_item, null);
//        ((TextView) header2.findViewById(R.id.textItem)).setText("HEADER 2");
//        LinearLayout footer = (LinearLayout) inflator.inflate(R.layout.list_item, null);
//        ((TextView) footer.findViewById(R.id.textItem)).setText("FOOTER");
//        listView.addHeaderView(header1);
//        listView.addHeaderView(header2);
//        listView.addFooterView(footer);
        
        
        initdata();
        
        TestSectionedAdapter sectionedAdapter = new TestSectionedAdapter();
        
        sectionedAdapter.setStringitem(stringitem);
        sectionedAdapter.setStringtitle(stringtitle);
        sectionedAdapter.setTitleitemcount(titleitemcount);
        sectionedAdapter.setTitleitemposition(titleitemposition);
        
        
        listView.setAdapter(sectionedAdapter);
        
        
        listView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view,
					int section, int position, long id) {
				// TODO Auto-generated method stub
				
				
				
				
			}

			@Override
			public void onSectionClick(AdapterView<?> adapterView, View view,
					int section, long id) {
				// TODO Auto-generated method stub
				
			}});
        
        
    }
    
    
    
    private void initdata()
    {
    	for (int i = 1; i < 6; i++) {
    		stringtitle.add("分组"+i);
		    
    	}
    	

    	int temp = 0;
    	titleitemposition.put("分组1", temp);
    	ArrayList stringitem1 = new ArrayList<String>();
    	for (int i = 0; i < 4; i++) {
    		stringitem1.add("stringitem1="+i);
    		temp++;
		}
    	
    	titleitemposition.put("分组2", temp);
    	
    	ArrayList stringitem2 = new ArrayList<String>();
    	
    	for (int i = 0; i <1; i++) {
    		stringitem2.add("stringitem2="+i);
    		temp++;
		}
    	titleitemposition.put("分组3", temp);
    	
    	
    	ArrayList stringitem3 = new ArrayList<String>();
    	for (int i = 0; i < 2; i++) {
    		stringitem3.add("stringitem3="+i);
    		temp++;
		}
    	
    	titleitemposition.put("分组4", temp);
    	ArrayList stringitem4 = new ArrayList<String>();
    	for (int i = 0; i <2; i++) {
    		stringitem4.add("stringitem4="+i);
    		temp++;
		}
    	
    	titleitemposition.put("分组5", temp);
    	ArrayList stringitem5 = new ArrayList<String>();
    	for (int i = 0; i < 3; i++) {
    		stringitem5.add("stringitem5="+i);
    		temp++;
		}
    	
    	
    	stringitem.addAll(stringitem1);
    	titleitemcount.put("分组1", stringitem1.size());
    	
    	
    	
    	stringitem.addAll(stringitem2);
    	titleitemcount.put("分组2", stringitem2.size());
    	stringitem.addAll(stringitem3);
    	titleitemcount.put("分组3", stringitem3.size());
    	stringitem.addAll(stringitem4);
    	titleitemcount.put("分组4", stringitem4.size());
    	stringitem.addAll(stringitem5);
    	titleitemcount.put("分组5", stringitem5.size());
    	
    	
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
