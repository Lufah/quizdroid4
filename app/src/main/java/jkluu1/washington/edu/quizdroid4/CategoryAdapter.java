package jkluu1.washington.edu.quizdroid4;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by JenniferLuu on 3/5/15.
 */
public class CategoryAdapter extends ArrayAdapter<Category> {

    Context context;
    int layoutResourceId;
    Category data[] = null;

    public CategoryAdapter(Context context, int layoutResourceId, Category[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        CategoryHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new CategoryHolder();
            holder.icon = (ImageView) row.findViewById(R.id.icon);
            holder.sdesc = (TextView) row.findViewById(R.id.shortDescription);
            holder.title = (TextView) row.findViewById(R.id.title);

            row.setTag(holder);
        } else {
            holder = (CategoryHolder) row.getTag();
        }

        Category category = data[position];
        holder.title.setText(category.getTitle());
        holder.sdesc.setText(category.getSd());
        holder.icon.setImageResource(R.drawable.ic_launcher);

        return row;
    }

    static class CategoryHolder {
        ImageView icon;
        TextView sdesc;
        TextView title;
    }
}
