import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:am_start_to_intent_converter/am_start_to_intent_converter_method_channel.dart';

void main() {
  TestWidgetsFlutterBinding.ensureInitialized();

  MethodChannelAmStartToIntentConverter platform =
      MethodChannelAmStartToIntentConverter();
  const MethodChannel channel = MethodChannel('am_start_to_intent_converter');

  setUp(() {
    TestDefaultBinaryMessengerBinding.instance.defaultBinaryMessenger
        .setMockMethodCallHandler(
      channel,
      (MethodCall methodCall) async {
        return '42';
      },
    );
  });

  tearDown(() {
    TestDefaultBinaryMessengerBinding.instance.defaultBinaryMessenger
        .setMockMethodCallHandler(channel, null);
  });

  test('getPlatformVersion', () async {
    //expect(await platform.amStart(command: ''), '42');
  });
}
