package com.noteshareapp.noteshare;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TermsAndConditionsActivity extends DrawerActivity {
	public LinearLayout layoutHeder;
	public ImageButton btnheaderMenu, btnsequence, btncalander;
	public LinearLayout layoutTitleHeaderview;
	public TextView h1,h2,h3,h4,h5,h6,h7,h8,h9,h10,h11;
	public TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13;
	public Activity activity;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LayoutInflater inflater = (LayoutInflater) this
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		// inflate your activity layout here!
		View contentView = inflater.inflate(R.layout.termsandconditions_activity, null,
				false);
		mDrawerLayout.addView(contentView, 0);
		activity = this;
		initlizeUIElement(contentView);

	}

	void initlizeUIElement(View contentView) {
		// mainHeadermenue
		layoutHeder = (LinearLayout) contentView
				.findViewById(R.id.actionBar);
		btnheaderMenu = (ImageButton) layoutHeder
				.findViewById(R.id.imageButtonHamburg);

		TextView tvTCHead = (TextView) contentView.findViewById(R.id.tvTCHead);
		tvTCHead.setTypeface(RegularFunctions.getAgendaBoldFont(this));

		/*btnsequence = (ImageButton) layoutHeder
				.findViewById(R.id.imageButtonsquence);
		btncalander = (ImageButton) layoutHeder
				.findViewById(R.id.imageButtoncalander);
		btncalander.setVisibility(View.GONE);
		btnsequence.setVisibility(View.GONE);

		// /textheadertitle=(TextView)
		// layoutHeder.findViewById(R.id.textViewheaderTitle);
		// textheadertitle.setText("");

		layoutTitleHeaderview = (LinearLayout) contentView
				.findViewById(R.id.titleHeaderview1);*/

		h1 = (TextView) findViewById(R.id.h1);
		h2 = (TextView) findViewById(R.id.h2);
		h3 = (TextView) findViewById(R.id.h3);
		h4 = (TextView) findViewById(R.id.h4);
		h5 = (TextView) findViewById(R.id.h5);
		h6 = (TextView) findViewById(R.id.h6);
		h7 = (TextView) findViewById(R.id.h7);
		h8 = (TextView) findViewById(R.id.h8);
		h9 = (TextView) findViewById(R.id.h9);
		h10 = (TextView) findViewById(R.id.h10);
		h11 = (TextView) findViewById(R.id.h11);


		t1 = (TextView) findViewById(R.id.t1);
		t2 = (TextView) findViewById(R.id.t2);
		t3 = (TextView) findViewById(R.id.t3);
		t4 = (TextView) findViewById(R.id.t4);
		t5 = (TextView) findViewById(R.id.t5);
		t6 = (TextView) findViewById(R.id.t6);
		t7 = (TextView) findViewById(R.id.t7);
		t8 = (TextView) findViewById(R.id.t8);
		t9 = (TextView) findViewById(R.id.t9);
		t10 = (TextView) findViewById(R.id.t10);
		t11 = (TextView) findViewById(R.id.t11);
		t12 = (TextView) findViewById(R.id.t12);
		t13 = (TextView) findViewById(R.id.t13);

		h1.setTypeface(RegularFunctions.getAgendaBoldFont(activity));
		h2.setTypeface(RegularFunctions.getAgendaBoldFont(activity));
		h3.setTypeface(RegularFunctions.getAgendaBoldFont(activity));
		h4.setTypeface(RegularFunctions.getAgendaBoldFont(activity));
		h5.setTypeface(RegularFunctions.getAgendaBoldFont(activity));
		h6.setTypeface(RegularFunctions.getAgendaBoldFont(activity));
		h7.setTypeface(RegularFunctions.getAgendaBoldFont(activity));
		h8.setTypeface(RegularFunctions.getAgendaBoldFont(activity));
		h9.setTypeface(RegularFunctions.getAgendaBoldFont(activity));
		h10.setTypeface(RegularFunctions.getAgendaBoldFont(activity));
		h11.setTypeface(RegularFunctions.getAgendaBoldFont(activity));


		t1.setTypeface(RegularFunctions.getAgendaMediumFont(activity));
		t2.setTypeface(RegularFunctions.getAgendaMediumFont(activity));
		t3.setTypeface(RegularFunctions.getAgendaMediumFont(activity));
		t4.setTypeface(RegularFunctions.getAgendaMediumFont(activity));
		t5.setTypeface(RegularFunctions.getAgendaMediumFont(activity));
		t6.setTypeface(RegularFunctions.getAgendaMediumFont(activity));
		t7.setTypeface(RegularFunctions.getAgendaMediumFont(activity));
		t8.setTypeface(RegularFunctions.getAgendaMediumFont(activity));
		t9.setTypeface(RegularFunctions.getAgendaMediumFont(activity));
		t10.setTypeface(RegularFunctions.getAgendaMediumFont(activity));
		t11.setTypeface(RegularFunctions.getAgendaMediumFont(activity));
		t12.setTypeface(RegularFunctions.getAgendaMediumFont(activity));
		t13.setTypeface(RegularFunctions.getAgendaMediumFont(activity));


		addListners();
	}

	@Override
	public void addListners() {
		// TODO Auto-generated method stub
		super.addListners();
		btnheaderMenu.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				openSlideMenu();
			}
		});

	}
}
