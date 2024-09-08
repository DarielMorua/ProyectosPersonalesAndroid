import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class Manzanas(val pt: Int, val pa: Int)

class ManzanasViewModel : ViewModel() {
    private val _result = MutableLiveData(0.0)
       val result: LiveData<Double> get() = _result

    private val _produccionTotal = MutableLiveData(0)
    val produccionTotal: LiveData<Int> get() = _produccionTotal

    private val _produccionActual = MutableLiveData(0)
    val produccionActual: LiveData<Int> get() = _produccionActual

    fun calcular(manzanas: Manzanas) {
        _result.value = (manzanas.pa * 100.0 / manzanas.pt)
    }

    fun incrementar(valor: Int) {
        val nuevoValor = (_produccionActual.value ?: 0) + valor
        _produccionActual.value = nuevoValor
    }

    fun setProduccionTotal(valor: Int) {
        _produccionTotal.value = valor
    }

    fun setProduccionActual(valor: Int) {
        _produccionActual.value = valor
    }
}
