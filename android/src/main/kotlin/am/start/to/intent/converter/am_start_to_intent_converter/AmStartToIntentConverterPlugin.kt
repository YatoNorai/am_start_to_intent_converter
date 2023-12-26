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
                   // ...
                argumentos[i].startsWith("-i") -> {
                     val identificador = argumentos[i + 1]
                     intent.setIdentifier(identificador)
                     i += 2
                }
                argumentos[i].startsWith("-f") -> {
                      val chave = argumentos[i + 1]
                      val valor = argumentos[i + 2]
                      intent.putExtra(chave, valor)
                      i += 3
                }
                argumentos[i].startsWith("-p") -> {
                     val pacote = argumentos[i + 1]
                     intent.setPackage(pacote)
                     i += 2
                }
                argumentos[i].startsWith("--ecn") -> {
                     val chave = argumentos[i + 1]
                     val valor = argumentos[i + 2]
                     intent.putExtra(chave, valor)
                     i += 3
                }
                argumentos[i].startsWith("--efa") -> {
                     val chave = argumentos[i + 1]
                     val valor = argumentos[i + 2]
                     intent.putExtra(chave, valor)
                     i += 3
                }
                argumentos[i].startsWith("--eia") -> {
                     val chave = argumentos[i + 1]
                     val valor = argumentos[i + 2]
                     intent.putExtra(chave, valor)
                     i += 3
                }
                argumentos[i].startsWith("--ela") -> {
                     val chave = argumentos[i + 1]
                     val valor = argumentos[i + 2]
                     intent.putExtra(chave, valor)
                     i += 3
                }
                argumentos[i].startsWith("--esa") -> {
                     val chave = argumentos[i + 1]
                     val valor = argumentos[i + 2]
                     intent.putExtra(chave, valor)
                     i += 3
                }
                argumentos[i].startsWith("--esn") -> {
                     val chave = argumentos[i + 1]
                     val valor = argumentos[i + 2]
                     intent.putExtra(chave, valor)
                     i += 3
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
                //
                argumentos[i].startsWith("--selector") -> {
                    val selector = argumentos[i + 1]
                    intent.selector = Intent.parseUri(selector, 0)
                    i += 2
                }
                argumentos[i].startsWith("--efal") -> {
                    val chave = argumentos[i + 1]
                    val valor = argumentos[i + 2]
                    intent.putExtra(chave, valor)
                    i += 3
                }
                argumentos[i].startsWith("--eial") -> {
                    val chave = argumentos[i + 1]
                    val valor = argumentos[i + 2]
                    intent.putExtra(chave, valor)
                    i += 3
                }
                argumentos[i].startsWith("--ela") -> {
                    val chave = argumentos[i + 1]
                    val valor = argumentos[i + 2]
                    intent.putExtra(chave, valor)
                    i += 3
                }
                argumentos[i].startsWith("--esal") -> {
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
                argumentos[i].startsWith("--grant-prefix-uri-permission") -> {
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                    i++
                }
                argumentos[i].startsWith("--activity-task-on-home") -> {
                    intent.addFlags(Intent.FLAG_ACTIVITY_TASK_ON_HOME)
                    i++
                }
                argumentos[i].startsWith("--activity-no-history") -> {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
                    i++
                }
                argumentos[i].startsWith("--debug-log-resolution") -> {
                    intent.addFlags(Intent.FLAG_DEBUG_LOG_RESOLUTION)
                    i++
                }
                argumentos[i].startsWith("--activity-reorder-to-front") -> {
                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                    i++
                }
                argumentos[i].startsWith("--activity-brought-to-front") -> {
                    intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT)
                    i++
                }
                argumentos[i].startsWith("--activity-previous-is-top") -> {
                    intent.addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP)
                    i++
                }
                argumentos[i].startsWith("--activity-exclude-from-recents") -> {
                    intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)
                    i++
                }
                argumentos[i].startsWith("--activity-no-animation") -> {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    i++
                }
                argumentos[i].startsWith("--attach-agent-bind") -> {
                    intent.addFlags(Intent.FLAG_ATTACH_AGENT_BIND)
                    i++
                }
                argumentos[i].startsWith("--activity-reset-task-if-needed") -> {
                    intent.addFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)
                    i++
                }
                argumentos[i].startsWith("--activity-no-user-action") -> {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_USER_ACTION)
                    i++
                }
                argumentos[i].startsWith("--receiver-registered-only") -> {
                    intent.addFlags(Intent.FLAG_RECEIVER_REGISTERED_ONLY)
                    i++
                }
                argumentos[i].startsWith("--grant-persistable-uri-permission") -> {
                    intent.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION)
                    i++
                }
                argumentos[i].startsWith("--exclude-stopped-packages") -> {
                    intent.addFlags(Intent.FLAG_EXCLUDE_STOPPED_PACKAGES)
                    i++
                }
                argumentos[i].startsWith("--include-stopped-packages") -> {
                    intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
                    i++
                }
                argumentos[i].startsWith("--receiver-replace-pending") -> {
                    intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING)
                    i++
                }
                argumentos[i].startsWith("--activity-clear-when-task-reset") -> {
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET)
                    i++
                }
                argumentos[i].startsWith("--activity-launched-from-history") -> {
                    intent.addFlags(Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY)
                    i++
                }
                argumentos[i].startsWith("--receiver-no-abort") -> {
                    intent.addFlags(Intent.FLAG_RECEIVER_NO_ABORT)
                    i++
                }
                argumentos[i].startsWith("--allow-background-activity-starts") -> {
                    intent.addFlags(Intent.FLAG_ALLOW_BACKGROUND_ACTIVITY_STARTS)
                    i++
                }
                argumentos[i].startsWith("--sampling") -> {
                    intent.addFlags(Intent.FLAG_SAMPLING)
                    i++
                }
                 // ...
                argumentos[i].startsWith("--activity-match-external") -> {
                    intent.addFlags(Intent.FLAG_ACTIVITY_MATCH_EXTERNAL)
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
