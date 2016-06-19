package mx.com.idmexico.vvazquez.interfaces.Fragmentos;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import mx.com.idmexico.vvazquez.interfaces.R;

/**
 * Created by sistemas on 17/06/2016.
 */
public class FragmentProfile extends Fragment {
    private ImageView imageUser;

    public static FragmentProfile newFragmentProfile(String userName)
    {
        FragmentProfile userProfile = new FragmentProfile();
        Bundle bundle = new Bundle();
        bundle.putString("user_name_key",userName);
        userProfile.setArguments(bundle);
        return userProfile;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_view,container,false);
        imageUser = (ImageView) view.findViewById(R.id.imageUserProfile);
        EditText txtusername = (EditText) view.findViewById(R.id.txtUserName);
        Bundle bundle=getArguments();
        String userName= bundle!=null? bundle.getString("user_name_key"):"?";
        txtusername.setText(userName);
        setUserImage(userName);
        return view;
    }

    public void setUserImage(String userName) {
        String iniStr = userName.substring(0,1).toUpperCase();
        Pattern p = Pattern.compile("[A-M]");
        Matcher m = p.matcher(iniStr);
        if (m.matches())
            imageUser.setImageResource(R.drawable.ic_blue_boy_face);
        else
            imageUser.setImageResource(R.drawable.ic_green_boy_face);
    }
}
