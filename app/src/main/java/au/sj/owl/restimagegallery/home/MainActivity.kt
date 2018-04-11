package au.sj.owl.restimagegallery.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.arch.persistence.room.Room
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import au.sj.owl.restimagegallery.R.layout
import au.sj.owl.restimagegallery.home.link.Link
import au.sj.owl.restimagegallery.home.link.LinksDB
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.rvImgs
import timber.log.Timber
import java.util.concurrent.TimeUnit.MILLISECONDS

class MainActivity : AppCompatActivity() {

    lateinit var mHomeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        mHomeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        mHomeViewModel.db = Room.databaseBuilder(applicationContext, LinksDB::class.java, "links-db").build()

        var links: List<Link> = listOf()
        rvImgs.adapter = GalleryAdapter(this, links)
        rvImgs.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        mHomeViewModel.getLinks().observe(this,
                                          Observer<List<Link>> { links ->
                                              Timber.d("jsp links got")
                                              rvImgs.adapter = GalleryAdapter(this, links!!)
                                          })
    }

    //    fun loadImage(links: List<String>) {
    //        var link = links[0]
    //
    //        var options = RequestOptions()
    //                .placeholder(mipmap.ic_launcher_round)
    //                .error(mipmap.ic_launcher)
    //
    //        Glide.with(this)
    //                .load(link)
    //                .apply(options)
    //                .into(imageView)
    //
    //    }

}


