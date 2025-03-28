package com.example.dicodingevents.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dicodingevents.core.data.Resource
import com.example.dicodingevents.core.ui.EventAdapter
import com.example.dicodingevents.R
import com.example.dicodingevents.databinding.FragmentHomeBinding
import com.example.dicodingevents.detail.DetailEventActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val eventAdapter = EventAdapter()
            eventAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailEventActivity::class.java)
                intent.putExtra(DetailEventActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            homeViewModel.event.observe(viewLifecycleOwner) { event ->
                if (event != null) {
                    when (event) {
                        is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            eventAdapter.submitList(event.data)
                        }
                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.viewError.root.visibility = View.VISIBLE
                            binding.viewError.tvError.text =
                                event.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
            }

            with(binding.rvTourism) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = eventAdapter
            }
        }
    }
}
