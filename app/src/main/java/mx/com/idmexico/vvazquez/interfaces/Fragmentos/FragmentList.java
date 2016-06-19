package mx.com.idmexico.vvazquez.interfaces.Fragmentos;

import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mx.com.idmexico.vvazquez.interfaces.Detail;
import mx.com.idmexico.vvazquez.interfaces.DetailedActivity;
import mx.com.idmexico.vvazquez.interfaces.Modelos.ModelItem;
import mx.com.idmexico.vvazquez.interfaces.R;

/**
 * Created by sistemas on 17/06/2016.
 */
public class FragmentList extends Fragment  {

    private List<String> list = new ArrayList<>();
    private ListView listView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_view,container,false);
        listView = (ListView) view.findViewById(R.id.itemList);
       //List<ModelItem> modelItemList = itemDataSource.getAllItems();
       // listView.setAdapter(new AdapterItemList(getActivity(),modelItemList));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter adapter= (ArrayAdapter) parent.getAdapter();
                String item = (String) adapter.getItem(position);
                Toast.makeText(getActivity(),item,Toast.LENGTH_SHORT).show();
                //Intent intent= new Intent(getActivity() , Detail.class);
                //intent.putExtra("user_name_key",item);
                //startActivity(intent);
                getFragmentManager().beginTransaction().replace(R.id.Contenedor, FragmentProfile.newFragmentProfile(item)).addToBackStack("FragmentList").commit();
            }
        });

        final EditText eItemText = (EditText) view.findViewById(R.id.txtItem);
        view.findViewById(R.id.btnAddItem).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String itemText = eItemText.getText().toString();
                if(!TextUtils.isEmpty(itemText))
                {
                    String[] item = {itemText};
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, item);
                    listView.setAdapter(adapter);
                    eItemText.setText("");
                }


            }
        });

                return view;
    }



}
