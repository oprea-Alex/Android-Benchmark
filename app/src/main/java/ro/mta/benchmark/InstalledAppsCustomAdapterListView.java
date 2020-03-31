package ro.mta.benchmark;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class InstalledAppsCustomAdapterListView extends BaseAdapter {

    Activity activity;
     List<InstalledAppsModel> installedAppsModelList;
    LayoutInflater inflater;

    public InstalledAppsCustomAdapterListView(Activity activity) {
        this.activity = activity;
    }

    public InstalledAppsCustomAdapterListView(Activity activity, List<InstalledAppsModel> installedAppsModelList) {
        this.activity = activity;
        this.installedAppsModelList = installedAppsModelList;

        inflater = activity.getLayoutInflater();
    }

    @Override
    public int getCount(){
        return installedAppsModelList.size();
    }

    @Override
    public Object getItem(int index){
        return index;
    }

    @Override
    public long getItemId(int index){
        return index;
    }

    @Override
    public View getView(int index, View view, ViewGroup viewGroup){

        ViewHolder viewHolder = null;
        if(view == null){
            view = inflater.inflate(R.layout.installed_apps_listview_item,viewGroup,false);
            viewHolder = new ViewHolder();
            viewHolder.appNameTV = view.findViewById(R.id.appNameTV);
            viewHolder.checBoxIV = view.findViewById(R.id.checkboxIV);
        }
        return view;
    }

    class ViewHolder{

        TextView appNameTV;
        ImageView checBoxIV;
    }

}
