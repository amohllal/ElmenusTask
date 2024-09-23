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

# Keep all entity classes in the com.example.data.entity package
-keep class com.example.data.entity.** { *; }

# Keep all model classes in the com.example.data.model package
-keep class com.example.data.model.** { *; }

# Keep all Retrofit interfaces
-keep interface retrofit2.** { *; }

# Keep Retrofit method parameters
-keepclassmembers,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}

# Keep GSON serialization/deserialization methods
-keepclassmembers,allowobfuscation class * {
    @com.google.gson.annotations.* <fields>;
}

# Keep Room database entity classes
-keep,allowobfuscation class com.example.data.entity.** { *; }

# Keep Room DAO (Data Access Object) interfaces
-keep,allowobfuscation interface com.example.data.dao.** { *; }

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