package com.example.com.dchat.views;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.com.dchat.R;
import com.example.com.dchat.activities.BaseActivity;
import com.example.com.dchat.activities.ContactsActivity;
import com.example.com.dchat.activities.MainActivity;
import com.example.com.dchat.activities.ProfileActivity;
import com.example.com.dchat.activities.SentMessagesActivity;
import com.example.com.dchat.infrastructure.User;

public class MainNavDrawer extends NavDrawer {
    private final TextView displayNameText;
    private final ImageView avatarImage;

    public MainNavDrawer(final BaseActivity activity) {
        super(activity);

        addItem(new ActivityNavDrawerItem(MainActivity.class, "Inbox", null, R.drawable.ic_menu_white_24dp, R.id.include_main_nav_drawer_topItems));
        addItem(new ActivityNavDrawerItem(SentMessagesActivity.class, "Sent Messages", null, R.drawable.ic_menu_white_24dp, R.id.include_main_nav_drawer_topItems));
        addItem(new ActivityNavDrawerItem(ContactsActivity.class, "Contacts", null, R.drawable.ic_menu_white_24dp, R.id.include_main_nav_drawer_topItems));
        addItem(new ActivityNavDrawerItem(ProfileActivity.class, "Profile", null, R.drawable.ic_menu_white_24dp, R.id.include_main_nav_drawer_topItems));

        addItem(new BasicNavDrawerItem("Logout", null, R.drawable.ic_menu_white_24dp, R.id.include_main_nav_drawer_bottomItems){
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "YOu have logged out!", Toast.LENGTH_SHORT).show();
            }
        });

        displayNameText = (TextView) navDrawerView.findViewById(R.id.include_main_nav_drawer_displayName);
        avatarImage = (ImageView) navDrawerView.findViewById(R.id.include_main_nav_drawer_avatar);

        User loggedInUser = activity.getDChatApplication().getAuth().getUser();
        displayNameText.setText(loggedInUser.getDisplayName());

        //todo: change avatar image to avatarurl from loggedinUser
    }
}
