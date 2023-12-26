import 'package:flutter_test/flutter_test.dart';
import 'package:am_start_to_intent_converter/am_start_to_intent_converter.dart';
import 'package:am_start_to_intent_converter/am_start_to_intent_converter_platform_interface.dart';
import 'package:am_start_to_intent_converter/am_start_to_intent_converter_method_channel.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

/* class MockAmStartToIntentConverterPlatform
    with MockPlatformInterfaceMixin
    implements AmStartToIntentConverterPlatform {

  @override
  //Future<String?> getPlatformVersion() => Future.value('42');
} */

void main() {
  final AmStartToIntentConverterPlatform initialPlatform =
      AmStartToIntentConverterPlatform.instance;

  test('$MethodChannelAmStartToIntentConverter is the default instance', () {
    expect(
        initialPlatform, isInstanceOf<MethodChannelAmStartToIntentConverter>());
  });

  test('getPlatformVersion', () async {
    AmStartToIntentConverter amStartToIntentConverterPlugin =
        AmStartToIntentConverter();
    //  MockAmStartToIntentConverterPlatform fakePlatform = MockAmStartToIntentConverterPlatform();
    //  AmStartToIntentConverterPlatform.instance = fakePlatform;

    //  expect(await amStartToIntentConverterPlugin.getPlatformVersion(), '42');
  });
}
