package am.start.to.intent.converter.am_start_to_intent_converter

//import android.app.Activity
import android.content.ComponentName
import android.content.pm.PackageManager
import android.content.Intent
import android.util.Log
import android.net.Uri
import android.app.Activity
import android.content.Context
import androidx.annotation.NonNull
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result

/** AmStartToIntentConverterPlugin */
class AmStartToIntentConverterPlugin: FlutterPlugin, MethodCallHandler {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private lateinit var channel : MethodChannel
 // private var activity: Activity
  private lateinit var context: Context  // Add this line to store the context


  override fun onAttachedToEngine(flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    channel = MethodChannel(flutterPluginBinding.binaryMessenger, "am_start_to_intent_converter")
    this.context = flutterPluginBinding.applicationContext  // Assign the context
    channel?.setMethodCallHandler(this)
    
  }

   companion object {
        fun registerWith(
                @NonNull registrar: io.flutter.plugin.common.PluginRegistry.Registrar) {
            val amStartToIntentConverterPlugin = AmStartToIntentConverterPlugin()
            amStartToIntentConverterPlugin.channel = MethodChannel(registrar.messenger(), "am_start_to_intent_converter")
            amStartToIntentConverterPlugin.context = registrar.context()
            amStartToIntentConverterPlugin.channel?.setMethodCallHandler(amStartToIntentConverterPlugin)
        }
    }

  override fun onMethodCall(call: MethodCall, result: Result) {
    if (call.method == "amStart") {
      val comando = call.arguments as String
                executarComando(comando)
                result.success(null)
    } else {
      result.notImplemented()
    }
  }

  override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
    channel.setMethodCallHandler(null)
  }

private fun executarComando(comando: String) {
        val comandoLimpo = comando.replace("\\n", " ")
        val argumentos = comandoLimpo.split("\\s+".toRegex()).toTypedArray()

        val intent = Intent()

        var i = 0
        while (i < argumentos.size) {
            when {
                argumentos[i].startsWith("-n") -> {
                    val componentName = argumentos[i + 1].split("/")
                    intent.component = ComponentName(componentName[0], componentName[1])
                    i += 2
                }
                argumentos[i].startsWith("-e") -> {
                    val chave = argumentos[i + 1]
                    val valor = argumentos[i + 2]
                    intent.putExtra(chave, valor)
                    i += 3
                }
                argumentos[i].startsWith("-a") -> {
                    val acao = argumentos[i + 1]
                    intent.action = acao
                    if (acao == "android.media.action.VIDEO_CAPTURE" || acao == "android.media.action.IMAGE_CAPTURE") {
                        intent.addCategory(Intent.CATEGORY_DEFAULT)
                    }
                    i += 2
                }
                argumentos[i].startsWith("-d") -> {
                    val dados = argumentos[i + 1]
                    intent.data = Uri.parse(dados)
                    i += 2
                }
                argumentos[i].startsWith("-c") -> {
                    val categoria = argumentos[i + 1]
                    intent.addCategory(categoria)
                    i += 2
                }
                argumentos[i].startsWith("-t") -> {
                    val tipo = argumentos[i + 1]
                    intent.type = tipo
                    i += 2
                }
                argumentos[i].startsWith("--ez") -> {
                    val chave = argumentos[i + 1]
                    val valor = argumentos[i + 2].toBoolean()
                    intent.putExtra(chave, valor)
                    i += 3
                }
                argumentos[i].startsWith("--ezs") -> {
                    val chave = argumentos[i + 1]
                    val valor = argumentos[i + 2]
                    intent.putExtra(chave, valor)
                    i += 3
                }
                argumentos[i].startsWith("--ei") -> {
                    val chave = argumentos[i + 1]
                    val valor = argumentos[i + 2].toInt()
                    intent.putExtra(chave, valor)
                    i += 3
                }
                argumentos[i].startsWith("--el") -> {
                    val chave = argumentos[i + 1]
                    val valor = argumentos[i + 2].toLong()
                    intent.putExtra(chave, valor)
                    i += 3
                }
                argumentos[i].startsWith("--eu") -> {
                    val chave = argumentos[i + 1]
                    val valor = Uri.parse(argumentos[i + 2])
                    intent.putExtra(chave, valor)
                    i += 3
                }
                argumentos[i].startsWith("--es") -> {
                    val chave = argumentos[i + 1]
                    val valor = argumentos[i + 2]
                    intent.putExtra(chave, valor)
                    i += 3
                }
                argumentos[i].startsWith("--grant-read-uri-permission") -> {
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                    i++
                }
                argumentos[i].startsWith("--grant-write-uri-permission") -> {
                    intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
                    i++
                }
                argumentos[i].startsWith("--activity-clear-task") -> {
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    i++
                }
                argumentos[i].startsWith("--activity-clear-top") -> {
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    i++
                }
                argumentos[i].startsWith("--activity-new-task") -> {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    i++
                }
                argumentos[i].startsWith("--activity-multiple-task") -> {
                    intent.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
                    i++
                }
                argumentos[i].startsWith("--activity-reset-task-if-needed") -> {
                    intent.addFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)
                    i++
                }
                argumentos[i].startsWith("--activity-reorder-to-front") -> {
                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                    i++
                }
                argumentos[i].startsWith("--activity-single-top") -> {
                    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                    i++
                }
                argumentos[i].startsWith("--activity-clear-when-task-reset") -> {
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET)
                    i++
                }
                argumentos[i].startsWith("--activity-exclude-from-recents") -> {
                    intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)
                    i++
                }
                else -> {
                    i++
                }
            }
        }
        context.let{
             intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
             it.startActivity(intent);
        }
       //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
      // context.startActivity(intent)

     }
}
