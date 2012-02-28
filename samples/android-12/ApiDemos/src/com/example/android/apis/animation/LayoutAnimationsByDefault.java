/*
 * Copyright (C) 2010 The Android Open Source Project
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

package com.example.android.apis.animation;

// Need the following import to get access to the app resources, since this
// class is in a sub-package.
import com.example.android.apis.R;

import android.view.View;
import android.view.ViewGroup;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

/**
 * This application demonstrates how to use the animateLayoutChanges tag in XML to automate
 * transition animations as items are removed from or added to a container.
 */
public class LayoutAnimationsByDefault extends Activity {

    private int numButtons = 1;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_animations_by_default);

        final ViewGroup horizontalContainer = (ViewGroup) findViewById(R.id.horizontalContainer);
        final ViewGroup verticalContainer = (ViewGroup) findViewById(R.id.verticalContainer);

        Button addButton = (Button) findViewById(R.id.addNewButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Button newButton = new Button(LayoutAnimationsByDefault.this);
                newButton.setText("Click To Remove " + (numButtons++));
                newButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        horizontalContainer.removeView(v);
                    }
                });
                horizontalContainer.addView(newButton, Math.min(1, horizontalContainer.getChildCount()));

                newButton = new Button(LayoutAnimationsByDefault.this);
                newButton.setText("Click To Remove " + (numButtons++));
                newButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        verticalContainer.removeView(v);
                    }
                });
                verticalContainer.addView(newButton, Math.min(1, verticalContainer.getChildCount()));
            }
        });
    }

}