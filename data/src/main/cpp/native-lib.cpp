#include <jni.h>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_data_core_NativeConfig_getHomeBaseUrl(
        JNIEnv *env,
        jobject) {
    const char *url = "https://66e90d50-5b69-488c-a03f-2d6c7e36a463.mock.pstmn.io/";
    return env->NewStringUTF(url);
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_data_core_NativeConfig_getMealsBaseUrl(
        JNIEnv *env,
        jobject) {
    const char *url = "https://www.themealdb.com/api/json/v1/1/";
    return env->NewStringUTF(url);
}

