
package me.aprilian.coinbasesample.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import me.aprilian.coinbasesample.data.LatestCoinResponse
import me.aprilian.coinbasesample.databinding.FragmentPriceBinding
import me.aprilian.coinbasesample.databinding.ItemLatestCoinBinding
import me.aprilian.coinbasesample.repository.CoinRepository
import me.aprilian.coinbasesample.utils.toast
import javax.inject.Inject

@AndroidEntryPoint
class PriceFragment : Fragment() {

    private val priceViewModel: PriceViewModel by viewModels()
    lateinit var binding: FragmentPriceBinding
    lateinit var adapter: LatestCoinAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPriceBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
        initAdapter()
    }

    private fun initObserver(){
        priceViewModel.isRefreshList.observe(viewLifecycleOwner, Observer {
            adapter.notifyDataSetChanged()
        })
    }

    private fun initAdapter(){
        adapter = LatestCoinAdapter()
        priceViewModel.getCoins().let { adapter.submitList(it) }
        binding.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() {}
    }
}

@HiltViewModel
class PriceViewModel @Inject constructor(
    @ApplicationContext private val mContext: Context,
    private val coinRepository: CoinRepository
): ViewModel(){
    val isRefreshList: MutableLiveData<Boolean> = MutableLiveData()
    private val coins: ArrayList<LatestCoinResponse.Data> = arrayListOf()

    fun getCoins(): ArrayList<LatestCoinResponse.Data> {
        return coins
    }

    fun loadLatestCoins() = viewModelScope.launch {
        if (coinRepository.getLatestCoin().isSuccessful){
            coinRepository.getLatestCoin().body()?.data?.let {
                coins.addAll(it)
            }
            mContext.toast("success "+coins.size.toString())
        } else {
            mContext.toast("failed")
        }

        isRefreshList.value = true
    }

    init {
        loadLatestCoins()
    }
}