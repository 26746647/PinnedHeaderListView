package za.co.immedia.pinnedheaderlistviewexample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import za.co.immedia.pinnedheaderlistview.SectionedBaseAdapter;

public class TestSectionedAdapter extends SectionedBaseAdapter {
	
	
	
	private ArrayList stringtitle = new ArrayList<String>();
	
	private ArrayList stringitem = new ArrayList<String>();
	
	private HashMap titleitemcount = new HashMap<String, Integer>();
	
	private HashMap titleitemposition = new HashMap<String, Integer>();

    @Override
    public Object getItem(int section, int position) {
        // TODO Auto-generated method stub
    	
    	String titlestring= stringtitle.get(section).toString();
    	int count = Integer.parseInt(titleitemcount.get(titlestring).toString());
        return stringitem.get(count+section);
    }

    @Override
    public long getItemId(int section, int position) {
        // TODO Auto-generated method stub
    	String titlestring= stringtitle.get(section).toString();
    	int count = Integer.parseInt(titleitemcount.get(titlestring).toString());
        return count+section;
    }

    @Override
    public int getSectionCount() {
        return stringtitle.size();
    }

    @Override
    public int getCountForSection(int section) {
    	
    	String titlestring= stringtitle.get(section).toString();
    	Log.d("TestSectionedAdapter ", "getCountForSection =" +titlestring);
    	int count = Integer.parseInt(titleitemcount.get(titlestring).toString());
        return count;
    }

    @Override
    public View getItemView(int section, int position, View convertView, ViewGroup parent) {
        LinearLayout layout = null;
        if (convertView == null) {
            LayoutInflater inflator = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = (LinearLayout) inflator.inflate(R.layout.list_item, null);
        } else {
            layout = (LinearLayout) convertView;
        }
        
        String titlestring= stringtitle.get(section).toString();

        int count = Integer.parseInt(titleitemposition.get(titlestring).toString());
        Log.d( "TestSectionedAdapter ", "title =" +titlestring + "start= "+titleitemposition.get(titlestring).toString()+"p="+(count+position));
        
        String itemstring=  stringitem.get(count+position).toString();
       
        ((TextView) layout.findViewById(R.id.textItem)).setText(" " + titlestring + " Item =" + itemstring);
        return layout;
    }

    @Override
    public View getSectionHeaderView(int section, View convertView, ViewGroup parent) {
        LinearLayout layout = null;
        if (convertView == null) {
            LayoutInflater inflator = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = (LinearLayout) inflator.inflate(R.layout.header_item, null);
        } else {
            layout = (LinearLayout) convertView;
        }
        String titlestring= stringtitle.get(section).toString();
        ((TextView) layout.findViewById(R.id.textItem)).setText("Header for section " + titlestring);
        return layout;
    }

	public ArrayList getStringtitle() {
		return stringtitle;
	}

	public void setStringtitle(ArrayList stringtitle) {
		this.stringtitle = stringtitle;
	}

	public ArrayList getStringitem() {
		return stringitem;
	}

	public void setStringitem(ArrayList stringitem) {
		this.stringitem = stringitem;
	}

	public HashMap getTitleitemcount() {
		return titleitemcount;
	}

	public void setTitleitemcount(HashMap titleitemcount) {
		this.titleitemcount = titleitemcount;
	}

	public HashMap getTitleitemposition() {
		return titleitemposition;
	}

	public void setTitleitemposition(HashMap titleitemposition) {
		this.titleitemposition = titleitemposition;
	}



    
    
    
    
}
