package hemanth.sunjanapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hemanth on 6/1/2016.
 */
public class Pantadapter extends ArrayAdapter {
    List list=new ArrayList();

    private Pantadapter(Context context,int resource)
    {
        super(context,resource);
    }
    public void add(Pant object)
    {
        list.add(object);
        super.add(object);
    }

    public int getCount()
    {
        return super.getCount();
    }

    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
