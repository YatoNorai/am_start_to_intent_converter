import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:am_start_to_intent_converter/am_start_to_intent_converter.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  final String _platformVersion = 'Unknown';
  final _amStartToIntentConverterPlugin = AmStartToIntentConverter();

  @override
  void initState() {
    super.initState();
    am();
  }

  // Platform messages are asynchronous, so we initialize in an async method.
  Future<void> am() async {
    _amStartToIntentConverterPlugin.start(
        command:
            '-a android.intent.action.VIEW -d https://www.github.com/YatoNorai');
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: Text('Running on: $_platformVersion\n'),
        ),
      ),
    );
  }
}
