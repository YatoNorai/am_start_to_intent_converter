#### am_start_to_intent_converter
The am_start_to_intent_converter package is a Flutter library that simplifies the conversion and execution of Android am start commands as Flutter Intent objects.

#### Installation
Add the following to your pubspec.yaml file:

```` yaml
dependencies:
  am_start_to_intent_converter: ^0.0.1````

#### Import
import 'package:am_start_to_intent_converter/am_start_to_intent_converter.dart';
#### Basic Usage
AmStartToIntentConverter().start("your_am_start_command");
#### Methods
start(command: 'command')
Converts an Android am start command into a Flutter Intent object and executes it.

#### Parameters:
command (String): The am start command to be converted and executed.

#### Example:
AmStartToIntentConverter().start("-n com.example.app/.MainActivity");

#### Supported Tags, Arguments, and Flags
/// Starts the execution of an Android `Intent` based on the provided command.
///
/// The `command` parameter represents the `am start` command to be executed.
/// It can include various options, flags, and tags to customize the behavior
/// of the Android `Intent`.
///
/// Supported `am start` command components:
///
/// - **Component Name (-n):** Specifies the component name to launch.
///   Example: `-n com.example.myapp/.MainActivity`
///
/// - **Extra (-e):** Adds key-value pairs as extras to the intent.
///   Example: `-e key value`
///
/// - **Action (-a):** Sets the action for the intent.
///   Example: `-a android.intent.action.VIEW`
///
/// - **Data (-d):** Specifies the data URI for the intent.
///   Example: `-d content://com.example.data`
///
/// - **Category (-c):** Adds a category to the intent.
///   Example: `-c android.intent.category.DEFAULT`
///
/// - **Type (-t):** Sets the MIME type of the intent.
///   Example: `-t image/jpeg`
///
/// - **Flags (Various):** Adds various flags to the intent, such as
///   `--grant-read-uri-permission`, `--activity-clear-task`, etc.
///
/// - **Extras (--ez, --ezs, --ei, --el, --eu, --es):** Adds extras with
///   different data types to the intent.
///
/// Example Usage:
///
/// ```dart
/// String amStartCommand = "-a android.intent.action.VIEW -d https://www.github.com/YatoNorai";
/// AmStartToIntentConverter().start(command: amStartCommand);
/// ```

#### Additional Notes
The package uses the Android Intent class to create and execute intents from Flutter.
Ensure you add the necessary permissions to your Android manifest to guarantee the desired behavior.
Refer to the official Android documentation for additional information on intents and filters in Android.