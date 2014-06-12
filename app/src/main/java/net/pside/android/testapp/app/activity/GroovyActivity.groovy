package net.pside.android.testapp.app.activity

import android.app.ListActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import groovy.transform.CompileStatic
import net.pside.android.testapp.app.util.DebugLog

@CompileStatic
class GroovyActivity extends ListActivity {

    enum BundleKey {
        ID,
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)

        int size = intent.getIntExtra(BundleKey.ID.toString(), 100)
        DebugLog.d(size.toString())

        /* Groovyのリスト操作をやってみる */
        def list = 0..size

        /*
        MEMO: Range で sort すると内部で add 呼ぶのだけどRangeはaddを継承してないのでError
         */

        /*
        def list = [
                "Apple",
                "Blackberry",
                "Cupcake"
        ]
        */

        DebugLog.d list.join(",")
        DebugLog.d list.reverse().join(",")
        List visibleList = list.reverse().collect { it * 10 }

        setListAdapter(new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                visibleList)
        )
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        Intent data = new Intent();
        data.putExtra(MainActivity.BundleKey.SELECTED_ID.toString(), (int) id)
        setResult(RESULT_OK, data)

        finish()
    }

}
