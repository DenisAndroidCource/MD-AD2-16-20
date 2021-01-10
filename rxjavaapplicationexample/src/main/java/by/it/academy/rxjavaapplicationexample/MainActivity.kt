package by.it.academy.rxjavaapplicationexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.it.academy.rxjavaapplicationexample.database.UserInfo
import by.it.academy.rxjavaapplicationexample.database.UserInfoDatabase
import by.it.academy.rxjavaapplicationexample.databinding.ActivityMainBinding
import by.it.academy.rxjavaapplicationexample.databinding.ItemViewBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)
            userInfoList.adapter = UserInfoListAdapter()
            userInfoList.layoutManager = LinearLayoutManager(this@MainActivity)
        }

        getAllData()
    }

    private fun getAllData() {
        val database = UserInfoDatabase.getInstance(this)
        Single.create<List<UserInfo>> { emitter ->
            val dataList = database?.getUserDao()?.getAllInfo() ?: emptyList()
            emitter.onSuccess(dataList)
//            emitter.onError()
        }.subscribeOn(Schedulers.io())
//            .map {  }
//            .flatMap {  }
//            .zip{,,,, }
//            .filter{}
//            .doOnError {  }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { dataList -> (binding.userInfoList.adapter as UserInfoListAdapter).addItems(dataList) }
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