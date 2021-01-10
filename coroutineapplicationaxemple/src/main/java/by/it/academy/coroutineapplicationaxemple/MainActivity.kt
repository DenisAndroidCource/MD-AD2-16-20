package by.it.academy.coroutineapplicationaxemple

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.it.academy.coroutineapplicationaxemple.database.UserInfo
import by.it.academy.coroutineapplicationaxemple.database.UserInfoDatabase
import by.it.academy.coroutineapplicationaxemple.databinding.ActivityMainBinding
import by.it.academy.coroutineapplicationaxemple.databinding.ItemViewBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private val activityScope = CoroutineScope(Dispatchers.Main + Job())

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)
            userInfoList.apply {
                adapter = UserInfoListAdapter()
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
        getAllData()
    }

    private fun getAllData() {
        val database = UserInfoDatabase.getInstance(applicationContext)
        activityScope.launch {
            val dataList = withContext(Dispatchers.IO) {
                database?.getUserDao()?.getAllInfo() ?: emptyList()
            }
            (binding.userInfoList.adapter as UserInfoListAdapter).addItems(dataList)
        }
    }

    class UserInfoListAdapter : RecyclerView.Adapter<UserInfoListAdapter.UserInfoViewHolder>() {

        private var userInfoList = listOf<UserInfo>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserInfoViewHolder {
            val binding =
                ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return UserInfoViewHolder(binding)
        }

        override fun getItemCount() = userInfoList.size

        override fun onBindViewHolder(holder: UserInfoViewHolder, position: Int) {
            holder.bind(userInfoList[position])
        }

        fun addItems(newItems: List<UserInfo>) {
            userInfoList = newItems
            notifyDataSetChanged()
        }

        class UserInfoViewHolder(
            private val itemBinding: ItemViewBinding
        ) : RecyclerView.ViewHolder(itemBinding.root) {
            fun bind(item: UserInfo) {
                with(itemBinding) {
                    nameTextView.text = item.name
                    addressTextView.text = item.address
                }
            }
        }
    }
}