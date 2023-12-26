import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

import 'am_start_to_intent_converter_platform_interface.dart';

/// An implementation of [AmStartToIntentConverterPlatform] that uses method channels.
class MethodChannelAmStartToIntentConverter
    extends AmStartToIntentConverterPlatform {
  /// The method channel used to interact with the native platform.
  @visibleForTesting
  final methodChannel = const MethodChannel('am_start_to_intent_converter');

  @override
  Future<void> start({required String command}) async {
    try {
      await methodChannel.invokeMethod<String>('amStart', command);
    } catch (e) {
      debugPrint('Erro ao chamar método nativo: $e');
    }
  }
}
