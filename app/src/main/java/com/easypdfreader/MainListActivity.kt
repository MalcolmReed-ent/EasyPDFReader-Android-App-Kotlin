package com.easypdfreader

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.provider.DocumentsContract
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.documentfile.provider.DocumentFile
import androidx.recyclerview.widget.LinearLayoutManager
import com.easypdfreader.databinding.ActivityMainBinding

class MainListActivity : AppCompatActivity(), PdfListAdapter.ClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var pdfListAdapter: PdfListAdapter
    private lateinit var sharedPreferences: SharedPreferences

    companion object {
        private const val REQUEST_DIRECTORY = 1
        private const val PREF_FOLDER_URI = "folder_uri"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getPreferences(MODE_PRIVATE)

        pdfListAdapter = PdfListAdapter(this)
        binding.rvPdf.layoutManager = LinearLayoutManager(this)
        binding.rvPdf.adapter = pdfListAdapter

        val savedFolderUri = sharedPreferences.getString(PREF_FOLDER_URI, null)
        if (savedFolderUri != null) {
            loadPdfFiles(Uri.parse(savedFolderUri))
        } else {
            requestStoragePermission()
        }

        binding.fabSelectFolder.setOnClickListener {
            requestStoragePermission()
        }
    }

    private fun requestStoragePermission() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT_TREE)
        startActivityForResult(intent, REQUEST_DIRECTORY)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_DIRECTORY && resultCode == Activity.RESULT_OK) {
            data?.data?.let { uri ->
                contentResolver.takePersistableUriPermission(
                    uri,
                    Intent.FLAG_GRANT_READ_URI_PERMISSION
                )
                sharedPreferences.edit().putString(PREF_FOLDER_URI, uri.toString()).apply()
                loadPdfFiles(uri)
            }
        }
    }

    private fun loadPdfFiles(folderUri: Uri) {
        val pdfList = mutableListOf<Pair<Uri, String>>()
        val docFile = DocumentFile.fromTreeUri(this, folderUri)
        docFile?.listFiles()?.forEach { file ->
            if (file.type == "application/pdf") {
                pdfList.add(Pair(file.uri, file.name ?: "Unnamed PDF"))
            }
        }
        pdfListAdapter.setPdfsToList(pdfList)
    }

    override fun itemClicked(position: Int) {
        val (pdfUri, pdfName) = pdfListAdapter.getPdfAt(position)
        val intent = Intent(this, PdfViewActivity::class.java)
        intent.putExtra("PDF_URI", pdfUri)
        intent.putExtra("PDF_NAME", pdfName)
        startActivity(intent)
    }
}
