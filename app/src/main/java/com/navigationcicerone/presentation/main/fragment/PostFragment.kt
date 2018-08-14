package com.androidnavigation.main.fragment

import android.app.Fragment
import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.navigationcicerone.R
import kotlinx.android.synthetic.main.fragment_post.view.*


class PostFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_post, container, false)
        view.postId.text = arguments!!.getString("id")
        return view
    }
}