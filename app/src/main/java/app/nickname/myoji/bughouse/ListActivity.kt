package app.nickname.myoji.bughouse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    val taskList: List<Task> = listOf(
        Task("Task 1"),
        Task("Task 2"),
        Task("Task 3")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)


        val adapter = TaskAdapter(this,
            object: TaskAdapter.ItemClickListener{
           /* override fun onItemClick(position: Int) {
               val intent = Intent(this@ListActivity, DetailActivity::class.java)
              //  val intent=Intent(this,DetailActivity::class.java)
                intent.putExtra("task", taskList[position].name)
                startActivity(intent)

            }
            */
           override fun onItemClick(task: Task) {
               val intent = Intent(this@ListActivity, DetailActivity::class.java)
               //  val intent=Intent(this,DetailActivity::class.java)
               intent.putExtra("task", task.name)
               startActivity(intent)

           }
        })

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter=adapter

        //adapter.addAll(taskList)

        addButton.setOnClickListener {
            val name = editText.text.toString()
           //taskList.add(Task(name))
            adapter.addItem(Task(name))

        }
        adapter.addAll(taskList)


    }



}