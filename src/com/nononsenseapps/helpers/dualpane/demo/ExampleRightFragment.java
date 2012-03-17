package com.nononsenseapps.helpers.dualpane.demo;

/*
 * Copyright (C) 2012 Jonas Kalderstam
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.nononsenseapps.helpers.R;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class ExampleRightFragment extends Fragment {
	public static final String TEXT = "textToDisplay";

	private EditText mText;
	private String textToDisplay = "";

	/**
	 * Inflate layout and grap hold of the text field
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		int layout = R.layout.example_right_fragment_layout;

		// Gets a handle to the EditText in the the layout.
		View theView = inflater.inflate(layout, container, false);

		// Main note edit text
		mText = (EditText) theView.findViewById(R.id.editText);

		return theView;
	}

	/**
	 * Get what we are supposed to display from the activity's intent
	 */
	@Override
	public void onActivityCreated(Bundle saves) {
		super.onActivityCreated(saves);
		Intent intent = getActivity().getIntent();
		if (intent != null && intent.getExtras() != null) {
			displayText(intent.getExtras().getString(TEXT, textToDisplay));
		}
	}

	/**
	 * This needs to be public since the ExampleListFragment will call it in
	 * dual pane view
	 */
	public void displayText(String text) {
		if (mText != null)
			mText.setText(text);
	}
}
