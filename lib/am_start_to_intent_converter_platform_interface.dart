import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'am_start_to_intent_converter_method_channel.dart';

abstract class AmStartToIntentConverterPlatform extends PlatformInterface {
  /// Constructs a AmStartToIntentConverterPlatform.
  AmStartToIntentConverterPlatform() : super(token: _token);

  static final Object _token = Object();

  static AmStartToIntentConverterPlatform _instance =
      MethodChannelAmStartToIntentConverter();

  /// The default instance of [AmStartToIntentConverterPlatform] to use.
  ///
  /// Defaults to [MethodChannelAmStartToIntentConverter].
  static AmStartToIntentConverterPlatform get instance => _instance;

  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [AmStartToIntentConverterPlatform] when
  /// they register themselves.
  static set instance(AmStartToIntentConverterPlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<void> start({required String command}) {
    throw UnimplementedError('platformVersion() has not been implemented.');
  }
}
