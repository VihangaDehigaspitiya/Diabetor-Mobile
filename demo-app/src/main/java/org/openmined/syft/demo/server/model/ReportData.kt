package org.openmined.syft.demo.server.model

class ReportData(result: String?, year: String?, id: String?) {
    
    private var result: String
    private var year: String
    private var id: String

    init {
        this.result = result!!
        this.year = year!!
        this.id = id!!
    }

    fun getResult(): String? {
        return result
    }

    fun setResult(name: String?) {
        result = name!!
    }

    fun getYear(): String? {
        return year
    }

    fun setYear(year: String?) {
        this.year = year!!
    }

    fun getId(): String? {
        return id
    }

    fun setId(id: String?) {
        this.id = id!!
    }
}