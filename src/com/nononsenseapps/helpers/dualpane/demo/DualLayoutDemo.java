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

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.nononsenseapps.helpers.R;
import com.nononsenseapps.helpers.dualpane.DualLayoutActivity;

/**
 * This activity merely demonstrates one possible way to handle the
 * hiding/showing of the left fragment. In this case the action is bound to the
 * up navigation button. Ideally, you'd want the fragment to be hidden when the
 * right fragment gains focus or by a sliding action. The up navigation button
 * should only be used for showing the list again.
 * 
 */
public class DualLayoutDemo extends DualLayoutActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// I want to tie the hiding/showing animation to the up navigation
		// button
		if (getCurrentContent() == CONTENTVIEW.DUAL
				&& getResources().getBoolean(R.bool.leftHideable)
				|| getCurrentContent() == CONTENTVIEW.RIGHT) {
			ActionBar actionBar = getActionBar();
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
	}

	/**
	 * Catch any clicks on the up navigation button
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			if (getCurrentContent() == CONTENTVIEW.DUAL) {
				// Toggle visibility
				setLeftFragmentVisible(!getLeftFragment().isVisible());
			} else if (getCurrentContent() == CONTENTVIEW.RIGHT) {
				// Should not just finish on up-navigation. Should make
				// sure we bring list to front as the new top activity.
				Intent intent = new Intent();
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				intent.setClass(this, DualLayoutDemo.class);

				startActivity(intent);
			}
			return true;
		}

		return false;
	}
}
