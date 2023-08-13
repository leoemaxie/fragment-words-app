package com.leo.wordsapp

import android.os.Bundle
import android.view.LinearLayout
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.leo.wordsapp.databinding.FragmentWordListBinding
import com.leo.wordsapp.R
import com.leo.wordsapp.WordAdapter

class WordListFragment : Fragment() {
    companion object {
        const val LETTER = "letter"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }
    
    private var _binding: FragmentLWordListBinding? = null
    private val binding get() = _binding!!
    private lateinit var letterId: String 
    
    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       arguments?.let {
        letterId = it.getString(LETTER).toString()
        }      
    }
    
    override fun onCreateView(inflater:  LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View? {
        _binding = FragmentLWordListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated() {
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = WordAdapter(letterId, requireContext())
        
        recyclerView.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )
    }
    
    override onDestroy() {
        super.onDestroy()
        _binding = null
    }
}