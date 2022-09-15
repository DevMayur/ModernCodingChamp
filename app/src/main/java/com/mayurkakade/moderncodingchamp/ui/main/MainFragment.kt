package com.mayurkakade.moderncodingchamp.ui.main

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mayurkakade.moderncodingchamp.MainActivity
import com.mayurkakade.moderncodingchamp.R
import com.mayurkakade.moderncodingchamp.api.RetrofitAPI
import com.mayurkakade.moderncodingchamp.api.content.ContentResponseObject
import com.mayurkakade.moderncodingchamp.api.subjects.SubjectResponseObject
import com.mayurkakade.moderncodingchamp.api.subtitles.SubtitleResponseObject
import com.mayurkakade.moderncodingchamp.api.titles.TitlesResponseObject
import com.mayurkakade.moderncodingchamp.recycler.ListAdapter
import com.mayurkakade.moderncodingchamp.recycler.Type
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainFragment : Fragment() {

    companion object {
        fun newInstance(elementId: Int, elementType: Type) = MainFragment().apply {
            currentId = elementId
            type = elementType
        }
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ListAdapter
    private lateinit var heading: TextView

    //following values we need in constructor
    private var currentId = 0
    private var type: Type = Type.SUBJECTS

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = view.findViewById(R.id.recyclerView)
        heading = view.findViewById(R.id.tvHeadingMain)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ( context as MainActivity ).getViewModel()
        adapter = ListAdapter( type, requireContext(), viewModel )
        recyclerView.adapter = adapter
        if (isTablet(requireContext()) && type != Type.CONTENT)
        {
            recyclerView.layoutManager = GridLayoutManager(context, 3)
        }
        else
        {
            recyclerView.layoutManager = LinearLayoutManager(context)

        }
        when(type)
        {
            Type.SUBJECTS -> "Select Subject :".also { heading.text = it }
            Type.TITLES -> "Select Topic :".also { heading.text = it }
            Type.SUBTITLE -> "Select Point :".also { heading.text = it }
            else -> { heading.visibility = View.GONE }
        }
        getData(type)
    }

    fun isTablet(ctx: Context): Boolean {
        return ctx.resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK >= Configuration.SCREENLAYOUT_SIZE_LARGE
    }

    private fun getData(type: Type) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://awesomestore.app/api/apiGetData.php/")
            .addConverterFactory(GsonConverterFactory.create()) // at last we are building our retrofit builder.
            .build()

        val retrofitAPI = retrofit.create(RetrofitAPI::class.java)
        if (type == Type.SUBJECTS)
        {
            getSubjects(retrofitAPI);
        }
        else if (type == Type.TITLES)
        {
            getTopics(retrofitAPI);
        }
        else if (type == Type.SUBTITLE)
        {
            getSubtitles(retrofitAPI);
        }
        else if (type == Type.CONTENT)
        {
            getContent(retrofitAPI);
        }



    }

    private fun getSubjects(retrofitAPI: RetrofitAPI) {
        var call: Call<SubjectResponseObject> = retrofitAPI.subject
        call.enqueue(object : Callback<SubjectResponseObject?> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<SubjectResponseObject?>, response: Response<SubjectResponseObject?>) {
                if (response.isSuccessful) {
                    var subject = response.body();
                    adapter.setSubjectsList(subject)
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<SubjectResponseObject?>, t: Throwable) {
                // displaying an error message in toast
                Toast.makeText(requireContext(), "Fail to get the data..", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

    private fun getTopics(retrofitAPI: RetrofitAPI) {
        var call: Call<TitlesResponseObject> = retrofitAPI.getTitles(currentId.toString())
        call.enqueue(object : Callback<TitlesResponseObject?> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<TitlesResponseObject?>, response: Response<TitlesResponseObject?>) {
                if (response.isSuccessful) {
                    var titles = response.body();
                    adapter.setTitlesList(titles)
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<TitlesResponseObject?>, t: Throwable) {
                // displaying an error message in toast
                Toast.makeText(requireContext(), "Fail to get the data..", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }


    private fun getSubtitles(retrofitAPI: RetrofitAPI) {
        var call: Call<SubtitleResponseObject> = retrofitAPI.getSubtitles(currentId.toString())
        call.enqueue(object : Callback<SubtitleResponseObject?> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<SubtitleResponseObject?>, response: Response<SubtitleResponseObject?>) {
                if (response.isSuccessful) {
                    var titles = response.body();
                    adapter.setSubTitleList(titles)
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<SubtitleResponseObject?>, t: Throwable) {
                // displaying an error message in toast
                Toast.makeText(requireContext(), "Fail to get the data..", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

    private fun getContent(retrofitAPI: RetrofitAPI) {
        var call: Call<ContentResponseObject> = retrofitAPI.getContent(currentId.toString())
        call.enqueue(object : Callback<ContentResponseObject?> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<ContentResponseObject?>, response: Response<ContentResponseObject?>) {
                if (response.isSuccessful) {
                    var titles = response.body();
                    adapter.setContentList(titles)
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<ContentResponseObject?>, t: Throwable) {
                // displaying an error message in toast
                Toast.makeText(requireContext(), "Fail to get the data..", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

}