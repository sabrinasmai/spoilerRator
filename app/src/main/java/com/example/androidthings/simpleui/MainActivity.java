/*
 * Copyright 2016, The Android Open Source Project
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

package com.example.androidthings.simpleui;

import android.app.Activity;

import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import java.util.ArrayList;

public class MainActivity extends Activity {


    private RecyclerView mListRecyclerList ;
    private FoodListAdapter mAdapter;
    private Button mTakePictureButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mListRecyclerList= (RecyclerView) findViewById(R.id.recycler_view_list_item);
        mListRecyclerList.setLayoutManager(new LinearLayoutManager(this));


        mTakePictureButton = (Button) findViewById(R.id.btn_take_pic);



        addData();
    }


    public void addData(){

        FoodItem item1 = new FoodItem();
        FoodItem item2 = new FoodItem();
        FoodItem item3 = new FoodItem();
        FoodItem item4 = new FoodItem();

        item1.setmName("BANANA");
        item2.setmName("ORANGE");
        item3.setmName("TOMATOE");
        item4.setmName("CUCUMBER");

        item1.setmStatus(Config.SPOILED);
        item2.setmStatus(Config.FRESH);
        item3.setmStatus(Config.SPOILED);
        item4.setmStatus(Config.FRESH);


        item1.setmDate("9/9/18");
        item2.setmDate("9/9/18");
        item3.setmDate("9/9/18");
        item4.setmDate("9/9/18");

        ArrayList<FoodItem> mListOfItems = new ArrayList<>();
        mListOfItems.add(item1);
        mListOfItems.add(item2);
        mListOfItems.add(item3);
        mListOfItems.add(item4);


        mAdapter = new FoodListAdapter(this,mListOfItems);
        mListRecyclerList.setAdapter(mAdapter);

    }

}
