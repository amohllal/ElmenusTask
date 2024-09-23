# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-keep class com.example.elmenustask.model.** { *; }

-keepclassmembers class com.example.elmenustask.model.** { *; }

# Keep BouncyCastle related classes
-keep class org.bouncycastle.** { *; }
-dontwarn org.bouncycastle.**

# Keep Conscrypt related classes
-keep class org.conscrypt.** { *; }
-dontwarn org.conscrypt.**

# Keep OpenJSSE related classes
-keep class org.openjsse.** { *; }
-dontwarn org.openjsse.**

# Keep OkHttp3 related platform classes
-keep class okhttp3.internal.platform.** { *; }
-dontwarn okhttp3.internal.platform.**