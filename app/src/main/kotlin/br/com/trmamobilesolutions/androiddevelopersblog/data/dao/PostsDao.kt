package br.com.trmamobilesolutions.androiddevelopersblog.data.dao

import android.arch.persistence.room.*
import br.com.trmamobilesolutions.androiddevelopersblog.model.Post
import com.remoteok.io.app.model.Job
import io.reactivex.Flowable

/**
 * Created by tairo on 12/12/17 3:03 PM.
 */
@Dao
interface PostsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(post: Post): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAll(posts: List<Post>?)

    @Update
    fun update(post: Post)

    @Delete
    fun delete(post: Post)

    @Query("DELETE FROM posts")
    fun deleteAll()

    @Query("SELECT * FROM posts LIMIT 30")
    fun getAll(): Flowable<List<Post>>

    @Query("select * from posts where id = :id")
    fun getByID(id: Int): Flowable<Post>

    @Query("SELECT * FROM posts where title LIKE '%'||:title|| '%' LIMIT 30")
    fun getAllByTitle(title: String): Flowable<List<Post>>
}