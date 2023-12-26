import 'am_start_to_intent_converter_platform_interface.dart';

class AmStartToIntentConverter {
  Future<void> start({required String command}) {
    return AmStartToIntentConverterPlatform.instance.start(command: command);
  }
}
