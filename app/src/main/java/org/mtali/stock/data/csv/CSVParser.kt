package org.mtali.stock.data.csv

import java.io.InputStream

interface CSVParser<out T> {
    suspend fun parser(stream: InputStream): List<T>
}